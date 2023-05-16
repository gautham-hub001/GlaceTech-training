import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ApplyPredicateFunc {
    static ArrayList<String> applyPredicateArrayList(List<String> s, Predicate<String> func) {
        ArrayList<String> list = new ArrayList<>();
        for (String si : s) {
            if (func.test(si)) {
                list.add(si);
            }
        }
        return list;
    }
}
