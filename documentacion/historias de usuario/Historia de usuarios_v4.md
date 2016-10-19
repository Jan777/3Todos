## **Historias de usuario** ##  

>1)	 Como Jugador, Quiero crear mi personaje, editando sus características principales (como raza y casta).
> Motivación: Quiero modificar mi avatar y verme reflejado en el mismo.  

 *Criterios de aceptación:*  
1.	Dado un Jugador, cuando ingrese por primera vez al juego, entonces se le creará un avatar al mismo relacionado con las opciones de personajes que haya seleccionado en Raza y Casta.
2.	Dado un Jugador, cuando desee editar las características de su avatar, entonces se le proveerá de una nueva pantalla para poder editar Raza y Casta de su personaje.

>2)	 Como Jugador, Quiero ingresar a un mundo. 
> Motivación: Para adquirir experiencia, ítems y habilidades nuevas.  
	
 *Criterios de aceptación:*  
1.	Dado un Jugador, cuando quiera ingresar a alguna partida, entonces seleccionará uno de los mundos propuestos por el sistema en un momento dado.
2.	Dado un Jugador, cuando se encuentre en alguna partida o buscando alguna para ingresar, entonces se le mostrará aquellas partidas o mundos disponibles a las cuales le sea posible unirse.
3.	Dado un Jugador, cuando su personaje gane una batalla contra otro personaje Jugador o un personaje genérico, entonces obtendrá experiencia e ítems.
4.	Dado un Jugador, cuando su personaje acumule la experiencia necesaria para aumentar de nivel, entonces podrá agregar nuevas habilidades.

>3) 	Atacar personajes.
> Motivación: Para aumentar mi experiencia.  

 *Criterios de aceptación:*  
> 1.	Dado un Orco, cuando gane alguna batalla contra otro Personaje Jugador o Personaje Genérico, entonces el Orco aumentará su experiencia acorde al nivel del derrotado.  
> 2.	Dado un Humano, cuando gane alguna batalla contra otro Personaje Jugador o Personaje Genérico, entonces el Humano aumentará su experiencia acorde al nivel del derrotado.  
> 3.	Dado un Elfo, cuando gane alguna batalla contra otro Personaje Jugador o Personaje Genérico, entonces el Elfo aumentará su experiencia acorde al nivel del derrotado. 

>4)	Como Personaje, quiero acumular experiencia. 
> Motivación: Para poder subir de nivel.

*Criterios de aceptación:*  
1.	Dado un Personaje, cuando acumule la cantidad de experiencia necesaria, entonces se incrementará su nivel. 	

> 5)	Como Personaje, quiero subir de nivel. 
Motivación: Para poder asignar puntos adicionales a mis habilidades.

*Criterios de aceptación:*  
1.	Dado un Personaje, cuando éste aumente su nivel, entonces se le otorgarán puntos adicionales para poder agregar a sus habilidades.
2.	Dado un Personaje, cuando éste aumente su nivel y acumule puntos de habilidades, entonces se le permitirá mejorar las habilidades existentes asignándoles puntos especiales.
3.	Dado un Personaje equipado con Items, cuando éste aumente su nivel podrá asignar puntos adicionales a sus habilidades, entonces podrá mejorar sus atributos para el manejo de ciertos Items.
4. 	Dado un Personaje, cuando éste aumente su nivel y alcance uno determinado, entonces podrá agregar una nueva habilidad que afecte sus atributos.    
>6)	 Como Personaje, Quiero aumentar mis habilidades. 
> Motivación: Para poder manipular ítems de manera más eficiente.

*Criterios de aceptación:*  
1.	Dado un Personaje, cuando aumenta de nivel y sus habilidades, entonces se incrementará el valor de ciertos atributos.
    
>7)	 Como Personaje, Quiero equipar Items. 
> Motivacion: Para poder potenciar mis habilidades.

*Criterios de aceptación:*  
1.	Dado un Personaje, cuando éste mata a otro Personaje Jugador o Personaje Genérico, entonces éste se equipará con el mejor Item de su enemigo.
2.	Dado un Personaje, cuando encuentre un ítem al recorrer el mundo donde se encuentra, entonces podrá equiparse con el mismo o agregarlo a su inventario.
3.	Dado un Personaje, cuando selecciona el ítem nuevo para equiparse, entonces éste será más fuerte con la combinación de ítem y habilidad.	

