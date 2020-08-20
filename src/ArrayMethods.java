import java.io.PrintWriter;
import java.util.Arrays;

public class ArrayMethods
{
    //private int[] values;
    PrintWriter out;
    public ArrayMethods(int[] initialValues, PrintWriter Out) {
        //values=initialValues;
        out = Out;
    }

    //a. Swap the first and last elements in the array.
    public void swapFirstAndLast(int[] initialValues) {
        int[] values = initialValues.clone();
        int temp = values[0];
        values[0] = values[values.length-1];
        values[values.length-1] = temp;

        //printout output
        out.println("a. Swap the first and last elements in the array.");
        out.println("Modified array is:");
        out.println(Arrays.toString(values));

    }

    //b. Shift all elements to the right by one and move the last element into the first position.
    public void shiftRight(int[] initialValues) {
        int[] values = initialValues.clone();
        int temp = values[values.length-1];
        for (int i=values.length-1; i>0;i--)
        values[i] = values[i-1];
        values[0] = temp;

        //printout output
        out.println("b. Shift all elements to the right by one and move the last element into the first position.");
        out.println("Modified array is:");
        out.println(Arrays.toString(values));

    }

    //c. Replace all even elements with 0.
    public void replaceAllEvenWithZero(int[] initialValues) {
        int[] values = initialValues.clone();
        for (int i=values.length-1; i>=0;i--) {
            if (values[i]%2==0)
            values[i] = 0;
        }

        //printout output
        out.println("c. Replace all even elements with 0.");
        out.println("Modified array is:");
        out.println(Arrays.toString(values));
    }

    //d. Replace each element except the first and last by the larger of its two neighbors.
    public void replaceWithLargerNeighbor(int[] initialValues) {
        int[] values = initialValues.clone();
        for (int i=1; i<values.length-1;i++) {
            if (values[i-1]>values[i+1])
                values[i] = values[i-1];
            else
                values[i] = values[i+1];
        }

        //printout output
        out.println("d. Replace each element except the first and last by the larger of its two neighbors.");
        out.println("Modified array is:");
        out.println(Arrays.toString(values));
    }

    //e. Remove the middle element if the array length is odd, or the middle two elements if the length is even.
    public void removeMiddle(int[] initialValues) {
        int[] values = initialValues.clone();
        int midA=0, midB=0, j=0;
        int[] newValue;
        if (values.length%2==0){
            midA = values.length/2-1;
            midB=midA+1;

            newValue = new int[values.length-2];
            for (int i=0; i<values.length;i++) {
                if (i!=midA && i!=midB) {
                    newValue[j] = values[i];
                    j++;
                }
            }
        }
        else {
            midA = (values.length + 1) / 2-1;
            newValue = new int[values.length - 1];
            for (int i = 0; i < values.length; i++) {
                if (i != midA) {
                    newValue[j] = values[i];
                    j++;
                }
            }
        }

        //printout output
        out.println("e. Remove the middle element if the array length is odd");
        out.println("Modified array is:");
        out.println(Arrays.toString(newValue));
    }

    //f. Move all even elements to the front, otherwise preserving the order of the elements.
    public void moveAllEvenToFront(int[] initialValues) {
        int[] values = initialValues.clone();
        int temp = 0;
        int counter = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                temp = values[i];
                for (int j = i; j > counter; j--) {
                    values[j] = values[j - 1];
                }
                values[counter] = temp;
                counter++;
            }
        }
            //printout output
            out.println("f. Move all even elements to the front, otherwise preserving the order of the elements.");
            out.println("Modified array is:");
            out.println(Arrays.toString(values));

    }

    //g. Return the second-largest element in the array.
    public int returnSecondLarge(int[] initialValues) {
        int[] values = initialValues.clone();
        int firstLarge=values[0], secondLarge=values[0];
        for (int i=0; i<values.length-1;i++) {
            if(firstLarge<values[i+1])
                 firstLarge= values[i+1];
        }

        for (int i=0; i<values.length-1;i++) {
            if(secondLarge<values[i+1] && values[i+1]<firstLarge)
                secondLarge= values[i+1];
        }

        //printout output
        out.println("g. Return the second-largest element in the array.");
        out.println("Second large item is:");
        out.println(secondLarge);
        return secondLarge;
    }

    //h. Return true if the array is currently sorted in increasing order.
    public boolean returnTrueIfIncreaseOrder(int[] initialValues) {
        int[] values = initialValues.clone();
        boolean isSorted = true;
        for (int i=0; i<values.length-2;i++) {
            if(values[i]>values[i+1]){
                isSorted=false;
                break;
            }
        }

        //printout output
        out.println("h. Return true if the array is currently sorted in increasing order.");
        out.println("Array is currently sorted in increasing order - " + isSorted);
        return isSorted;
    }

    //i. Return true if the array contains two adjacent duplicate elements.
    public boolean returnTrueIfContainsTwoAdjacentDuplicates(int[] initialValues) {
        int[] values = initialValues.clone();
        boolean isContainsAdjDuplElems = false;
        for (int i=0; i<values.length-2;i++) {
            if(values[i]==values[i+1])
                isContainsAdjDuplElems=true;
        }

        //printout output
        out.println("i. Return true if the array contains two adjacent duplicate elements.");
        out.println("Array contains two adjacent duplicate elements - " + isContainsAdjDuplElems);
        return isContainsAdjDuplElems;
    }

    //j. Return true if the array contains duplicate elements (which need not be adjacent).
    public boolean returnTrueIfContainsNotAdjacentDuplicates(int[] initialValues) {
        int[] values = initialValues.clone();
        boolean isContainsNotAdjDuplElems = false;

        for (int i=0; i<values.length-1;i++) {
            int duplicateElement=values[i];
            for (int j=i+1; j<values.length-1;j++) {
                if (duplicateElement == values[j] &&duplicateElement!=values[j-1])
                    isContainsNotAdjDuplElems = true;
            }
        }

        //printout output
        out.println("j. Return true if the array contains duplicate elements (which need not be adjacent).");
        out.println("Array contains not adjacent two duplicate elements - " + isContainsNotAdjDuplElems);
        return isContainsNotAdjDuplElems;
    }


}
