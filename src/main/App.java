package main;

import java.util.Scanner;

import main.implementation.Supermarket;
import main.implementation.SupermarketArray;

public class App {
    private final static int SIZE = 3;
    public static void main(String[] args) throws Exception {
        String nome = "Leonardo";
        System.out.println(nome);
        Supermarket supermarket = new SupermarketArray(SIZE);
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nLista de compras");
            System.out.println("1 - Inserir");
            System.out.println("2 - Listar");
            System.out.println("3 - Remover");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o item a ser inserido: ");
                    String item = scanner.next();
                    supermarket.add(item);
                    break;  
                case 2:
                    supermarket.print();
                    break;
                case 3:
                    System.out.print("Digite a posição para remocao");
                    int index = scanner.nextInt();
                    supermarket.delete(index);
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente");
            }
        }while (opcao!=4);
    }
}
