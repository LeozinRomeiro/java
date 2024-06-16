package main.implementation;

import java.util.Random;

import main.dataScructure.Queue;

public class FilaDeAtendimento {
    public static void main(String[] args) {
        int n = 5;
        var random = new Random();
        int cliente = random.nextInt(999);
        Queue queue = new Queue(cliente);
        System.out.println("Chegou o cliente: "+cliente);
        for (int i = 1; i < n; i++) {
            cliente = random.nextInt(999);
            System.out.println("Chegou cliente: "+cliente);
            queue.enqueue(cliente);
        }
        var node = queue.dequeue();
        while (node != null) {
            System.out.println("Atendido cliente: "+node.getValue());
            node = queue.dequeue();
        }
    }
}
