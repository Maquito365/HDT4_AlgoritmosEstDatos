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
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacia");
        }
        size--;                   // <- decrementa aquí
        return list.removeFirst();
    }

    @Override
    public T peek(){
        if (isEmpty()) {
            throw new RuntimeException("La pila esta vacia");
        }
        return list.getFirst();   // no modifica size
    }
}
