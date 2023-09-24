import java.util.ArrayList;
import java.util.Date;

class Task {
    private String title;
    private String description;
    private Date creationDate;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.creationDate = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Название задачи: " + title + ", Описание: " + description + ", Дата создания: " + creationDate;
    }
}

class DeadlineTask extends Task {
    private Date deadline;

    public DeadlineTask(String title, String description, Date deadline) {
        super(title, description);
        this.deadline = deadline;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return super.toString() + ", Дедлайн: " + deadline;
    }
}

class RecurringTask extends Task {
    private String recurringPeriod;
    private Date startDate;

    public RecurringTask(String title, String description, String recurringPeriod, Date startDate) {
        super(title, description);
        this.recurringPeriod = recurringPeriod;
        this.startDate = startDate;
    }

    public String getRecurringPeriod() {
        return recurringPeriod;
    }

    public void setRecurringPeriod(String recurringPeriod) {
        this.recurringPeriod = recurringPeriod;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Период повторения: " + recurringPeriod + ", Дата начала: " + startDate;
    }
}

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task = new Task("чет надо сделать", "сделай че-то чёбы была");
        DeadlineTask deadlineTask = new DeadlineTask("ну чет ещё надо сделать", "так же ка в прошлой задаче", new Date());
        RecurringTask recurringTask = new RecurringTask("да чет надо читать", "ну тоже чет поделай, а то че ты", "каждый божий день", new Date());

        taskManager.addTask(task);
        taskManager.addTask(deadlineTask);
        taskManager.addTask(recurringTask);

        taskManager.viewAllTasks();
    }
}