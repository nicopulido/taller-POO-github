import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona la lista de tareas. Es el ÚNICO archivo compartido por todo el grupo.
 *
 * Reglas del taller:
 *  - Cada integrante implementa su funcionalidad en SU PROPIO archivo
 *    (TaskDeleter, TaskSearcher, TaskStatusUpdater o TaskCounter).
 *  - El único método de este archivo que se modifica en el taller es
 *    showBanner(), y solo lo modifican los Integrantes 2 y 3 (ver TALLER.md).
 */
public class TaskManager {

    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    /** Mensaje que se muestra al iniciar el programa. */
    public void showBanner() {
        System.out.println("=== Task Manager ===");
    }

    /** Registra una nueva tarea y la devuelve. */
    public Task addTask(String title) {
        Task task = new Task(nextId++, title);
        tasks.add(task);
        return task;
    }

    /**
     * Devuelve la lista interna de tareas (modificable).
     * En un proyecto real se encapsularía; aquí se expone para que cada
     * funcionalidad pueda vivir en su propio archivo.
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /** Muestra todas las tareas en consola. */
    public void listTasks() {
        System.out.println("--- Lista de tareas ---");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
