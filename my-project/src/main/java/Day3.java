public class Day3 {
    int a = 10;
    int b;
    static String c;

    public int add(int a,int b) {
        return a+b;
    }

    public static boolean logicalOr(boolean a, boolean b) {
        return a || b;
    }
    static void forloop() {
        for(int i=1, j=10; i<10 && j>1; i++, j--) {
            System.out.println("i: " + i + " j: " + j);
        }
    }
    public static void main(String[] args) {

            // static variables
            // static keyword members gets instantiated
            System.out.println(Constants.a); // 10
            float a =1, b=2;
            System.out.println(a/b); // 0.5
            boolean c = a/b > 0;
            System.out.println(c); // true

            System.out.println(logicalOr(true,false)); // true
            forloop();
        }

}