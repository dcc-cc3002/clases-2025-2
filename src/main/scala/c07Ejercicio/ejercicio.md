# Sistema Simplificado de Juego de Rol "Pathfinder"
## Objetivo

Construir un sistema básico de combate y gestión de entidades inspirado en juegos de rol como Pathfinder o Dungeons & Dragons. El sistema debe modelar jugadores, monstruos, hechizos, dados y el flujo de turnos, permitiendo simular enfrentamientos entre personajes y criaturas.

## Requisitos

### 1. Entidades y Jerarquía
- Implementa una jerarquía de entidades (`Entity`) que incluya jugadores y monstruos.
- Los jugadores deben tener clases específicas (por ejemplo: `Fighter`, `Cleric`, `Wizard`), cada una con habilidades y hechizos particulares.
- Los monstruos deben tener subclases (por ejemplo: `Goblin`, `Beholder`).

### 2. Sistema de Magia
- Implementa un sistema de escuelas de magia (`SchoolOfMagic`) y hechizos (`Spell`).
- Cada hechizo debe pertenecer a una escuela (por ejemplo: conjuración, evocación, transmutación) y tener efectos definidos (por ejemplo: daño, curación, desintegración).

### 3. Dados y Aleatoriedad
- Crea una clase para simular tiradas de dados (`Dice`), permitiendo lanzar dados de distintos tamaños (d4, d6, d8, d20, etc.).

### 4. Flujo de Turnos
- Implementa un controlador de turnos (`TurnContext`, `Controller`) que gestione el orden de las acciones y resuelva los efectos de los hechizos y ataques.

### 5. Interacción y Combate
- Permite que los jugadores y monstruos realicen acciones como atacar, lanzar hechizos y recibir daño.
- Gestiona puntos de vida y condiciones de victoria/derrota.

### 6. Extensibilidad
- El diseño debe permitir agregar fácilmente nuevas clases de personajes, monstruos y hechizos.
debe permitir agregar fácilmente nuevas clases de personajes, monstruos y hechizos.