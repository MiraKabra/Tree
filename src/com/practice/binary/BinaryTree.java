package com.practice.binary;

public class BinaryTree {

    private Node root;
    public BinaryTree(){
        root = null;
    }

    public int computeHeight(Node v){
        int left = 0; int right = 0;

        if(v.getLeftChild() == null && v.getRightChild() == null){
            return 0;
        }
        if(v.getLeftChild() != null){
            left = 1 + computeHeight(v.getLeftChild());
        }
        if(v.getRightChild() != null){
            right = 1 + computeHeight(v.getRightChild());
        }
        return Math.max(left, right);
    }

    public int computeDepth(Node v){
        int depth = 0;
        Node ancestor = v;
        while (!ancestor.equals(root)){
            depth++;
            ancestor = ancestor.getParent();
        }
        return depth;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void preOrder(Node root){

        if(root == null){
            return;
        }

        System.out.println(root.getValue());

        if(root.getLeftChild() != null){
            preOrder(root.getLeftChild());
        }

        if(root.getRightChild() != null){
            preOrder(root.getRightChild());
        }
    }

    public void postOrder(Node root){

        if(root == null){
            return;
        }

        if(root.getLeftChild() != null){
            postOrder(root.getLeftChild());
        }

        if(root.getRightChild() != null){
            postOrder(root.getRightChild());
        }

        System.out.println(root.getValue());
    }

    public void inOrder(Node root){

        if(root == null) return;

        if(root.getLeftChild() != null){
            inOrder(root.getLeftChild());
        }

        System.out.println(root.getValue());

        if(root.getRightChild() != null){
            inOrder(root.getRightChild());
        }
    }
}



