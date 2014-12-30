/**
 * Created by Basil on 30/12/2014.
 */
public class StackImplTest {

    public static void main(String[] args) {

        System.out.println("***\tStack Test Module\t***\n");

        List aList = new LinkedList();

        /* FUNCTIONAL TESTS */

        System.out.println("Initial EMPTY list: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        System.out.println("\nAdding objects to the end of the list...\n");

        System.out.println("\t" + aList.add(1).getError());
        System.out.println("\t" + aList.add("item2").getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        Stack stack = new StackImpl(aList);

        System.out.println("\nStack is EMPTY? " + stack.isEmpty());

    }
}
