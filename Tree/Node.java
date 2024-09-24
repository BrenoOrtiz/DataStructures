package Tree;

public class Node {

    private int valor;
    private Node esquerda = null;
    private Node direita = null;

    public Node(int valor) {
        this.valor = valor;
    }

    public Node(Node esquerda, Node direita, int valor) {
        this.esquerda = esquerda;
        this.direita = direita;
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }
}
