import java.util.Objects;

public class Task {
    private int Number;
    private String description;
    private String status;
    private int daysInProcessing;

    public Task(int number, String description, String status, int daysInProcessing) {
        Number = number;
        this.description = description;
        this.status = status;
        this.daysInProcessing = daysInProcessing;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDaysInProcessing() {
        return daysInProcessing;
    }

    public void setDaysInProcessing(int daysInProcessing) {
        this.daysInProcessing = daysInProcessing;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Number == task.Number && daysInProcessing == task.daysInProcessing && Objects.equals(description, task.description) && Objects.equals(status, task.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Number, description, status, daysInProcessing);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task{");
        sb.append("Number=").append(Number);
        sb.append(", description='").append(description).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", daysInProcessing=").append(daysInProcessing);
        sb.append('}');
        return sb.toString();
    }
}
