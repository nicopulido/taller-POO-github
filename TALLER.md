# Taller práctico: trabajo colaborativo con Git y GitHub

## Descripción del taller

Grupos de 4 integrantes, un solo repositorio por grupo. Cada uno implementa una funcionalidad en su propia rama y su propio archivo, la integra en `main` y, entre todos, provocan **a propósito** un conflicto de merge en el único archivo compartido (`TaskManager.java`) para resolverlo juntos. Todos los commits usan **Conventional Commits**. Las pruebas y el programa se ejecutan desde NetBeans. Los tips, comandos y explicaciones están en los **archivos de consulta** (opcionales): [conceptos y comandos](docs/CONSULTA_comandos_y_conceptos.md), [Conventional Commits](docs/CONSULTA_commits.md) y [merges y conflicto](docs/CONSULTA_merge_y_conflicto.md).

## Reparto de funcionalidades

Cada integrante sigue su guía: [Integrante 1](docs/integrante-1.md), [Integrante 2](docs/integrante-2.md), [Integrante 3](docs/integrante-3.md) o [Integrante 4](docs/integrante-4.md). Asignen los números entre ustedes antes de empezar. Los nombres de rama y archivo no se cambian.

| Int. | Rama | Archivo (`src/main/java/`) | Método y qué hace | Pruebas (no se tocan) |
|:----:|------|---------|--------|---------|
| 1 | `feature/eliminar-tareas` | `TaskDeleter.java` | `deleteTask(manager, id)`: elimina una tarea por id | `TaskDeleterTest` |
| 2 | `feature/buscar-tareas` | `TaskSearcher.java` | `searchTasks(manager, keyword)`: busca tareas por texto, sin distinguir mayúsculas | `TaskSearcherTest` |
| 3 | `feature/actualizar-estado` | `TaskStatusUpdater.java` | `updateStatus(manager, id, newStatus)`: cambia el estado de una tarea | `TaskStatusUpdaterTest` |
| 4 | `feature/contar-pendientes` | `TaskCounter.java` | `countPending(manager)`: cuenta las tareas en estado `PENDING` | `TaskCounterTest` |

## Reglas

1. **Nunca se trabaja en `main`**, salvo para hacer los merges de la Parte 3.
2. Cada integrante hace sus propios commits, desde su computador y con su usuario de GitHub: **mínimo 2 en su rama, al menos uno de tipo `feat`**.
3. Cada integrante **solo modifica su archivo**. Excepción: los Integrantes 2 y 3 modifican además la línea de `showBanner()` en `TaskManager.java`. Nadie toca `Main.java`, `Task.java`, `pom.xml`, `README.md`, `docs/`, `src/test/` ni `.github/`.
4. **Conventional Commits** en todos los commits (también el que resuelve el conflicto): `<tipo>(<ámbito>): <descripción>`. Tipos: `feat`, `fix`, `test`, `refactor`, `docs`, `style`, `chore`. Ámbitos: `delete`, `search`, `status`, `count`, `banner`. Descripción en minúsculas, en español, imperativo, sin punto final y de máximo 72 caracteres. No se puede corregir después: háganlo bien desde el primero (detalles en la [consulta de commits](docs/CONSULTA_commits.md)).
5. **No borren ramas**, no usen `push --force`, `rebase` ni *squash*. El historial es la evidencia.
6. No usen "formatear documento" del IDE y agreguen los archivos al commit **por nombre** (nada de `git add .` ni `git add -A`).

## Pasos

### Parte 0: Preparación (todos)

1. Tengan Git, JDK 17 o superior y NetBeans. Configuren Git una sola vez con su nombre real y el correo de su cuenta de GitHub (`user.name` y `user.email`).
2. Acepten la invitación al repositorio, clónenlo y ábranlo como proyecto en NetBeans.
3. Ejecuten todas las pruebas desde NetBeans: **deben fallar varias** (faltan las funcionalidades). Si todas pasan o el proyecto no compila, avisen al docente.

### Parte 1: Cada uno implementa su funcionalidad (en paralelo)

Cada integrante, con su guía: (1) crea su rama desde `main` actualizado, (2) implementa su método en su archivo (`// TODO (Integrante N)`), (3) ejecuta las pruebas de su clase en NetBeans, (4) hace mínimo 2 commits y (5) sube su rama a GitHub enlazándola con el remoto.

### Parte 2: Preparar el conflicto (solo Integrantes 2 y 3)

Cada uno, **desde su propia rama**, cambia el mensaje de `showBanner()` en `TaskManager.java` (**la misma línea**, con un texto **distinto** escrito por ustedes), hace commit con ámbito `banner` y lo sube. **No integren nada en `main` todavía.**

> **Antes de seguir:** los 4 deben tener su rama subida a GitHub con todos sus commits.

### Parte 3: Integrar en main, uno por uno

