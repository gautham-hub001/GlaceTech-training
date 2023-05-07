public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println(fun1());
        System.out.println(fun2());
    }

    static int fun1() {
        try {
            System.out.println("try"); // executes
            throw new ArithmeticException("arithmetic exception"); // executes but does not get printed in console
        } catch (ArithmeticException e) {
            System.out.println("catch"); // executes
            throw new RuntimeException(); // cannot be thrown since throw is not inside try block
        } catch (NullPointerException e) {
            System.out.println("runtime");
        } finally {
            System.out.println("finally"); // executes
            return 30; // executes
        }
    }

    static int fun2() {
        try {
            System.out.println("try"); // executes
            System.exit(1); // executes
            return 10;
        } catch (Exception e) {
            System.out.println("catch");
            throw new RuntimeException();
        } finally {
            System.out.println("finally"); // Not executed. This is the only case where finally block is not executed.
        }
    }
}
