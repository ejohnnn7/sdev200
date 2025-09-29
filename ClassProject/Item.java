package ClassProject;

// Abstract parent class for any tracked media item.

public abstract class Item {
    private int id;
    private String title;
    private String platform;
    private String status; // "Not Started", "In Progress", "Completed"

    public Item(int id, String title, String platform, String status) {
        this.id = id;
        this.title = title;
        this.platform = platform;
        setStatus(status);
    }

    // Getters and setters with validation
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        if (status.equals("Not Started") || status.equals("In Progress") || status.equals("Completed")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status value.");
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title +
               ", Platform: " + platform +
               ", Status: " + status;
    }
}
