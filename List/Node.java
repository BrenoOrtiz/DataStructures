package List;

class Node<T> {

    Node<T> anterior;
    T data;
    Node<T> proximo;

    Node(T data){
        this.data = data;
        this.anterior = null;
        this.proximo = null;
    }


}
