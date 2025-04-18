package com.pandeyar;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest<K, V> extends HashMap<K, V> {


    Map<K, V> map;

    public HashMapTest() {
        map = new HashMap<K, V>();
    }

    public static void main(String[] args) {

        HashMapTest<MapKey, MapValue> hashMap = new HashMapTest<MapKey, MapValue>();
        for (int i = 1; i <= 25; i++) {
            hashMap.put(new MapKey(i), new MapValue("MapValue_" + i));

        }


//		Set<Map.Entry<MapKey,MapValue>> entrySet=hashMap.entrySet();

//		Iterator<Map.Entry<MapKey,MapValue>> iterator=entrySet.iterator();
//		
//		while(iterator.hasNext()){
//			Map.Entry<MapKey, MapValue> entry=iterator.next();
//			System.out.println("Entry Key is - "+entry.getKey()+" Entry Value is - "+entry.getValue());
//		}
//		

        for (Map.Entry<MapKey, MapValue> entry : hashMap.entrySet()) {
            System.out.println("Entry Key is - " + entry.getKey() + " Entry Value is - " + entry.getValue());
        }
    }
}


class MapKey {
    int keyNumber;

    public MapKey(int keyNumber) {
        this.keyNumber = keyNumber;
    }

    public String toString() {
        return String.valueOf(keyNumber);
    }
}

class MapValue {
    String value;

    public MapValue(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}