/**
 * Created by Basil on 22/12/2014.
 */
public class LinkedListTest {

    public static void main(String[] args) {

        System.out.println("***\tLinked List Test Module\t***\n");

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

        // Get object from list...

        System.out.println("\nGetting object from list:\n"
                + "\t" + aList.get(0).getError()
                + "\n\t"  +aList.get(0).getReturnValue().toString());

        // Insert objects at index...

        System.out.println("\nInserting objects to specific index...\n");

        System.out.println("\t" + aList.add(1, 3).getError());
        System.out.println("\t" + aList.add(1, "item4").getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        // Remove objects at index...

        System.out.println("\nRemoving objects from specific index...\n");

        System.out.println("\t" + aList.remove(0).getError());
        System.out.println("\t" + aList.remove(2).getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        /* ERROR TESTING */

        // Get object out of bounds

        System.out.println("\nGetting objects from out of bounds...\n");

        System.out.println("\t" + aList.get(-10).getError());
        System.out.println("\t" + aList.get(10).getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        // Remove object out of bounds

        System.out.println("\nRemoving objects from out of bounds...\n");

        System.out.println("\t" + aList.remove(-1).getError());
        System.out.println("\t" + aList.remove(7).getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        // Adding object out of bounds

        System.out.println("\nAdding objects from out of bounds...\n");

        System.out.println("\t" + aList.add(-3, "out").getError());
        System.out.println("\t" + aList.add(9, "out").getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        // check list size increase and decrease

        System.out.println("\nAdding objects to increase list array list size...\n");

        System.out.println("\t" + aList.add(5).getError());
        System.out.println("\t" + aList.add(6).getError());
        System.out.println("\t" + aList.add(7).getError());
        System.out.println("\t" + aList.add(8).getError());
        System.out.println("\t" + aList.add("nine").getError());
        System.out.println("\t" + aList.add("ten").getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        System.out.println("\t" + aList.add(5).getError());
        System.out.println("\t" + aList.add(6).getError());
        System.out.println("\t" + aList.add(7).getError());
        System.out.println("\t" + aList.add(8).getError());
        System.out.println("\t" + aList.add("nine").getError());
        System.out.println("\t" + aList.add("ten").getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        System.out.println("\t" + aList.add(5).getError());
        System.out.println("\t" + aList.add(6).getError());
        System.out.println("\t" + aList.add(7).getError());
        System.out.println("\t" + aList.add(8).getError());
        System.out.println("\t" + aList.add("nine").getError());
        System.out.println("\t" + aList.add("ten").getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        System.out.println("\t" + aList.add(5).getError());
        System.out.println("\t" + aList.add(6).getError());
        System.out.println("\t" + aList.add(7).getError());
        System.out.println("\t" + aList.add(8).getError());
        System.out.println("\t" + aList.add("nine").getError());
        System.out.println("\t" + aList.add("ten").getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        System.out.println("\nGetting object from list:\n"
                + "\t" + aList.get(14).getError()
                + "\n\t"  +aList.get(14).getReturnValue().toString());

        System.out.println("\nGetting object from list:\n"
                + "\t" + aList.get(24).getError()
                + "\n\t"  +aList.get(24).getReturnValue().toString());

        System.out.println("\nGetting object from list:\n"
                + "\t" + aList.get(8).getError()
                + "\n\t" + aList.get(8).getReturnValue().toString());

        System.out.println("\t" + aList.remove(0).getError());
        System.out.println("\t" + aList.remove(2).getError());
        System.out.println("\t" + aList.remove(24).getError());
        System.out.println("\t" + aList.remove(12).getError());
        System.out.println("\t" + aList.remove(8).getError());
        System.out.println("\t" + aList.remove(8).getError());
        System.out.println("\t" + aList.remove(13).getError());
        System.out.println("\t" + aList.remove(2).getError());
        System.out.println("\t" + aList.remove(21).getError());
        System.out.println("\t" + aList.remove(16).getError());
        System.out.println("\t" + aList.remove(9).getError());
        System.out.println("\t" + aList.remove(6).getError());
        System.out.println("\t" + aList.remove(12).getError());

        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());


    }
}
