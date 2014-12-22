/**
 * Created by Basil on 22/12/2014.
 */
public class LinkedList implements List {

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Returns true if the list is empty, false otherwise.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (head == null) ? true : false;
    }

    /**
     * Returns the number of items currently in the list.
     *
     * @return the number of items currently in the list
     */
    public int size() {
        return this.size;
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

            Node tmp = head;

            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();

            }

            ret = new ReturnObjectImpl(tmp.getData(), ErrorMessage.NO_ERROR);
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

        Node tmp;
        ReturnObject ret;

        if (index > size || index < 0) {
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {

            size--;

            if (index == 0) {
                head = head.getNext();
            } else {

                tmp = head;

                for (int i = 0; i < index - 2; i++) {
                    tmp = tmp.getNext();
                }

                tmp.setNext(tmp.getNext().getNext());

            }

            ret = new ReturnObjectImpl(null, ErrorMessage.NO_ERROR);

        }

        return ret;
    }

    /**
     * Adds an element to the list, inserting it at the given
     * position. The indeces of elements at and after that position
     * must be updated accordignly.
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

        Node tmp;
        ReturnObject ret;

        if (item == null) {
            ret = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
        } else if (index > size || index < 0) {
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {

            size++;

            tmp = head;

            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.getNext();
            }

            Node add = new Node();
            add.setData(item);
            add.setNext(tmp.getNext());
            tmp.setNext(add);

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

        Node tmp = new Node();
        ReturnObject ret;

        if (item == null) {
            ret = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
        } else {

            size++;

            if (head == null) {

                tmp.setData(item);
                head = tmp;

            } else {

                tmp = head;

                while(tmp.getNext() != null) {
                    tmp = tmp.getNext();
                }

                Node add = new Node();
                add.setData(item);

                tmp.setNext(add);

            }

            ret = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);
        }

        return ret;

    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        Node tmp = head;

        sb.append("[");

        if (tmp == null) {

        } else {

            do {
                sb.append(tmp.getData().toString());
                sb.append(", ");
                tmp = tmp.getNext();
            } while (tmp != null);

        }

        if (sb.length() > 2) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");

        return sb.toString();

    }

    private class Node {

        private Node next;
        private Object data;

        public Node() {
            next = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

}
