package main.dataScructure;

public class BST {
    public Node root;   

    public static class Node {
    
        public int value;
        public Node left;
        public Node rigth;
        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value){
        if (root==null){
            root = new Node(value);
        }else{
            insert(root,value);
        }
    }

    private void insert(final Node root, int value) {
        if (root==null) return;
        if (value==root.value) {
            return;
        }
        if (value>root.value) {
            if (root.rigth==null) {
                root.rigth = new Node(value);
            }else insert(root.rigth,value);
        }else{
            if (root.left==null) {
                root.left = new Node(value);
            }else insert(root.left,value);
        }
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

    public boolean contains(int value){
        return contains(root, value);
    }

    private boolean contains(final Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.value==value) {
            return true;
        }
        if (value>root.value) {
            return contains(root.rigth,value);
        }else{
            return contains(root.left,value);
        }
    }

    public int minValue(Node currentNode){
        while (currentNode.left!=null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void deleteNode(int value){
        deleteNode(root, value);
    }

    private Node deleteNode(final Node root, int value) {
        if (root==null) return null;
        if (value<root.value) {
            root.left = deleteNode(root.left, value);
        }else if(value>root.value){
            root.rigth = deleteNode(root.rigth, value);
        }else{
            if ((root.left==null) && (root.rigth==null)) {
                return null;
            }else if(root.left==null){
                return root.rigth;
            }else if(root.rigth==null){
                return root.left;
            }else{
                int minValue = minValue(root.rigth);
                root.value=minValue;
                root.rigth = deleteNode(root.rigth, minValue);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(435);
        tree.insert(345);
        tree.insert(65);
        tree.insert(34);
        tree.insert(545);
        tree.insert(4354);

        tree.deleteNode(34);

        tree.inOrder();
        System.out.println(tree.contains(99));
        System.out.println(tree.contains(65));


    }
}
