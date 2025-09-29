package ClassProject;

import java.time.LocalDate;

public class GameTest {
    public static void main(String[] args) {
        Game g = new Game(1, "Zelda", "Switch", "In Progress",
                10, 25, "Adventure", "Fun game",
                LocalDate.now(), LocalDate.now());

        System.out.println(g);
        g.setCompletionPercent(50);
        g.setHoursPlayed(20);
        System.out.println("Updated -> " + g);
    }
}
