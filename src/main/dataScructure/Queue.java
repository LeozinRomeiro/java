package main.dataScructure;

public class Queue {

    private int height;
    private Node first;
    private Node last;

    public Queue(int value) {
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        this.height++;
    }

    public void getFirst(){
        if (first == null) {
            System.out.println("Fila vazia");
        }else{
            System.out.println("Primeiro: "+first.value);
        }
    }

    public void getLast(){
        if (last == null) {
            System.out.println("Fila vazia");
        }else{
            System.out.println("Ultimo: "+last.value);
        }
    }

    public void getHeight(){
        if (height == 0) {
            System.out.println("Fila vazia");
        }else{
            System.out.println("Tamanho: "+height);
        }
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if (this.height==0) {
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        height++;
    }

    public Node dequeue(){
        Node temp = null;
        if (height ==0 ) return null;
        if (this.height==1) {
            temp = first;
            first = null;
            last = null;
        }else{
            temp = first;
            first = temp.next;
        }
        height--;
        return temp;
    }

    public void print(){
        System.out.println("-----------------------------");
        Node temp = this.first;
        while (temp!=null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("-----------------------------");
    }

    public class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args){
        Queue line = new Queue(7);
        line.getHeight();
        line.getFirst();
        line.getLast();
        line.print();
        line.enqueue(6);
        line.getHeight();
        line.getFirst();
        line.getLast();
        line.print();
        line.dequeue();
        line.getHeight();
        line.getFirst();
        line.getLast();
        line.print();
    }
}
