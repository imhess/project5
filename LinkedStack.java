package matrix;

import java.util.EmptyStackException;

import matrix.LinkedListWithIterator.Node;

/**
 * A class of stacks whose entries are stored in a chain of nodes.
 *
 * @author Frank M. Carrano and Timothy M. Henry
 * @author Abdur rahman (convertToPostfix)
 * @version 5.0
 */

public final class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode; // References the first node in the chain

    /**
     * default constructor
     */
    public LinkedStack()
    {
        topNode = null;
    } // end default constructor

    /**
     * Adds an object to the stack
     *
     * @param newEntry An object to be added to the stack.
     */
    public void push(T newEntry)
    {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
    } // end push

    /**
     * Shows what is on the top of the stack
     *
     * @return returns the object at the top of the stack
     */
    public T peek()
    {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    } // end peek

    /**
     * removes the object at the top of the stack
     *
     * @return returns the object at the top of the stack
     */
    public T pop()
    {
        T top = peek(); // Might throw EmptyStackException
        // Assertion: topNode != null
        topNode = topNode.getNextNode();
        return top;
    }
    
    private class Node
    {
        private T data; // Entry in list
        private Node next; // Link to next node

        private Node(T dataPortion)
        {
            data = dataPortion;
            next = null;
        } // end constructor

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private T getData()
        {
            return data;
        } // end getData

        private void setData(T newData)
        {
            data = newData;
        } // end setData

        private Node getNextNode()
        {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } // end setNextNode
    }
    
    @Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
	public void clear() {
		// TODO Auto-generated method stub
		
	} 
	
}