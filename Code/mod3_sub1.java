import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayQueue.
 */
public class ArrayQueue<T> {

    /*
     * The initial capacity of the ArrayQueue.
     *
     * DO NOT MODIFY THIS VARIABLE.
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int front;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayQueue.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayQueue() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    private void resizeArray(){

        // Create a new array with size * 2- array should be at capacity so we can use size

        int newLength = backingArray.length * 2;
             
        T[] newBackingArray = (T[]) new Object[newLength];
        
        // Assign all elements till size is reached to newBackingArray
        for (int i=0; i<size; i++)
        {
            newBackingArray[i]=backingArray[i];
        }
        
        // Set the backingArray to the new backingArray
        backingArray=newBackingArray;
        
        // Reset size
        size = size * 2;
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {

        if(data==null){
            throw new IllegalArgumentException("Data is null, try again with non-null value");
        }
        else if (size+1>backingArray.length) // If we need to resize
        { 
            resizeArray(); //TODO - Implement this method.
        }
        else{

            // Calculate back
            int back = (front+size) % backingArray.length;

            // Add data at back of the array
            backingArray[back] = data;

            // Increment the size
            size+=1;

            // Check for circularity - ie: if the back>capacity of array, then modulo

            if(back>backingArray.length){

                back = back % size;
            }
        }
               
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * Do not shrink the backing array.
     *
     * Replace any spots that you dequeue from with null.
     *
     * If the queue becomes empty as a result of this call, do not reset
     * front to 0.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        if(size==0){
            throw new NoSuchElementException("Array is empty, illegal action");
        }
        else{

            // Get the value needed
            T dataToRemove = backingArray[front];

            // Set data from the front of queue to null

            backingArray[front] = null;

            // Adjust  the front
            front =(front + 1) % backingArray.length;

            // Decremenet the size
            size-=1;

            // No resizing, no checking for emptying.

            // To do - account for circular behavior.

            // Return the value
            return dataToRemove;

        }
    }



    /** ----------- NON EDITED METHODS --------- */

    /**
     * Returns the backing array of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the queue.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the queue
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}