/**
 * Created by Basil on 28/12/2014.
 *
 * implementation of sampleable list based on array structure
 * Status: Final.
 */
public class SampleableListImpl extends ArrayList implements SampleableList {

    /** {@inheritDoc}
     * @return returns odd elements of list
     */
    @Override
    public SampleableList sample() {

        SampleableList ret = new SampleableListImpl();  // return list
        int size = this.size(); // get size

        if (size > 0) { // if list non-empty populate return list with odd elements

            for (int i = 0; i < size; i+=2) {   // step by 2 to get odd elements
                ret.add(this.get(i).getReturnValue());
            }

        }

        return ret; // return list

    }

}
