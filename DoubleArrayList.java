/**
 * Objects of this class type store a list of double values,
 * each having a position in the list. 
 * 
 * You may not import the ArrayList class!
 * 
 * @author (Matthew Laframboise)
 * @version (3/10/2023)
 */
public class DoubleArrayList 
{

    //array storing the elements in positions 0...currentSize-1
    private double[] elements; 

    //number of elements in the list
    private int currentSize;  

    //the initial size of the list
    final int INITIAL_SIZE = 10;

    /**
     * Initializes an empty list with an initial capacity.
     */
    public DoubleArrayList() 
    {    
        //set the empty list to an initial size
        elements = new double[INITIAL_SIZE];
        currentSize = 0;
    }

    /**
     * Initializes an empty list with the specified initial
     * capacity. initialCapacity must be > 0. If initialCapacity
     * is <= 0, then it initializes an empty list with INITIAL_SIZE.
     * 
     * @param initialCapacity initial capacity of list
     */
    public DoubleArrayList(int initialCapacity) 
    {
        if ( initialCapacity <= 0 )
        {
            elements = new double[INITIAL_SIZE];
        }
        else
        { 
            elements = new double[initialCapacity];
        }
        currentSize = 0;
    }

    /** 
     * Valid positions for elements in the list range
     * from 0 to currentSize-1. This method checks
     * that pos is valid. If pos is not in this
     * range, then it throws the IndexOutOfBounds 
     * exception. Otherwise, it does nothing.
     * 
     * @param pos A position in the list
     * @throws IndexOutOfBoundsException 
     *         if pos < 0 or pos >= currentSize
     */
    private void checkBounds(int pos) 
    {
        if ((pos < 0) || (pos >= currentSize))
        {
            throw new IndexOutOfBoundsException();
        }
    }

    /** 
     * Returns the element at position pos in the list.
     * pos must be in the range [0...currentSize-1]. 
     * If it is not, then the IndexOutOfBounds exception
     * is thrown.
     * 
     * @param pos The position of the desired element.
     * @return The indicated element.
     * @throws IndexOutOfBoundsException if pos < 0 or pos >= currentSize. 
     */
    public double get( int pos ) 
    {
        //return the element at pos
        checkBounds(pos);
        return elements[pos];
    }

    /** 
     * A simplistic add method that adds the element to the end 
     * of the list, if there is room for it.  However, if the 
     * list is at its maximum capacity, then this method does 
     * not add the element. It just returns false.
     * 
     * @param element The element to be added.
     * @return true if the element is sucessfully added, false otherwise
     */
    public boolean addSimple(double element) 
    {
        if (elements == null || currentSize >= elements.length) 
        {
            return false; 
        }
        elements[ currentSize ] = element;
        currentSize++;
        return true;
    }

    /**
     * Returns the number of elements in the list
     * 
     * @return The number of list elements
     */
    public int size() 
    {
        //simply return the currentSize of the arraylist
        return currentSize;
    }

    /**
     * Sets the element at position pos to element. 
     * 
     * @param pos The position of the element to be replaced
     * @param element The element that will replace the 
     *                one at the indicated position        
     * @throws IndexOutOfBoundsException if pos < 0 or pos >= currentSize. 
     */
    public void set(int pos, double element ) 
    {
        //set the specified index to the inputted element
        elements[pos] = element;
    }

    /** 
     * Removes the element at position pos from the list
     * and returns it. Entries originally at positions 
     * higher than the given position are at the next 
     * lower position within the list, and the list size 
     * is decreased by 1.
     * 
     * @param pos Position of the element to be removed
     * @return The removed element
     * @throws IndexOutOfBoundsException 
     *         if pos < 0 or pos >= currentSize
     */
    public double remove( int pos ) 
    {
        //call the checkBounds method to see if pos is with range
        checkBounds(pos);

        //create a temp variable
        double temp = elements[pos]; 
        for (int i = pos; i <= currentSize-2; i++){
            elements[i] = elements[i+1];
        }
        currentSize = currentSize - 1;
        return temp;

    }

    /** 
     * Clears all elements from the list, resulting in a empty list.
     * You may NOT call any other method in your implementation
     * of this!
     */
    public void clear() 
    {
        //set the currentSize to 0
        currentSize = 0;
    }

