/**
 * Making a generic method that can take two list and return the number of times the elements of the 
 * shorter array are found in the longer array
 *
 * @author Matthew Laframboise
 * @version Spring 2023
 */

public class GenericMethodExample
{
    /**
     * Returns the number of times the elements of the 
     * shorter array are contained in the longer array.
     * 
     * @param arrayA A non-null array of strings.
     * @param arrayB A non-null array of strings.
     * @return The number of times the elements of the 
     * shorter array are contained in the longer array.
     */
    // public static int countOccurrences(String[] arrayA, String[] arrayB) 
    // {
        // int count = 0;
        // String[] shorter;
        // String[] longer;

        // if (arrayA != null && arrayB != null) {
            // if(arrayA.length <= arrayB.length){
                // shorter = arrayA;
                // longer = arrayB;
            // } else {
                // shorter = arrayB;
                // longer = arrayA;
            // }

            // for(String s : shorter){
                // for(String l : longer){
                    // if(s.equals(l)){
                        // count++;
                    // }
                // }
            // }

        // }

        // return count;
    // }
    
    /**
     * Returns the number of times the elements of the 
     * shorter array are contained in the longer array.
     * 
     * @param arrayA A non-null array of strings.
     * @param arrayB A non-null array of strings.
     * @return The number of times the elements of the 
     * shorter array are contained in the longer array.
     */
    public static <T> int countOccurrences(T[] arrayA, T[] arrayB) 
    {
        int count = 0;
        T[] shorter;
        T[] longer;

        if (arrayA != null && arrayB != null) {
            if(arrayA.length <= arrayB.length){
                shorter = arrayA;
                longer = arrayB;
            } else {
                shorter = arrayB;
                longer = arrayA;
            }

            for(T s : shorter){
                for(T l : longer){
                    if(s.equals(l)){
                        count++;
                    }
                }
            }

        }

        return count;
    }
}
