package hashtable;

import java.util.*;

public class HashTable {

    private int size = 7;
    private Node[] dataMap;

    public HashTable (){
        dataMap = new Node[size];
    }

    class Node {
        String key;
        int value;
        Node next;

        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int hash(String key){
        int hash = 0;
        char[] chars = key.toCharArray();
        for(int i = 0; i < chars.length; i++){
            int ascii = chars[i];
            hash = (hash + ascii * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);

        if(dataMap[index] == null){
            dataMap[index] = newNode;
        }else{
            Node temp = dataMap[index]; //head
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];

        while(temp != null){
            if(key.equals(temp.key)) return temp.value;
            temp = temp.next;
        }

        return 0;
    }

    public ArrayList<String> keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        for(int i = 0; i < dataMap.length; i++){
            Node temp = dataMap[i];
            while(temp != null){
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public void printTable(){
        for(int i = 0; i < dataMap.length; i++){
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null){
                System.out.println(" {" + temp.key + "=" + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    public boolean itemInCommon(int[] array1, int[] array2){
        HashMap<Integer, Boolean> hash = new HashMap<>();

        for(int value : array1){
            hash.put(value, true);
        }


        for(int value : array2){
            if(hash.get(value).equals(value)) return true;
        }

        return false;
    }



}
