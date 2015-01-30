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

    }
}
