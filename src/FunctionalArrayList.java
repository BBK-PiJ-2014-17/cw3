/**
 * Created by Basil on 28/12/2014.
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

        ReturnObject ret;

        ret = new ReturnObjectImpl(this.get(0).getReturnValue().toString(), this.get(0).getError());

        return ret;

    }

    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list.
     *
     * If the list is empty, another empty list is returned.
     */
    public FunctionalList rest() {

        FunctionalList ret = new FunctionalArrayList();
        int size = this.size();

        if (size > 0) {

            for (int i = 1; i < this.size(); i++) {

                ret.add(this.get(i).getReturnValue());

                //System.out.println("ret EMPTY list: " + this.toString());
                //System.out.println("ret Is EMPTY? " + this.isEmpty());
                //System.out.println("ret Has size? " + this.size());

            }

        }

        return ret;

    }

}
