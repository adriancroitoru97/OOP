package lab11.task1;

import java.util.*;

public class MultiMapValue<K, V> {

    private final HashMap<K, ArrayList<V>> hashMap = new HashMap<>();

    public void add(K key, V value) {
        if (hashMap.containsKey(key)) {
            (hashMap.get(key)).add(value);
        } else {
            ArrayList<V> arrayList = new ArrayList<>();
            arrayList.add(value);
            hashMap.put(key, arrayList);
        }
    }

    public void addAll(K key, List<V> values) {
        if (hashMap.containsKey(key)) {
            (hashMap.get(key)).addAll(values);
        } else {
            ArrayList<V> arrayList = new ArrayList<>(values);
            hashMap.put(key, arrayList);
        }
    }

    public void addAll(MultiMapValue<K, V> map) {
        for (Map.Entry<K, ArrayList<V>> entry: map.hashMap.entrySet()) {
            addAll(entry.getKey(), entry.getValue());
        }
    }

    public V getFirst(K key) {
        if (hashMap.containsKey(key) && hashMap.get(key).size() > 0) {
            return hashMap.get(key).get(0);
        }

        return null;
    }

    public List<V> getValues(K key) {
        return hashMap.get(key);
    }

    public boolean containsKey(K key) {
        return hashMap.containsKey(key);
    }

    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    public List<V> remove(K key) {
        return hashMap.remove(key);
    }

    public int size() {
        return hashMap.size();
    }
}
