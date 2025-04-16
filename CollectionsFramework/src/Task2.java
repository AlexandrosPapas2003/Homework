import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        //Task 2

        //Create list of emails
        List<String> emails = new ArrayList<>(List.of(
                "alice@gmail.com",
                "bob@yahoo.com",
                "carol@gmail.com",
                "david@hotmail.com",
                "eve@yahoo.com",
                "frank@gmail.com"
        ));

        //Group emails by domains
        Map<String, List<String>> groupsOfDomains = emails.stream()
                .collect(Collectors.groupingBy(
                       email-> email.substring(email.indexOf("@") + 1)
                ));

        //Sort in descending order
        List <Map.Entry<String,List<String>>> valuesList = new ArrayList<>(groupsOfDomains.entrySet());
        valuesList.sort((o1, o2) -> o2.getValue().size() - o1.getValue().size());

        //Output only top 3 domains
        valuesList.stream()
                .limit(3)
                .forEach(System.out::println);
    }
}
