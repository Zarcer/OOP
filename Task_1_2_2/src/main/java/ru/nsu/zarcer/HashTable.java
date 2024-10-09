package ru.nsu.zarcer;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;

public class HashTable<K, V> implements Iterable<Element<K, V>> {

    private ArrayList<ArrayList<Element<K, V>>> table;
    private int size;
    private int changes;

    public HashTable(){
        table = new ArrayList<>(100);
        size = 0;
        changes = 0;
        for(int i = 0;i<100;i++){
            table.add(new ArrayList<>());
        }
    }

    public int hashFunc(K key){
        return (Objects.hashCode(key)% table.size());
    }

    public void put(K key, V value){
        if((double) size / table.size()>0.50){
            resize();
        }
        int index = hashFunc(key);
        for(Element<K, V> test : table.get(index)){
            if(Objects.equals(key, test.getKey())){
                test.setValue(value);
                return;
            }
        }
        table.get(index).add(new Element<>(key, value));
        size++;
        changes++;
    }

    public void remove(K key){
        int index = hashFunc(key);
        for(Element<K, V> test : table.get(index)){
            if(Objects.equals(key, test.getKey())){
                table.get(index).remove(test);
                size--;
                changes++;
                break;
            }
        }

    }

    public V get(K key){
        int index = hashFunc(key);
        for(Element<K, V> test : table.get(index)){
            if(Objects.equals(key, test.getKey())){
                return test.getValue();
            }
        }
        return null;
    }

    public void update(K key, V value) {
        int index = hashFunc(key);
        for(Element<K, V> test : table.get(index)){
            if(Objects.equals(key, test.getKey())){
                test.setValue(value);
            }
        }
    }

    public int checkExist(K key){
        boolean check = false;
        int index = hashFunc(key);
        for(Element<K, V> test : table.get(index)){
            if (Objects.equals(key, test.getKey())) {
                check = true;
                break;
            }
        }
        if(check){
            return 1;
        }
        else{
            return 0;
        }
    }

    public void resize() {
        ArrayList<ArrayList<Element<K, V>>> newTable = new ArrayList<>(table.size()*2);
        for(int i = 0;i< table.size()*2;i++){
            newTable.add(new ArrayList<>());
        }
        for(ArrayList<Element<K, V>> list : table){
            for(Element<K, V> entry : list){
                int index = (Objects.hashCode(entry.getKey())% newTable.size());
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
    public boolean equals(Object obj){
        if(!(obj instanceof HashTable)){
            return false;
        }
        HashTable<K, V> test = (HashTable<K, V>) obj; //how check????
        if(size!=test.size){
            return false;
        }
        for(ArrayList<Element<K, V>> list : table){
            for(Element<K, V> entry : list){
                V testValue = test.get(entry.getKey());
                if(!Objects.equals(entry.getValue(), testValue)){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString(){
        String output="";
        for(ArrayList<Element<K, V>> list : table){
            for(Element<K, V> entry : list){
                output = output+"["+entry.getKey()+" "+entry.getValue()+"]\n";
            }
        }
        return output;
    }

    private class HashTableIterator implements Iterator<Element<K, V>> {

        private int currIndexList;
        private int currIndexElem;
        private int captureChanges;

        private HashTableIterator(){
            captureChanges = changes;
            currIndexList = 0;
            currIndexElem = 0;
        }

        @Override
        public boolean hasNext() {
            if(captureChanges!=changes){
                throw new ConcurrentModificationException();
            }
            for(int i = currIndexList;i<table.size();i++){
                if(!table.get(i).isEmpty()){
                    return true;
                }
            }
            return false;
        }

        @Override
        public Element<K, V> next() {
            if(captureChanges!=changes){
                throw new ConcurrentModificationException();
            }
            while(currIndexList<table.size()){
                if (currIndexElem<table.get(currIndexList).size()){
                    int temp = currIndexElem;
                    currIndexElem++;
                    return table.get(currIndexList).get(temp);
                }
                currIndexList++;
                currIndexElem = 0;
            }
            return null;
        }
    }
}