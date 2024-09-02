package Stack;

import java.util.ArrayList;

public abstract class ArrayStack implements Stack {

    private int top = -1;
    protected ArrayList<Integer> stack;
    protected int capacidade;

    ArrayStack(int capacidade) {
        this.stack = new ArrayList<>();
        this.capacidade = capacidade;
    }

    public abstract void push(int data);

    public int pop(){
        return stack.remove(top);
    }

    public void clear(){
        stack.clear();
    }

    public boolean isFull(){
        return (capacidade - 1) == top;
    }
    public boolean isEmpty(){
        return this.capacidade == -1;
    }

}
