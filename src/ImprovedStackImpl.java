/**
 * Created by Basil on 27/01/2015.
 *
 * implementation of improved stack
 */
public class ImprovedStackImpl implements ImprovedStack {

    private Stack stack;

    // constructors

    public ImprovedStackImpl(List list) {
        stack = new StackImpl(list);
    }

    @Override
    public ImprovedStack reverse() {

        ImprovedStack ret = new ImprovedStackImpl(new LinkedList());
        Stack tmp = new StackImpl(new LinkedList());

        // populate return stack with items in reverse order

        while(!stack.isEmpty()) {

            ReturnObject item = stack.pop();

            ret.push(item.getReturnValue());
            tmp.push(item.getReturnValue());

        }

        // re-populate initial stack

        while(!tmp.isEmpty()) {

            ReturnObject item = tmp.pop();

            stack.push(item.getReturnValue());

        }

        return ret;

    }

    @Override
    public void remove(Object object) {

        Stack tmp = new StackImpl(new LinkedList());

        // populate return stack with items in reverse order

        while(!stack.isEmpty()) {

            ReturnObject item = stack.pop();

            if (object.equals(item.getReturnValue())) {
                // do nothing
            } else {
                tmp.push(item.getReturnValue());
            }

        }

        // re-populate initial stack

        while(!tmp.isEmpty()) {

            ReturnObject item = tmp.pop();
            stack.push(item.getReturnValue());

        }

    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public void push(Object item) {
        stack.push(item);
    }

    @Override
    public ReturnObject top() {
        return stack.top();
    }

    @Override
    public ReturnObject pop() {
        return stack.pop();
    }

    public String toString() {
        return stack.toString();
    }
}
