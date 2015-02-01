/**
 * Created by Basil on 27/01/2015.
 *
 * implementation of improved stack
 * Status: Final
 */
public class ImprovedStackImpl implements ImprovedStack {

    private Stack stack;    // internal stack object

    // constructors

    /**
     * default constructor
     * create improved stack with empty list, default linked list
     */
    public ImprovedStackImpl() {
        stack = new StackImpl((new LinkedList()));
    }

    /**
     * list constructor
     * create Improved stack with underlying list structure
     * @param list to create stack with
     */
    public ImprovedStackImpl(List list) {
        stack = new StackImpl(list);
    }

    // interface methods

    /** {@inheritDoc}
     * reverse elements in stack
     * @return returns copy of stack with elements reversed
     */
    @Override
    public ImprovedStack reverse() {

        ImprovedStack ret = new ImprovedStackImpl(new LinkedList());    // return object
        Stack tmp = new StackImpl(new LinkedList());    // temporary stack

        // populate return stack with items in reverse order
        while(!stack.isEmpty()) {
            ReturnObject item = stack.pop();    // pop stack
            ret.push(item.getReturnValue());    // push to ret
            tmp.push(item.getReturnValue());    // push to tmp
        }

        // re-populate initial stack to leave unchanged
        while(!tmp.isEmpty()) {
            ReturnObject item = tmp.pop();      // pop tmp
            stack.push(item.getReturnValue());  // push to stack
        }

        return ret; // return object

    }

    /** {@inheritDoc}
     * remove any object matching @param
     * @param object to remove
     */
    @Override
    public void remove(Object object) {

        Stack tmp = new StackImpl(new LinkedList());    // temporary stack

        // populate return stack with items in reverse order
        while(!stack.isEmpty()) {
            ReturnObject item = stack.pop();
            if (object.equals(item.getReturnValue())) { // if object matches
                // do nothing
            } else {    // store in temporary stack
                tmp.push(item.getReturnValue());
            }
        }

        // re-populate initial stack with item(s) removed
        while(!tmp.isEmpty()) {
            ReturnObject item = tmp.pop();
            stack.push(item.getReturnValue());
        }
    }

    /** {@inheritDoc}
     * check if contained stack object is empty
     * @return returns true of false
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /** {@inheritDoc}
     * check contained stack size
     * @return
     */
    @Override
    public int size() {
        return stack.size();
    }

    /** {@inheritDoc}
     * push object onto contained stack
     * @param item the new item to be added
     */
    @Override
    public void push(Object item) {
        stack.push(item);
    }

    /** {@inheritDoc}
     * @return returns object at top of contained stack structure
     */
    @Override
    public ReturnObject top() {
        return stack.top();
    }

    /** {@inheritDoc}
     * @return returns object popped of contained stack structure
     */
    @Override
    public ReturnObject pop() {
        return stack.pop();
    }

    // class methods

    /**
     * view stack as string
     * @return string representing stack
     */
    public String toString() {
        return stack.toString();
    }
}
