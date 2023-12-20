import java.util.Iterator;

// Custom Linked List class using Generics
class List<T> implements Iterable<T> {
    MapNode<T> head, tail;

    // add new Element at tail of the linked list in O(1)
    public void add(T data)
    {
        MapNode<T> mapNode = new MapNode<>(data, null);
        if (head == null)
            tail = head = mapNode;
        else {
            tail.setNext(mapNode);
            tail = mapNode;
        }
    }

    // return Head
    public MapNode<T> getHead()
    {
        return head;
    }

    // return Tail
    public MapNode<T> getTail()
    {
        return tail;
    }

    // return Iterator instance
    public Iterator<T> iterator()
    {
        return new ListIterator<T>(this);
    }
}

class ListIterator<T> implements Iterator<T> {
    MapNode<T> current;

    // initialize pointer to head of the list for iteration
    public ListIterator(List<T> list)
    {
        current = list.getHead();
    }

    // returns false if next element does not exist
    public boolean hasNext()
    {
        return current != null;
    }

    // return current data and update pointer
    public T next()
    {
        T data = current.getData();
        current = current.getNext();
        return data;
    }

    // implement if needed
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}

// Constituent Node of Linked List
class Node<T> {
    T data;
    MapNode<T> next;
    public Node(T data, MapNode<T> next)
    {
        this.data = data;
        this.next = next;
    }

    // Setter getter methods for Data and Next Pointer
    public void setData(T data)
    {
        this.data = data;
    }

    public void setNext(MapNode<T> next)
    {
        this.next = next;
    }

    public T getData()
    {
        return data;
    }

    public MapNode<T> getNext()
    {
        return next;
    }
}
