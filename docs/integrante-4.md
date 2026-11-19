# Guía del Integrante 4: Contar las tareas en estado `PENDING`

## Descripción de tu parte

Lee primero el enunciado del [TALLER](../TALLER.md): las reglas y las Partes 0, 3, 4 y 5 son **de todo el grupo**. Esta guía solo cubre **tu** parte: implementar `countPending(manager)` en tu rama, probarlo, dejar un historial limpio de commits e integrar tu rama en `main` en tu turno. **No modifiques este archivo.** Si necesitas ayuda, consulta (opcional): [conceptos y comandos](CONSULTA_comandos_y_conceptos.md), [Conventional Commits](CONSULTA_commits.md) y [merges y conflicto](CONSULTA_merge_y_conflicto.md).

## Tu ficha

| Dato | Valor |
|------|-------|
| **Rama** | `feature/contar-pendientes` |
| **Archivo de `src/main/java/` que modificas** | `TaskCounter.java` |
| **Método** | `countPending(manager)` |
| **Qué debe hacer** | Contar las tareas en estado `PENDING` |
| **Tus pruebas (no se tocan)** | `TaskCounterTest` |
| **Ámbito de tus commits** | `count` |
| **Tu turno de merge (Parte 3)** | 2° |

## Pasos

### Paso 1: Crea tu rama

Cámbiate a `main`, actualízala con lo que hay en GitHub, crea la rama `feature/contar-pendientes` y cámbiate a ella. Comprueba que la rama activa es la tuya.

### Paso 2: Implementa tu método

Abre `src/main/java/TaskCounter.java`, busca `// TODO (Integrante 4)` y escribe tu implementación. Lee antes `src/test/java/TaskCounterTest.java` para saber qué se espera. Pista: recorre `manager.getTasks()` y cuenta las tareas con `getStatus() == Task.Status.PENDING`.

### Paso 3: Pruébalo

Desde NetBeans, ejecuta las pruebas de `TaskCounterTest` (deben pasar) y ejecuta `Main` para probar el menú. Las pruebas de los demás seguirán fallando hasta que integren su trabajo: es normal. No modifiques las pruebas.

### Paso 4: Haz tus commits (mínimo 2, al menos uno `feat`)

- Revisa qué archivos cambiaron: solo debe aparecer el tuyo.
- Agrega **solo** tu archivo, por nombre.
- Primer commit: lo que implementaste (tipo `feat`, ámbito `count`).
- Mejora tu código (validaciones, casos borde, simplificación) y haz un segundo commit. Elige el tipo según lo que **realmente** hiciste.
- Revisa tu historial y verifica que tus mensajes cumplen el formato.

### Paso 5: Sube tu rama

Sube tu rama a GitHub enlazándola con el remoto (así los siguientes `push` no necesitan argumentos) y comprueba en GitHub, pestaña **Branches**, que aparece. En **Actions** es normal que falle mientras falten las demás funcionalidades.

### Tu turno de merge (Parte 3)

Orden de integración: `1 → 4 → 2 → 3`. Tú eres el **2°**. Cuando el integrante anterior haya subido `main`, desde tu computador:

1. Cámbiate a `main`.
2. Actualiza `main` con lo que hay en GitHub.
3. Fusiona `feature/contar-pendientes` en `main` (si se abre un editor de mensaje, guarda y cierra sin cambiar nada).
4. Comprueba el resultado y sube `main`.

Resultado esperado: Merge limpio (queda un *merge commit*).

Después de tu merge ya no tienes más pasos individuales, pero **participas en la Parte 4** (opinar sobre cómo resolver el conflicto) y en la **Parte 5** (verificación final).

## Lista de comprobación personal

- [ ] Mi rama `feature/contar-pendientes` está en GitHub.
- [ ] Hice mínimo 2 commits, al menos uno `feat`, todos con Conventional Commits.
- [ ] Solo modifiqué `TaskCounter.java`.
- [ ] Las pruebas de `TaskCounterTest` pasan en NetBeans.
- [ ] Integré mi rama en `main` en mi turno.
