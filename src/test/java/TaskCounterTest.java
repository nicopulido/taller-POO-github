import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Pruebas de la funcionalidad del Integrante 4 (TaskCounter). No modificar. */
class TaskCounterTest {

    @Test
    void countPendingCuentaSoloLasPendientes() {
        TaskManager manager = new TaskManager();
        manager.addTask("Tarea 1");
        Task t2 = manager.addTask("Tarea 2");
        Task t3 = manager.addTask("Tarea 3");
        t2.setStatus(Task.Status.DONE);
        t3.setStatus(Task.Status.IN_PROGRESS);
        assertEquals(1, TaskCounter.countPending(manager));
    }

    @Test
    void countPendingEnListaVaciaEsCero() {
        assertEquals(0, TaskCounter.countPending(new TaskManager()));
    }
}
