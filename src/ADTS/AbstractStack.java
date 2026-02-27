public abstract class AbstractStack<T> implements Stack<T> {
    
    protected int size = 0;

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }
}
