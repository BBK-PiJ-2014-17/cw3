/**
 * Created by Basil on 22/12/2014.
 *
 * List implementation based on pointers
 */
public class LinkedList implements List {

    // class variables

    private Node head;  // head of list
    private int size;   // size of list

    // constructors

    /**
     * default constructor
     * head null until first element added
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // class methods

    /**
     * check if list is empty, based on class variable head
     * @return true if head is null.
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

        ReturnObject ret;   // return object

        if (size == 0) {    // if list is empty do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
        } else if (index >= size || index < 0) { // if index is out of bounds do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {    // fetch object at index

            Node tmp = head;    //  start at head, safe to assume list is non-empty due to size == 0 clause

            for (int i = 0; i < index; i++) {   // scan through list
                tmp = tmp.getNext();
            }

            ret = new ReturnObjectImpl(tmp.getData(), ErrorMessage.NO_ERROR);   // populate return object with node data
        }

        return ret; // return object
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

        Node tmp, prev;   // temporary node
        ReturnObject ret;   // return object

        if (size == 0) {  // empty structure
            ret = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
        } else if (index > size || index < 0) {    // if index out of bounds do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {    // remove object

            size--; // decrement instance variable size
            tmp = head; // safe to assume non-empty due to index > size clause
            prev = null;

            if (index == 0) {   // if beginning of list removed, correct head
                head = head.getNext();
            } else {    // scan list until index reached

                for (int i = 0; i < index; i++) {
                    prev = tmp; // store node before node to be removed
                    tmp = tmp.getNext();    // skip along list
                }

                prev.setNext(tmp.getNext());
                //tmp.setNext(tmp.getNext().getNext());   // correct links following removal

            }

            // return removed object...

            ret = new ReturnObjectImpl(tmp.getData(), ErrorMessage.NO_ERROR);    // return removed object

        }

        return ret; // return object
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

        Node tmp;   // temporary node
        ReturnObject ret;   // return object

        if (item == null) { // if null object added do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
        } else if (index >= size || index < 0) {    // if index out of bounds do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {    // add object

            size++; // increment instance variable size
            tmp = head; // start at head of list, possibly null
            Node add = new Node();  // temporary node to store object being added
            add.setData(item);

            if (index == 0) {   // if add at beginning of list, update head

                head = add;
                head.setNext(tmp);

            } else {    // scan list until index reached

                for (int i = 0; i < index - 1; i++) {
                    tmp = tmp.getNext();
                }

                add.setNext(tmp.getNext()); // correct links of following nodes
                tmp.setNext(add);
            }

            ret = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);    // populate return object with added item
        }

        return ret; // return object

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

        if (item == null) { // if null object added do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
        } else {

            size++; // increment instance variable size

            if (head == null) { // if currently empty list

                tmp.setData(item);
                head = tmp; // set head

            } else {

                tmp = head; // start at head of list

                while(tmp.getNext() != null) {  // scan list until end reached
                    tmp = tmp.getNext();
                }

                // tmp now points to last node in list

                Node add = new Node();  // create temporary node with content to be added
                add.setData(item);

                tmp.setNext(add);   // link last node to new node

            }

            ret = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);
        }

        return ret;

    }

    /**
     * toString method to represent list and contents as string
     * for inspection and testing purposes
     * @return contents of list as string
     */
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

    /**
     * inner class Node used to contain data and pointer to next list element
     */
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
