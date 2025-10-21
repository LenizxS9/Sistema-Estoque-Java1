import java.util.Scanner;

public class EstoqueApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorEstoque gerenciador = new GerenciadorEstoque();
        int opcao;

        System.out.println("BEM-VINDO AO SISTEMA DE GESTÃO DE ESTOQUE");

        do {
            exibirMenu();
            // Bloco try-catch para lidar com possíveis erros de entrada (ex: digitar texto em vez de número)
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha
            } catch (java.util.InputMismatchException e) {
                System.out.println("\nERRO: Entrada inválida. Por favor, digite um número da opção.");
                scanner.nextLine(); // Limpa a entrada
                opcao = 0; // Garante que o loop continue
                continue;
            }

            switch (opcao) {
                case 1: cadastrarProduto(scanner, gerenciador); break;
                case 2: registrarVenda(scanner, gerenciador); break;
                case 3: gerenciador.listarProdutos(); break;
                case 4: gerenciador.verificarEstoqueBaixo(5); break;
                case 5: System.out.println("\nSistema encerrado. Obrigado!"); break;
                default: System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    // Método estático para exibir o menu
    private static void exibirMenu() {
        System.out.println("\n------------------------------------");
        System.out.println("1. Cadastrar Novo Produto");
        System.out.println("2. Registrar Venda (Dar Baixa)");
        System.out.println("3. Listar Estoque Completo");
        System.out.println("4. Alerta de Estoque Baixo (Lim: 5)");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Lógica para cadastrar
    private static void cadastrarProduto(Scanner scanner, GerenciadorEstoque gerenciador) {
        System.out.println("\n--- Cadastro de Produto ---");
        try {
            System.out.print("ID (Número inteiro): ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Preço (Ex: 10.50): R$");
            double preco = scanner.nextDouble();
            System.out.print("Quantidade Inicial: ");
            int qtd = scanner.nextInt();
            scanner.nextLine();

            Produto novoProduto = new Produto(id, nome, preco, qtd);
            gerenciador.adicionarProduto(novoProduto);
        } catch (java.util.InputMismatchException e) {
            System.out.println("ERRO: Formato de número inválido. Tente novamente.");
            scanner.nextLine();
        }
    }

    // Lógica para registrar venda
    private static void registrarVenda(Scanner scanner, GerenciadorEstoque gerenciador) {
        System.out.println("\n--- Registrar Venda ---");
        try {
            System.out.print("ID do Produto vendido: ");
            int id = scanner.nextInt();
            System.out.print("Quantidade vendida: ");
            int qtdVendida = scanner.nextInt();
            scanner.nextLine();

            Produto p = gerenciador.buscarProduto(id);

            if (p != null) {
                if (p.darBaixa(qtdVendida)) {
                    System.out.println("Venda registrada com sucesso!");
                    System.out.println("Estoque atual de " + p.getNome() + ": " + p.getQuantidadeEmEstoque());
                } else {
                    System.out.println("ERRO: Quantidade insuficiente em estoque (" + p.getQuantidadeEmEstoque() + " restantes) ou quantidade de venda inválida.");
                }
            } else {
                System.out.println("ERRO: Produto com ID " + id + " não encontrado.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("ERRO: Formato de número inválido. Tente novamente.");
            scanner.nextLine();
        }
    }
}