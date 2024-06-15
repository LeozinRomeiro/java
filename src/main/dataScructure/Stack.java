package main.dataScructure;

public class Stack {
    private Node top;
    private int height;
    
    public Stack(int value) {
        Node newNode =  new Node(value);
        top = newNode;
        height++;
    }

    public void getTop(){
        if (top == null) {
            System.out.println("Pilha vazia");
        }else{
            System.out.println("Top: "+top.value);
        }
    }

    public void getHeight(){
        if (top == null) {
            System.out.println("Pilha vazia");
        }else{
            System.out.println("Altura: "+height);
        }
    }

    public void print(){
        Node temp = top;
        System.out.println("-----------------------------");
        while (temp!=null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("-----------------------------");
    }

    public void push(int value){
        Node newNode =  new Node(value);
        if (height ==0 ) {
            top = newNode;
        }else{
            newNode.next=top;
            top=newNode;
        }
        height++;
    }

    public Node pop(){
        if (height ==0 ) return null;

        Node temp = top;
        top = temp.next;
        top.next = null;

        height--;
        return temp;
    }

    class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }

    public static void main(String[] args){
        Stack stack = new Stack(7);
        stack.push(7);
        stack.getHeight();
        stack.getTop();
        stack.print();
        System.out.println(stack.pop().value);
        stack.getHeight();
        stack.getTop();
        stack.print();
    }

}
