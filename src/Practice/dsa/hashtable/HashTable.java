package Practice.dsa.hashtable;

import java.util.ArrayList;

public class HashTable {

    private final int size = 10;
    private Node[] dataMap;

    public HashTable(){
        dataMap = new Node[size];
    }

    public class Node{
        public String key;
        public int value;
        private Node next;
        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public Node[] getDataMap() {
        return dataMap;
    }

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    public void set(String key, int value){
        int index = generateIndex(key);
        Node newNode = new Node(key, value);

        Node temp = dataMap[index];

        if(temp == null){
            dataMap[index] = newNode;
        }else{
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key){
        int index = generateIndex(key);
        Node node = dataMap[index];

        if(node == null) return 0;

        while (node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return 0;
    }

    public ArrayList<String> allKeys(){
        ArrayList<String> result = new ArrayList<>();

        for(Node node : dataMap){
            while (node != null){
                result.add(node.key);
                node = node.next;
            }
        }
        return result;
    }

    private int generateIndex(String key) {
        int hash = 0;

        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            hash += (int) c;
        }

        return hash % size;
    }


}
