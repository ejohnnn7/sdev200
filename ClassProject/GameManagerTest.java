package ClassProject;

import java.time.LocalDate;

public class GameManagerTest {
    public static void main(String[] args) {
        GameManager manager = new GameManager("games.txt");
        Game g1 = new Game(1, "Zelda", "Switch", "In Progress", 10, 25,
                           "Adventure", "", LocalDate.now(), LocalDate.now());
        manager.addGame(g1);
        System.out.println(manager);

        Game found = manager.findGameByTitle("Zelda");
        System.out.println("Found game: " + found);

        manager.removeGame(1);
        System.out.println("After removal:\n" + manager);
    }
}
