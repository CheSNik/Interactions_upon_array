import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * Assignment 5 E7.10 This program has many methods to interact with an array
 * @author Sergei Chekhonin
 */
public class TestArrayMethods {

    public static void main(String[] args) {
        //This block initialize printWriter and dateFormatter
        PrintWriter out = null;
        try {
            out = new PrintWriter("Assignment5_E7.10output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        out.println(dtf.format(now));

        int initial[] = {2,6,9,12,15,17,18,18,21,23};

        ArrayMethods methods = new ArrayMethods(initial,out);
        out.println("Initial array is:");
        out.println(Arrays.toString(initial));
        //a. Swap the first and last elements in the array.
        methods.swapFirstAndLast(initial);
        out.println("Expected:");
        out.println("[23, 6, 9, 12, 15, 17, 18, 18, 21, 2]");
        //b. Shift all elements to the right by one and move the last element into the first position.
        methods.shiftRight(initial);
        out.println("Expected:");
        out.println("[23, 2, 6, 9, 12, 15, 17, 18, 18, 21]");
        //c. Replace all even elements with 0.
        methods.replaceAllEvenWithZero(initial);
        out.println("Expected:");
        out.println("[0, 0, 9, 0, 15, 17, 0, 0, 21, 23]");
        //d. Replace each element except the first and last by the larger of its two neighbors.
        methods.replaceWithLargerNeighbor(initial);
        out.println("Expected:");
        out.println("[2, 9, 12, 15, 17, 18, 18, 21, 23, 23]");
        //e. Remove the middle element if the array length is odd, or the middle two elements if the length is even.
        methods.removeMiddle(initial);
        out.println("Expected:");
        out.println("[2, 6, 9, 12, 18, 18, 21, 23]");
        //f. Move all even elements to the front, otherwise preserving the order of the elements.
        methods.moveAllEvenToFront(initial);
        out.println("Expected:");
        out.println("[2, 6, 12, 18, 18, 9, 15, 17, 21, 23]");
        //g. Return the second-largest element in the array.
        methods.returnSecondLarge(initial);
        out.println("Expected:");
        out.println("21");
        //h. Return true if the array is currently sorted in increasing order.
        methods.returnTrueIfIncreaseOrder(initial);
        out.println("Expected:");
        out.println("true");
        //i. Return true if the array contains two adjacent duplicate elements.
        methods.returnTrueIfContainsTwoAdjacentDuplicates(initial);
        out.println("Expected:");
        out.println("true");
        //j. Return true if the array contains duplicate elements (which need not be adjacent).
        methods.returnTrueIfContainsNotAdjacentDuplicates(initial);
        out.println("Expected:");
        out.println("false");

        out.close();
        System.exit(0);

    }

}
