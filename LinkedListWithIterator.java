package matrix;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class that implements the ADT list by using a chain of linked nodes.
 * The list has an iterator. The class is similar to LList.
 *
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class LinkedListWithIterator<T> implements ListWithIteratorInterface<T>
{
    private Node firstNode;
    private int numberOfEntries;

    public LinkedListWithIterator()
    {
        initializeDataFields();
    } // end default constructor

    public void add(T newEntry)
    {
        Node newNode = new Node(newEntry);
        if (isEmpty()) firstNode = newNode;
        else // Add to end of nonempty list
        {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode); // Make last node reference new node
        } // end if
        numberOfEntries++;
    }

    public void add(int givenPosition, T newEntry)
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
        {
            Node newNode = new Node(newEntry);
            if (givenPosition == 1) // Case 1
            {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            } else // Case 2: List is not empty
            { // and givenPosition > 1
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            } // end if
            numberOfEntries++;
        } else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to add operation.");
    } // end add


    public boolean isEmpty()
    {
        boolean result;
        if (numberOfEntries == 0) // Or getLength() == 0
        {
            result = true;
        } else
        {
            result = false;
        } // end if
        return result;
    } // end isEmpty


    public T remove(int givenPosition)
    {
        T result = null; // Return value
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            if (givenPosition == 1) // Case 1: Remove first entry
            {
                result = firstNode.getData(); // Save entry to be removed
                firstNode = firstNode.getNextNode(); // Remove entry
            } else // Case 2: Not first entry
            {
                Node nodeBefore = getNodeAt(givenPosition-1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData(); // Save entry to be removed
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter); // Remove entry
            } // end if
            numberOfEntries--; // Update count
            return result; // Return removed entry
        } else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to remove operation.");
    } // end remove

    public void clear()
    {
        initializeDataFields();
    }

    public T getEntry(int givenPosition)
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            return getNodeAt(givenPosition).getData();
        }
        else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to getEntry operation.");
    } // end getEntry


    public T[] toArray()
    {// The cast is safe because the new array contains null entries
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        } // end while
        return result;
    }

    public int getLength()
    {
        return numberOfEntries;
    }

    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while
        return found;
    } // end contains


    public T replace(int givenPosition, T newEntry)
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            Node desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        } else
            throw new IndexOutOfBoundsException(
                    "Illegal position given to replace operation.");
    } // end replace


    private void initializeDataFields()
    {
        firstNode = null;
        numberOfEntries = 0;
    }

    private Node getNodeAt(int givenPosition)
    {
        Node currentNode = firstNode;
        for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode();

        return currentNode;
    }

    public Iterator<T> iterator()
    {
        return new IteratorForLinkedList();
    } // end iterator

    public Iterator<T> getIterator()
    {
        return iterator();
    } // end getIterator

    private class IteratorForLinkedList implements Iterator<T>
    {
        private Node nextNode;

        private IteratorForLinkedList()
        {
            nextNode = firstNode;
        } // end default constructor

        // Implementations of the methods in the interface Iterator go here.
        public T next()
        {
            T result;
            if (hasNext())
            {
                result = nextNode.getData();
                nextNode = nextNode.getNextNode(); // Advance iterator
            } else
                throw new NoSuchElementException("Illegal call to next(); " +
                        "iterator is after end of list.");
            return result; // Return next entry in iteration
        } // end next

        public boolean hasNext()
        {
            return nextNode != null;
        } // end hasNext

        public void remove()
        {
            throw new UnsupportedOperationException("remove() is not supported " +
                    "by this iterator");
        } // end remove


    } // end IteratorForLinkedList

    public class Node
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
    } // end Node
} // end LinkedListWithIterator