>8)	 Como Personaje, Quiero disponer de habilidades de destreza, fuerza e inteligencia.
> Motivación: Para afectar a mis puntos de ataque, magia y defensa.

*Criterios de aceptación:*  
1.	Dado un Personaje, cuando agrega a su lista de habilidades ‘Destreza’, entonces aumentará su velocidad y potencia.
2.	Dado un Personaje, cuando agrega a su lista de habilidades ‘Fuerza’, entonces aumentará su ataque y potencia.
3.	Dado un Personaje, cuando agrega a su lista de habilidades ‘Inteligencia’, entonces aumentará su ataque y potencia.
4.	Dado un Personaje, cuando agrega a su lista de habilidades ‘Velocidad’, entonces aumentará su velocidad y su ataque.
5.	Dado un Personaje, cuando agrega a su lista de habilidades ‘Evasión’, entonces aumentará su defensa.
6.	Dado un Personaje, cuando agrega a su lista de habilidades ‘Valentía’, entonces aumentará su ataque.          

> 9)	Como Personaje, Quiero encontrarme con otros personajes en el mismo mundo.
> Motivación: Para aliarme con ellos o combatir contra ellos.

*Criterios de aceptación:*  
1.	Dado un Personaje, cuando se encuentre cercano a otro e interactúen, entonces éste podrá unirse a la alianza de su nuevo compañero o formar una nueva.
2.	Dado un Personaje, cuando se encuentre cercano a otro e interactúen, entonces éste podrá combatir contra él hasta definir un ganador.

>10)	 Como Personaje, Quiero aliarme con otro personaje.
> Motivación: Para combatir junto a él y aumentar la experiencia que recolectamos en ese tiempo.

*Criterios de aceptación:*
1.	Dado un Personaje que pertenece a una Alianza, cuando resulten ganadores de un combate contra otra Alianza de Personajes Usuarios, entonces el sistema incrementará la experiencia de todos ellos.
2.	Dado un Personaje que pertenece a una Alianza, cuando resulten ganadores de un combate contra un Personaje Usuario, entonces el sistema incrementará la experiencia de todos ellos.
3. 	Dado un Personaje que pertenece a una Alianza, cuando resulten ganadores de un combate contra un Personaje Genérico, entonces el sistema incrementará la experiencia de todos ellos.

> 11)	Como Personaje, Quiero combatir contra otros jugadores.
> Motivación: Para obtener sus ítems al derrotarlos.

*Criterios de aceptación:*
1.	Dado un Personaje que pertenece a una Alianza, cuando éstos resultan ganadores de un combate, entonces se reparten los ítems de los perdedores entre los integrantes.
2.	Dado un Personaje, cuando finaliza el combate contra otro Personaje Usuario y resulta ganador, entonces se le entrega el mejor ítem de aquel Personaje Usuario derrotado.
3.	Dado un Personaje, cuando finaliza el combate contra un Personaje Genérico y resulta ganador, entonces se le entrega el mejor ítem del Personaje Genérico.

>12)	 Como Personaje, quiero cambiar las alianzas establecidas cada cierta cantidad de tiempo.
> Motivación: Para poder traicionar a mis aliados.

*Criterios de aceptación:*
1.	Dado un Personaje miembro de una Alianza, cuando se exceda el tiempo mínimo de pertenencia en la misma y decida abandonarla, entonces el Personaje deja de formar parte de ésta.

> 13)	Como Personaje, puedo morir en combate.
> Motivación: Reaparecer en una zona segura.

*Criterios de aceptación:*
1.	Dado un Personaje, cuando éste es derrotado en combate, entonces reaparece en el lugar seguro designado en el mundo donde se encuentra.

>14)	 Como Personaje, quiero agregar ataques.
> Motivación: Para poder hacer más daño.

*Criterios de aceptación:*
1.	Dado un Personaje, cuando luego de acumular experiencia alcanza un determinado nivel, entonces se le otorgará un nuevo ataque.
>15)	 Como Personaje, quiero dirigirme al lugar seguro.
> Motivación: Para recuperar salud.

*Criterios de aceptación:*
1.	Dado un Personaje, cuando se encuentre con la salud baja, entonces podrá dirigirse a la zona segura donde su salud comenzará a incrementarse.

