import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calculadora {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Argumentos insuficientes");
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        String operation = args[2];
        System.out.println(Calculate(a, b, operation));
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
