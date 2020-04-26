package com.practice.heap;

import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Node> array;

    public MinHeap(ArrayList<Node> array) {
        this.array = array;
    }

    private int leftChild(int i) {
        return  (2 * i + 1 > array.size() - 1) ? -1 : 2 * i + 1;
    }

    private int rightChild(int i) {
        return (2 * i + 2) > array.size() - 1 ? -1 : (2 * i + 2);
    }

    private int parent(int i) {
        return i == 0 ? -1 : (int) Math.floor((i - 1)/2);
    }

    private void upHeapBubble(int i){
        int parent = array.get(parent(i)).getKey();
        int child = array.get(i).getKey();
        if (child >= parent) return;
        Node temp = array.get(parent(i));
        array.set(parent(i), array.get(i));
        array.set(i, temp);
        upHeapBubble(parent(i));
    }

    private void downHeapBubble(int i){
        int leftChild = leftChild(i);
        int rightChild = rightChild(i);
        if(leftChild == -1 || rightChild == -1) return;
        int lower = 0;
        if(leftChild == -1){
            lower = rightChild;
        }
        else if(rightChild == -1){
            lower = leftChild;
        }
        else{
            lower = array.get(leftChild).getKey() <= array.get(rightChild).getKey() ? leftChild : rightChild;
        }

        if (array.get(i).getKey() <= array.get(lower).getKey()) return;
        Node temp = array.get(lower);
        array.set(lower, array.get(i));
        array.set(i, temp);
        downHeapBubble(lower);
    }

    public void insert(int k, char v) {

        array.add(new Node(k, v));
        upHeapBubble(array.size() - 1);
    }

    public Node min(){
        return array.get(0);
    }

    public Node removeMin(){
        Node root = array.get(0);
        array.set(0, array.get(array.size() - 1));
        array.remove(array.size() - 1);
        downHeapBubble(0);
        return root;
    }

    public void inOrder(int i){

        if(i < 0 || i > array.size() - 1 ) return;

        if(! (2*i + 1 > array.size() - 1) ){
            inOrder(2*i + 1);
        }

        System.out.println(array.get(i).getKey());

        if(!(2*i + 2 > array.size() - 1)){
            inOrder(2*i + 2);
        }
    }

    public  MinHeap bottomUpConstruction(int[] array){

        Node[] heapArray = new Node[array.length];
        for(int i = 0; i < array.length; i++){
            this.array.add(null);
        }
        int level = 0; int nodes = array.length;
        while((nodes / (int)Math.pow(2, level) >= 1)){
            nodes = nodes - (int)Math.pow(2, level);
            level++;
        }
        int leafNodes = nodes;
        int size = array.length;
        if(leafNodes != 0) {
            for (int i = size - leafNodes; i < size; i++) {
                heapArray[i] = new Node(array[i], 'A');
            }
        }
        level--;
        nodes = array.length;  int counter = 0;
        while (level >= 0){
            System.out.println("level : " + (level) );
            int lastIndex = nodes - 1 - counter; int startIndex = lastIndex - (int)Math.pow(2, level) + 1;
            for(int i = startIndex ; i <= lastIndex; i++){

                counter++;
                this.array.set(i, new Node(array[i], 'A'));
                downHeapBubble(i);
            }
            for(Node node : this.array){
                if(node != null) System.out.print(node.getKey() + " ");

            }
            level--;
        }
        return this;
    }
}
