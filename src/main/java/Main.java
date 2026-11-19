import java.util.List;
import java.util.Scanner;

/**
 * Programa principal (menú de consola). Ya está completo:
 * en el taller NO es necesario modificar este archivo.
 */
public class Main {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner in = new Scanner(System.in);
        manager.showBanner();

        int option;
        do {
            printMenu();
            option = readInt(in, "Opción: ");
            switch (option) {
                case 1 -> {
                    System.out.print("Título: ");
                    Task t = manager.addTask(in.nextLine().trim());
                    System.out.println("Creada: " + t);
                }
                case 2 -> manager.listTasks();
                case 3 -> {
                    int id = readInt(in, "Id a eliminar: ");
                    System.out.println(TaskDeleter.deleteTask(manager, id) ? "Tarea eliminada." : "No existe esa tarea.");
                }
                case 4 -> {
                    System.out.print("Texto a buscar: ");
                    List<Task> found = TaskSearcher.searchTasks(manager, in.nextLine().trim());
                    if (found.isEmpty()) System.out.println("Sin resultados.");
                    else found.forEach(System.out::println);
                }
                case 5 -> {
                    int id = readInt(in, "Id de la tarea: ");
                    int s = readInt(in, "Nuevo estado (1=PENDING, 2=IN_PROGRESS, 3=DONE): ");
                    if (s < 1 || s > 3) {
                        System.out.println("Estado inválido.");
                    } else {
                        Task.Status status = Task.Status.values()[s - 1];
                        System.out.println(TaskStatusUpdater.updateStatus(manager, id, status) ? "Estado actualizado." : "No existe esa tarea.");
                    }
                }
                case 6 -> System.out.println("Tareas pendientes: " + TaskCounter.countPending(manager));
                case 0 -> System.out.println("¡Hasta pronto!");
                default -> System.out.println("Opción no válida.");
            }
        } while (option != 0);
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Registrar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Eliminar tarea");
        System.out.println("4. Buscar tareas");
        System.out.println("5. Actualizar estado");
        System.out.println("6. Contar pendientes");
        System.out.println("0. Salir");
    }

    private static int readInt(Scanner in, String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(in.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
