import apresentacao.InterfaceCliente;
import apresentacao.InterfacePedido;
import apresentacao.InterfaceProduto;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.println("Deseja acessar qual interface?");
            System.out.println("1 - Interface Cliente");
            System.out.println("2 - Interface Produto");
            System.out.println("3 - Interface Pedido");
            System.out.println("0 - Sair");
            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    InterfaceCliente interfaceCliente = new InterfaceCliente();
                    interfaceCliente.menu();
                    break;
                case 2:
                    InterfaceProduto interfaceProduto = new InterfaceProduto();
                    interfaceProduto.menu();
                    break;
                case 3:
                    InterfacePedido interfacePedido = new InterfacePedido();
                    interfacePedido.menu();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}
