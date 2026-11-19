import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Pruebas de la funcionalidad del Integrante 2 (TaskSearcher). No modificar. */
class TaskSearcherTest {

    private TaskManager manager;

    @BeforeEach
    void preparar() {
        manager = new TaskManager();
        manager.addTask("Comprar leche");
        manager.addTask("Estudiar Git");
        manager.addTask("Leer documentación de Java");
    }

    @Test
    void searchTasksEncuentraUnaCoincidencia() {
        assertEquals(1, TaskSearcher.searchTasks(manager, "leche").size());
    }

    @Test
    void searchTasksIgnoraMayusculasYMinusculas() {
        assertEquals(1, TaskSearcher.searchTasks(manager, "GIT").size());
    }

    @Test
    void searchTasksDevuelveVariasCoincidencias() {
        assertEquals(3, TaskSearcher.searchTasks(manager, "e").size());
    }

    @Test
    void searchTasksDevuelveListaVaciaSiNoHay() {
        assertTrue(TaskSearcher.searchTasks(manager, "zzz").isEmpty());
    }
}
