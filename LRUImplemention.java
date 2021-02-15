// Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:

// set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, 
// then it should also remove the least recently used item.
// get(key): gets the value at key. If no such key exists, return null.

// Each operation should run in O(1) time.

import java.util.LinkedHashMap;
import java.util.Map;


// Time complexity is O(n) and space complexity is O(n).
class LRUImplemention {

    public static final class LRU<K, V> {

        private final Map<K, V> map = new LinkedHashMap<>();
        private final int maxSize;

        public LRU(int maxSize) {

            this.maxSize = maxSize;
        }

        public void set(K key, V value) {

            if (map.containsKey(key)) {

                map.remove(key);
            }
            else if (map.size() == maxSize) {

                map.remove(map.keySet().iterator().next());
            }

            map.put(key, value);
        }

        public V get(K key) {

            if (!map.containsKey(key)) {

                return null;
            }

            V value = map.remove(key);
            map.put(key, value);

            return value;
        }
    }

    public static void main(String... args) {

        LRU<String, String> cache = new LRU<>(3);

        cache.set("one", "one1");
        cache.set("two", "two1");
        cache.set("three", "three1");
        cache.set("four", "four1");

        System.out.println(cache.get("two"));
        System.out.println(cache.get("one"));

        cache.set("five", "five1");
        System.out.println(cache.get("two"));
        System.out.println(cache.get("three"));

        cache.set("four", "four2");
        System.out.println(cache.get("four"));
    }
}