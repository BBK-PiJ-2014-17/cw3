/**
 * Created by Basil on 28/12/2014.
 */
public class FunctionalLinkedListTest {

    public static void main(String[] args) {

        System.out.println("***\tFunctional Linked List Test Module\t***\n");

        FunctionalLinkedList aList = new FunctionalLinkedList();

        /* FUNCTIONAL TESTS */

        System.out.println("Initial EMPTY list: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        // Add objects to EMPTY list...

        System.out.println("\nAdding objects to the end of the list...\n");

        System.out.println("\t" + aList.add(1).getError());
        System.out.println("\t" + aList.add("item2").getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        // Get list Head...

        System.out.println("\nHead of List:\n"
                + "\t" + aList.head().getError()
                + "\n\t"  +aList.head().getReturnValue().toString());

        // Get rest...

        System.out.println("\nRest of list: " + aList.rest().toString());
        System.out.println("Is EMPTY? " + aList.rest().isEmpty());
        System.out.println("Has size? " + aList.rest().size());

    }
}
