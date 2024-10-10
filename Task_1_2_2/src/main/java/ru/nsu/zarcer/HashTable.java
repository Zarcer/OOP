package ru.nsu.zarcer;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

public class HashTable<K, V> implements Iterable<Element<K, V>> {

    private ArrayList<ArrayList<Element<K, V>>> table;
    private final int EXTEND_NUMBER = 2;
    private int size;
    private int changes;

    public HashTable() {
        table = new ArrayList<>(5);
        size = 0;
        changes = 0;
        for (int i = 0; i < 5; i++) {
            table.add(new ArrayList<>());
        }
    }

    public int hashFunc(K key) {
        return (Objects.hashCode(key) % table.size());
    }

    public void put(K key, V value) {
        if ((double) size / table.size() > 0.50) {
            resize();
        }
        int index = hashFunc(key);
        for (Element<K, V> test : table.get(index)) {
            if (Objects.equals(key, test.getKey())) {
                test.setValue(value);
                return;
            }
        }
        table.get(index).add(new Element<>(key, value));
        size++;
        changes++;
    }

    public boolean remove(K key) {
        int index = hashFunc(key);
        for (Element<K, V> test : table.get(index)) {
            if (Objects.equals(key, test.getKey())) {
                table.get(index).remove(test);
                size--;
                changes++;
                return true;
            }
        }
        return false;

    }

    public V get(K key) {
        int index = hashFunc(key);
        for (Element<K, V> test : table.get(index)) {
            if (Objects.equals(key, test.getKey())) {
                return test.getValue();
            }
        }
        return null;
    }

    public void update(K key, V value) {
        int index = hashFunc(key);
        for (Element<K, V> test : table.get(index)) {
            if (Objects.equals(key, test.getKey())) {
                test.setValue(value);
            }
        }
    }

    public boolean checkExist(K key) {
        boolean check = false;
        int index = hashFunc(key);
        for (Element<K, V> test : table.get(index)) {
            if (Objects.equals(key, test.getKey())) {
                check = true;
                break;
            }
        }
        if (check) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(EXTEND_NUMBER, size);
    }

    public void resize() {
        ArrayList<ArrayList<Element<K, V>>> newTable = new ArrayList<>(table.size() * EXTEND_NUMBER);
        for (int i = 0; i < table.size() * EXTEND_NUMBER; i++) {
            newTable.add(new ArrayList<>());
        }
        for (ArrayList<Element<K, V>> list : table) {
            for (Element<K, V> entry : list) {
                int index = (Objects.hashCode(entry.getKey()) % newTable.size());
                newTable.get(index).add(entry);
            }
        }
        table = newTable;
        changes++;
    }

    @Override
    public Iterator<Element<K, V>> iterator() {
        return new HashTableIterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HashTable)) {
            return false;
        }
        HashTable<K, V> test = (HashTable<K, V>) obj;
        if (size != test.size) {
            return false;
        }
        for (ArrayList<Element<K, V>> list : table) {
            for (Element<K, V> entry : list) {
                V testValue = test.get(entry.getKey());
                if (!Objects.equals(entry.getValue(), testValue)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (ArrayList<Element<K, V>> list : table) {
            for (Element<K, V> entry : list) {
                output.append("[").append(entry.getKey()).append(" ").append(entry.getValue()).append("]\n");
            }
        }
        return output.toString();
    }

    private class HashTableIterator implements Iterator<Element<K, V>> {

        private int currIndexList;
        private int currIndexElem;
        private int captureChanges;

        private HashTableIterator() {
            captureChanges = changes;
            currIndexList = 0;
            currIndexElem = 0;
        }

        @Override
        public boolean hasNext() {
            if (captureChanges != changes) {
                throw new ConcurrentModificationException();
            }
            for (int i = currIndexList; i < table.size(); i++) {
                if (!table.get(i).isEmpty()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Element<K, V> next() {
            if (captureChanges != changes) {
                throw new ConcurrentModificationException();
            }
            while (currIndexList < table.size()) {
                if (currIndexElem < table.get(currIndexList).size()) {
                    int temp = currIndexElem;
                    int tempList = currIndexList;
                    currIndexElem++;
                    if (currIndexElem == table.get(currIndexList).size()) {
                        currIndexList++;
                        currIndexElem = 0;
                    }
                    return table.get(tempList).get(temp);
                }
                currIndexList++;
                currIndexElem = 0;
            }
            return null;
        }
    }
}