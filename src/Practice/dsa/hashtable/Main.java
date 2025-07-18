package Practice.dsa.hashtable;

public class Main {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.set("test", 10);
        hashTable.set("nails", 10);
        hashTable.set("ilsan", 15);
        hashTable.set("cobasi", 15);
        hashTable.set("ar", 21);

        System.out.println(hashTable.get("ar"));
        System.out.println(hashTable.get("nails"));
        System.out.println(hashTable.get("cobasi"));
        //hashTable.printTable();

        System.out.println(hashTable.allKeys().toString());

    }

}
