import java.util.Iterator;

class DoublyList<T> implements Iterable<T> {
    DoublyNode<T> head, tail;

    // add new Element at tail of the doubly linked list in O(1)
    public void add(T data) {
        DoublyNode<T> node = new DoublyNode<>(data, null, null);
        if (head == null)
            tail = head = node;
        else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
    }

    // return Head
    public DoublyNode<T> getHead() {
        return head;
    }

    // return Tail
    public DoublyNode<T> getTail() {
        return tail;
    }

    // return Iterator instance
    public Iterator<T> iterator() {
        return new DoublyListIterator<T>(this);
    }
}

class DoublyListIterator<T> implements Iterator<T> {
    DoublyNode<T> current;

    // initialize pointer to head of the list for iteration
    public DoublyListIterator(DoublyList<T> list) {
        current = list.getHead();
    }

    // returns false if next element does not exist
    public boolean hasNext() {
        return current != null;
    }

    // return current data and update pointer
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }

    // implement if needed
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

// Constituent Node of Doubly Linked List
class DoublyNode<T> {
    T data;
    DoublyNode<T> next, prev;

    public DoublyNode(T data, DoublyNode<T> next, DoublyNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    // Setter getter methods for Data, Next Pointer, and Previous Pointer
    public void setData(T data) {
        this.data = data;
    }

    public void setNext(DoublyNode<T> next) {
        this.next = next;
    }

    public void setPrev(DoublyNode<T> prev) {
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public DoublyNode<T> getNext() {
        return next;
    }

    public DoublyNode<T> getPrev() {
        return prev;
    }
}
