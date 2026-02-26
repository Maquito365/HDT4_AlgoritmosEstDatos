public class SimpleLinkedList<T> extends AbstractList<T> {
    
    Node<T> head;

    public SimpleLinkedList(){
        this.head = null;
    }

    @Override
    public void addFirst(T element){
        Node<T> newNode = new Node<>(element);
        if(isEmpty()){
             head = newNode;
        } else{
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst(){
        if(isEmpty()){
            throw new RuntimeException("La lista está vacia");
        }else{
        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
        }
    }

    @Override
    public T getFirst(){
        if(isEmpty()){
            throw new RuntimeException("La lista está vacía");
        }else{
            return head.getData();
        }
    }
    
}
