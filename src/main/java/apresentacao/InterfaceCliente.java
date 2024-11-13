package apresentacao;

import model.*;
import negocio.CarrinhoService;
import negocio.ClienteService;
import negocio.PedidoService;
import negocio.ProdutoService;

import java.util.List;
import java.util.Scanner;

public class InterfaceCliente {
    private ClienteService clienteService = new ClienteService();
    private CarrinhoService carrinhoService = new CarrinhoService();
    private ProdutoService produtoService = new ProdutoService();
    private PedidoService pedidoService = new PedidoService();
    private Scanner scanner = new Scanner(System.in);

    public void menu(){
        int opcao = 0;
        do {
            System.out.println("----- Menu Cliente -----");
            System.out.println("1 - Registrar Cliente");
            System.out.println("2 - Atualizar Cliente");
            System.out.println("3 - Remover Cliente");
            System.out.println("4 - Listar Todos Clientes");
            System.out.println("5 - Buscar Cliente");
            System.out.println("6 - Listar Produtos");
            System.out.println("7 - Adicionar Produto ao Carrinho do Cliente");
            System.out.println("8 - Remover Produto do Carrinho do Cliente");
            System.out.println("9 - Listar Produtos do Carrinho do Cliente");
            System.out.println("10 - Realizar Pedido");
            System.out.println("11 - Exibir Histórico de Pedidos");
            System.out.println("0 - Voltar");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    atualizarCliente();
                    break;
                case 3:
                    removerCliente();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    buscarCliente();
                    break;
                case 6:
                    listarProdutos();
                    break;
                case 7:
                    adicionarProdutoCarrinhoCliente();
                    break;
                case 8:
                    removerProdutoCarrinhoCliente();
                    break;
                case 9:
                    listarProdutosCarrinhoCliente();
                    break;
                case 10:
                    realizarPedido();
                    break;
                case 11:
                    exibirHistoricoPedidos();
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

    private void registrarCliente() {
        System.out.println("----- Registrar Cliente -----");
        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o email do cliente: ");
        String email = scanner.nextLine();
        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.println("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        if(clienteService.registrarCliente(nome, email, endereco, telefone)) {
            System.out.println("Cliente registrado com sucesso!");
        } else {
            System.out.println("Erro ao registrar cliente!");
        }
    }

    private void atualizarCliente(){
        System.out.println("----- Atualizar Cliente -----");
        System.out.println("Digite o id do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o email do cliente: ");
        String email = scanner.nextLine();
        System.out.println("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();
        System.out.println("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();
        if(clienteService.atualizarCliente(id, nome, email, endereco, telefone)) {
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Erro ao atualizar cliente!");
        }
    }

    private void removerCliente(){
        System.out.println("----- Remover Cliente -----");
        System.out.println("Digite o id do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if(clienteService.removerCliente(id)) {
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Erro ao remover cliente!");
        }
    }

    private void listarClientes() {
        System.out.println("----- Listagem de Clientes -----");
        List<Cliente> clienteList = clienteService.listarClientes();
        if(clienteList.isEmpty())
            System.out.println("Nenhum cliente cadastrado!");
        else
            clienteList.forEach(System.out::println);
    }

    private void buscarCliente() {
        System.out.println("----- Buscar Cliente -----");
        System.out.println("Digite o id do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = clienteService.buscarCliente(id);
        if(cliente == null)
            System.out.println("Cliente não encontrado!");
        else
            System.out.println(cliente);
    }

    private void listarProdutos() {
        System.out.println("----- Listagem de Produtos -----");
        List<Produto> produtoList = produtoService.listarProdutos();
        if(produtoList.isEmpty())
            System.out.println("Nenhum produto cadastrado!");
        else
            produtoList.forEach(System.out::println);
    }

    private void adicionarProdutoCarrinhoCliente(){
        System.out.println("----- Adicionar Produto ao Carrinho do Cliente -----");
        System.out.println("Digite o id do cliente: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o id do produto: ");
        int produtoId = scanner.nextInt();
        scanner.nextLine();
        if(carrinhoService.adicionarProduto(clienteId, produtoId))
            System.out.println("Produto adicionado ao carrinho com sucesso!");
        else
            System.out.println("Erro ao adicionar produto ao carrinho!");
    }

    private void removerProdutoCarrinhoCliente(){
        System.out.println("----- Remover Produto do Carrinho do Cliente -----");
        System.out.println("Digite o id do cliente: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o id do produto: ");
        int produtoId = scanner.nextInt();
        scanner.nextLine();
        if(carrinhoService.removerProduto(clienteId, produtoId))
            System.out.println("Produto removido do carrinho com sucesso!");
        else
            System.out.println("Erro ao remover produto do carrinho!");
    }

    private void listarProdutosCarrinhoCliente(){
        System.out.println("----- Listar Produtos do Carrinho do Cliente -----");
        System.out.println("Digite o id do cliente: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine();
        List<Produto> produtos = carrinhoService.listarProdutosCarrinho(clienteId);
        if(produtos.isEmpty())
            System.out.println("Carrinho vazio!");
        else
            produtos.forEach(System.out::println);
    }

    private void realizarPedido(){
        System.out.println("----- Realizar Pedido -----");
        System.out.println("Digite o id do cliente: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o método de pagamento: ");
        String metodoPagamento = scanner.nextLine();
        if(pedidoService.adicionarPedido(clienteId,metodoPagamento))
            System.out.println("Pedido realizado com sucesso!");
        else
            System.out.println("Erro ao realizar pedido!");
    }

    private void exibirHistoricoPedidos() {
        System.out.println("----- Exibir Histórico de Pedidos -----");
        System.out.println("Digite o id do cliente: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine();
        List<Pedido> historico = clienteService.visualizarHistoricoPedidos(clienteId);
        if(historico.isEmpty())
            System.out.println("Cliente não possui histórico de pedidos!");
        else
            historico.forEach(System.out::println);
    }
}
