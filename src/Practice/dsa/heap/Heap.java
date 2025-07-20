package Practice.dsa.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    public List<Integer> root; // I set this public for print my heap...

    public Heap(){
        root = new ArrayList<>();
        root.add(0);
    }

    public void push(int value){
        root.add(value);
        int actual = root.size() - 1;
        while(actual > 1 && root.get(actual) < root.get(actual / 2)){
            swap(actual, actual / 2);
            actual = actual / 2; //For get the parent
        }
    }

    public Integer pop(){
        if(root.size() == 1){
            return null;
        }
        if(root.size() == 2){
            return root.remove(root.size() - 1);
        }

        int i = 1;
        int firstNode = root.get(i);

        swap(i, root.size() - 1);
        root.remove(root.size() - 1);

        while(i * 2 < root.size()){
           if (2*i + 1 < root.size() && root.get(2 * i + 1) < root.get(2 * i) && root.get(i) > root.get(2 * i + 1)){
                swap(i * 2 + 1, i);
                i = i * 2 + 1;
            } else if(root.get(i * 2) < root.get(i)){
                swap(i * 2, i);
                i = i * 2;
            }
        }

        return firstNode;
    }

    public void heapify(int[] array){
        root = new ArrayList<>();
        for(int num : array){
            root.add(num);
        }
        int temp = root.get(0);
        root.set(0, 0);
        root.add(temp);

        int i = root.size() / 2 - 1;

        while(i > 0){
            if(root.get(i * 2) < root.get(i) && root.get(i * 2) < root.get(i * 2 + 1)){
                swap(i, i * 2);
            }else if(root.get(i * 2 + 1) < root.get(i)){
                swap(i, i * 2 + 1);
            }
            i = i - 1;
        }
        i = 1;
        while(i * 2 < root.size()){
            if(root.get(i * 2) < root.get(i) && root.get(i * 2) < root.get(i * 2 + 1)){
                swap(i, i * 2);
                i = i * 2;
            }else if(root.get(i * 2 + 1) < root.get(i)){
                swap(i, i * 2 + 1);
                i = i * 2 + 1;
            }
            i = i * 2;
        }
    }

    public void swap(int indexOne, int indexTwo){
        Integer temp = root.get(indexOne);
        root.set(indexOne, root.get(indexTwo));
        root.set(indexTwo, temp);

    }

}
