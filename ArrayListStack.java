import java.util.ArrayList;

public class ArrayListStack<T> extends AbstractStack<T> {

    private ArrayList<T> list;

    public ArrayListStack() {
        this.list = new ArrayList<>();
    }

    @Override
    public void push(T element){
        list.add(element);
        size++;
    }

    @Override
    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("La pila está vacia");
        }else{
            size--;
            return list.remove(size);
        }
    }

    @Override
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("La pila esta vacia");
        }else{
            return list.get(size - 1);
        }
    }
}