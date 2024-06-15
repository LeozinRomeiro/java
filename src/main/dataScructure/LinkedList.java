package main.dataScructure;

public class LinkedList {
    private int length;
    private Node head;
    private Node tail;

    public boolean set(int index, String data){
        Node temp = get(index);
        if (temp!=null) {
            temp.data=data;
            return true;
        }
        return false;
    }

    public boolean insert(int index, String data){
        if (index<0||index>length) {
            return false;
        }else if (index==0) {
            prepend(data);
        }else if(index==length) {
            append(data);
        }else{
            Node newNode = new Node(data);
            Node temp = get(index-1);
            newNode.next = temp.next;
            temp.next = newNode;
        }


        length++;
        return true;
    }

    public boolean remove(int index, String data){
        
        if (index<0||index>length) {
            return false;
        }
        
        if(length==index+1){
            removeLast();
        }else if(length == 0){
            removeFirst();
        }else{
            Node temp = get(index);
            get(index - 1).next = temp.next;
            temp = null;
            length--;
        }
        
        return true;
    }

    public Node get(int indice){
        if (indice<0||indice>length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < indice; i++) {
            temp = temp.next; 
        }
        return temp;
    }

    public void getLength() {
        System.out.println("Length: " + this.length);
    }
    public void getHead() {
        if (this.head == null) {
            System.out.println("Lista vazia");
        }else{
            System.out.println(head.data);
        }
    }
    public void getTail() {
        if (this.tail == null) {
            System.out.println("Lista vazia");
        }else{
            System.out.println(tail.data);
        }
    }
    public void makeEmpty(){
        head = null;
        tail = null;
        length = 0;
    }
    public void print(){
        System.out.println("-----------------------------");
        Node temp = this.head;
        while (temp!=null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("-----------------------------");
    }
    public LinkedList(String data) {
        length = 1;
        Node newNode= new Node(data);
        head = newNode;
        tail = newNode;
    }

    public void append(String data){
        Node newNode = new Node(data);
        if (this.length==0) {
            tail = newNode;
            head = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        Node temp = null;
        if (this.length==0) {
            System.out.println("Lista vazia");
        }else if(this.head==this.tail){
            temp = tail;
            head = null;
            tail = null;
        }else{
            Node pre = head;
            while (pre.next!=tail) {
                pre = pre.next;
            }
            temp = tail;
            pre.next = null;
            tail = pre;
            length--;
        }
        return temp;
    }

    public Node removeFirst(){
        Node temp = null;
        if (this.length==0) {
            System.out.println("Lista vazia");
        }else if(this.head==this.tail){
            temp = head;
            head = null;
            tail = null;
        }else{
            temp = head;
            head = head.next;
            length--;
        }
        return temp;
    }

    public void prepend(String data){
        Node newNode = new Node(data);
        if (this.length==0) {
            tail = newNode;
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList("Elemento 1");
        list.append("Elemento 2");
        list.append("Elemento 3");
        list.getHead();
        list.getTail();
        list.getLength();
        list.print();
        list.removeLast();
        list.print();
        list.prepend("Elemento 3");
        list.print();
        list.removeFirst();
        list.print();
        System.out.println(list.get(1).data);
        list.insert(1, "Elemento 3");
        list.set(1, "null");
        list.print();
    }

    public class Node {
        String data;
        Node next;
        public Node(String data) {
            this.data = data;
        }
    }

}
