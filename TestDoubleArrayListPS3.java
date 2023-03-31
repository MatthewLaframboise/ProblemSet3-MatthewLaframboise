import java.util.ArrayList;

/**
 * The main method should be used to test your DoubleArrayList class
 * BEFORE you add any code.  Then, follow the directions in the
 * problem set to complete this program.
 * 
 * @author Prof. White
 * @version Spring 2023
 */
public class TestDoubleArrayListPS3 
{
    /**
     * The main method should be used to test your DoubleArrayList class
     * BEFORE you add any code.
     * 
     * @param args No command line arguments required.
     */
    public static void main(String[] args)
    {
        int score = 0;
        int maxscore = 0;      

        try {

            DoubleArrayList list1 = new DoubleArrayList( );

            list1.addSimple(5.0);
            list1.addSimple(4.0);
            list1.addSimple(3.0);
            list1.addSimple(2.0);
            list1.addSimple(1.0);

            if (list1.contains(5.0)){
                score++;
            }
            maxscore++;

            if(list1.contains(3.0)){
                score++;
            }
            maxscore++;

            if(list1.contains(1.0)){
                score++;
            }
            maxscore++;

            if(!list1.contains(3.5)){
                score++;
            }
            maxscore++;

            if(!list1.contains(-3.5)){
                score++;
            }
            maxscore++;

            list1 = new DoubleArrayList( );

            //-------- Test size() method
            if (list1.size() == 0)
                score++;
            maxscore++;

            list1.addSimple( 5.0 );
            list1.addSimple( 4.0 );
            list1.addSimple( 3.0 );
            list1.addSimple( 2.0 );

            if (list1.size() == 4)
                score++;
            maxscore++;

            //-------- Test set(pos, element) method
            list1.set(0, 50.0);
            if (list1.get(0) == 50.0) 
                score++;
            maxscore++;

            list1.set(3, 20.0);
            if (list1.get(3) == 20.0) 
                score++;
            maxscore++;

            list1.set(1, 40.0);
            if (list1.get(1) == 40.0) 
                score++;
            maxscore++;

            //Test boundary checking
            try{
                list1.set(-1, -1.0);
            } catch (IndexOutOfBoundsException iobe) {
                score++;
            }
            maxscore++;

            try{
                list1.set(100, 0);
            } catch (IndexOutOfBoundsException iobe){
                score++;
            }
            maxscore++;            

            //-------- Test remove method
            DoubleArrayList list2 = new DoubleArrayList();

            // create list {0,1,2,3,4,5,6,7,8,9}
            for (int i = 0; i < 10; i++ ) 
                list2.addSimple( i );

            if (list2.remove( 3 ) == 3.0) 
                score++;
            maxscore++;

            if (list2.size() == 9)
                score++;
            maxscore++;

            // remove first item
            if (list2.remove( 0 ) == 0.0)
                score++;
            maxscore++;

            if (list2.get( 0 ) == 1.0)
                score++;
            maxscore++;

            if (list2.remove( 3 ) == 5.0)
                score++;
            maxscore++;

            if (list2.size() == 7)
                score++;
            maxscore++;

            // remove last item
            if (list2.remove( 6 ) == 9.0)
                score++;
            maxscore++;

            //Test boundary checking
            try{
                list1.remove(-1);
            } catch (IndexOutOfBoundsException iobe) {
                score++;
            }
            maxscore++;

            try{
                list1.remove(6);
            } catch (IndexOutOfBoundsException iobe){
                score++;
            }
            maxscore++;            

            //-------- Test clear method
            list2.clear();
            if (list2.size() == 0) 
                score++;
            maxscore++;

            list2.addSimple( 1.0 );
            if (list2.size() == 1) 
                score++;
            maxscore++;

            DoubleArrayList list3 = new DoubleArrayList();
            list3.addSimple(5.0);
            list3.addSimple(6.0);
            list3.addSimple(7.0);

            DoubleArrayList c1;
            c1 = list3.getCopy();

            if ( c1 != null ) { // make sure it is not a null reference
                if (c1.size() == 3)
                    score++;

                if (c1.getCapacity() == 10)
                    score++;

                if (c1.get(0) == 5.0) 
                    score++;

                if (c1.get(1) == 6.0) 
                    score++;

                if (c1.get(2) == 7.0) 
                    score++;

                // make sure c1 and list3 are separate and independent
                // lists - we don't want them to share a single array.
                c1.set(0,123.0);
                if (list3.get(0) == 5.0) 
                    score++;
            }
            maxscore += 6;

            //-------- Test getCapacity
            DoubleArrayList list4 = new DoubleArrayList( );

            if ( list4.getCapacity() == 10 ) 
                score++;
            maxscore++;

            //-------- Test ensureCapacity
            DoubleArrayList list6 = new DoubleArrayList();
            list6.ensureCapacity(15);
            if (list6.getCapacity() == 15)
                score++;
            maxscore++;

            // this should have no effect on capacity
            list6.ensureCapacity(12);
            if (list6.getCapacity() == 15)
                score++;
            maxscore++;

            // We should be able to add 15 values to list6, 
            // now that its capacity is 15.
            // Add first ten elements
            for (int i = 0; i<10; i++) 
                list6.addSimple(i);
            // Are we able to add 5 more elements?
            for (int i = 10; i<15; i++) {
                if (list6.addSimple(i) == true) 
                    score++;   
                maxscore++;
            }

            //-------- Test add(element) 
            // this add method should automatically double the
            // capacity of list as necessary
            DoubleArrayList list12 = new DoubleArrayList();
            // add 14 items to list, which should double its capacity
            for (int i = 0; i < 14; i++)
                list12.add(i);

            if (list12.size() == 14) {
                score++;

                if (list12.get(0) == 0.0)
                    score++;

                if (list12.get(13) == 13.0)
                    score++;

                if (list12.getCapacity() == 20)
                    score++;
            }
            maxscore += 4;

            //-------- Test add(pos,newElement)
            DoubleArrayList list7 = new DoubleArrayList();
            list7.addSimple(0.0);
            list7.addSimple(1.0);

            list7.add(0, 2.0); // add to the beginning

            // list should now contain {2, 0, 1}
            if (list7.size() == 3) { 
                score++;

                if (list7.get(0) == 2.0)
                    score++;

                if (list7.get(2) == 1.0)
                    score++;

                list7.add(3, 5.0); // at to the end

                // list should now contains {2, 0, 1, 5}
                if (list7.size() == 4)
                    score++;

                if (list7.get(0) == 2.0)
                    score++;

                if (list7.get(3) == 5.0)
                    score++;

                list7.add(2, 7.0); // at to the middle

                // list should now contain {2, 0, 7, 1, 5}
                if (list7.size() == 5)
                    score++;

                if (list7.get(0) == 2.0)
                    score++;

                if (list7.get(3) == 1.0)
                    score++;

                if (list7.get(2) == 7.0)
                    score++;

                // see if it doubles the capacity when necessary
                list7.add( 5, 50 );
                list7.add( 6, 60 );
                list7.add( 7, 60 );
                list7.add( 8, 60 );
                list7.add( 9, 60 );
                list7.add( 10, 60 );

                if (list7.getCapacity() == 20)
                    score++;
                if (list7.get( 10 ) == 60)
                    score++;
            }
            maxscore += 12;

            System.out.println( "You scored " + score + " out of a possible " + maxscore + " points." );
            if ( score < maxscore ) System.out.println( "Keep working on it - you can fix the bugs!" );
            else System.out.println( "You rock -- a perfect score!" );
        } catch(Exception e) {
            System.out.println( "     Unable to complete test program because " );
            System.out.println( "     Exception thrown: " + e.getClass().getSimpleName() );
            System.out.println( "     Use the debugger to figure out what is going on.");
            System.out.println( "     Your score before the exception was thrown was " + score + ".");
        }
    }

