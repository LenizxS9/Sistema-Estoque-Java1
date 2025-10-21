public class Produto {
    // 1. Atributos (Propriedades do Produto) - private para Encapsulamento
    private int id;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    // 2. Construtor: Usado para criar novos objetos Produto
    public Produto(int id, String nome, double preco, int quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    // 3. Getters (Permitem ler os atributos)
    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidadeEmEstoque() { return quantidadeEmEstoque; }

    // 4. Setters (Permitem modificar, se necessário)
    public void setPreco(double novoPreco) { this.preco = novoPreco; }
    // Poderíamos ter um setter para estoque, mas o método darBaixa é mais seguro!

    // 5. Lógica de Negócio: Dar Baixa no Estoque
    // Retorna true se a baixa foi feita, false caso contrário.
    public boolean darBaixa(int quantidadeVendida) {
        if (quantidadeVendida > 0 && quantidadeVendida <= quantidadeEmEstoque) {
            this.quantidadeEmEstoque -= quantidadeVendida;
            return true;
        } else {
            return false;
        }
    }

    // 6. Método toString(): Facilita a exibição dos dados do objeto
    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Preço: R$" + String.format("%.2f", preco) +
                " | Estoque: " + quantidadeEmEstoque;
    }
}