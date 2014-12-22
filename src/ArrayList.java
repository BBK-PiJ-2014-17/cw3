import java.lang.reflect.Array;

/**
 * Created by Basil on 22/12/2014.
 */
public class ArrayList implements List {

    private Object[] data;
    private int size;

    public ArrayList() {
        data = new Object[5];
        size = 0;
    }

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

        if (index > size || index < 0) {
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            ret = new ReturnObjectImpl(data[index], ErrorMessage.NO_ERROR);
        }

        return ret;
    }

    /**
     * Returns the elements at the given position and removes it
     * from the list. The indeces of elements after the removed
     * element must be updated accordignly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message,
     *         encapsulated in a ReturnObject
     */
    public ReturnObject remove(int index) {

        ReturnObject ret;

        if (index > size || index < 0) {
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            shiftListLeftFromIndex(index);
            size--;
            ret = new ReturnObjectImpl(data[index], ErrorMessage.NO_ERROR);
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

        if (item == null) {
            ret = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
        } else if (index > size || index < 0) {
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            shiftListRightFromIndex(index);
            data[index] = item;
            size++;
            ret = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);
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

        if (item == null) {
            ret = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
        } else {
            int index = 0;

            while(data[index] != null) {

                index++;

                if (index > data.length - 1) {
                    adjustListSize();
                }

            }



            data[index] = item;

            size++;
            ret = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);

        }

        return ret;

    }

    private void adjustListSize() {

        System.out.println("DOUBLING ARRAY");

        int oldLength = data.length;
        int newLength = oldLength * 2;
        Object[] tmp = new Object[newLength];

        for (int i = 0 ; i < oldLength ; i++) {
            tmp[i] = data[i];
        }

        data = tmp;

    }

    private void shiftListRightFromIndex(int index) {

        Object[] tmp = new Object[data.length];

        for (int i = 0 ; i < index ; i++) {
            tmp[i] = data[i];
        }

        for (int i = index ; i < tmp.length -1 ; i++) {
            tmp[i + 1] = data[i];
        }

        data = tmp;

    }

    private void shiftListLeftFromIndex(int index) {

        Object[] tmp = new Object[data.length];

        for (int i = 0 ; i < index ; i++) {
            tmp[i] = data[i];
        }

        for (int i = index + 1 ; i < tmp.length ; i++) {
            tmp[i - 1] = data[i];
        }

        data = tmp;

    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(data[i].toString());
            sb.append(", ");
        }

        if (sb.length() > 2) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append("]");

        return sb.toString();

    }

}
