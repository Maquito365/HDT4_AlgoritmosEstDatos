import java.util.Vector;
public class VectorStack<T> extends AbstractStack<T>{

    private Vector<T> vector;

    public VectorStack() {
        this.vector = new Vector<>();
    }

    @Override
    public void push(T element){
        vector.add(element);
        size++;
    }

    @Override
    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("La pila está vacia");
        }else{
            size--;
            return vector.remove(size);
        }
    }

    @Override
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("La pila esta vacia");
        }else{
            return vector.get(size - 1);
        }
    }
}
 
    

