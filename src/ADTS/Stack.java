public interface Stack<T> {

    void push(T elemento);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
    
}