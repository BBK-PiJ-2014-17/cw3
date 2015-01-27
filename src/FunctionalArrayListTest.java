/**
 * Created by Basil on 28/12/2014.
 */
public class FunctionalArrayListTest {

    private FunctionalArrayList aList;

    public static void main(String[] args) {

        System.out.println("***\tFunctional Array List Test Module\t***\n");

        FunctionalArrayListTest falt = new FunctionalArrayListTest();
        falt.launch();

    }

    private void launch() {

        aList = new FunctionalArrayList();

        /* FUNCTIONAL & ERROR TESTS */

        System.out.println("Initial EMPTY list: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        testGetHead();

        // Get rest...

        System.out.println("\nRest of list: " + aList.rest().toString());
        System.out.println("Is EMPTY? " + aList.rest().isEmpty());
        System.out.println("Has size? " + aList.rest().size());

        System.out.println("\nAdding objects to the end of the list...");

        testAdd(1);
        testAdd("item2");
        testAdd("item3");
        testAdd(4);
        testAdd(null);
        testAdd(5);

        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        // Get head and rest...

        System.out.println("\nGet head and rest...");

        testGetHead();

        System.out.println("\nRest of list: " + aList.rest().toString());
        System.out.println("Is EMPTY? " + aList.rest().isEmpty());
        System.out.println("Has size? " + aList.rest().size());


    }

    private void testGetHead() {

        ReturnObject ret = aList.head();

        if (!ret.hasError()) {
            System.out.println("\nGetting head of list: "
                                + ret.getReturnValue().toString());
        } else {
            System.out.println("\nError getting head from list.\n"
                                + ret.getError());
        }

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
