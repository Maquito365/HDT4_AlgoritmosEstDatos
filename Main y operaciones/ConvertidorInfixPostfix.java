public class ConvertidorInfixPostfix {
    public String convert(String expression, Stack<String> stack){
        
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
                stack.push(String.valueOf(c));
            }else if(c== ')'){
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    resultado.append(stack.pop()).append(" ");
                }
                stack.pop(); 
            }else if(isOperator(c)){
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(String.valueOf(c))){
                    resultado.append(stack.pop()).append(" ");
                }
                stack.push(String.valueOf(c));
            }
            i++;

        }
        while(!stack.isEmpty()){
            resultado.append(stack.pop()).append(" ");
        }
        return resultado.toString().trim();
    }

    private boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int precedence(String operator){
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
