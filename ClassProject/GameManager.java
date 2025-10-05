package ClassProject;

import java.util.ArrayList;

public class GameManager {
    private ArrayList<Game> games;
    private String filePath;
    private int nextItemId; // for unique item IDs

    public GameManager(String filePath) {
        this.games = new ArrayList<>();
        this.filePath = filePath;
        this.nextItemId = 1;
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

    public ArrayList<Game> getGames() {
        return games;
    }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    // --- New method: add item to last game ---
    public void addItemToLastGame(Item item) {
        if (!games.isEmpty()) {
            Game lastGame = games.get(games.size() - 1);
            lastGame.addItem(item); // make sure Game has addItem(Item item)
        } else {
            throw new IllegalStateException("No game exists to add the item to.");
        }
    }

    // --- New method: get next unique item ID ---
    public int getNextItemId() {
        return nextItemId++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Game List:\n");
        for (Game g : games) sb.append(g).append("\n");
        return sb.toString();
    }
}
