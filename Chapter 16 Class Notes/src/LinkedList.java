// import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient element insertion and
 * removal. This class contains a subset of the methods of the standard
 * java.util.LinkedList class.
 */
public class LinkedList {
    private Node first;

    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {
        this.first = null;
    }

    /**
     * Returns the first element in the linked list.
     * 
     * @return the first element in the linked list
     */
    public Object getFirst() {
        return this.first;
    }

    /**
     * Removes the first element in the linked list.
     * 
     * @return the removed element
     */

    public void removeFirst() {
        this.first = first.next;
    }

    /**
     * Adds an element to the front of the linked list.
     * 
     * @param element the element to add
     */

    public int size() {
        Node currentNode = this.first;
        int size = 0;
        while (currentNode != null) {
            currentNode = currentNode.next;
            size++;
        }
        return size;
    }

    private static int size(Node start) {
        if (start == null) {
            return 0;
        } else {
            return 1 + size(start.next);
        }
    }

    public int recursiveSize() {
        return size(this.first);
    }

    public void addElement(Object data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = this.first;
        this.first = newNode;
    }

    public boolean contains(Object obj) {
        Node currentNode = this.first;
        while (currentNode != null) {
            if (obj.equals(currentNode.data)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    private static boolean contains(Node start, Object obj) {
        if (start == null) {
            return false;
        } else if (obj.equals(start.data)) {
            return true;
        } else {
            return contains(start.next, obj);
        }
    }

    public boolean recursiveContains(Object obj) {
        return contains(this.first, obj);
    }

    /**
     * Returns an iterator for iterating through this list.
     * 
     * @return an iterator for iterating through this list
     */

    // Class Node
    static class Node {
        public Object data;
        public Node next;

        public Node() {
            this.data = null;
            this.next = null;
        }
    }

    // inmplements ListIterator
    class LinkedListIterator {
        // private data

        /**
         * Constructs an iterator that points to the front of the linked list.
         */

        /**
         * Moves the iterator past the next element.
         * 
         * @return the traversed element
         */

        /**
         * Tests if there is an element after the iterator position.
         * 
         * @return true if there is an element after the iterator position
         */

        /**
         * Adds an element before the iterator position and moves the iterator past the
         * inserted element.
         * 
         * @param element the element to add
         */

        /**
         * Removes the last traversed element. This method may only be called after a
         * call to the next() method.
         */

        /**
         * Sets the last traversed element to a different value.
         * 
         * @param element the element to set
         */

    }// LinkedListIterator
}// LinkedList
