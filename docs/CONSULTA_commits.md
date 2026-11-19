# Consulta opcional: Conventional Commits

> Volver al [TALLER](../TALLER.md). Otras consultas: [conceptos y comandos](CONSULTA_comandos_y_conceptos.md) · [merges y conflicto](CONSULTA_merge_y_conflicto.md).

Este documento **no es obligatorio**: amplía lo que dice la regla 4 del TALLER.

## Qué es y para qué sirve

Conventional Commits es una convención para escribir mensajes de commit, de modo que cualquiera entienda, leyendo solo el historial, qué se hizo y en qué parte del proyecto.

```
<tipo>(<ámbito>): <descripción>
```

- **tipo** (uno de estos): `feat` (funcionalidad nueva), `fix` (corrección de un error), `test` (pruebas), `refactor` (reorganizar código sin cambiar su comportamiento), `docs` (documentación), `style` (formato, sin cambiar lógica), `chore` (tareas de mantenimiento).
- **ámbito**: el módulo afectado, en minúsculas y entre paréntesis. En este taller: `delete`, `search`, `status`, `count` o `banner`.
- **descripción**: en minúsculas, en español, en modo imperativo (*agrega*, *corrige*, *implementa*), sin punto final, corta (máximo 72 caracteres).

**Prueba rápida:** la descripción debe completar bien la frase "Si se aplica, este commit...". Si no suena natural, reescríbanla.

## Ejemplos

Correctos (de un proyecto distinto; sirven para ver el formato, no para copiarlos):

```
feat(carrito): agrega botón para vaciar el carrito
fix(login): corrige la validación de correo vacío
docs(readme): aclara los pasos de instalación
refactor(pagos): extrae el cálculo del total a un método
```

Incorrectos: `cambios`, `listo`, `Implementé el método`, `feat: cosas`, `Feat(carrito): ...` (el tipo va en minúsculas), `feat(Carrito): ...` (el ámbito va en minúsculas).

## Cómo elegir bien

- **Un commit, una idea.** Si el mensaje necesita "y" para explicarse, probablemente son dos commits.
- **El tipo describe lo que hiciste de verdad.** Agregar una funcionalidad es `feat`; arreglar un caso que fallaba es `fix`; reorganizar sin cambiar el resultado es `refactor`; solo comentarios o documentación es `docs`; solo espacios o formato es `style`.
- **El ámbito es el módulo que tocaste**, no tu nombre ni el del archivo completo.
- **Revisa el mensaje antes de pulsar Enter.** GitHub Actions muestra una advertencia amarilla si un commit no cumple, y no se puede corregir reescribiendo el historial.
- **Los merges automáticos que genera Git no cuentan**, pero el commit que cierra la resolución del conflicto sí debe cumplir el formato (ámbito `banner`).
