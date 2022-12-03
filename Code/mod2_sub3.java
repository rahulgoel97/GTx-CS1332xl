import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
        // Throw exception if null
        if(data==null){
            throw new IllegalArgumentException("Cannot be null");
        }
        
        // Create a new Noded for the SLL, set head as next
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data, head);
        
        // Increment size
        size = size + 1;
        
        
        // Change current head to point to this newer noded
        head = newNode;
        
        // If this is the only node, also set tail to this head
        if(size==1){
            tail = head;
        }
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
        // Throw exception if null
        if(data==null){
            throw new IllegalArgumentException("Cannot be null");
        }
        else if(size==0){

        // Create a new Noded for the SLL, set head as null.
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data, null);
        head = newNode;
        tail = newNode;
        size = size+1;
        }
        else{  
        // Create a new Noded for the SLL, set head as null.
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<T>(data, null);
        
        // Set the next node at the tail to be the new node.
        tail.setNext(newNode);
        tail = newNode;
        // Increment size
        size = size + 1;

        }      
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
        // Throw exception if null
        if(size==0){
            throw new NoSuchElementException();
        }
        else if(size==1){
            T returnData = head.getData();
            tail = null;
            head = null;
            return returnData;
        }
        else
        {
        // Get the data to be returned from the head
        T returnData = head.getData();
        
        
        // Get the next node, and set it to be the head
        head = head.getNext();
        
        // Decrement size
        size = size - 1;
       
        // Return the original T removed.
        return returnData;
        }   
        
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
        if(size==0){
            throw new NoSuchElementException();
        }
        else if(size==1){
            T returnData = head.getData();
            head=null;
            tail=null;
            return returnData;
        }
        else
        {
          
        // Get the data to be removed
        T removedData = tail.getData();     
        
        // Need to understand the second last node, and set it's next to null
        // Recurse till next is equal to tail, and then execute the code
        
        SinglyLinkedListNode<T> tempNode = head;
        
        while(tempNode.getNext().getNext() != null){
            tempNode = tempNode.getNext();
        }
        
        tempNode.setNext(null);

        // Set tail to the tempNode
        tail = tempNode; 

        // Decrement size
        size = size - 1;
        
        return removedData; 
        }       
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
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