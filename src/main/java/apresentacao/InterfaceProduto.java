package apresentacao;

import model.Produto;
import negocio.ProdutoService;

import java.util.List;
import java.util.Scanner;

//Crud do produto
public class InterfaceProduto {
    ProdutoService produtoService = new ProdutoService();
    Scanner scanner = new Scanner(System.in);

    public void menu(){
        int opcao = 0;
        do {
            System.out.println("----- Menu Produto -----");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Remover Produto");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Listar Produtos");
            System.out.println("5 - Buscar Produto");
            System.out.println("0 - Voltar");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    removerProduto();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    listarProdutos();
                    break;
                case 5:
                    buscarProduto();
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

    private void adicionarProduto() {
        System.out.println("----- Adicionar Produto -----");
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a descrição do produto: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Digite a quantidade em estoque do produto: ");
        int estoque = scanner.nextInt();
        scanner.nextLine();
        if(produtoService.adicionarProduto(nome, descricao, preco, estoque))
            System.out.println("Produto adicionado com sucesso!");
        else
            System.out.println("Erro ao adicionar produto!");
    }

    private void removerProduto() {
        System.out.println("----- Remover Produto -----");
        System.out.println("Digite o id do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if(produtoService.removerProduto(id))
            System.out.println("Produto removido com sucesso!");
        else
            System.out.println("Erro ao remover produto!");
    }

    private void atualizarProduto() {
        System.out.println("----- Atualizar Produto -----");
        System.out.println("Digite o id do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a descrição do produto: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Digite a quantidade em estoque do produto: ");
        int estoque = scanner.nextInt();
        scanner.nextLine();
        if(produtoService.atualizarProduto(id, nome, descricao, preco, estoque))
            System.out.println("Produto atualizado com sucesso!");
        else
            System.out.println("Erro ao atualizar produto!");
    }

    private void listarProdutos() {
        System.out.println("----- Listagem de Produtos -----");
        List<Produto> produtoList = produtoService.listarProdutos();
        if(produtoList.isEmpty())
            System.out.println("Nenhum produto cadastrado!");
        else
            produtoList.forEach(System.out::println);
    }

    private void buscarProduto() {
        System.out.println("----- Buscar Produto -----");
        System.out.println("Digite o id do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Produto produto = produtoService.buscarProduto(id);
        if(produto != null)
            System.out.println(produto.toString());
        else
            System.out.println("Produto não encontrado!");
    }
}
