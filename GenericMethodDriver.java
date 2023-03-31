import java.awt.Point;
/**
 * Testing the generic method class
 *
 * @author Matthew Laframboise
 * @version Spring 2023
 */
public class GenericMethodDriver
{   
    public static void main(String args[]){
        GenericMethodExample test1 = new GenericMethodExample();
        String[] strTest1 = {"Hi", "hi", "hello", "hi", "hi", "Bye"};
        String[] strTest2 = {"hi"};
        //System.out.println(strTest1);
        //System.out.println(strTest2);
        System.out.println("---------Testing String arrays -------------------------------------");
        System.out.println("---------Test one --------------------------------------------------");
        System.out.println("String array 1: Hi, hi, hello, hi, hi, Bye");
        System.out.println("String array 2: hi");
        System.out.println("There should be 3 occrance of the shorter array in the longer array.");
        System.out.println("There are " + test1.countOccurrences(strTest1, strTest2) +
            " occurance of the shorter array in the longer array.");
        System.out.println("-------------------------------------------------------------------- \n");

        String[] strTest3 = {"Hi", "hi", "hello", "hi", "hi", "Bye"};
        String[] strTest4 = {""};
        //System.out.println(strTest1);
        //System.out.println(strTest2);
        System.out.println("---------Test two --------------------------------------------------");
        System.out.println("String array 1: Hi, hi, hello, hi, hi, Bye");
        System.out.println("String array 2: ");
        System.out.println("There should be 0 occrance of the shorter array in the longer array.");
        System.out.println("There are " + test1.countOccurrences(strTest3, strTest4) +
            " occurance of the shorter array in the longer array.");
        System.out.println("-------------------------------------------------------------------- \n");

        String[] strTest5 = {"hello"};
        String[] strTest6 = {"Hi", "hi", "hello", "hi", "hi", "Bye"};
        //System.out.println(strTest1);
        //System.out.println(strTest2);
        System.out.println("---------Test three-------------------------------------------------");
        System.out.println("String array 1: hello");
        System.out.println("String array 2: Hi, hi, hello, hi, hi, Bye");
        System.out.println("There should be 1 occrance of the shorter array in the longer array.");
        System.out.println("There are " + test1.countOccurrences(strTest5, strTest6) +
            " occurance of the shorter array in the longer array.");
        System.out.println("-------------------------------------------------------------------- \n");

        Integer[] intTest1 = {1,2,3,4,1,2,3,4,1};
        Integer[] intTest2 = {1};
        //System.out.println(strTest1);
        //System.out.println(strTest2);
        System.out.println("---------Testing Integer arrays ------------------------------------");
        System.out.println("---------Test one --------------------------------------------------");
        System.out.println("Integer array 1: 1,2,3,4,1,2,3,4,1");
        System.out.println("Integer array 2: 1");
        System.out.println("There should be 3 occrance of the shorter array in the longer array.");
        System.out.println("There are " + test1.countOccurrences(intTest1, intTest2) +
            " occurance of the shorter array in the longer array.");
        System.out.println("-------------------------------------------------------------------- \n");

        Integer[] intTest3 = {1,2,3,4,1,2,3,4,1};
        Integer[] intTest4 = {};
        //System.out.println(strTest1);
        //System.out.println(strTest2);
        System.out.println("---------Test two --------------------------------------------------");
        System.out.println("Integer array 1: 1,2,3,4,1,2,3,4,1");
        System.out.println("Integer array 2: ");
        System.out.println("There should be 0 occrance of the shorter array in the longer array.");
        System.out.println("There are " + test1.countOccurrences(intTest3, intTest4) +
            " occurance of the shorter array in the longer array.");
        System.out.println("-------------------------------------------------------------------- \n");

        Integer[] intTest5 = {2};
        Integer[] intTest6 = {1,2,3,4,1,2,3,4,1};
        //System.out.println(strTest1);
        //System.out.println(strTest2);
        System.out.println("---------Test three --------------------------------------------------");

        System.out.println("Integer array 1: 2");
        System.out.println("Integer array 2: 1,2,3,4,1,2,3,4,1");

        System.out.println("There should be 2 occrance of the shorter array in the longer array.");
        System.out.println("There are " + test1.countOccurrences(intTest5, intTest6) +
            " occurance of the shorter array in the longer array.");
        System.out.println("-------------------------------------------------------------------- \n");

        
        Point point1 = new Point(1,2);
        Point point2 = new Point(2,3);
        Point point3 = new Point(3,4);
        Point point4 = new Point(4,5);
        Point[] pointTest1 = {point1,point2,point3,point4,point1};
        Point[] pointTest2 = {point1};
        //System.out.println(strTest1);
        //System.out.println(strTest2);
        System.out.println("---------Testing Point arrays --------------------------------------");
        System.out.println("---------Test one --------------------------------------------------");
        System.out.println("Point array 1: point1,point2,point3,point4,point1");
        System.out.println("Point array 2: point1");
        System.out.println("There should be 2 occrance of the shorter array in the longer array.");
        System.out.println("There are " + test1.countOccurrences(pointTest1, pointTest2) +
            " occurance of the shorter array in the longer array.");
        System.out.println("-------------------------------------------------------------------- \n");

        Point[] pointTest3 = {point1,point2,point3,point4,point1};
        Point[] pointTest4 = {};
        //System.out.println(strTest1);
        //System.out.println(strTest2);
        System.out.println("---------Test two --------------------------------------------------");
        System.out.println("Point array 1: point1,point2,point3,point4,point1");
        System.out.println("Point array 2: ");
        System.out.println("There should be 0 occrance of the shorter array in the longer array.");
        System.out.println("There are " + test1.countOccurrences(pointTest3, pointTest4) +
            " occurance of the shorter array in the longer array.");
        System.out.println("-------------------------------------------------------------------- \n");

        Point[] pointTest5 = {point2};
        Point[] pointTest6 = {point1,point2,point3,point4,point1};
        //System.out.println(strTest1);
        //System.out.println(strTest2);
        System.out.println("---------Test three ------------------------------------------------");
        System.out.println("Point array 1: point2");
        System.out.println("Point array 2: point1,point2,point3,point4,point1");
        System.out.println("There should be 1 occrance of the shorter array in the longer array.");
        System.out.println("There are " + test1.countOccurrences(pointTest5, pointTest6) +
            " occurance of the shorter array in the longer array.");
        System.out.println("-------------------------------------------------------------------- \n");
    }
}
