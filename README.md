# 📦 Sistema Básico de Gerenciamento de Estoque (Java - Terminal)

## Olá! 👋 Sobre este Projeto

Decidi criar este sistema de controle de estoque simples para consolidar meus conhecimentos básicos em Java. Meu objetivo principal foi simular uma aplicação que resolve um problema real—o controle de inventário para um pequeno negócio—enquanto praticava a **Programação Orientada a Objetos (POO)** do zero.

Rodando no terminal, ele me forçou a focar 100% na lógica de negócio e na estrutura do código, sem distrações com a interface gráfica.

## ✨ O Que o Sistema Faz

O sistema oferece um menu de opções para interagir com o inventário:

* **Cadastrar Produto:** Cria um novo item (ID, Nome, Preço, Qtd).
* **Registrar Venda (Baixa):** Reduz o estoque de um produto específico. *Com validação: o sistema impede vendas se o estoque for insuficiente.*
* **Visualizar Inventário:** Lista todos os produtos e suas quantidades.
* **Alerta de Estoque Baixo:** Identifica e avisa sobre produtos cuja quantidade está abaixo do limite definido (atualmente 5 unidades).

## 🧠 Meu Foco: Conceitos Aplicados

Este projeto foi fundamental para entender como os conceitos de Java se aplicam em um sistema real. As principais áreas de aprendizado foram:

| Conceito Java | Aplicação no Código |
| :--- | :--- |
| **POO e Classes** | A classe `Produto` serve como o *molde* para cada item do estoque, centralizando seus dados e comportamentos. |
| **Encapsulamento** | Todos os atributos do `Produto` são `private` e só podem ser alterados ou lidos via métodos públicos (Getters/Setters), garantindo a integridade dos dados. |
| **`ArrayList` (Coleções)** | Usei uma `ArrayList<Produto>` na classe `GerenciadorEstoque` para armazenar de forma eficiente todos os objetos do inventário. |
| **Lógica de Entrada/Saída** | O uso do `Scanner` me ensinou a tratar e validar a entrada de dados do usuário, garantindo que a aplicação não quebre com entradas inesperadas. |

## ⏭️ Próximos Passos 

Como desafio pessoal para o futuro, planejo evoluir este projeto adicionando:

1.  **Persistência de Dados:** Implementar o salvamento do estoque em um arquivo (`.txt` ou `.csv`) para que os dados não se percam ao fechar o programa.
2.  **Busca Avançada:** Adicionar a funcionalidade de buscar produtos não só por ID, mas também por parte do nome.
---

