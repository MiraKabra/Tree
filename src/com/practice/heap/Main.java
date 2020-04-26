package com.practice.heap;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        Node node1 = new Node(4, 'C');
        Node node2 = new Node(5, 'A');
        Node node3= new Node(6, 'Y');
        Node node4 = new Node(15, 'K');
        Node node5 = new Node(9, 'F');
        Node node6 = new Node(7, 'Q');
        Node node7 = new Node(20, 'B');
        Node node8 = new Node(16, 'X');
        Node node9 = new Node(25, 'J');
        Node node10 = new Node(14, 'E');
        Node node11 = new Node(12, 'H');
        Node node12 = new Node(11, 'S');
        Node node13 = new Node(13, 'W');
        ArrayList<Node> array = new ArrayList<>();
        array.add(node1);
        array.add(node2);
        array.add(node3);
        array.add(node4);
        array.add(node5);
        array.add(node6);
        array.add(node7);
        array.add(node8);
        array.add(node9);
        array.add(node10);
        array.add(node11);
        array.add(node12);
        array.add(node13);

        //MinHeap minHeap = new MinHeap(array);
        //minHeap.inOrder(0);
        //System.out.println("Curreny min : " + minHeap.min().getKey());
        //minHeap.removeMin();
        //minHeap.inOrder(0);
        //System.out.println("Curreny min : " + minHeap.min().getKey());

        int[] arr = {14, 5, 8, 25, 9, 11, 7, 16, 15, 4, 12, 6, 7, 23, 20};

        MinHeap minHeap = new MinHeap(new ArrayList<>(arr.length));
        minHeap.bottomUpConstruction(arr);
        minHeap.inOrder(0);



    }

}
