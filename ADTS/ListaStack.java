public class ListaStack<T> extends AbstractStack<T> {

    private ListInterfaz<T> list;

    public ListaStack(ListInterfaz<T> list){
        this.list = list;
    }

    @Override
    public void push(T element){
        list.addFirst(element);
        size++;
    }

    @Override
    public T pop(){
        if(isEmpty()){
            throw new RuntimeException("La pila está vacia");
        }else{
            return list.removeFirst();
        }
    }

    @Override
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("La pila esta vacia");
        }else{
            size--;
            return list.getFirst();
        }
    }
}
