/**
 * Complete each method as described.  For each method, you must 
 * add ONE private recursive method which computes and returns 
 * the result recursively.
 *
 * @author Matthew Laframboise
 * @version Spring 2023
 */
public class RecursionPractice
{
    /**
     * Wherever lookFor occurs in str, surrounds lookFor with asterisks.
     * 
     * @param str A non-null string.
     * @param lookFor The character to emphasize in the string.
     * @return A new string with all occurrences of the requested character emphasized.
     * @throws NullPointerException if str == null.
     */
    public static String addEmphasis(String str, char lookFor)
    {
        if(str != null){
            return addEmphasisPr(str, lookFor);

        } else {
            throw new NullPointerException("The input string cannot be null.");
        }
    }

    /**
     * For each digit in number, if the digit is divisible by divBy, then the
     * digit is replaced with a 0.  Otherwise, the digit remains the same.
     * 
     * @param number A positive integer.
     * @param divBy The number by which each digit in the number will be divided by.
     * @return A new integer where, for each digit in number, if the digit is divisible by divBy, then the
     * digit is replaced with a 0.  Otherwise, the digit remains the same.
     * @throws IllegalArgumentException if number <= 0 or divBy <= 0.
     */
    public static int digitMod(int number, int divBy)
    {
        if(number > 0 && divBy > 0){
            return digitModPr(number, divBy);

        } else {
            throw new IllegalArgumentException("The input values must be positive integers.");
        }
    }

    /**
     * Returns the minimum of sum of array[begin] to array[end] inclusive and maxSum.
     * 
     * @param array A non-null integer array.
     * @param begin The starting index in the array.
     * @param end The ending index in the array.
     * @param maxSum The largest sum that can be returned.
     * @throws NullPointerException if array is null.
     * @throws IllegalArgumentException if begin < 0 or end < begin or end >= array.length.
     */
    public static int sumInRangeUntil(int[] array, int begin, int end, int maxSum)
    {
        if(array == null){
            throw new NullPointerException("The array cannot be null.");
        } else if(begin < 0 || end < begin || end >= array.length){
            throw new IllegalArgumentException("The following must be true.  0 <= begin <= end < array.length");
        } else {

            return sumInRangeUntilPr(array, begin, end, maxSum);
        }
    }

    private static String addEmphasisPr(String str, char lookFor){
        if (str.length() == 0){
            return "";
        }
        else if (str.charAt(0) == lookFor){
            return "*" + lookFor + "*" + addEmphasis(str.substring(1), lookFor);
        }
        else{
            return str.charAt(0) + addEmphasis(str.substring(1), lookFor);
        }
    }

    private static int digitModPr(int number, int divBy){
        if (number/10 == 0 && number%divBy == 0){
            return 0;
        }
        else if(number/10 == 0){
            return number;
        }
        else if(((number%10) % divBy) == 0){
            return 0 + 10*digitMod(number/10, divBy);
        }
        else{
            return number%10 + 10*digitMod(number/10, divBy);
        }
    }

    private static int sumInRangeUntilPr(int[] array, int begin, int end, int maxSum){
        if (begin == end){
            return array[begin];
        }
        else if (sumInRangeUntil(array, begin + 1, end, maxSum) >= maxSum){
            return maxSum;
        }
        else{
            return array[begin] + sumInRangeUntil(array, begin + 1, end, maxSum);

        }
    }
}
