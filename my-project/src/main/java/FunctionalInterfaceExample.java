import java.util.Arrays;
import java.util.function.Predicate;
import java.util.List;

// THis is annotation is not mandatory. It can be used for debugging
@FunctionalInterface
interface A {
    void print();
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // using anonymous inner class
        A a = new A() {
            public void print() {
                System.out.println("hello");
            }
        };

        // Using lambda expression
        A a1 = () -> {
            System.out.println("hello");
        };

        // if there is only a single line, we don't need braces
        A a2 = () -> System.out.println("hello");

        a.print();
        a1.print();
        a2.print();

        // builtin functions
        Predicate<String> p = s -> s.startsWith("A");
        System.out.println(p.test("Abc"));

        List<String> names = Arrays.asList("Apple", "Amazon", "Google", "Microsoft");
        System.out.println(ApplyPredicateFunc.applyPredicateArrayList(names, p));
        List<Integer> l = List.of(1, 2, 3, 4, 5);
    }
}
