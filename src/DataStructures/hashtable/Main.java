package DataStructures.hashtable;

public class Main {

    public static void main(String[] args) {
        HashTable hash = new HashTable();

        hash.set("nails", 100);
        hash.set("tile", 50);
        hash.set("lumber", 80);
        hash.set("bolts", 200);
        hash.set("screws", 140);

        hash.printTable();

        //System.out.println(hash.keys());

//        System.out.println(hash.get("nails"));
//        System.out.println(hash.get("test 0"));

    }


}
