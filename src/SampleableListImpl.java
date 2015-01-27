/**
 * Created by Basil on 28/12/2014.
 *
 * implementation of sampleable list based on array structure
 */
public class SampleableListImpl extends ArrayList implements SampleableList {

    /**
     * Returns a list containing the first, third, fifth...
     * items of this list, or an empty list if the list is empty.
     *
     * @return a list containing the first, third, fifth... items of this list
     */
    public SampleableList sample() {

        SampleableList ret = new SampleableListImpl();  // return list
        int size = this.size(); // get size

        if (size > 0) { // if list non-empty populate with odd elements of list

            for (int i = 0; i < size; i+=2) {   // step by 2 to get odd elements
                ret.add(this.get(i).getReturnValue());
            }

        }

        return ret; // return list

    }

}
