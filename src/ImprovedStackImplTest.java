/**
 * Created by Basil on 30/01/2015.
 */
public class ImprovedStackImplTest {

    private ImprovedStack aStack;

    public static void main(String[] args) {

        System.out.println("***\tImproved Stack Test Module\t***\n");

        ImprovedStackImplTest sit = new ImprovedStackImplTest();
        sit.launch();

    }

    private void launch() {

        aStack = new ImprovedStackImpl(new LinkedList());

        aStack.push(1);
        aStack.push("item2");

        System.out.println("\nStack now contains objects: " + aStack.toString());
        System.out.println("Is EMPTY? " + aStack.isEmpty());
        System.out.println("Has size? " + aStack.size());

        Stack reversedStack = aStack.reverse();

        System.out.println("\nReversed stack contains objects: " + reversedStack.toString());
        System.out.println("Is EMPTY? " + reversedStack.isEmpty());
        System.out.println("Has size? " + reversedStack.size());

        Object item = "item4";

        aStack.push(item);
        aStack.push("item5");

        System.out.println("\nStack now contains objects: " + aStack.toString());
        System.out.println("Is EMPTY? " + aStack.isEmpty());
        System.out.println("Has size? " + aStack.size());

        reversedStack = aStack.reverse();

        System.out.println("\nReversed stack contains objects: " + reversedStack.toString());
        System.out.println("Is EMPTY? " + reversedStack.isEmpty());
        System.out.println("Has size? " + reversedStack.size());

        aStack.remove(item);

        System.out.println("\nStack now contains objects: " + aStack.toString());
        System.out.println("Is EMPTY? " + aStack.isEmpty());
        System.out.println("Has size? " + aStack.size());

        ImprovedStack newStack = new ImprovedStackImpl();
        ImprovedStack newReversedStack;

        System.out.println("\nStack now contains objects: " + newStack.toString());
        System.out.println("Is EMPTY? " + newStack.isEmpty());
        System.out.println("Has size? " + newStack.size());

        newReversedStack = newStack.reverse();

        System.out.println("\nStack now contains objects: " + newReversedStack.toString());
        System.out.println("Is EMPTY? " + newReversedStack.isEmpty());
        System.out.println("Has size? " + newReversedStack.size());

        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);
        newStack.push(5);
        newStack.push(6);

        System.out.println("\nStack now contains objects: " + newStack.toString());
        System.out.println("Is EMPTY? " + newStack.isEmpty());
        System.out.println("Has size? " + newStack.size());

        newReversedStack = newStack.reverse();

        System.out.println("\nStack now contains objects: " + newReversedStack.toString());
        System.out.println("Is EMPTY? " + newReversedStack.isEmpty());
        System.out.println("Has size? " + newReversedStack.size());

        newReversedStack.pop();

        System.out.println("\nStack now contains objects: " + newStack.toString());
        System.out.println("Is EMPTY? " + newStack.isEmpty());
        System.out.println("Has size? " + newStack.size());

        System.out.println("\nStack now contains objects: " + newReversedStack.toString());
        System.out.println("Is EMPTY? " + newReversedStack.isEmpty());
        System.out.println("Has size? " + newReversedStack.size());

    }
}
