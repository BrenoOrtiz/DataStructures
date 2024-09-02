package Stack;

public class StaticStack extends ArrayStack{


    StaticStack(int capacidade){
        super(capacidade);
    }
    public void push(int data){
        if (super.isFull()){
            System.out.println("Pilha esta cheia!");
        }
        else{
            stack.add(data);
        }
    }
}
