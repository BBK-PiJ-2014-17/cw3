/**
 * Created by Basil on 28/12/2014.
 */
public class SampleableListImplTest {

    private SampleableList aList;

    public static void main(String[] args) {

        System.out.println("***\tSampleable List Test Module\t***\n");

        SampleableListImplTest slit = new SampleableListImplTest();
        slit.launch();

    }

    private void launch() {

        aList = new SampleableListImpl();

        List sample;

        /* FUNCTIONAL & ERROR TESTS */

        System.out.println("Initial EMPTY list: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        sample = aList.sample();

        System.out.println("\nOriginal List:\t" + aList.toString());
        System.out.println("Sample of list:\t" + sample.toString());
        System.out.println("Is EMPTY? " + sample.isEmpty());
        System.out.println("Has size? " + sample.size());

        testAdd(1);
        testAdd("item2");
        testAdd("item3");
        testAdd(4);
        testAdd(null);
        testAdd(5);

        sample = aList.sample();

        System.out.println("\nOriginal List:\t" + aList.toString());
        System.out.println("Sample of list:\t" + sample.toString());
        System.out.println("Is EMPTY? " + sample.isEmpty());
        System.out.println("Has size? " + sample.size());

        testRemove(2);
        testRemove(3);
        testRemove(1);

        sample = aList.sample();

        System.out.println("\nOriginal List:\t" + aList.toString());
        System.out.println("Sample of list:\t" + sample.toString());
        System.out.println("Is EMPTY? " + sample.isEmpty());
        System.out.println("Has size? " + sample.size());

        testRemove(0);

        sample = aList.sample();

        System.out.println("\nOriginal List:\t" + aList.toString());
        System.out.println("Sample of list:\t" + sample.toString());
        System.out.println("Is EMPTY? " + sample.isEmpty());
        System.out.println("Has size? " + sample.size());

        testRemove(0);

        sample = aList.sample();

        System.out.println("\nOriginal List:\t" + aList.toString());
        System.out.println("Sample of list:\t" + sample.toString());
        System.out.println("Is EMPTY? " + sample.isEmpty());
        System.out.println("Has size? " + sample.size());

        testAdd(234);
        testAdd("hello");
        testAdd("football");
        testAdd(5);
        testAdd(190);
        testAdd("food");
        testAdd(1);
        testAdd("stuff");
        testAdd("random");
        testAdd(78);
        testAdd(null);
        testAdd(5);

        sample = aList.sample();

        System.out.println("\nOriginal List:\t" + aList.toString());
        System.out.println("Sample of list:\t" + sample.toString());
        System.out.println("Is EMPTY? " + sample.isEmpty());
        System.out.println("Has size? " + sample.size());

        // check changes to sample do not affect original.

        sample.add("test");

        System.out.println("\nOriginal List:\t" + aList.toString());
        System.out.println("Sample of list:\t" + sample.toString());
        System.out.println("Is EMPTY? " + sample.isEmpty());
        System.out.println("Has size? " + sample.size());

    }

    private void testGet(int index) {

        ReturnObject ret = aList.get(index);

        if (!ret.hasError()) {
            System.out.println("\nGetting object from list at index " + index
                    + ": "
                    + "\n\t"  + ret.getReturnValue().toString());
        } else {
            System.out.println("\nError getting object from list at index " + index
                    + ": "
                    + "\n\t" + ret.getError());
        }

    }

    private void testAdd(Object o) {

        ReturnObject ret = aList.add(o);

        if (!ret.hasError()) {
            System.out.println("\nAdding object " + o.toString() + " to end of list.");
        } else {
            System.out.println("\nError adding object:"
                    + "\n\t" + ret.getError());
        }

    }

    private void testAddAtIndex(int index, Object o) {

        ReturnObject ret = aList.add(index, o);

        if (!ret.hasError()) {
            System.out.println("\nAdding object " + o.toString() + " at index "
                    + index + ".");
        } else {
            System.out.println("\nError adding object at index "
                    + index + "."
                    + "\n\t" + ret.getError());
        }

    }

    private void testRemove(int index) {

        ReturnObject ret = aList.remove(index);

        if (!ret.hasError()) {
            System.out.println("\nRemoving object at index "
                    + index + " returns: "
                    + ret.getReturnValue().toString());
        } else {
            System.out.println("\nError removing object at index "
                    + index + "."
                    + "\n\t" + ret.getError());
        }

    }
}
