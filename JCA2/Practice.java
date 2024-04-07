import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        System.out.println("hi");
        Integer[] arr = {1,2,3};
        int[] arr2 = {1,2,3};
        List<Integer> list = Arrays.asList(1,2,3,900,45);
        List<Integer> listFromArr = List.of(1,2,3);

        List<Integer> sorted = list.stream() // for list
                                    .sorted()
                                    .map(e->e*2)
                                    .filter(e->e%3==0)
                                    .collect(Collectors.toList());
        List<Integer> sortedNew = Arrays.stream(arr2) // for arrays
                                        .boxed()
                                        .sorted()
                                        .map(e->e*2)
                                        .filter(e->e%3==0)
                                        .collect(Collectors.toList());

        Integer min = Arrays.stream(arr2) // for arrays
                .boxed()
                .sorted()
                .map(e->e*2)
                .filter(e->e%10==0)
                .min(Integer::compareTo)
                .orElse(null);
        System.out.println(sorted);
        System.out.println(sortedNew);
        System.out.println(min);



        System.out.println(listFromArr);
    }
}