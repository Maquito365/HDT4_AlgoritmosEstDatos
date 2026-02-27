import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testInfixToPostfixConversion_ArrayListStack() {

        Stack<String> stack = StackFactory.createStack(1, 0); // ArrayList
        ConvertidorInfixPostfix converter = new ConvertidorInfixPostfix();

        String infix = "2 + 3 * 4";
        String expectedPostfix = "2 3 4 * +";

        String result = converter.convert(infix, stack);

        assertEquals(expectedPostfix, result);
    }

    @Test
    void testPostfixEvaluation_ArrayListStack() {

        Stack<Integer> stack = StackFactory.createStack(1, 0); // ArrayList
        PostfixEvaluator evaluator = new PostfixEvaluator();

        String postfix = "2 3 4 * +"; // 2 + (3*4) = 14
        int expectedResult = 14;

        int result = evaluator.evaluate(postfix, stack);

        assertEquals(expectedResult, result);
    }

    @Test
    void testCompleteExpression_VectorStack() {

        Stack<String> stackConversion = StackFactory.createStack(2, 0); // Vector
        Stack<Integer> stackEvaluation = StackFactory.createStack(2, 0);

        ConvertidorInfixPostfix converter = new ConvertidorInfixPostfix();
        PostfixEvaluator evaluator = new PostfixEvaluator();

        String infix = "( 5 + 3 ) * 2";
        String postfix = converter.convert(infix, stackConversion);
        int result = evaluator.evaluate(postfix, stackEvaluation);

        assertEquals(16, result);
    }

    @Test
    void testDivisionOperation() {

        Stack<String> stackConversion = StackFactory.createStack(1, 0);
        Stack<Integer> stackEvaluation = StackFactory.createStack(1, 0);

        ConvertidorInfixPostfix converter = new ConvertidorInfixPostfix();
        PostfixEvaluator evaluator = new PostfixEvaluator();

        String infix = "20 / 4";
        String postfix = converter.convert(infix, stackConversion);
        int result = evaluator.evaluate(postfix, stackEvaluation);

        assertEquals(5, result);
    }
}
