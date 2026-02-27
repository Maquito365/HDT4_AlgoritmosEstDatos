import java.util.Stack;
public class ConvertidorInfixPostfix {
    public String convert(String expression, Stack<String> stackForConversion){
        
        StringBuilder resultado = new StringBuilder();
        int i = 0;
        while(i < expression.length()){
             //Se comprueba si hay un espaci, se ignora el espacio
            char c = expression.charAt(i);
            if(Character.isWhitespace(c)){
                i++;
                continue;
            }
            //Se ve si el caracter es un número
            if (Character.isDigit(c)){

                StringBuilder numero = new StringBuilder();

                while(i < expression.length() && Character.isDigit(expression.charAt(i))){ //Mientras el caracter sea un número, se va añadiendo al número completo
                    numero.append(expression.charAt(i));
                    i++;
                }
                resultado.append(numero).append(" ");;
                continue;
            }

            //Si es paréntesis izquierdo
            if(c == '('){
                stackForConversion.push(String.valueOf(c));
            }else if(c== ')'){
                while(!stackForConversion.isEmpty() && !stackForConversion.peek().equals("(")){
                    resultado.append(stackForConversion.pop()).append(" ");
                }
                stackForConversion.pop(); 
            }else if(isOperator(c)){ //Si es un operador
                while(!stackForConversion.isEmpty() && precedence(stackForConversion.peek()) >= precedence(String.valueOf(c))){ //Mientras el operador en la cima de la pila tenga mayor o igual precedencia 
                // que el operador actual, se saca de la pila y se añade al resultado
                    resultado.append(stackForConversion.pop()).append(" ");
                }
                stackForConversion.push(String.valueOf(c));
            }
            i++;

        }
        while(!stackForConversion.isEmpty()){
            resultado.append(stackForConversion.pop()).append(" ");
        }
        return resultado.toString().trim();
    }

    private boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int precedence(String operator){ //Se asigna una precedencia a cada operador, * y / tienen mayor precedencia que + y -
        switch(operator){
        case "+":
        case "-":
            return 1;
        case "*":
        case "/":
            return 2;   
        default:
            return 0;
        }
    }
}
