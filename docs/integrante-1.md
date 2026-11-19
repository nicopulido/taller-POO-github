# Guía del Integrante 1: Eliminar una tarea por id

## Descripción de tu parte

Lee primero el enunciado del [TALLER](../TALLER.md): las reglas y las Partes 0, 3, 4 y 5 son **de todo el grupo**. Esta guía solo cubre **tu** parte: implementar `deleteTask(manager, id)` en tu rama, probarlo, dejar un historial limpio de commits e integrar tu rama en `main` en tu turno. **No modifiques este archivo.** Si necesitas ayuda, consulta (opcional): [conceptos y comandos](CONSULTA_comandos_y_conceptos.md), [Conventional Commits](CONSULTA_commits.md) y [merges y conflicto](CONSULTA_merge_y_conflicto.md).

## Tu ficha

| Dato | Valor |
|------|-------|
| **Rama** | `feature/eliminar-tareas` |
| **Archivo de `src/main/java/` que modificas** | `TaskDeleter.java` |
| **Método** | `deleteTask(manager, id)` |
| **Qué debe hacer** | Eliminar una tarea por id |
| **Tus pruebas (no se tocan)** | `TaskDeleterTest` |
| **Ámbito de tus commits** | `delete` |
| **Tu turno de merge (Parte 3)** | 1° |

## Pasos

### Paso 1: Crea tu rama

Cámbiate a `main`, actualízala con lo que hay en GitHub, crea la rama `feature/eliminar-tareas` y cámbiate a ella. Comprueba que la rama activa es la tuya.

### Paso 2: Implementa tu método

Abre `src/main/java/TaskDeleter.java`, busca `// TODO (Integrante 1)` y escribe tu implementación. Lee antes `src/test/java/TaskDeleterTest.java` para saber qué se espera. Pista: `List.removeIf(...)` sobre `manager.getTasks()`. Devuelve `true` solo si algo se eliminó.

### Paso 3: Pruébalo

Desde NetBeans, ejecuta las pruebas de `TaskDeleterTest` (deben pasar) y ejecuta `Main` para probar el menú. Las pruebas de los demás seguirán fallando hasta que integren su trabajo: es normal. No modifiques las pruebas.

### Paso 4: Haz tus commits (mínimo 2, al menos uno `feat`)

- Revisa qué archivos cambiaron: solo debe aparecer el tuyo.
- Agrega **solo** tu archivo, por nombre.
- Primer commit: lo que implementaste (tipo `feat`, ámbito `delete`).
- Mejora tu código (validaciones, casos borde, simplificación) y haz un segundo commit. Elige el tipo según lo que **realmente** hiciste.
- Revisa tu historial y verifica que tus mensajes cumplen el formato.

### Paso 5: Sube tu rama

Sube tu rama a GitHub enlazándola con el remoto (así los siguientes `push` no necesitan argumentos) y comprueba en GitHub, pestaña **Branches**, que aparece. En **Actions** es normal que falle mientras falten las demás funcionalidades.

### Tu turno de merge (Parte 3)

Orden de integración: `1 → 4 → 2 → 3`. Tú eres el **1°**. Cuando el integrante anterior haya subido `main`, desde tu computador:

1. Cámbiate a `main`.
2. Actualiza `main` con lo que hay en GitHub.
3. Fusiona `feature/eliminar-tareas` en `main` (si se abre un editor de mensaje, guarda y cierra sin cambiar nada).
4. Comprueba el resultado y sube `main`.

Resultado esperado: Merge limpio (*fast-forward*: no se crea commit de merge).

Después de tu merge ya no tienes más pasos individuales, pero **participas en la Parte 4** (opinar sobre cómo resolver el conflicto) y en la **Parte 5** (verificación final).

## Lista de comprobación personal

- [ ] Mi rama `feature/eliminar-tareas` está en GitHub.
- [ ] Hice mínimo 2 commits, al menos uno `feat`, todos con Conventional Commits.
- [ ] Solo modifiqué `TaskDeleter.java`.
- [ ] Las pruebas de `TaskDeleterTest` pasan en NetBeans.
- [ ] Integré mi rama en `main` en mi turno.
