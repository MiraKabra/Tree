package com.practice.binary;


public class Main {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        Node root = new Node(1, null, null, null);
        Node node2 = new Node(2, root, null, null);
        Node node3 = new Node(3, root, null, null);
        Node node4 = new Node(4, node2, null, null);
        Node node5 = new Node(5, node2, null, null);
        Node node6 = new Node(6, node3, null, null);
        Node node7 = new Node(7, node3, null, null);
        Node node8 = new Node(8, node4, null, null);
        Node node9 = new Node(9, node4, null, null);

        binaryTree.setRoot(root);
        root.setLeftChild(node2);  root.setRightChild(node3);
        node2.setLeftChild(node4); node2.setRightChild(node5);
        node3.setLeftChild(node6);  node3.setRightChild(node7);
        node4.setLeftChild(node8); node4.setRightChild(node9);

        System.out.println(binaryTree.computeDepth(node8));

        System.out.println("Pre Order: ");
        binaryTree.preOrder(root);

        System.out.println("Post Order");
        binaryTree.postOrder(root);

        System.out.println("In Order");
        binaryTree.inOrder(root);


    }
}
