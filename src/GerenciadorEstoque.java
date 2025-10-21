import java.util.ArrayList;
import java.util.List;

public class GerenciadorEstoque {
    // Armazenamento: Lista de objetos Produto
    private final List<Produto> estoque = new ArrayList<>();

    // Método para Adicionar Produto
    public void adicionarProduto(Produto produto) {
        // Verifica se o ID já existe (opcional, mas boa prática)
        if (buscarProduto(produto.getId()) != null) {
            System.out.println("ERRO: Produto com ID " + produto.getId() + " já existe.");
            return;
        }
        estoque.add(produto);
        System.out.println("Produto " + produto.getNome() + " adicionado com sucesso.");
    }

    // Método para Listar Todos os Produtos
    public void listarProdutos() {
        if (estoque.isEmpty()) {
            System.out.println("\n*** Estoque vazio! Nada a listar. ***");
            return;
        }
        System.out.println("\n--- INVENTÁRIO ATUAL ---");
        for (Produto p : estoque) {
            System.out.println(p);
        }
    }

    // Método para Buscar Produto por ID
    public Produto buscarProduto(int id) {
        for (Produto p : estoque) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Método para Verificar Estoque Baixo (Alerta)
    public void verificarEstoqueBaixo(int limite) {
        System.out.println("\n--- ALERTA DE ESTOQUE BAIXO (Qtd < " + limite + ") ---");
        boolean temAlerta = false;
        for (Produto p : estoque) {
            if (p.getQuantidadeEmEstoque() < limite) {
                System.out.println("ALERTA: " + p.getNome() + " (ID " + p.getId() + ") - Apenas " + p.getQuantidadeEmEstoque() + " unidades.");
                temAlerta = true;
            }
        }
        if (!temAlerta) {
            System.out.println("Nenhum produto com estoque abaixo de " + limite + ".");
        }
    }
}