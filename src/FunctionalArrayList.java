/**
 * Created by Basil on 28/12/2014.
 *
 * Functional List implementation based on array structure
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList {

    /**
     * Returns the element at the beginning of the list.
     *
     * If the list is empty, an appropriate error is returned.
     *
     * @return a copy of the element at the beginning of the list or
     *         an error if the list is empty.
     */
    public ReturnObject head() {

        ReturnObject ret, head;   // return object

        head = this.get(0); // get return object from head of list

        // copy data into new object
        ret = new ReturnObjectImpl(head.getReturnValue(), head.getError());

        return ret; // return object

    }

    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list.
     *
     * If the list is empty, another empty list is returned.
     */
    public FunctionalList rest() {

        FunctionalList ret = new FunctionalArrayList(); // return list
        int size = this.size(); // current size

        if (size > 0) { // if list is non-empty, populate with all but head, i.e. get(0)

            for (int i = 1; i < size; i++) {
                ret.add(this.get(i).getReturnValue());
            }

        }

        return ret; // return list

    }

}
