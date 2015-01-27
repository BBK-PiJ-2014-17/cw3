/**
 * Created by Basil on 30/12/2014.
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

        return (internalList.size() == 0) ? true : false;
    }

    /**
     * Returns the number of items currently in the stack.
     *
     * @return the number of items currently in the stack
     */
    public int size() {

        return internalList.size();
    }

    /**
     * Adds an element at the top of the stack.
     *
     * @param item the new item to be added
     */
    public void push(Object item) {

        internalList.add(0, item);

    }

    /**
     * Returns the element at the top of the stack. The stack is
     * left unchanged.
     *
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    public ReturnObject top() {

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

        ReturnObject ret;

        if (internalList.get(0).getReturnValue() == null) {
            ret = new ReturnObjectImpl(null, ErrorMessage.EMPTY_STRUCTURE);
        } else {
            ret = new ReturnObjectImpl(internalList.get(0).getReturnValue(), internalList.get(0).getError());
            internalList.remove(0);
        }

        return ret;
    }

    public String toString() {

        return internalList.toString();

    }

}
