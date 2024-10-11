package ru.nsu.zarcer;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

/**Class for hashtable.
 *
 * @param <K> generic type for keys
 *
 * @param <V> generic type for values
 *
 */
public class HashTable<K, V> implements Iterable<Element<K, V>> {

    private ArrayList<ArrayList<Element<K, V>>> table;
    private int size;
    private int changes;

    /**
     * Constructor that initialize table with first 5 hashes.
     */
    public HashTable() {
        table = new ArrayList<>(5);
        size = 0;
        changes = 0;
        for (int i = 0; i < 5; i++) {
            table.add(new ArrayList<>());
        }
    }

    /**Computes hash for key.
     *
     * @param key generic type, on this will compute hash
     *
     * @return returns hash
     *
     */
    public int hashFunc(K key) {
        return (Objects.hashCode(key) % table.size());
    }

    /**Puts value in hashtable.
     *
     * @param key what key assign to value
     *
     * @param value value needs to be placed
     *
     */
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

    /**Removes value based on key.
     *
     * @param key what key used to delete value
     *
     * @return true if deletion was successful, false otherwise
     *
     */
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

    /**Returns value.
     *
     * @param key what key used to find value
     *
     * @return value assigned to key
     *
     */
    public V get(K key) {
        int index = hashFunc(key);
        for (Element<K, V> test : table.get(index)) {
            if (Objects.equals(key, test.getKey())) {
                return test.getValue();
            }
        }
        return null;
    }

    /**Updates value on key.
     *
     * @param key what key used to find value
     *
     * @param value assigned to key
     *
     */
    public void update(K key, V value) {
        int index = hashFunc(key);
        for (Element<K, V> test : table.get(index)) {
            if (Objects.equals(key, test.getKey())) {
                test.setValue(value);
            }
        }
    }

    /**Checks if element with K key exists.
     *
     * @param key what key used to find value
     *
     * @return true if element was found, false otherwise
     *
     */
    public boolean checkExist(K key) {
        boolean check = false;
        int index = hashFunc(key);
        for (Element<K, V> test : table.get(index)) {
            if (Objects.equals(key, test.getKey())) {
                check = true;
                break;
            }
        }
        return check;
    }

    /**Override for hashCode().
     *
     * @return hash
     *
     */
    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    /**
     * Resize method, used when table filled more or equal 50%.
     */
    public void resize() {
        int newCapacity = table.size() * 2;
        ArrayList<ArrayList<Element<K, V>>> newTable =
            new ArrayList<>(newCapacity);
        for (int i = 0; i < newCapacity; i++) {
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

    /**Iterator override.
     *
     * @return new iterator
     *
     */
    @Override
    public Iterator<Element<K, V>> iterator() {
        return new HashTableIterator();
    }

    /**Override for equals.
     *
     * @param obj with whom this. will compare
     *
     * @return true if equal, false otherwise
     *
     */
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

    /**toString override.
     *
     * @return string
     *
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (ArrayList<Element<K, V>> list : table) {
            for (Element<K, V> entry : list) {
                output.append("[").append(entry.getKey())
                    .append(" ").append(entry.getValue()).append("]\n");
            }
        }
        return output.toString();
    }

    /**
     * Iterator class.
     */
    private class HashTableIterator implements Iterator<Element<K, V>> {

        private int currIndexList;
        private int currIndexElem;
        private int captureChanges;

        /**
         * Just initialization of values.
         */
        private HashTableIterator() {
            captureChanges = changes;
            currIndexList = 0;
            currIndexElem = 0;
        }

        /**Checks if there is next element in table.
         *
         * @return true if next element is existed, false otherwise
         *
         */
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

        /**Returns current element and sets next element for next call of next().
         *
         * @return Element class
         *
         */
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