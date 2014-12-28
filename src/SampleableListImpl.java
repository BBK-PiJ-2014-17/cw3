/**
 * Created by Basil on 28/12/2014.
 */
public class SampleableListImpl extends ArrayList implements SampleableList {

    /**
     * Returns a list containing the first, third, fifth...
     * items of this list, or an empty list if the list is empty.
     *
     * @return a list containing the first, third, fifth... items of this list
     */
    public SampleableList sample() {

        SampleableList ret = new SampleableListImpl();
        int size = this.size();

        if (size > 0) {

            for (int i = 0; i < this.size(); i+=2) {

                ret.add(this.get(i).getReturnValue());

            }

        }

        return ret;

    }

}
