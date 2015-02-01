/**
 * Created by Basil on 22/12/2014.
 */
public class LinkedListTest {

    private List aList;

    public static void main(String[] args) {

        System.out.println("***\tLinked List Test Module\t***\n");

        LinkedListTest llt = new LinkedListTest();
        llt.launch();

    }

    private void launch() {

        aList = new LinkedList();

        inspectList(aList);

        System.out.println("\nAdding objects to the end of the list...");

        testAdd(1);
        testAdd("item2");
        testAdd("item3");
        testAdd(4);
        testAdd(null);
        testAdd(5);

        inspectList(aList);

        System.out.println("\nGetting objects from the list...");

        testGet(0);
        testGet(1);
        testGet(2);
        testGet(3);
        testGet(4);
        testGet(5);
        testGet(100);
        testGet(-3);

        inspectList(aList);

        System.out.println("\nInserting objects to specific indices...");

        testAddAtIndex(1, "item10");
        testAddAtIndex(0, 11);
        testAddAtIndex(5, "12");
        testAddAtIndex(10, 13);
        testAddAtIndex(3, null);
        testAddAtIndex(1, "item14");
        testAddAtIndex(-1, "item14");
        testAddAtIndex(1, "item19");
        testAddAtIndex(1, "item18");
        testAddAtIndex(1, "item17");

        inspectList(aList);

        System.out.println("\nRemoving objects from specific index...");

        testRemove(0);
        testRemove(2);
        testRemove(100);
        testRemove(0);
        testRemove(2);
        testRemove(0);
        testRemove(5);
        testRemove(0);
        testRemove(-1);
        testRemove(0);
        testRemove(0);
        testRemove(5);
        testRemove(0);

        inspectList(aList);

        testRemove(0);
        testRemove(0);
        testRemove(0);
        testRemove(0);

        inspectList(aList);

        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);
        testAdd(1);

        inspectList(aList);

    }

    private void inspectList(List l) {
        System.out.println("\nList: " + l.toString());
        System.out.println("Is EMPTY? " + l.isEmpty());
        System.out.println("Has size? " + l.size());
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
