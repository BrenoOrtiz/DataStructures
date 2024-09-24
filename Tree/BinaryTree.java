package Tree;

public class BinaryTree {

    private Node raiz;

    public BinaryTree() {
        this.raiz = null;
    }


    public boolean isEmpty() {
        return raiz == null;
    }

    public void insert(int valor) {
        raiz = insertRec(raiz, valor);
    }

    private Node insertRec(Node current, int valor) {
        if (current == null) {
            return new Node(valor);  // Insere um novo nó se a posição estiver vazia
        }

        if (valor < current.getValor()) {
            current.setEsquerda(insertRec(current.getEsquerda(), valor));  // Inserir à esquerda
        } else if (valor > current.getValor()) {
            current.setDireita(insertRec(current.getDireita(), valor));  // Inserir à direita
        }
        // Se o valor já existir, não faz nada (não permite duplicatas)
        return current;
    }

    // Método para buscar um valor na árvore
    public boolean search(int valor) {
        return searchRec(raiz, valor);
    }

    private boolean searchRec(Node current, int valor) {
        if (current == null) {
            return false;  // Valor não encontrado
        }

        if (valor == current.getValor()) {
            return true;  // Valor encontrado
        }

        return valor < current.getValor()
                ? searchRec(current.getEsquerda(), valor)
                : searchRec(current.getDireita(), valor);  // Busca na subárvore correta
    }

    // Método para remover um valor da árvore
    public void remove(int valor) {
        raiz = removeRec(raiz, valor);
    }

    private Node removeRec(Node current, int valor) {
        if (current == null) {
            return null;  // Nó não encontrado
        }

        if (valor < current.getValor()) {
            current.setEsquerda(removeRec(current.getEsquerda(), valor));  // Remove da subárvore esquerda
        } else if (valor > current.getValor()) {
            current.setDireita(removeRec(current.getDireita(), valor));  // Remove da subárvore direita
        } else {
            // Caso 1: O nó a ser removido é uma folha (sem filhos)
            if (current.getEsquerda() == null && current.getDireita() == null) {
                return null;
            }

            // Caso 2: O nó a ser removido tem apenas um filho
            if (current.getEsquerda() == null) {
                return current.getDireita();
            } else if (current.getDireita() == null) {
                return current.getEsquerda();
            }

            // Caso 3: O nó a ser removido tem dois filhos
            int menorValor = findSmallestValue(current.getDireita());
            current.setValor(menorValor);
            current.setDireita(removeRec(current.getDireita(), menorValor));
        }

        return current;
    }

    private int findSmallestValue(Node root) {
        return root.getEsquerda() == null ? root.getValor() : findSmallestValue(root.getEsquerda());
    }




    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.getEsquerda());
            System.out.print(node.getValor() + " ");
            inOrderRec(node.getDireita());
        }
    }


    private void postOrderRec(Node node) {
        if (node != null) {
            postOrderRec(node.getEsquerda());
            postOrderRec(node.getDireita());
            System.out.print(node.getValor() + " ");
        }
    }

    public Node getRoot() {
        return raiz;
    }
}
