package LRUCache;


import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMapImpl<K, V> extends LinkedHashMap<K, V> {
    private final int maxEntries;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public LRUCacheLinkedHashMapImpl(int initialCapacity,
                    float loadFactor,
                    int maxEntries) {
        super(initialCapacity, loadFactor, true);
        this.maxEntries = maxEntries;
    }

    public LRUCacheLinkedHashMapImpl(int initialCapacity,
                    int maxEntries) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR, maxEntries);
    }

    public LRUCacheLinkedHashMapImpl(int maxEntries) {
        this(DEFAULT_INITIAL_CAPACITY, maxEntries);
    }

    // not very useful constructor
    public LRUCacheLinkedHashMapImpl(Map<? extends K, ? extends V> m,
                    int maxEntries) {
        this(m.size(), maxEntries);
        putAll(m);
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxEntries;
    }
}
