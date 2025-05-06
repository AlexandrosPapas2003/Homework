import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Task3 {

    //The method that remove duplicates
    public static <T> List<T> removeDuplicatesPreserveOrder(List<T> input){
        Set<T> noDuplicates = new LinkedHashSet<>(input);
        return List.copyOf(noDuplicates);
    }

    public static void main(String[] args) {
        //Lists of duplicates
        List<Integer> listOfIntegers = List.of(3,5,3,2,5,1);
        List<String> listOfStrings = List.of("apple", "banana", "apple", "orange", "banana", "kiwi");

        //Remove duplicates
        listOfIntegers = removeDuplicatesPreserveOrder(listOfIntegers);
        listOfStrings = removeDuplicatesPreserveOrder(listOfStrings);

        //output without duplicates
        System.out.println(listOfIntegers);
        System.out.println(listOfStrings);
    }
}
