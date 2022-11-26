import java.util.NoSuchElementException;


/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;


    /**
     * This is the constructor that constructs a new ArrayList.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }
    
 
    /**
    * Helper function to resize ArrayList
    *
    *
    *
    *
    */
    private void resizeArray(){
        
        // Create a new array with size * 2- array should be at capacity so we can use size
             
        T[] newBackingArray = (T[]) new Object[size*2];
        
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
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
        // ===== Algorithm to add to the front ======
        // Check total length - if exceeds 9, create new array with double length and run the algo
        // When sufficient space exists, move all elements to next index, place data to head of the array
        // return the new array
        
         if(data==null){
            throw new IllegalArgumentException("Cannot be null");
        }
        
        if(size+1 <= backingArray.length){
            // Code for addToFront
            
            // Shift all elements to the right
            for (int i=size-1; i>=0; i--){
                
                backingArray[i+1]=backingArray[i];
                
            }
            
            // Add to the front
            backingArray[0]=data; 
            size = size + 1;
       
        }
        else {
            // Resize Array
            resizeArray();
                
            //Re-run method
            addToFront(data);
        }
        
        
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
         // ===== Algorithm to add to the back ======
        // Check total length - if exceeds 9, create new array with double length and run the algo
        // When sufficient space exists, add element to next index
        // return the new array
        
        if(data==null){
            throw new IllegalArgumentException("Cannot be null");
        }
        
        
        if(size <= backingArray.length){
            
            // Code for addToBack - add data to index size. 
            backingArray[size]= data;  
            size = size+1;
        }
        else {
            // Resize Array
            resizeArray();
            
            //Re-run method
            addToBack(data);
        }
        
        
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
         if(size==0){
            throw new NoSuchElementException();
        }
        
        
        // ===== Algorithm to remove from the front ======     
        
        T dataToRemove = backingArray[0];
        
        // Traverse thru array starting at index 1 to shift values into a new array
        for (int i=0; i<size()-1; i++){
            backingArray[i]=backingArray[i+1];
        }
        
        // Make removal at the end 
        
        backingArray[0]=null;
        
        // Update size
        size = size - 1;   
        
        return dataToRemove;
        
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
        if(size==0){
            throw new NoSuchElementException();
        }
        
      
        
        T dataToRemove = backingArray[size-1];
        
          // ===== Algorithm to remove from the back ======
        // Get array list size
        int indexToRemove = size-1;
        
        // Remove the element at this index
        backingArray[indexToRemove]=null;
        
        // Update size
        size = size-1;
        
        return dataToRemove;
         
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}