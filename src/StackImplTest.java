/**
 * Created by Basil on 30/12/2014.
 */
public class StackImplTest {

    public static void main(String[] args) {

        System.out.println("***\tStack Test Module\t***\n");
        System.out.println("\n**LIST**\n");

        List aList = new LinkedList();

        /* Setup List */

        System.out.println("Initial EMPTY list: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

        System.out.println("\nAdding objects to the end of the list...\n");

        System.out.println("\t" + aList.add(1).getError());
        System.out.println("\t" + aList.add("item2").getError());
        System.out.println("\nList now contains objects: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());


        System.out.println("\n**STACK**");
        /* create Stack */

        Stack stack = new StackImpl(aList);

        System.out.println("\nStack is EMPTY? " + stack.isEmpty());
        System.out.println("Stack has size? " + stack.size());
        System.out.println("Stack now contains objects: " + stack.toString());

        System.out.println("\nPushing objects to Stack...\n");

        stack.push(3);
        System.out.println("Stack now contains objects: " + stack.toString());

        stack.push("item4");
        System.out.println("Stack now contains objects: " + stack.toString());

        System.out.println("\nPopping objects from Stack...\n");

        stack.pop();
        System.out.println("Stack now contains objects: " + stack.toString());

        stack.pop();
        System.out.println("Stack now contains objects: " + stack.toString());

        System.out.println("\nGet Top of Stack...\n"
                + "\t" + stack.top().getError()
                + "\n\t"  + stack.top().getReturnValue().toString());

        System.out.println("\nPopping objects from Stack...\n");

        stack.pop();
        System.out.println("Stack now contains objects: " + stack.toString());

        stack.pop();
        System.out.println("Stack now contains objects: " + stack.toString());

        stack.pop();
        System.out.println("Stack now contains objects: " + stack.toString());

        System.out.println("\nGet Top of Stack...\n"
                + "\t" + stack.top().getError());

        System.out.println("Stack now contains objects: " + stack.toString());


    }
}
