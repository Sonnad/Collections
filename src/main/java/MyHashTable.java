import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Sonad on 01.08.18.
 */
public class MyHashTable<K, V> {
    private int capacity;
    private List<Pair>[] table;
    private Function<K, Integer> hash = (key) -> {
        return Math.abs(key != null ? key.hashCode() : 0) % capacity;
    };

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        table = new ArrayList[capacity];
        initTable();
    }

    public MyHashTable() {
        this.capacity = 16;
        table = new ArrayList[capacity];
        initTable();
    }

    public MyHashTable(int capacity, Function<K, Integer> hash) {
        this.capacity = capacity;
        this.hash = hash;
    }

    public void add(K key, V value) {
        for (Pair pair: table[hash.apply(key)]) {
            if (pair.getKey().equals(key)) {
                pair.setValue(value);
                return;
            }
        }
        table[hash.apply(key)].add(new Pair(key, value));
        resize();
    }

    public V search(K key) {
        for (Pair pair : table[hash.apply(key)]) {
            if (pair.getKey().equals(key)) return (V)pair.getValue();
        }
        return null;
    }

    public boolean remove(K key) {
        for (Pair pair: table[hash.apply(key)]) {
            if (pair.getKey().equals(key)) {
                table[hash.apply(key)].remove(pair);
                return true;
            }
        }
        return false;
    }

    public Double getLoadFactor() {
        double empty = 0;
        double notEmpty = 0;
        for (int i = 0; i < capacity; i++) {
            if (table[i].size() > 0) notEmpty++;
            else empty++;
        }
        return Math.round((notEmpty/empty) * 100.0) / 100.0;
    }

    public Integer getBucketCount() {
        return capacity;
    }

    public Integer maxCollisionLength() {
        int max = 0;
        for (int i = 0; i < capacity; i++) {
            if (table[i].size() > max) max = table[i].size();
        }
        return max;
    }


    private void resize() {
        if (getLoadFactor() > 0.75) {
            capacity *= 2;
            table = Arrays.copyOf(table, capacity);
            initTable();
        }
    }

    private void initTable() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] == null) table[i] = new ArrayList<>();
        }
    }

    private class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }



    }



}
