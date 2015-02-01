/**
 * Created by Basil on 30/12/2014.
 */
public class StackImplTest {

    private List aList;
    private Stack aStack;

    public static void main(String[] args) {

        System.out.println("***\tStack Test Module\t***\n");

        StackImplTest sit = new StackImplTest();
        sit.launch();

    }

    private void launch() {

        System.out.println("**LIST SETUP**\n");

        aList = new LinkedList();

        /* FUNCTIONAL & ERROR TESTS */

        System.out.println("Initial EMPTY list: " + aList.toString());
        System.out.println("Is EMPTY? " + aList.isEmpty());
        System.out.println("Has size? " + aList.size());

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

        aStack = new StackImpl(aList);

        System.out.println("\nStack now contains objects: " + aStack.toString());
        System.out.println("Is EMPTY? " + aStack.isEmpty());
        System.out.println("Has size? " + aStack.size());

        aStack.push(2);
        aStack.push("item36");
        aStack.push(7658);

        System.out.println("\nStack now contains objects: " + aStack.toString());
        System.out.println("Is EMPTY? " + aStack.isEmpty());
        System.out.println("Has size? " + aStack.size());

        testTop();
        testTop();

        System.out.println("\nStack now contains objects: " + aStack.toString());
        System.out.println("Is EMPTY? " + aStack.isEmpty());
        System.out.println("Has size? " + aStack.size());

        testPop();
        testPop();

        System.out.println("\nStack now contains objects: " + aStack.toString());
        System.out.println("Is EMPTY? " + aStack.isEmpty());
        System.out.println("Has size? " + aStack.size());

        testPop();
        testPop();
        testPop();
        testPop();
        testPop();
        testPop();
        testPop();
        testPop();

        System.out.println("\nStack now contains objects: " + aStack.toString());
        System.out.println("Is EMPTY? " + aStack.isEmpty());
        System.out.println("Has size? " + aStack.size());

        testTop();

        System.out.println("\nStack now contains objects: " + aStack.toString());
        System.out.println("Is EMPTY? " + aStack.isEmpty());
        System.out.println("Has size? " + aStack.size());

        aStack.push(4768);
        aStack.push("item345");
        aStack.push(97);

        System.out.println("\nStack now contains objects: " + aStack.toString());
        System.out.println("Is EMPTY? " + aStack.isEmpty());
        System.out.println("Has size? " + aStack.size());

        Stack newStack = new StackImpl();

        System.out.println("\nNew stack now contains objects: " + newStack.toString());
        System.out.println("Is EMPTY? " + newStack.isEmpty());
        System.out.println("Has size? " + newStack.size());

        ReturnObject ret = newStack.pop();

        if (!ret.hasError()) {
            System.out.println("\nGetting top of stack: "
                    + ret.getReturnValue().toString());
        } else {
            System.out.println("\nError getting top of stack."
                    + "\n" + ret.getError());
        }

        newStack.push(4768);
        newStack.push("item345");
        newStack.push(97);

        System.out.println("\nNew stack now contains objects: " + newStack.toString());
        System.out.println("Is EMPTY? " + newStack.isEmpty());
        System.out.println("Has size? " + newStack.size());

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

    private void testTop() {

        ReturnObject ret = aStack.top();

        if (!ret.hasError()) {
            System.out.println("\nGetting top of stack: "
                    + ret.getReturnValue().toString());
        } else {
            System.out.println("\nError getting top of stack."
                    + "\n" + ret.getError());
        }

    }

    private void testPop() {

        ReturnObject ret = aStack.pop();

        if (!ret.hasError()) {
            System.out.println("\nPopping top of stack: "
                    + ret.getReturnValue().toString());
        } else {
            System.out.println("\nError popping top of stack."
                    + "\n" + ret.getError());
        }

    }

}
