# Task Manager (taller de Git)

Aplicación Java de consola para gestionar tareas. Este repositorio es la base del **taller de Git: ramas y merge conflicts**.

👉 **Empiecen por [`TALLER.md`](TALLER.md)** (enunciado general del grupo: reglas, integración, conflicto y entrega).
👉 **Luego cada integrante sigue su guía individual:** [1](docs/integrante-1.md) · [2](docs/integrante-2.md) · [3](docs/integrante-3.md) · [4](docs/integrante-4.md).
👉 **Consultas opcionales** (tips, comandos y explicaciones): [conceptos y comandos](docs/CONSULTA_comandos_y_conceptos.md) · [Conventional Commits](docs/CONSULTA_commits.md) · [merges y conflicto](docs/CONSULTA_merge_y_conflicto.md).

## Estructura

```
TALLER.md                  # enunciado general del taller (todo el grupo)
docs/
  integrante-1.md ... integrante-4.md   # guía individual de cada integrante
  CONSULTA_comandos_y_conceptos.md      # consulta opcional: conceptos y comandos de Git
  CONSULTA_commits.md                   # consulta opcional: Conventional Commits
  CONSULTA_merge_y_conflicto.md         # consulta opcional: merges y conflicto
pom.xml                    # configuración de Maven (Java 17 y JUnit 5)
src/
  main/java/
    Main.java              # menú de consola (ya completo, no se modifica)
    Task.java              # representación de una tarea
    TaskManager.java       # datos de las tareas + showBanner() (único archivo compartido)
    TaskDeleter.java       # Integrante 1: eliminar tareas
    TaskSearcher.java      # Integrante 2: buscar tareas
    TaskStatusUpdater.java # Integrante 3: actualizar estado
    TaskCounter.java       # Integrante 4: contar pendientes
  test/java/
    TaskDeleterTest.java       # pruebas JUnit del Integrante 1
    TaskSearcherTest.java      # pruebas JUnit del Integrante 2
    TaskStatusUpdaterTest.java # pruebas JUnit del Integrante 3
    TaskCounterTest.java       # pruebas JUnit del Integrante 4
.github/workflows/
  verificar.yml            # GitHub Actions: revisa marcadores, compila, ejecuta las pruebas y revisa los commits
```

## Compilar, probar y ejecutar

Requisitos: JDK 17 o superior, Maven y Git.

**Desde el IDE (recomendado en el taller):** abre la carpeta como proyecto Maven en NetBeans (también funciona en IntelliJ IDEA, VS Code o Eclipse), ejecuta las pruebas desde la interfaz y corre `Main` para probar el menú.

**Desde la terminal (opcional):**

```bash
# Ejecutar todas las pruebas (compila antes)
mvn test

# Ejecutar solo las pruebas de una clase
mvn test -Dtest=TaskDeleterTest          # PowerShell: mvn test "-Dtest=TaskDeleterTest"

# Ejecutar el programa
mvn -q compile
java -cp target/classes Main
```

La primera vez, Maven descarga las dependencias (necesita internet).
