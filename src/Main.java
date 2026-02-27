import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de pila:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista enlazada (simple)");
        System.out.println("4. Lista enlazada (doble)");
        System.out.print("Opción: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume newline

        int optionStack = 0;
        int optionList = 0;
        switch (option) {
            case 1:
                optionStack = 1;
                break;
            case 2:
                optionStack = 2;
                break;
            case 3:
                optionStack = 3;
                optionList = 1;
                break;
            case 4:
                optionStack = 3;
                optionList = 2;
                break;
            default:
                System.out.println("Opción no válida");
                System.exit(1);
        }

        Stack<String> stackForConversion =
                StackFactory.createStack(optionStack, optionList);
        Stack<Integer> stackForEvaluation =
                StackFactory.createStack(optionStack, optionList);

        ConvertidorInfixPostfix converter = new ConvertidorInfixPostfix();
        PostfixEvaluator evaluator = new PostfixEvaluator();

        System.out.print("Ingrese una expresión infija (solo números y operadores +-*/): ");
        String infix = scanner.nextLine();

        String postfix = converter.convert(infix, stackForConversion);
        System.out.println("Postfijo: " + postfix);

        int result = evaluator.evaluate(postfix, stackForEvaluation);
        System.out.println("Resultado: " + result);

        scanner.close();
    }
}