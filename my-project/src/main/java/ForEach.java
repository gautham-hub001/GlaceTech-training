import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEach {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 2, 3, 4);

        // for loop
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }

        // enhanced for loop - does not need index
        for (int n : l) {
            System.out.println(n);
        }

        // forEach() method
        l.forEach(n -> System.out.println(n));

        // forEach() using seperate Consumer object.
        Consumer<Integer> c = (n) -> System.out.println(n);
        // or Consumer<Integer> c = n -> System.out.println(n);
        l.forEach(c);
    }
}
