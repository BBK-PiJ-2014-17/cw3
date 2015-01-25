/**
 * Created by Basil on 30/12/2014.
 */
public class StackImpl extends AbstractStack {

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

        return 1;
    }

    /**
     * Adds an element at the top of the stack.
     *
     * @param item the new item to be added
     */
    public void push(Object item) {

    }

    /**
     * Returns the element at the top of the stack. The stack is
     * left unchanged.
     *
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    public ReturnObject top() {


        return new ReturnObjectImpl(null, ErrorMessage.NO_ERROR);
    }

    /**
     * Returns the element at the top of the stack. The element is
     * removed frmo the stack.
     *
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    public ReturnObject pop() {

        return new ReturnObjectImpl(null, ErrorMessage.NO_ERROR);
    }

}