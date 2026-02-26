public static void main(String[] args) {

    Stack<Integer> stack = StackFactory.createStack(1, 0);

    PostfixEvaluator evaluator = new PostfixEvaluator();

    int result = evaluator.evaluate("10 20 + 9 *", stack);

    System.out.println(result);
}
