# Guía del Integrante 3: Cambiar el estado de una tarea

## Descripción de tu parte

Lee primero el enunciado del [TALLER](../TALLER.md): las reglas y las Partes 0, 3, 4 y 5 son **de todo el grupo**. Esta guía solo cubre **tu** parte: implementar `updateStatus(manager, id, newStatus)` en tu rama, probarlo, dejar un historial limpio de commits e integrar tu rama en `main` en tu turno. **No modifiques este archivo.** Si necesitas ayuda, consulta (opcional): [conceptos y comandos](CONSULTA_comandos_y_conceptos.md), [Conventional Commits](CONSULTA_commits.md) y [merges y conflicto](CONSULTA_merge_y_conflicto.md).

## Tu ficha

| Dato | Valor |
|------|-------|
| **Rama** | `feature/actualizar-estado` |
| **Archivo de `src/main/java/` que modificas** | `TaskStatusUpdater.java` (más una línea de `TaskManager.java`, Paso 6) |
| **Método** | `updateStatus(manager, id, newStatus)` |
| **Qué debe hacer** | Cambiar el estado de una tarea |
| **Tus pruebas (no se tocan)** | `TaskStatusUpdaterTest` |
| **Ámbito de tus commits** | `status` (y `banner`) |
| **Tu turno de merge (Parte 3)** | 4° |

## Pasos

### Paso 1: Crea tu rama

Cámbiate a `main`, actualízala con lo que hay en GitHub, crea la rama `feature/actualizar-estado` y cámbiate a ella. Comprueba que la rama activa es la tuya.

### Paso 2: Implementa tu método

Abre `src/main/java/TaskStatusUpdater.java`, busca `// TODO (Integrante 3)` y escribe tu implementación. Lee antes `src/test/java/TaskStatusUpdaterTest.java` para saber qué se espera. Pista: recorre `manager.getTasks()`, encuentra el id y usa `task.setStatus(...)`.

### Paso 3: Pruébalo

Desde NetBeans, ejecuta las pruebas de `TaskStatusUpdaterTest` (deben pasar) y ejecuta `Main` para probar el menú. Las pruebas de los demás seguirán fallando hasta que integren su trabajo: es normal. No modifiques las pruebas.

### Paso 4: Haz tus commits (mínimo 2, al menos uno `feat`)

- Revisa qué archivos cambiaron: solo debe aparecer el tuyo.
- Agrega **solo** tu archivo, por nombre.
- Primer commit: lo que implementaste (tipo `feat`, ámbito `status`).
- Mejora tu código (validaciones, casos borde, simplificación) y haz un segundo commit. Elige el tipo según lo que **realmente** hiciste.
- Revisa tu historial y verifica que tus mensajes cumplen el formato.

### Paso 5: Sube tu rama

Sube tu rama a GitHub enlazándola con el remoto (así los siguientes `push` no necesitan argumentos) y comprueba en GitHub, pestaña **Branches**, que aparece. En **Actions** es normal que falle mientras falten las demás funcionalidades.

### Paso 6: Prepara el conflicto (solo Integrantes 2 y 3)

Desde **tu rama** (no desde `main`) cambia **una sola línea**: el mensaje de `showBanner()` en `src/main/java/TaskManager.java`. El Integrante 2 hace lo mismo desde la suya.

```java
public void showBanner() {
    System.out.println("=== Task Manager ===");     // <- cambia SOLO esta línea
}
```

- Escribe **tu propio mensaje**, distinto al del Integrante 2.
- No cambies nada más del archivo ni uses "formatear documento".
- Haz un commit con ámbito `banner` (tú eliges tipo y descripción) y súbelo.
- **No** traigas a tu rama la rama de tu compañero: el conflicto debe aparecer al integrar en `main`.

> **Antes de seguir:** los 4 integrantes deben tener su rama subida a GitHub con todos sus commits.

### Tu turno de merge (Parte 3)

Orden de integración: `1 → 4 → 2 → 3`. Tú eres el **4°**. Cuando el integrante anterior haya subido `main`, desde tu computador:

1. Cámbiate a `main`.
2. Actualiza `main` con lo que hay en GitHub.
3. Fusiona `feature/actualizar-estado` en `main` (si se abre un editor de mensaje, guarda y cierra sin cambiar nada).
4. Comprueba el resultado y sube `main`.

Resultado esperado: **CONFLICTO** en `showBanner()`. Es lo esperado.

Cuando aparezca `CONFLICT (content): Merge conflict in src/main/java/TaskManager.java`, **no entres en pánico**: comparte pantalla y sigue la **Parte 4** del TALLER. **No hagas nada hasta tener las capturas A y B.** Tú ejecutas los pasos y el grupo decide qué mensaje se conserva. Anota la opción elegida (A, B o C) y el porqué para el documento complementario.

## Lista de comprobación personal

- [ ] Mi rama `feature/actualizar-estado` está en GitHub.
- [ ] Hice mínimo 2 commits, al menos uno `feat`, todos con Conventional Commits.
- [ ] Solo modifiqué `TaskStatusUpdater.java` y la línea de `showBanner()`.
- [ ] Las pruebas de `TaskStatusUpdaterTest` pasan en NetBeans.
- [ ] Integré mi rama en `main` en mi turno.
- [ ] Tenemos las capturas A y B y anotamos la opción elegida y su justificación.
