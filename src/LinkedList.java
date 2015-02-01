/**
 * Created by Basil on 22/12/2014.
 *
 * List implementation based on pointers
 * Use inner class node to contain list item content and pointer
 * Status: Final.
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
        this.head = null;   // no head when empty
        this.size = 0;      // created empty
    }

    // interface methods

    /** {@inheritDoc}
     * check if list is empty, based on class variable head
     * @return returns true or false
     */
    @Override
    public boolean isEmpty() {
        return (head == null) ? true : false;
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
        } else if (index >= size || index < 0) { // if index is out of bounds do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {    // fetch object at index

            Node tmp = head;    //  start at head, safe to assume list is non-empty due to size == 0 statement

            for (int i = 0; i < index; i++) {   // scan through list
                tmp = tmp.getNext();    // skip to next element via pointer
            }

            ret = new ReturnObjectImpl(tmp.getData(), ErrorMessage.NO_ERROR);   // populate return object with node data
        }

        return ret; // return object
    }

    /** {@inheritDoc}
     * @param index sets index of object to remove
     * @return returns object at index or error
     */
    @Override
    public ReturnObject remove(int index) {

        Node tmp, prev;   // temporary nodes
        ReturnObject ret;   // return object

        if (size == 0) {  // empty structure
            ret = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
        } else if (index > size || index < 0) {    // if index out of bounds do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {    // remove object

            size--; // decrement instance variable size
            tmp = head; // safe to assume non-empty due to index > size statement
            prev = null;

            if (index == 0) {   // if beginning of list removed, correct head
                head = head.getNext();
            } else {    // scan list until index reached

                for (int i = 0; i < index; i++) {
                    prev = tmp; // store node before node to be removed
                    tmp = tmp.getNext();    // skip along list
                }

                prev.setNext(tmp.getNext());    // correct links from previous to next node, after removal

            }

            ret = new ReturnObjectImpl(tmp.getData(), ErrorMessage.NO_ERROR);    // return removed object

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

        Node tmp;   // temporary node
        ReturnObject ret;   // return object

        if (item == null) { // if null object added do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT);
        } else if (index >= size || index < 0) {    // if index out of bounds do nothing and return error
            ret = new ReturnObjectImpl(null, ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {    // add object

            size++; // increment instance variable size
            tmp = head; // start at head of list
            Node add = new Node();  // temporary node to store object being added
            add.setData(item);

            if (index == 0) {   // if add at beginning of list, update head

                head = add; // set added object at head of list
                head.setNext(tmp);  // set next object as previous head object

            } else {    // scan list until index reached

                for (int i = 0; i < index - 1; i++) {   // scan through until index before add
                    tmp = tmp.getNext();
                }

                add.setNext(tmp.getNext()); // correct links to following nodes
                tmp.setNext(add);   // correct links from previous nodes
            }

            ret = new ReturnObjectImpl(item, ErrorMessage.NO_ERROR);    // populate return object with added item
        }

        return ret; // return object

    }

    /** {@inheritDoc}
     * @param item provides object to be added, cannot be null
     * @return returns added object or error
     */
    @Override
    public ReturnObject add(Object item) {

        Node tmp = new Node();    // temporary node
        ReturnObject ret;   // return object

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

    // class methods

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

    // inner class

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
