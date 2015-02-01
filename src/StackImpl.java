/**
 * Created by Basil on 30/12/2014.
 *
 * implementation of stack
 * treat zero-th element of the underlying list structure as the top of the stack
 * Status: Final.
 */
public class StackImpl extends AbstractStack {

    // constructors

    /**
     * default constructor
     * create empty list as underlying list structure, using linked lists
     * call super constructor to set list
     */
    public StackImpl(){
        super(new LinkedList());
    }

    /**
     * list constructor
     * create stack with existing underlying list structure
     * call super constructor to set list
     * @param list underlying data structure
     */
    public StackImpl(List list) {
        super(list);
    }

    // inherited methods

    /** {@inheritDoc}
     * checks size of underlying list structure before returning boolean
     * @return returns true or false
     */
    @Override
    public boolean isEmpty() {
        // check size of underlying list structure
        return (internalList.size() == 0) ? true : false;
    }

    /** {@inheritDoc}
     * @return returns instance variable size of underlying list structure
     */
    @Override
    public int size() {
        // return size of underlying list structure
        return internalList.size();
    }

    /** {@inheritDoc}
     * push object onto stack by adding it to the zero-th element of the underlying list structure
     * @param item to be added
     */
    @Override
    public void push(Object item) {
        // add element to beginning of underlying list structure
        if (size() == 0) {  // if list empty use default add to end method
            internalList.add(item);
        } else {    // else add to beginning
            internalList.add(0, item);
        }
    }

    /** {@inheritDoc}
     * view object at top of stack
     * @return returns zero-th object of underlying list structure
     */
    @Override
    public ReturnObject top() {
        // get element from beginning of underlying list structure
        return internalList.get(0);
    }

    /** {@inheritDoc}
     * pop object at top of stack, and removes zero-th element from underlying list structure
     * @return returns zero-th object of underlying list structure
     */
    @Override
    public ReturnObject pop() {
        return internalList.remove(0);
    }

    // class methods

    /**
     * view stack as string
     * @return string representing stack
     */
    public String toString() {
        return internalList.toString();
    }

}