Las ramas se integran **de una en una, en el orden 1 → 4 → 2 → 3**. Cada integrante lo hace **desde su computador** y el siguiente **espera a que el anterior termine de subir `main`**. En su turno, cada uno repite estos 4 pasos:

1. Cambiarse a `main`.
2. Actualizar `main` con lo que hay en GitHub (`pull`).
3. Fusionar su rama en `main` (`merge`). Si se abre un editor de mensaje, guardar y cerrar sin cambiar nada.
4. Comprobar el resultado y subir `main` (`push`).

| Turno | Quién | Resultado esperado |
|:-----:|-------|--------------------|
| 1° | Integrante 1 | Merge limpio, *fast-forward* (no se crea commit de merge) |
| 2° | Integrante 4 | Merge limpio (queda un *merge commit*) |
| 3° | Integrante 2 | Merge limpio: `showBanner()` queda con el mensaje del 2 |
| 4° | Integrante 3 | **CONFLICTO** en `showBanner()`: pasen a la Parte 4 |

El conflicto aparece en el 4° turno porque `main` ya tiene el mensaje del Integrante 2 y la rama del 3 cambió esa misma línea: Git no sabe cuál conservar. Si les sale un conflicto en **otro** archivo o en **otro** turno, avisen al docente.

### Parte 4: Resolver el conflicto (todo el grupo, juntos)

Al hacer su merge, el Integrante 3 verá `CONFLICT (content): Merge conflict in src/main/java/TaskManager.java`. **No es un error: es lo que buscábamos.** El Integrante 3 comparte pantalla y los demás opinan. **No toquen nada hasta tener las dos capturas.**

1. **Ver el estado:** `TaskManager.java` debe aparecer como *both modified*.
2. **Tomar DOS capturas** (van en el documento complementario): **A (terminal)**, con el mensaje `CONFLICT` y el estado con `both modified`; **B (editor)**, con `TaskManager.java` abierto, el nombre del archivo visible y las tres líneas de marcadores con los dos mensajes.
3. **Decidir entre todos qué se conserva** y anotar cuál y por qué: **A** (solo el mensaje del 2), **B** (solo el del 3) o **C** (una combinación).
4. **Editar el archivo:** dejar `showBanner()` con el contenido final y **borrar las tres líneas de marcadores** (`<<<<<<<`, `=======`, `>>>>>>>`).
5. **Verificar en NetBeans:** compila, todas las pruebas pasan y al ejecutar `Main` se ve el mensaje final.
6. **Cerrar el merge:** marcar `TaskManager.java` como resuelto (`add`), hacer el commit **reemplazando** el mensaje por defecto por uno convencional (ámbito `banner`, máx. 72 caracteres) y subir `main` (`push`).

Así se ve el archivo en conflicto (arriba lo que ya estaba en `main`, abajo lo de la rama que se integra):

```java
<<<<<<< HEAD
    System.out.println("<mensaje del Integrante 2>");
=======
    System.out.println("<mensaje del Integrante 3>");
>>>>>>> feature/actualizar-estado
```

Si se confunden, pueden abortar el merge y volver a empezar; **si abortan, repitan las capturas**.

### Parte 5: Verificación final (todos)

Cada uno actualiza `main`, mira el historial como grafo con **todas** las ramas (deben verse las 4 ramas y los merges) y ejecuta las pruebas en NetBeans (todas en verde). En GitHub revisen:

- [ ] Las 4 ramas `feature/...` existen y `main` tiene las 4 funcionalidades.
- [ ] **Actions** sobre `main` en verde y sin advertencias amarillas de commits.
- [ ] `TaskManager.java` no contiene `<<<<<<<`, `=======` ni `>>>>>>>`.
- [ ] Cada integrante aparece como autor de sus commits y todos siguen Conventional Commits.

## Entrega

Se debe enviar **un solo proyecto empaquetado en un `.zip`**, desde el correo de uno de los integrantes, con el asunto:

`[Código1_Apellido1_Nombre1_Código2_Apellido2_Nombre2_Código3_Apellido3_Nombre3_Código4_Apellido4_Nombre4_TallerGit]`

El nombre del archivo es el mismo texto con la extensión `.zip`. El `.zip` contiene el **documento complementario en PDF** con: (1) la Captura A (terminal) y la Captura B (editor) del conflicto, (2) la opción elegida (A, B o C) y por qué, y (3) qué fue lo más difícil o confuso del proceso; y el **enlace del repositorio** del grupo. Todos los puntos son obligatorios. Ramas, commits, merges y Conventional Commits se verifican en el repositorio: no los copien al documento.

- Asunto: `20261020045_Perez_Pepito_20261020046_Pineda_Pepita_20261020047_Gomez_Ana_20261020048_Ruiz_Luis_TallerGit`
- Nombre del archivo: `20261020045_Perez_Pepito_20261020046_Pineda_Pepita_20261020047_Gomez_Ana_20261020048_Ruiz_Luis_TallerGit.zip`
- Correo de envío: nfpulidos@udistrital.edu.co
