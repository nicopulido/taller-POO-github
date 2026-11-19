# Consulta opcional: conceptos y comandos de Git

> Volver al [TALLER](../TALLER.md). Otras consultas: [Conventional Commits](CONSULTA_commits.md) · [merges y conflicto](CONSULTA_merge_y_conflicto.md).

Este documento **no es obligatorio**. Úsenlo cuando no recuerden un concepto o un comando. Todo lo que va entre `<` y `>` lo completan ustedes.

## Conceptos clave

- **Repositorio local y remoto:** su copia en el computador y la copia en GitHub (el remoto se llama `origin`). Lo que hacen en local no lo ven los demás hasta que hacen `push`; lo que hacen los demás no les llega hasta que hacen `pull`.
- **Rama:** una línea de trabajo independiente. Crear una rama no copia archivos: solo crea un puntero nuevo sobre el historial.
- **Área de preparación (*staging*):** el lugar donde se dejan los archivos que irán en el próximo commit. Se llena con `git add` y se vacía al hacer `git commit`.
- **Commit:** una fotografía del proyecto con un mensaje que explica qué cambió.
- **`HEAD`:** la rama o commit en el que están parados. En un conflicto, `HEAD` es la rama donde hacen el merge, es decir, `main`.

## Esqueleto de los comandos por tarea

**Crear mi rama** (partiendo de `main` actualizado):

```bash
git switch main
git pull
git switch -c <nombre-de-tu-rama>
git branch                        # la rama activa lleva asterisco
```

**Hacer un commit:**

```bash
git status                        # ¿qué archivos cambiaron?
git diff                          # ¿qué líneas cambiaron?
git add <tu-archivo>              # preparar solo tu archivo
git commit -m "<tu mensaje de commit>"
git log --oneline                 # revisar lo que quedó
```

**Subir mi rama (primera vez) y después:**

```bash
git push -u origin <nombre-de-tu-rama>
git push                          # las siguientes veces
```

**Integrar mi rama en `main` (mi turno):**

```bash
git switch main
git pull
git merge <nombre-de-tu-rama>
git log --oneline --graph --all   # ¿se ve lo esperado?
git push
```

## Chuleta

| Quiero... | Comando |
|-----------|---------|
| Descargar el repositorio | `git clone <url>` |
| Configurar mi nombre y correo (una sola vez) | `git config --global user.name "<nombre>"` y `git config --global user.email "<correo>"` |
| Ver rama actual y cambios | `git status` |
| Ver ramas locales | `git branch` |
| Ver líneas modificadas | `git diff` |
| Preparar un archivo | `git add <archivo>` |
| Guardar un commit | `git commit -m "<tu mensaje de commit>"` |
| Crear y cambiarme a una rama | `git switch -c <rama>` |
| Cambiarme a una rama existente | `git switch <rama>` |
| Subir una rama nueva | `git push -u origin <rama>` |
| Subir cambios | `git push` |
| Traer cambios del remoto | `git pull` |
| Fusionar una rama en la actual | `git merge <rama>` |
| Abortar un merge con conflicto | `git merge --abort` |
| Ver el historial como grafo | `git log --oneline --graph --all` |

Si prefieren la terminal a NetBeans para las pruebas: `mvn test` (todas) o `mvn test -Dtest=<NombreDeLaClaseTest>` (una clase; en PowerShell, con comillas en `-Dtest`).

## Problemas frecuentes

- **El `push` es rechazado:** alguien subió algo antes que ustedes. Actualicen (`pull`) y repitan el `push`.
- **Se abre un editor al hacer `merge` o `commit`:** en Vim escriban `:wq` y Enter; en Nano, `Ctrl+O`, Enter y `Ctrl+X`. En `merge` también pueden buscar la opción que evita abrir el editor.
- **Aparecen archivos que no son míos en `git status`:** no los agreguen. Si ya los modificaron sin querer, pregunten al docente antes de seguir.
- **No sé en qué rama estoy:** `git status` lo dice en la primera línea.
- **Me equivoqué en el mensaje de un commit:** no reescriban el historial (está prohibido). Si aún no lo han subido, consulten al docente.

## Glosario

- **Fast-forward:** merge en el que Git solo adelanta el puntero de la rama, sin crear un commit nuevo.
- **Merge commit:** commit especial con dos padres que une dos historiales.
- **Marcadores de conflicto:** las líneas `<<<<<<<`, `=======` y `>>>>>>>` que Git escribe dentro del archivo para señalar las dos versiones en disputa.
