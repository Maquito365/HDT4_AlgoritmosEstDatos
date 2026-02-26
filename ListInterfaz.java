public interface ListInterfaz<T> {
    
    void addFirst(T elemento);
    T removeFirst();
    T getFirst();
    boolean isEmpty();
    int size();
    
}
