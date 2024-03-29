import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient element insertion and
 * removal. This class contains a subset of the methods of the standard
 * java.util.LinkedList class. Complete the reverse method by reversing the
 * links in a the list. Implement this method by directly rerouting the links,
 * not by using an iterator.
 */
public class LinkedList {
    private Node first;

    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {
        first = null;
    }

    /**
     * Reverses all elements in a linked list.
     */
    public void reverse() {
        // Complete this method
        Node previousNode = new Node();
        previousNode.data = first.next.data;
        previousNode.next = first.next;
        first.next = null;
        first = previousNode;

        System.out.println("hello" + first);

        System.out.println(first.data + " " + first.next.data + " " + previousNode.data);
        while (first != null) {
            // 4 -> 5 -> 6
            // currently, first = 5
            // we want first to go to the next one so
            // node = first (5)
            // node.next = previousNode (4)
            // previousNode = node (5)
            // first = first.next

            System.out.println(first.data + " " + first.next.data);
            // Node node = this.first;
            Node node = first.next;
            first.next = previousNode;
            previousNode = first;
            // System.out.println(node.data + " " + first.data);
            first = node;
            // first = node;
            // first = first.next;
            // node.next = node;
            // System.out.println(node.data + " " + first.data);
            // node.next = previousNode;
            // previousNode = node;
        }
    }

    /**
     * Returns the first element in the linked list.
     * 
     * @return the first element in the linked list
     */
    public Object getFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    /**
     * Removes the first element in the linked list.
     * 
     * @return the removed element
     */
    public Object removeFirst() {
        if (first == null)
            throw new NoSuchElementException();
        Object element = first.data;
        first = first.next;
        return element;
    }

    /**
     * Adds an element to the front of the linked list.
     * 
     * @param element the element to add
     */
    public void addFirst(Object element) {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
    }

    /**
     * Returns an iterator for iterating through this list.
     * 
     * @return an iterator for iterating through this list
     */
    public ListIterator listIterator() {
        return new LinkedListIterator();
    }

    private class Node {
        public Object data;
        public Node next;
    }

    private class LinkedListIterator implements ListIterator {
        private Node position;
        private Node previous;

        /**
         * Constructs an iterator that points to the front of the linked list.
         */
        public LinkedListIterator() {
            position = null;
            previous = null;
        }

        /**
         * Moves the iterator past the next element.
         * 
         * @return the traversed element
         */
        public Object next() {
            if (!hasNext())
                throw new NoSuchElementException();
            previous = position; // Remember for remove

            if (position == null)
                position = first;
            else
                position = position.next;

            return position.data;
        }

        /**
         * Tests if there is an element after the iterator position.
         * 
         * @return true if there is an element after the iterator position
         */
        public boolean hasNext() {
            if (position == null)
                return first != null;
            else
                return position.next != null;
        }

        /**
         * Adds an element before the iterator position and moves the iterator past the
         * inserted element.
         * 
         * @param element the element to add
         */
        public void add(Object element) {
            if (position == null) {
                addFirst(element);
                position = first;
            } else {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
            previous = position;
        }

        /**
         * Removes the last traversed element. This method may only be called after a
         * call to the next() method.
         */
        public void remove() {
            if (previous == position)
                throw new IllegalStateException();

            if (position == first) {
                removeFirst();
            } else {
                previous.next = position.next;
            }
            position = previous;
        }

        /**
         * Sets the last traversed element to a different value.
         * 
         * @param element the element to set
         */
        public void set(Object element) {
            if (position == null)
                throw new NoSuchElementException();
            position.data = element;
        }
    }
}
