package Stack;

public class DynamicStack extends ArrayStack{


    DynamicStack(int capacidade){
        super(10);
    }

    public void push(int data){
        stack.add(data);
        capacidade += 10;
    }

}
