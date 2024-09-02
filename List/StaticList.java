package List;

public class StaticList {

    private int[] array;
    private int tamanho = 0;
    private int capacidade;

    StaticList(int tamanho, int capacidade){
        this.array = new int[capacidade];
        this.capacidade = capacidade;

    }

    public void append(int data){
        if (!isFull()){
            this.array[tamanho-1] = data;
        }

    }

    public void insert(int data, int pos){
        if (array[pos] != 0) {
            shift(pos);
        }
            this.array[pos] = data;
    }

    public int remove(int pos){
        if (array[pos] != 0) {
            int value = array[pos];
            unshift(pos);
            return value;
        }
        return 0;
    }

    private void shift(int pos){
        if(!isFull() &&  pos < tamanho-1 && pos >= 0){
            for (int i = tamanho; i > pos; i--){
                this.array[i] = i-1;
            }
        }
    }

    private void unshift(int pos){
        if(!isFull() &&  pos < tamanho-1 && pos >= 0){
            for (int i = pos; i < tamanho-1 ; i++){
                this.array[i] = i+1;
            }
        }
    }

    public int find(int value){
        for (int i = 0; i < tamanho-1; i++){
            if (value == array[i]){
                return i;
            }
        }
        return 0;
    }

    public int getData(int pos){
        return array[pos];
    }

    public int getSize(){
        return tamanho;
    }


    public boolean isFull(){
        return tamanho == capacidade;
    }

    public boolean isEmpty(){
        return tamanho == 0;
    }

}
