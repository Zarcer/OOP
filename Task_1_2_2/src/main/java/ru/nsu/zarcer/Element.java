package ru.nsu.zarcer;

/**Entry with value and a key.
 *
 * @param <K> generic key
 *
 * @param <V> generic value
 *
 */
public class Element<K, V> {
    private K key;
    private V value;

    /**Constructor of element.
     *
     * @param key generic
     *
     * @param value generic
     *
     */
    public Element(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**Just setter for key.
     *
     * @param key generic
     *
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**Just setter for value.
     *
     * @param value generic
     *
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**Just getter for key.
     *
     * @return generic
     *
     */
    public K getKey() {
        return this.key;
    }

    /**Just getter for value.
     *
     * @return generic
     *
     */
    public V getValue() {
        return this.value;
    }
}