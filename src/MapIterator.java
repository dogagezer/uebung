
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

class MapIterator<K, V> implements Iterator<Map.Entry<K, V>> {

    private MapNode<Map.Entry<K, V>> current;

    MapIterator(MapNode<Map.Entry<K, V>> head) {
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Map.Entry<K, V> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Map.Entry<K, V> data = current.getData();
        current = current.getNext();
        return data;
    }
}

// Custom Linked List class using Generics
class MapNode<T> {
    private T data;
    private MapNode<T> next;

    MapNode(T data, MapNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public MapNode<T> getNext() {
        return next;
    }

    public void setNext(MapNode<T> next) {
        this.next = next;
    }
}

class CustomMap<K, V> implements Iterable<Map.Entry<K, V>> {
    private MapNode<Map.Entry<K, V>> head, tail;

    public void put(K key, V value) {
        Map.Entry<K, V> entry = Map.entry(key, value);
        MapNode<Map.Entry<K, V>> mapNode = new MapNode<>(entry, null);

        if (head == null)
            tail = head = mapNode;
        else {
            tail.setNext(mapNode);
            tail = mapNode;
        }
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new MapIterator<>(head);
    }
}

