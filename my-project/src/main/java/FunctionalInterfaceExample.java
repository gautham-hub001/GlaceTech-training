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
        Predicate<String> p = s -> s.startsWith("A"); // startsWith returns true/false
        System.out.println(p.test("Abc"));

        List<String> names = Arrays.asList("Apple", "Amazon", "Google", "Microsoft");
        // names.add(10, null);
        System.out.println(ApplyPredicateFunc.applyPredicateArrayList(names, p)); // we're passing functional interface
                                                                                  // as
                                                                                  // argument. Indirectly, we're passing
                                                                                  // methods as arguments.
        List<Integer> l = List.of(1, 2, 3, 4, 5); // this is same as Arrays.asList(). But This is immutable list. // It
                                                  // returns immutable list. That is the array names cannot be
                                                  // modified later
    }
}
