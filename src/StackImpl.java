/**
 * Created by Basil on 30/12/2014.
 *
 * implementation of stack
 * treat zero-th element of the underlying list structure as the top of the stack
 */
public class StackImpl extends AbstractStack {

    // constructors

    /**
     * construct stack with underlying list structure
     * call super constructor to set list
     * @param list underlying data structure
     */
    public StackImpl(List list) {
        super(list);
    }

    /**
     * Returns true if the stack is empty, false otherwise.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        // check size of underlying list structure
        return (internalList.size() == 0) ? true : false;
    }

    /**
     * Returns the number of items currently in the stack.
     *
     * @return the number of items currently in the stack
     */
    public int size() {
        // return size of underlying list structure
        return internalList.size();
    }

    /**
     * Adds an element at the top of the stack.
     *
     * @param item the new item to be added
     */
    public void push(Object item) {
        // add element to beginning of underlying list structure
        if (size() == 0) {  // if list empty use default add to end method
            internalList.add(item);
        } else {    // else add to beginning
            internalList.add(0, item);
        }
    }

    /**
     * Returns the element at the top of the stack. The stack is
     * left unchanged.
     *
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    public ReturnObject top() {
        // get element from beginning of underlying list structure
        return internalList.get(0);
    }

    /**
     * Returns the element at the top of the stack. The element is
     * removed from the stack.
     *
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    public ReturnObject pop() {

        //ReturnObject ret, pop;

        //pop = internalList.remove(0);

        //ret = new ReturnObjectImpl(pop.get, ErrorMessage.EMPTY_STRUCTURE);

        /*
        if (internalList.get(0).getReturnValue() == null) {
            ret = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
        } else {
            ret = new ReturnObjectImpl(internalList.get(0).getReturnValue(), internalList.get(0).getError());
            internalList.remove(0);
        }*/

        //return ret;

        return internalList.remove(0);
    }

    public String toString() {
        return internalList.toString();
    }

}
