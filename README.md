# 21_Blackjack
Juego De "BLACKJACK" En Java
# Autores
- [Ronaldo Basto Pillimur](https://github.com/RonaldB24)
- [Juan Stevan Ordoñez Galindez](https://github.com/juanostevan)
- [Eider David Sanchez Ceron](https://github.com/Zandybro)
- [Alexander Chantre Vernaza](https://github.com/AlexanderChantre)

# Descripción del Proyecto
Desarrollo del juego "BlackJack" en el que el jugador se enfrenta al sistema (crupier).
Ambos reciben cartas con el objetivo de acercarse lo más posible a 21 puntos sin superarlo.
El jugador puede elegir entre pedir una carta para acercarse al objetivo o quedarse con su puntaje actual, 
mientras que el crupier actúa siguiendo un árbol de decisión automatizado.

# Características Técnicas
- Modalidad: Jugador vs Máquina.
- Lenguaje: Java.
- Interfaz: No (Solo consola).
- Semestre: 4to de Ingeniería Informática.
- Enfoque: Lógica de programación, estructuras de datos propias, programacion orienta a objetos, recursividad, codigo limpio y despliegue colaborativo en GitHub.

# Reglas del Blackjack
- Una baraja inglesa estandar de 52 cartas.
- Clasificacion de cartas:
- Cartas numéricas (2–10): su valor nominal.
- Figuras (J, Q, K): valen 10 puntos.
- As (A): puede valer 1 u 11 puntos, según convenga al jugador.
- Inicio repartir 2 cartas.
- Suma ganadora es la que se acerca o igual a vigésimo primero(21).
- Cada jugador decide cómo proceder con su mano:
- Pedir carta (Hit): solicitar una carta adicional.
- Plantarse (Stand): mantener la mano actual sin pedir más cartas.
- Se comparan las manos del jugador y del dealer:
- Victoria del jugador: si su mano es más cercana a 21 sin pasarse.
- Victoria del crupier: si su mano es más cercana a 21 sin pasarse.
- Empate (Push): si ambas manos tienen el mismo valor.
- Perdida del jugador: si se pasa de 21 puntos (se "quema")
