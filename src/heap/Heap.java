package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> heap;

    public Heap(){
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap(){
        return new ArrayList<>(heap);
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    public int parent(int index){
        return (index - 1 ) / 2;
    }

    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value){
        heap.add(value);
        int current = heap.size() - 1;

        while(current > 0 && heap.get(current) > heap.get(parent(current))){
            swap(current, parent(current));
            current = parent(current);
        }

    }

}
