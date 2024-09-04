package List;

public class LinkedList<T> {
    private Node<T> base;
    private Node<T> topo;
    private int size;

    public LinkedList() {
        this.base = null;
        this.topo = null;
        this.size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (base == null) {
            base = topo = newNode;
        } else {
            topo.proximo = newNode;
            newNode.anterior = topo;
            topo = newNode;
        }
        size++;
    }

    public void add(int pos, T data) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }
        if (pos == 0) {
            addFirst(data);
        } else if (pos == size) {
            add(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = getNode(pos);
            newNode.proximo = current;
            newNode.anterior = current.anterior;
            current.anterior.proximo = newNode;
            current.anterior = newNode;
            size++;
        }
    }

    public boolean remove(T data) {
        Node<T> current = find(data);
        if (current == null) return false;

        if (current.anterior != null) {
            current.anterior.proximo = current.proximo;
        } else {
            base = current.proximo;
        }

        if (current.proximo != null) {
            current.proximo.anterior = current.anterior;
        } else {
            topo = current.anterior;
        }

        size--;
        return true;
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Posição inválida: " + pos);
        }
        Node<T> current = getNode(pos);

        if (current.anterior != null) {
            current.anterior.proximo = current.proximo;
        } else {
            base = current.proximo;
        }

        if (current.proximo != null) {
            current.proximo.anterior = current.anterior;
        } else {
            topo = current.anterior;
        }

        size--;
        return current.data;
    }

    private Node<T> getNode(int pos) {
        Node<T> current;
        if (pos < size / 2) {
            current = base;
            for (int i = 0; i < pos; i++) {
                current = current.proximo;
            }
        } else {
            current = topo;
            for (int i = size - 1; i > pos; i--) {
                current = current.anterior;
            }
        }
        return current;
    }

    public Node<T> find(T data) {
        Node<T> current = base;
        while (current != null) {
            if (current.data.equals(data)) {
                return current;
            }
            current = current.proximo;
        }
        return null;
    }

    public void printList() {
        Node<T> current = base;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.proximo;
        }
        System.out.println("NULL");
    }

    private void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (base == null) {
            base = topo = newNode;
        } else {
            newNode.proximo = base;
            base.anterior = newNode;
            base = newNode;
        }
        size++;
    }
}

