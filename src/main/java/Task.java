/**
 * Representa una tarea del Task Manager.
 */
public class Task {

    public enum Status { PENDING, IN_PROGRESS, DONE }

    private final int id;
    private String title;
    private Status status;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.status = Status.PENDING;
    }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " (" + status + ")";
    }
}