    /**
     * Checks if the object contains the input
     */
    public boolean contains (double element){
        int i = 0;
        while (i < currentSize && elements[i] != element){
            i++;
        }
        return i < currentSize;
    }
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //
    // STOP HERE! REFER TO THE LAB INSTRUCTIONS BEFORE CONTINUING
    //
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    /**
     * Returns a reference to a new DoubleArrayList object that is a copy
     * of this DoubleArrayList. The copy contains the same
     * ordered list of elements as the list and has the same capacity.
     * 
     * Make sure the elements array of the copy is distinct from 
     * that of this list. In other words, this list and the copy 
     * must each have their own, separate elements arrays. 
     * 
     * @return A reference to a new DoubleArrayList object that is a copy
     * of this DoubleArrayList.  I.e., returns a copy of the list.
     */
    public DoubleArrayList getCopy() 
    {
        //create a new DoubleArrayList object
        DoubleArrayList elementsTwo = new DoubleArrayList();

        //create a copy of the list elements
        for (int i = 0; i < currentSize; i++){
            elementsTwo.addSimple(elements[i]);
        }
        return elementsTwo;
    }

    /**
     * Returns the capacity of the list, which is the largest number
     * of elements the array elements[] is capable of holding. In other 
     * words, it is the size of array elements[].
     * 
     * @return The capacity of the list.
     */
    public int getCapacity() 
    {
        //return the length of the list elements
        return elements.length;
    }

    /**
     * Ensures that the capacity of the list is at least
     * the specified amount minCapacity. If it is not,
     * it increases the capacity of the list to minCapacity.
     * If the list capacity is already >= minCapacity, then 
     * no action is taken.
     * 
     * @param minCapacity the desired minimum capacity
     */
    public void ensureCapacity( int minCapacity ) 
    {
        //store the capacity of the list in a temp variable
        int listSize = getCapacity();
        //if the listSize(capaicty) is less than the inputted minCapacity, create a new list
        //and set the size as the minCapacity. 
        if(listSize < minCapacity){
            double[] newList = new double[minCapacity];
            for (int i = 0; i < currentSize; i++){
                newList[i] = elements[i];
            }

            //replace elements with newList
            elements = newList;
        }
    }

    /** 
     * This is a smart add method (unlike the previous
     * addSimple method that was provided for you.)
     * 
     * This method adds the element to the end of the list.
     * If the list is at its maximum capacity, its
     * capacity is doubled to make room for the element.
     * 
     * You may call ensureCapacity in this method, but you
     * may NOT CALL ANY OTHER METHODS HERE.
     * 
     * @param element the new element to be added
     */
    public void add(double element) 
    {
        //check if the position is less then 0, or greater than currentSize
        //throw an IndexOutOfBoundsException() if it satisifies either conditional
        if(currentSize == elements.length){
            ensureCapacity(elements.length*2);
        }
        elements[currentSize] = element;

        //increase currentSize by 1 every time the method is called
        currentSize++;
    }

    /** 
     * Adds a new element at a specified position within the list.
     * If the list is at its maximum capacity, its
     * capacity is first doubled to make room for the new element.
     * 
     * Entries originally at and above the specified position
     * are moved to the next higher position within the list.
     * The list size is increased by 1. 
     * 
     * Note that pos must be in the range [0...currentSize]. It is 
     * okay if pos is equal to currentSize -- in this case it merely 
     * adds the new element as the last item in the list.
     * 
     * You may call ensureCapacity in this method, but you
     * may NOT CALL ANY OTHER METHODS HERE.
     * 
     * @param pos The desired position of the new element
     * @param element The element to be added 
     * @throws IndexOutOfBoundsException 
     *               if pos < 0 or pos > currentSize.        
     */
    public void add(int pos, double element) 
    {
        //check if the position is less then 0, or greater than currentSize
        //throw an IndexOutOfBoundsException() if it satisifies either conditional
        if (pos < 0 || pos > currentSize){
            throw new IndexOutOfBoundsException();
        }

        //use the ensureCapacity method to check if the arraylist is at max capacity
        if(currentSize == elements.length){
            ensureCapacity(elements.length*2);
        }

        //move every element greater than the index of pos, and set the index of pos to 
        //the inputted element
        for (int i = currentSize-1; i >= pos; i--){
            elements[i+1] = elements[i];
        }
        elements[pos] = element;

        //increase currentSize by 1 every time the method is called
        currentSize++;
    }

    /**
     * This method will return the index of the last occurance of a specified element
     * or -1 if the element is not found
     * @param element This is the element you are looking for
     * @return This will return the index of the last occurance of element or -1 if
     * element does not exist in the list
     */
    public double lastIndexOf(double element){
        int temp = -1;

        for (int i = 0; i < currentSize; i++){
            if (elements[i] == element){
                temp = i;
            }
        }

        return temp;
    }

    /**
     * This method removes all of the elements contained in a collection
     * 
     * @param c This is the collection of elements you want to remove
     * @returm returns true if the list change as a result of the call
     */
    public boolean removeAll(java.util.Collection<Double> c){
        boolean temp = false;

        for(double e: c){
            for (int i = 0; i < currentSize; i++){
                if(e == elements[i]){
                    remove(i);
                    temp = true;
                }
            }
        }

        return temp;
    }
}
