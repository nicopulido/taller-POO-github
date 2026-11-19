# Consulta opcional: merges y conflicto

> Volver al [TALLER](../TALLER.md). Otras consultas: [conceptos y comandos](CONSULTA_comandos_y_conceptos.md) · [Conventional Commits](CONSULTA_commits.md).

Este documento **no es obligatorio**: explica con más calma lo que pasa en las Partes 2, 3 y 4 del TALLER.

## Qué pasa en cada turno de merge

- **Turno 1 (Integrante 1), *fast-forward*:** `main` no ha avanzado desde que se creó la rama, así que Git solo adelanta el puntero de `main` hasta el último commit de la rama. No se crea ningún commit de merge.
- **Turno 2 (Integrante 4), *merge commit*:** `main` ya tiene el trabajo del 1, que la rama del 4 no tiene. Los historiales divergieron, así que Git crea un commit de merge que los une (puede abrirse el editor de mensaje). En el grafo se ve como una línea que se bifurca y se vuelve a juntar.
- **Turno 3 (Integrante 2), merge limpio:** otro merge commit. Hasta ahora nadie más había cambiado `showBanner()` en `main`, así que no hay conflicto. Al ejecutar `Main` debe verse el mensaje del 2.
- **Turno 4 (Integrante 3), conflicto:** `main` ya tiene el mensaje del 2 en `showBanner()` y la rama del 3 cambió esa misma línea. Git no puede decidir cuál es la correcta y detiene el merge.

## Por qué se provoca así

Las ramas del 2 y del 3 parten del mismo punto de `main` y cada una reescribe la misma línea de forma distinta. Si alguno traía a su rama los cambios del otro, el conflicto aparecería ahí y no en `main`: por eso se pide **no** mezclar esas dos ramas entre sí.

## Cómo leer el archivo en conflicto

```java
public void showBanner() {
<<<<<<< HEAD
    System.out.println("<mensaje que ya estaba en main>");
=======
    System.out.println("<mensaje de la rama que se integra>");
>>>>>>> feature/actualizar-estado
}
```

- Entre `<<<<<<< HEAD` y `=======`: la versión que ya estaba en `main` (la del Integrante 2).
- Entre `=======` y `>>>>>>>`: la versión de la rama que se integra (la del Integrante 3).
- Resolver es dejar **un solo** contenido final y borrar las tres líneas de marcadores. El archivo debe quedar como Java válido.

## Las tres opciones de decisión

- **Opción A:** dejar solo el mensaje del Integrante 2.
- **Opción B:** dejar solo el mensaje del Integrante 3.
- **Opción C:** dejar una combinación (ambos mensajes o un tercero).

No hay una opción "correcta": lo que se evalúa es que la decisión sea consciente y esté justificada. Piensen, por ejemplo, qué mensaje le sirve más a quien ejecute el programa, o si perder uno de los dos mensajes significa perder algo importante.

## Si algo sale mal

- **Me confundí a mitad del conflicto:** `git merge --abort` deshace el merge y vuelven al estado anterior. Al volver a provocar el conflicto, **repitan las capturas**.
- **NetBeans:** si la versión que usan tiene la herramienta visual de resolución de conflictos (menú *Team > Git*), pueden usarla, pero el archivo final no debe tener ningún marcador.
- **Git dice "You have unmerged paths":** aún hay archivos sin marcar como resueltos. Ejecuten `git status` y marquen el archivo con `git add` cuando ya esté limpio.
- **Salió un conflicto en otro archivo o en otro turno:** alguien modificó un archivo que no le correspondía. Avisen al docente.

## Qué anotar para el documento complementario

Tómenlo mientras lo viven; después se olvida.

- La Captura A (terminal) y la Captura B (editor), tomadas **antes** de editar nada. Esta evidencia no queda en el historial de Git.
- La opción elegida (A, B o C) y **por qué**.
- Qué les pareció más difícil o confuso del proceso.
