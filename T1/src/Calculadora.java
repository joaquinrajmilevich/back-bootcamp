import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
public class Calculadora {
    public static void main(String[] args) {
        try {
            int valueA = Integer.parseInt(args[0]);
            int valueB = Integer.parseInt(args[1]);
            String operation = args[2];
            System.out.println(Calculate(valueA, valueB, operation));
        } catch (Exception e) {
            System.out.println("Error: ".concat(e.getMessage()));
        }
    }
    public static int Calculate(int x, int y, String operation){
        Map<String, BinaryOperator<Integer>> operations = new HashMap<>();
        operations.put("SUM", Integer::sum);
        operations.put("RES", (a, b) -> a - b);
        operations.put("MUL", (a, b) -> a * b);
        operations.put("DIV", (a, b) -> a / b);
        return operations.get(operation).apply(x, y);
    }
}
