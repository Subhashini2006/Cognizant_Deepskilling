public class TestLogger {
    public static void main(String[] args) {

        Logger obj1 = Logger.getInstance();
        Logger obj2 = Logger.getInstance();
        Logger obj3 = Logger.getInstance();

        obj1.log("First message");
        obj2.log("Second message");
        obj3.log("Third message");

        System.out.println(obj1 == obj2);
        System.out.println(obj2 == obj3);
    }
}
