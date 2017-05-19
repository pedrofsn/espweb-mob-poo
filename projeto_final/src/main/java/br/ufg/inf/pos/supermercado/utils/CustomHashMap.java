package br.ufg.inf.pos.supermercado.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pedrofsn on 19/05/2017.
 */
public class CustomHashMap<K, V> extends HashMap<K, V> {

    private Map<V, K> reverseMap = new HashMap<V, K>();

    @Override
    public V put(K key, V value) {
        reverseMap.put(value, key);
        return super.put(key, value);
    }

    public K getKey(V value) {
        return reverseMap.get(value);
    }
}