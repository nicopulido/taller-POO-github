import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Pruebas de la funcionalidad del Integrante 1 (TaskDeleter). No modificar. */
class TaskDeleterTest {

    @Test
    void deleteTaskDevuelveTrueSiExiste() {
        TaskManager manager = new TaskManager();
        Task a = manager.addTask("Comprar leche");
        manager.addTask("Estudiar Git");
        assertTrue(TaskDeleter.deleteTask(manager, a.getId()));
    }

    @Test
    void deleteTaskEliminaLaTareaDeLaLista() {
        TaskManager manager = new TaskManager();
        Task a = manager.addTask("Comprar leche");
        manager.addTask("Estudiar Git");
        TaskDeleter.deleteTask(manager, a.getId());
        assertEquals(1, manager.getTasks().size());
    }

    @Test
    void deleteTaskDevuelveFalseSiNoExiste() {
        TaskManager manager = new TaskManager();
        manager.addTask("Comprar leche");
        assertFalse(TaskDeleter.deleteTask(manager, 999));
    }
}