    /**    
     * Follow the directions in the problem set to use this method in testing your code.
     * Passing all tests does not guarantee full credit on this part of the problem set.
     * You should do more thorough testing.
     */
    public static void testDoubleArrayListPS3()
    {
        int score = 0;
        int maxscore = 0;      

        try {
            DoubleArrayList list = new DoubleArrayList();
            for(int j = 1; j < 3; j++){
                for(int i = 1; i < 6; i++){
                    list.add((double) i);
                }
            }

            if(list.lastIndexOf(0) == -1) score++;
            if(list.lastIndexOf(1) == 5) score++;
            if(list.lastIndexOf(2) == 6) score++;
            if(list.lastIndexOf(3) == 7) score++;
            if(list.lastIndexOf(4) == 8) score++;
            if(list.lastIndexOf(5) == 9) score++;
            maxscore += 6;

            ArrayList<Double> r = new ArrayList<Double>();
            r.add(1.0);
            r.add(3.0);
            r.add(5.0);
            list.removeAll(r);
            if(list.size() == 4) score++;
            if(list.get(0) == 2.0) score++;
            if(list.get(1) == 4.0) score++;
            if(list.get(2) == 2.0) score++;
            if(list.get(3) == 4.0) score++;
            maxscore += 5;

            System.out.println( "You scored " + score + " out of a possible " + maxscore + " points." );
            if ( score < maxscore ) System.out.println( "Keep working on it - you can fix the bugs!" );
            else System.out.println( "You rock -- a perfect score!" );
            } catch(Exception e) {
            System.out.println( "     Unable to complete test program because " );
            System.out.println( "     Exception thrown: " + e.getClass().getSimpleName() );
            System.out.println( "     Use the debugger to figure out what is going on.");
            System.out.println( "     Your score before the exception was thrown was " + score);
            }
        }
    }
