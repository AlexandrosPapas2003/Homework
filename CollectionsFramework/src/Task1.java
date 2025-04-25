import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {

        /*Task 1
        Create a list of 5-10 Player objects
         */
        List<Player> players = new ArrayList<>(List.of(
                new Player("Sergey", 21, 20),
                new Player("Andrey", 43, 36),
                new Player("Alexandr", 32, 29),
                new Player("Oleg", 12, 31),
                new Player("Anton", 12, 18)
        ));

        //Sorting strategy
        Comparator<Player> scoreComparator = Comparator.comparing(
                Player::getScore , (score1, score2) -> score2 - score1

        ).thenComparing(Player::getAge);
        players.sort(scoreComparator);

        //Output sorting list
        for(Player player : players){
            System.out.println(player);
        }
    }
}
