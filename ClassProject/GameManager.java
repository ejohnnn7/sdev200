package ClassProject;

// Maintains a collection of Game objects.

import java.util.ArrayList;

public class GameManager {
    private ArrayList<Game> games;
    private String filePath;

    public GameManager(String filePath) {
        this.games = new ArrayList<>();
        this.filePath = filePath;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void removeGame(int id) {
        games.removeIf(g -> g.getId() == id);
    }

    public Game findGameByTitle(String title) {
        for (Game g : games) {
            if (g.getTitle().equalsIgnoreCase(title)) return g;
        }
        return null;
    }

    public ArrayList<Game> getGames() { return games; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Game List:\n");
        for (Game g : games) sb.append(g).append("\n");
        return sb.toString();
    }
}
