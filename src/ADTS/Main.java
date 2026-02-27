import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione implementación del Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");
        System.out.print("Ingrese su opción: ");

        int stackType = scanner.nextInt();
        int listType = 0;

        if (stackType == 3) {
            System.out.println("Seleccione implementación de Lista:");
            System.out.println("1. Simplemente enlazada");
            System.out.println("2. Doblemente enlazada");
            System.out.print("Ingrese su opción: ");

            listType = scanner.nextInt();
        }

        scanner.nextLine();

        System.out.println("¿Cómo desea ingresar la expresión?");
        System.out.println("1. Leer desde archivo datos.txt");
        System.out.println("2. Ingresar manualmente");
        System.out.print("Ingrese su opción: ");

        int inputOption = scanner.nextInt();
        scanner.nextLine();

        String expression = "";

        if (inputOption == 1) {
            try {
                File file = new File("datos.txt");
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {

                    expression = fileScanner.nextLine().trim();

                    if (expression.isEmpty()) {
                        continue; 
                    }

                    Stack<String> stackConvert =
                            StackFactory.createStack(stackType, listType);

                    ConvertidorInfixPostfix converter =
                            new ConvertidorInfixPostfix();

                    String postfix =
                            converter.convert(expression, stackConvert);

                    Stack<Integer> stackEvaluate =
                            StackFactory.createStack(stackType, listType);

                    PostfixEvaluator evaluator =
                            new PostfixEvaluator();

                    int result =
                            evaluator.evaluate(postfix, stackEvaluate);

                    System.out.println("\nExpresión Infix: " + expression);
                    System.out.println("Expresión Postfix: " + postfix);
                    System.out.println("Resultado: " + result);
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado.");
                return;
            }
        } else {
            System.out.println("Ingrese la expresión infix:");
            expression = scanner.nextLine();   
        }

        Stack<String> stackConvert = StackFactory.createStack(stackType, listType);

        ConvertidorInfixPostfix converter = new ConvertidorInfixPostfix();
        String postfix = converter.convert(expression, stackConvert);

        Stack<Integer> stackEvaluate = StackFactory.createStack(stackType, listType);

        PostfixEvaluator evaluator = new PostfixEvaluator();
        int result = evaluator.evaluate(postfix, stackEvaluate);

        System.out.println("\nExpresión Infix: " + expression);
        System.out.println("Expresión Postfix: " + postfix);
        System.out.println("Resultado: " + result);
    }
}