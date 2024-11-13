package apresentacao;

import negocio.PagamentoService;
import negocio.PedidoService;

import java.util.Scanner;

public class InterfacePedido {
    private PedidoService pedidoService = new PedidoService();
    private PagamentoService pagamentoService = new PagamentoService();
    private Scanner scanner = new Scanner(System.in);

    public void menu(){
        int opcao = 0;
        do {
            System.out.println("----- Menu Pedido -----");
            System.out.println("1 - Listar Pedidos");
            System.out.println("2 - Atualizar Pedido");
            System.out.println("3 - Finalizar Pedido");
            System.out.println("4 - Cancelar Pedido");
            System.out.println("5 - Excluir Pedido");
            System.out.println("6 - Listar Pagamentos");
            System.out.println("7 - Confirmar Pagamento");
            System.out.println("8 - Cancelar Pagamento");
            System.out.println("9 - Atualizar Pagamento");
            System.out.println("0 - Voltar");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    listarPedidos();
                    break;
                case 2:
                    atualizarPedido();
                    break;
                case 3:
                    finalizarPedido();
                    break;
                case 4:
                    cancelarPedido();
                    break;
                case 5:
                    excluirPedido();
                    break;
                case 6:
                    listarPagamentos();
                    break;
                case 7:
                    confirmarPagamento();
                    break;
                case 8:
                    cancelarPagamento();
                    break;
                case 9:
                    atualizarPagamento();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void listarPagamentos(){
        System.out.println("----- Listar Pagamentos -----");
        pagamentoService.listarPagamentos().forEach(System.out::println);
    }

    private void confirmarPagamento(){
        System.out.println("----- Confirmar Pagamento -----");
        System.out.println("Digite o id do pagamento que deseja confirmar:");
        int idPagamento = scanner.nextInt();
        scanner.nextLine();
        if(pagamentoService.confirmarPagamento(idPagamento)){
            System.out.println("Pagamento confirmado com sucesso!");
        }else{
            System.out.println("Erro ao confirmar pagamento!");
        }
    }

    private void cancelarPagamento(){
        System.out.println("----- Cancelar Pagamento -----");
        System.out.println("Digite o id do pagamento que deseja cancelar:");
        int idPagamento = scanner.nextInt();
        scanner.nextLine();
        if(pagamentoService.cancelarPagamento(idPagamento)){
            System.out.println("Pagamento cancelado com sucesso!");
        }else{
            System.out.println("Erro ao cancelar pagamento!");
        }
    }

    private void atualizarPagamento(){
        System.out.println("----- Atualizar Pagamento -----");
        System.out.println("Digite o id do pagamento que deseja atualizar:");
        int idPagamento = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o novo status do pagamento:");
        String status = scanner.nextLine();
        if(pagamentoService.atualizarPagamento(idPagamento,status)){
            System.out.println("Pagamento atualizado com sucesso!");
        }else{
            System.out.println("Erro ao atualizar pagamento!");
        }
    }

    private void listarPedidos(){
        System.out.println("----- Listar Pedidos -----");
        pedidoService.listarPedidos().forEach(System.out::println);
    }

    private void atualizarPedido(){
        System.out.println("----- Atualizar Pedido -----");
        System.out.println("Digite o id do pedido que deseja atualizar:");
        int idPedido = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o novo status do pedido:");
        String status = scanner.nextLine();
        if(pedidoService.atualizarPedido(idPedido,status)){
            System.out.println("Pedido atualizado com sucesso!");
        }else{
            System.out.println("Erro ao atualizar pedido!");
        }
    }

    private void finalizarPedido(){
        System.out.println("----- Finalizar Pedido -----");
        System.out.println("Digite o id do pedido que deseja finalizar:");
        int idPedido = scanner.nextInt();
        scanner.nextLine();
        if(pedidoService.finalizarPedido(idPedido)){
            System.out.println("Pedido finalizado com sucesso!");
        }else{
            System.out.println("Erro ao finalizar pedido!");
        }
    }

    private void cancelarPedido(){
        System.out.println("----- Cancelar Pedido -----");
        System.out.println("Digite o id do pedido que deseja cancelar:");
        int idPedido = scanner.nextInt();
        scanner.nextLine();
        if(pedidoService.cancelarPedido(idPedido)){
            System.out.println("Pedido cancelado com sucesso!");
        }else{
            System.out.println("Erro ao cancelar pedido!");
        }
    }

    private void excluirPedido(){
        System.out.println("----- Excluir Pedido -----");
        System.out.println("Digite o id do pedido que deseja excluir:");
        int idPedido = scanner.nextInt();
        scanner.nextLine();
        if(pedidoService.removerPedido(idPedido)){
            System.out.println("Pedido excluído com sucesso!");
        }else{
            System.out.println("Erro ao excluir pedido!");
        }
    }
}
