public class StackFactory {
    public static <T> Stack<T> createStack(int optionStack, int optionList){

        switch (optionStack){
            case 1: 
                return new ArrayListStack<>();
            case 2:
                return new VectorStack<>();
            case 3:
                if(optionList == 1){
                    return new ListaStack<>(new SimpleLinkedList<>());
                }else if (optionList == 2){
                    return new ListaStack<>(new DoubleLinkedList<>());
                }else{
                    throw new IllegalArgumentException("Tipo de lista no valido");
                }
            default:
                throw new IllegalArgumentException("Tipo de pila no valido");
        }
    }
}
