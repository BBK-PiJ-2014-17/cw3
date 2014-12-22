/**
 * Created by Basil on 22/12/2014.
 */
public class ArrayListTest {

    public static void main(String[] args) {

        System.out.println("***\tArray List Test Module\t***\n");

        List aList = new ArrayList();

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

        // Get object from list...

        System.out.println("\nGetting object from list:\n"
                            + "\t" + aList.get(1).getError()
                            + "\n\t"  +aList.get(1).getReturnValue().toString());

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

    }

}
