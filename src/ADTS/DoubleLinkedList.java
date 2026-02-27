public class DoubleLinkedList<T> extends AbstractList<T> {

    Node<T> head;
    Node<T> tail;

    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;  
    }

    @Override
    public void addFirst(T element){
        Node<T> newNode = new Node<>(element);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        } else{
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst(){
        if(isEmpty()){
            throw new RuntimeException("La Lista esta vacía");
        }
        T data = head.getData();
        head = head.getNext();
        if(head != null){
            head.setPrevious(null);
        } else {
            tail = null;
        }
        size--;
        return data;
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
