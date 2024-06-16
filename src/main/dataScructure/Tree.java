package main.dataScructure;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    public Node root;

    public static class Node {
    
        public int value;
        public Node left;
        public Node rigth;
        public Node(int value) {
            this.value = value;
        }

        public boolean isLeaf(Node node){
            return (this.left==null) && (this.rigth==null);
        }
    }

    public void insert(int value){
        if (root==null) root = new Node(value);
        else{
            Node newNode = new Node(value);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size()>0) {
                Node currentNode = queue.remove();
                if (currentNode.left==null) {
                    currentNode.left=newNode;
                    break;
                }else{
                    queue.add(currentNode.left);
                }
                if (currentNode.rigth==null) {
                    currentNode.rigth=newNode;
                    break;
                }else{
                    queue.add(currentNode.rigth);
                }
            }
        }
    }

    public void preOrder(){
        //R E D
        System.out.println("-----------------------------");
        preOrder(root);
        System.out.println("-----------------------------");
    }

    private void preOrder(final Node node) {
        if(node ==null)return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.rigth);
    }

    public void inOrder(){
        //E R D
        System.out.println("-----------------------------");
        inOrder(root);
        System.out.println("-----------------------------");
    }

    private void inOrder(final Node node) {
        if(node ==null)return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.rigth);
    }

    public void posOrder(){
        //E R D
        System.out.println("-----------------------------");
        posOrder(root);
        System.out.println("-----------------------------");
    }

    private void posOrder(final Node node) {
        if(node ==null)return;
        posOrder(node.left);
        posOrder(node.rigth);
        System.out.println(node.value);
    }

    public void BFS(){
        if (root ==null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        System.out.println("-----------------------------");
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if(node.left!=null) queue.add(node.left);
            if(node.rigth!=null) queue.add(node.rigth);

            System.out.println(node.value);
        }
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(7);
        tree.insert(34);
        tree.insert(97);

        System.out.println(tree.root.value);
        System.out.println(tree.root.left.value);
        System.out.println(tree.root.rigth.value);

        tree.preOrder();
        tree.inOrder();
        tree.posOrder();
    }

}
