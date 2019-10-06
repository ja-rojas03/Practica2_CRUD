import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        get("/", (request,response) -> {
            return "HAI, u started me program :D";
        });
    }
}
