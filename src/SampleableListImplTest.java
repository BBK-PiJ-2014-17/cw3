/**
 * Created by Basil on 28/12/2014.
 */
public class SampleableListImplTest {

    public static void main(String[] args) {

        System.out.println("***\tSampleable List Test Module\t***\n");

        SampleableList aList = new SampleableListImpl();

        /* FUNCTIONAL TESTS */

        System.out.println("Initial EMPTY list: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        // Add objects to EMPTY list...

        System.out.println("\nAdding objects to the end of the list...\n");

        System.out.println("\t" + aList.add(1).getError());
        System.out.println("\t" + aList.add("item2").getError());
        System.out.println("\t" + aList.add(3).getError());
        System.out.println("\t" + aList.add("item4").getError());
        System.out.println("\t" + aList.add(5).getError());
        System.out.println("\t" + aList.add("item6").getError());
        //System.out.println("\t" + aList.add(7).getError());
        //System.out.println("\t" + aList.add("item8").getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        // Add objects to EMPTY list...

        System.out.println("\nGetting sample...\n");

        System.out.println("\nSample of list: " + aList.sample().toString());
        System.out.println("Is EMPTY? " + aList.sample().isEmpty());
        System.out.println("Has size? " + aList.sample().size());

    }
}
