package Queue;

public class CircularQueue {
    private int[] queue;
    private int top;
    private int base;
    private final int capacity;
    private int size;

    CircularQueue(int size) {
        this.queue = new int[size];
        this.capacity = size;
        this.top = 0;
        this.base = -1;
        this.size = 0;
    }

    public void add(int item) {
        if (isFull()) {
            System.out.println("Fila está cheia");
        } else {
            base = (base + 1) % capacity;
            queue[base] = item;
            size++;
            System.out.println("Inserido: " + item + " na posição " + base);
        }
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Fila está vazia");
            return 0;
        } else {
            int item = queue[top];
            top = (top + 1) % capacity;
            size--;
            System.out.println("Removido: " + item + " da posição " + (top - 1 + capacity) % capacity);
            return item;
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public void printQueue() {
        System.out.print("Fila: [");
        if (isEmpty()) {
            System.out.print("vazia");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.print(queue[i] + ", ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.add(1);
        queue.printQueue();
        queue.add(2);
        queue.printQueue();
        queue.add(3);
        queue.printQueue();
        queue.add(4);
        queue.printQueue();
        queue.add(5);
        queue.printQueue();

        queue.remove();
        queue.printQueue();

        queue.add(6);
        queue.printQueue();

    }
}
