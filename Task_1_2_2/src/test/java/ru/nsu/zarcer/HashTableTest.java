package ru.nsu.zarcer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class HashTableTest {
    @Test
    public void putAndGetTest() {
        HashTable<String, Number> hashTable = new HashTable<>();
        hashTable.put("one", 1);
        assertEquals(1, hashTable.get("one"));
    }

    @Test
    public void removeTest() {
        HashTable<String, Number> hashTable = new HashTable<>();
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        assertTrue(hashTable.remove("one"));
        assertNull(hashTable.get("one"));
    }

    @Test
    public void updateTest() {
        HashTable<String, Number> hashTable = new HashTable<>();
        hashTable.put("one", 1);
        hashTable.update("one", 1.0);
        assertEquals(1.0, hashTable.get("one"));
    }

    @Test
    public void checkExistTest() {
        HashTable<String, Number> hashTable = new HashTable<>();
        hashTable.put("one", 1);
        assertTrue(hashTable.checkExist("one"));
        assertFalse(hashTable.checkExist("test"));
    }

    @Test
    public void resizeTest() {
        HashTable<String, Number> hashTable = new HashTable<>();
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);
        hashTable.put("four", 4);
        hashTable.put("five", 5);
        hashTable.put("six", 6);
        hashTable.put("seven", 7);
        hashTable.put("eight", 8);
        hashTable.put("nine", 9);
        hashTable.put("ten", 10);
        assertEquals(10, hashTable.get("ten"));
    }

    @Test
    public void equalsTest() {
        HashTable<String, Number> hashTable = new HashTable<>();
        HashTable<String, Number> test = new HashTable<>();
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);
        test.put("one", 1);
        test.put("two", 2);
        test.put("three", 3);
        assertEquals(hashTable, test);
        test.put("four", 4);
        assertNotEquals(test, hashTable);
    }

    @Test
    public void toStringTest() {
        HashTable<String, Number> hashTable = new HashTable<>();
        hashTable.put("one", 1);
        assertEquals("[one 1]\n", hashTable.toString());
    }

    @Test
    public void IteratorTest() {
        HashTable<String, Number> hashTable = new HashTable<>();
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);
        for (Element<String, Number> test : hashTable) {
            assertEquals(hashTable.get(test.getKey()), test.getValue());
        }
    }
}