/**
 * Created by Basil on 22/12/2014.
 *
 * List implementation based on array structure
 */
public class ArrayList implements List {

    // class variables

    private Object[] data;  // object array for list content
    private int size;       // list size, to be maintained by class methods

    // constructors

    /**
     * default constructor
     * arbitrary object array start size, could be optimised based on demand on list
     */
    public ArrayList() {
        data = new Object[5];
        size = 0;
    }

    // class methods

    /**
     * check if list is empty, based on class variable size
     * @return true if size is zero
     */
    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    /**
     * Returns the number of items currently in the list.
     *
     * @return the number of items currently in the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns the elements at the given position.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message,
     *         encapsulated in a ReturnObject
     */
    public ReturnObject get(int index) {

        ReturnObject ret;

        // empty array error when size = 0

        if (size == 0) {    // if list is empty do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
        } else if (index > size || index < 0) {
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            ret = new ReturnObjectImpl(data[index], ErrorMessage.NO_ERROR);
        }

        return ret;
    }

    /**
     * Returns the elements at the given position and removes it
     * from the list. The indices of elements after the removed
     * element must be updated accordingly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message,
     *         encapsulated in a ReturnObject
     */
    public ReturnObject remove(int index) {

        ReturnObject ret;   // return object

        if (size == 0) {  // empty structure
            ret = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
        } else if (index > size || index < 0) {    // if index out of bounds do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {    // remove object
            ret = new ReturnObjectImpl(data[index], ErrorMessage.NO_ERROR);
            shiftListLeftFromIndex(index);  // update indices
            size--; // decrease size of list
        }

        return ret;

    }

    /**
     * Adds an element to the list, inserting it at the given
     * position. The indices of elements at and after that position
     * must be updated accordingly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     *
     * @param index the position at which the item should be inserted in
     *              the list
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         the item added or containing an appropriate error message
     */
    public ReturnObject add(int index, Object item) {

        ReturnObject ret;

        if (item == null) { // if null object added do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
        } else if (index > size || index < 0) { // if index out of bounds do nothing and report error
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {    // add object to list
            shiftListRightFromIndex(index); // update indices of all objects, leaving a null object at given index
            data[index] = item; // overwrite null object at given index with new object
            size++; // increase size of list
            ret = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);    //  return object added with no error
        }

        return ret;

    }

    /**
     * Adds an element at the end of the list.
     *
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     *
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         the item added or containing an appropriate error message
     */
    public ReturnObject add(Object item) {

        ReturnObject ret;

        if (item == null) { // if null object added do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
        } else {

            if (size + 1 > data.length) {
                adjustListSize();
            }

            int index = 0;  // start at top of array

            // scan down array until null object reached, signaling end of array content
            // should match class variable size...
            while(data[index] != null) {

                index++;

            }

            data[index] = item; // add new object to end of list
            size++; // increment list size
            ret = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);    // return object added with no error

        }

        return ret;

    }

    /**
     * internal operation to adjust capacity of underlying content array
     * if list capacity reached, create new array with doubled length
     * copy data to new array and point class variable data to array of new capacity
     */
    private void adjustListSize() {

        int oldLength = data.length;
        int newLength = oldLength * 2;  // doubled capacity
        Object[] tmp = new Object[newLength]; // temporary array

        // populate new array wih content

        for (int i = 0 ; i < oldLength ; i++) {
            tmp[i] = data[i];
        }

        // point data variable to array with newly increased capacity

        data = tmp;

    }

    /**
     * internal operation to maintain integrity of list indices after object addition
     * if addition of new element exceeds array capacity, adjust the size of the array first
     * copies data content to temporary array
     * leaves null object at given array
     * continues to populate temporary array with data content at index + 1
     * points class variable data to now populated temporary array
     * @param index
     */
    private void shiftListRightFromIndex(int index) {

        // if list with added object exceeds current capacity, adjust the size of the array

        if (size + 1 >= data.length) {
            adjustListSize();
        }

        Object[] tmp = new Object[data.length]; // create temporary array

        // populate temporary array wih data content up to given index

        for (int i = 0 ; i < index ; i++) {
            tmp[i] = data[i];
        }

        // populate remainder of temporary array with data content

        for (int i = index ; i < tmp.length -1 ; i++) {
            tmp[i + 1] = data[i];
        }

        // point data array to newly constructed array with corrected content indices

        data = tmp;

    }

    /**
     * internal operation to maintain integrity of list indices after object removal
     * creates temporary array with size of data array
     * copies data content of array up to given index
     * skips object at given index and continues to copy data content with index shifted
     * points class variable data to now populated temporary array
     * @param index gives point in data array past which object should be shifted
     */
    private void shiftListLeftFromIndex(int index) {

        Object[] tmp = new Object[data.length]; //  create temporary array

        // populate temporary array with data content up to given index

        for (int i = 0 ; i < index ; i++) {
            tmp[i] = data[i];
        }

        // skip index and continue to copy data until all data content copied

        for (int i = index + 1 ; i < tmp.length ; i++) {
            tmp[i - 1] = data[i];
        }

        // point data array to newly constructed array with corrected content indices

        data = tmp;

    }

    /**
     * toString method to represent list and contents as string
     * for inspection and testing purposes
     * @return contents of list as string
     */
    public String toString() {

        StringBuilder sb = new StringBuilder(); // output to be constructed
        sb.append("["); // begin list with open square bracket

        // for each object in the list
        for (int i = 0; i < size; i++) {
            sb.append(data[i].toString());  // object to string
            sb.append(", ");    // delimiter
        }

        // correct final unnecessary delimiter
        if (sb.length() > 2) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append("]"); // close list with square bracket

        return sb.toString();   // return constructed output

    }

}
