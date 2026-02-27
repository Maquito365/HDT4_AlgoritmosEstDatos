public class PostfixEvaluator {
    public int evaluate(String postfix, Stack<Integer> stack){
        String[] tokens = postfix.split(" ");
        for(String token : tokens){
            if(Character.isDigit(token.charAt(0))){
                stack.push(Integer.parseInt(token));
            }else if(isOperator(token.charAt(0))){
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token.charAt((0)));
                stack.push(result);
            }
        }
        return stack.pop();
    
    }

    private boolean isOperator(char c){
            return c== '+' || c == '-' || c == '*' || c == '/';
    }

    private int applyOperator(int a, int b, char operator){
        switch(operator){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            default:
                throw new IllegalArgumentException("Operador no válido");
        }
    }
}
