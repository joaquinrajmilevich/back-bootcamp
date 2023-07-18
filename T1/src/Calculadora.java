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
        Map<String, BinaryOperator<Integer>> operaciones = new HashMap<>();
        operaciones.put("SUM", (a, b) -> a + b);
        operaciones.put("RES", (a, b) -> a - b);
        operaciones.put("MUL", (a, b) -> a * b);
        operaciones.put("DIV", (a, b) -> a / b);
        return operaciones.get(operation).apply(x, y);
    }
}
