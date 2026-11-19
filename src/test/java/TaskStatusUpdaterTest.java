import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Pruebas de la funcionalidad del Integrante 3 (TaskStatusUpdater). No modificar. */
class TaskStatusUpdaterTest {

    @Test
    void updateStatusDevuelveTrueSiExiste() {
        TaskManager manager = new TaskManager();
        Task t = manager.addTask("Entregar taller");
        assertTrue(TaskStatusUpdater.updateStatus(manager, t.getId(), Task.Status.DONE));
    }

    @Test
    void updateStatusCambiaElEstado() {
        TaskManager manager = new TaskManager();
        Task t = manager.addTask("Entregar taller");
        TaskStatusUpdater.updateStatus(manager, t.getId(), Task.Status.DONE);
        assertEquals(Task.Status.DONE, t.getStatus());
    }

    @Test
    void updateStatusDevuelveFalseSiNoExiste() {
        TaskManager manager = new TaskManager();
        manager.addTask("Entregar taller");
        assertFalse(TaskStatusUpdater.updateStatus(manager, 999, Task.Status.DONE));
    }
}
