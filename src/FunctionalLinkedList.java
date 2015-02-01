/**
 * Created by Basil on 28/12/2014.
 *
 * Functional List implementation based on pointers
 * Status: Final.
 */
public class FunctionalLinkedList extends LinkedList implements FunctionalList {

    /** {@inheritDoc}
     * @return returns head of list
     */
    @Override
    public ReturnObject head() {

        ReturnObject ret, head;   // return object

        head = this.get(0); // get return object from head of list

        // copy data into new object
        ret = new ReturnObjectImpl(head.getReturnValue(), head.getError());

        return ret; // return object

    }

    /** {@inheritDoc}
     * @return returns all of list except head
     */
    @Override
    public FunctionalList rest() {

        FunctionalList ret = new FunctionalLinkedList();  // return list

        int size = this.size(); // current size

        if (size > 0) { // if list is non-empty, populate with all but head, i.e. get(0)

            for (int i = 1; i < size; i++) {
                ret.add(this.get(i).getReturnValue());
            }

        }

        return ret; // return list

    }
}
