public class Jsonify {
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("faltan datos");
        }
        String jsonString = "{\"data\":[%s]}".formatted(String.join("\", \"", args));
        System.out.println(jsonString);
    }
}