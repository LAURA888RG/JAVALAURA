package local.collections;

import java.util.HashMap;
import java.util.Map;

public class Demo09Map {

    Map<Character, String> map = new HashMap<>();

    public Demo09Map() {
        useMap();
    }

    public void useMap(){
        map.put('A', "Alpha");
        map.put('B', "Betta");
        map.put('C', "Charlie");

        map.put('A', "Alfa");
        map.replace('B', "Beta");

        map.replace('Z', "Zebra");

        map.remove('Z');
    }

    public void showMap(){
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.values());

        System.out.println(map.get('R'));
        System.out.println(map.get('A'));
        
    }

    public static void main(String[] args) {

        Demo09Map map = new Demo09Map();
        map.showMap();       
    }
}
