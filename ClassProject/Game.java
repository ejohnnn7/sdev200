package ClassProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Game extends Item {

    private int hoursPlayed;
    private int completionPercent;
    private String genre;
    private String notes;
    private LocalDate dateAdded;
    private LocalDate lastPlayed;

    // --- New field: list of items ---
    private List<Item> items;

    public Game(int id, String title, String platform, String status,
                int hoursPlayed, int completionPercent,
                String genre, String notes,
                LocalDate dateAdded, LocalDate lastPlayed) {
        super(id, title, platform, status);
        setHoursPlayed(hoursPlayed);
        setCompletionPercent(completionPercent);
        this.genre = genre;
        this.notes = notes;
        this.dateAdded = dateAdded;
        this.lastPlayed = lastPlayed;
        this.items = new ArrayList<>(); // initialize list
    }

    // --- Item list methods ---
    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    // --- Existing getters and setters ---
    public int getHoursPlayed() { return hoursPlayed; }
    public void setHoursPlayed(int hours) {
        if (hours < 0) throw new IllegalArgumentException("Hours cannot be negative.");
        this.hoursPlayed = hours;
    }

    public int getCompletionPercent() { return completionPercent; }
    public void setCompletionPercent(int percent) {
        if (percent < 0 || percent > 100)
            throw new IllegalArgumentException("Completion must be 0-100.");
        this.completionPercent = percent;
    }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDate getDateAdded() { return dateAdded; }
    public void setDateAdded(LocalDate dateAdded) { this.dateAdded = dateAdded; }

    public LocalDate getLastPlayed() { return lastPlayed; }
    public void setLastPlayed(LocalDate lastPlayed) { this.lastPlayed = lastPlayed; }

    @Override
    public String toString() {
        return super.toString() +
               ", Hours: " + hoursPlayed +
               ", Completion: " + completionPercent + "%" +
               ", Genre: " + genre +
               ", Last Played: " + lastPlayed;
    }
}
