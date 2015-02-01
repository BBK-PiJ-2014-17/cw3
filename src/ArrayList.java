/**
 * Created by Basil on 22/12/2014.
 *
 * List implementation based on array structure
 * Status: Final.
 */
public class ArrayList implements List {

    // class variables

    private Object[] data;  // object array for list content
    private int size;       // list size, to be maintained by class methods

    // constructors

    /**
     * default constructor
     * arbitrary object array start size
     */
    public ArrayList() {
        data = new Object[10];
        size = 0;
    }

    /**
     * size constructor
     * choice underlying array size for optimization purposes
     */
    public ArrayList(int n) {
        data = new Object[n];
        size = 0;
    }

    // interface methods

    /** {@inheritDoc}
     * checks instance variable size before returning boolean
     * @return returns true or false
     */
    @Override
    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }

    /** {@inheritDoc}
     * @return returns instance variable size
     */
    @Override
    public int size() {
        return size;
    }

    /** {@inheritDoc}
     * @param index sets index of object to get
     * @return returns object at index or error
     */
    @Override
    public ReturnObject get(int index) {

        ReturnObject ret;   // return object

        if (size == 0) {    // if list is empty do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
        } else if (index >= size || index < 0) { // if index out of bounds do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {    // access underlying data array at given index and return object
            ret = new ReturnObjectImpl(data[index], ErrorMessage.NO_ERROR);
        }

        return ret; // return object
    }

    /** {@inheritDoc}
     * @param index sets index of object to remove
     * @return returns object at index or error
     */
    @Override
    public ReturnObject remove(int index) {

        ReturnObject ret;   // return object

        if (size == 0) {  // if list is empty do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
        } else if (index > size || index < 0) {    // if index out of bounds do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {    // access underlying data array, return and remove object
            ret = new ReturnObjectImpl(data[index], ErrorMessage.NO_ERROR);
            shiftListLeftFromIndex(index);  // update indices to remove object
            size--; // decrease size of list
        }

        return ret; // return object

    }

    /** {@inheritDoc}
     * @param index sets index at which to add object
     * @param item provides object to be added, cannot be null
     * @return returns added object or error
     */
    @Override
    public ReturnObject add(int index, Object item) {

        ReturnObject ret;   // return object

        if (item == null) { // if null object added do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
        } else if (index > size || index < 0) { // if index out of bounds do nothing and report error
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {    // add object to underlying data array
            shiftListRightFromIndex(index); // update indices of all objects, leaving a null object at given index
            data[index] = item; // overwrite null object at given index with new object
            size++; // increase size of list
            ret = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);    //  return object added with no error
        }

        return ret; // return object

    }

    /** {@inheritDoc}
     * @param item provides object to be added, cannot be null
     * @return returns added object or error
     */
    @Override
    public ReturnObject add(Object item) {

        ReturnObject ret;   // return object

        if (item == null) { // if null object added do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
        } else {    // add object to end of underlying array
            if (size + 1 > data.length) // check underlying array capacity
                adjustListSize();    // if addition of element requires extra space, adjust array
            data[size] = item;  // add new object
            size++; // increment list size
            ret = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);    // return object added with no error
        }

        return ret; // return object

    }

    // class methods

    /**
     * internal operation to adjust capacity of underlying content array
     * if list capacity reached, create new array with doubled length
     * copy data to new array and point class variable data to array of new capacity
     */
    private void adjustListSize() {

        int oldLength = data.length;    // current capacity
        int newLength = oldLength * 2;  // increased capacity
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
     * @param index gives point in data array past which object should be shifted
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
