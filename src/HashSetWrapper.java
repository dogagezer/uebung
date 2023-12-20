import java.util.HashSet;
import java.util.Iterator;

// Custom HashSet class using Generics
class HashSetWrapper<T> implements Iterable<T> {
    HashSet<T> set;

    // Constructor
    public HashSetWrapper() {
        set = new HashSet<>();
    }

    // add new element to the HashSet
    public void add(T data) {
        set.add(data);
    }

    // return Iterator instance
    public Iterator<T> iterator() {
        return new HashSetIterator<>(set);
    }
}

class HashSetIterator<T> implements Iterator<T> {
    private Iterator<T> iterator;

    // initialize iterator with the HashSet
    public HashSetIterator(HashSet<T> set) {
        this.iterator = set.iterator();
    }

    // returns false if next element does not exist
    public boolean hasNext() {
        return iterator.hasNext();
    }

    // return current data and update pointer
    public T next() {
        return iterator.next();
    }

    // implement if needed
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
