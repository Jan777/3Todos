## **Historia de usuario** ##  

> Como Jugador, Quiero crear mi personaje, editando sus características principales (como raza y casta) 
> Resultado: Quiero verme reflejado en mi avatar  

 *Criterios de aceptación:*  

1. 	Titulo: Seleccionar raza  
	Contexto: El jugador quiere editar su raza.  
	Evento: El jugador presiona editar.  
	Resultado: El sistema mostrará tres opciones: Orco, Elfo y Humano.  
	
2. 	Titulo: Seleccionar casta  
	Contexto: El jugador quiere editar su raza.
	Evento: El jugador presiona editar.  
	Resultado: El sistema mostrará tres opciones: Hechicero, Guerrero y Chaman.  
	
3.	Titulo: Raza seleccionada  
	Contexto:El jugador elige una raza.  
	Evento: El jugador seleccionó una raza.
	Resultado: El sistema guarda la nueva raza del personaje.

4.	Titulo: Casta seleccionada  
	Contexto:El jugador elige una casta.  
    Evento: El jugador seleccionó una casta.  
	Resultado: El sistema guarda la nueva casta del personaje.  
	
5.	Titulo: Personaje editado  
	Contexto: El jugador editó el personaje. 
	Evento: El jugador finaliza la edición.  
	Resultado: El sistema guarda el nuevo personaje creado.  

> Como Jugador, Quiero ingresar a un mundo  
> Resultado: Para adquirir experiencia, items y habilidades nuevas  
	
 *Criterios de aceptación:*  
	
1.	Titulo: Seleccionar mundo  
	Contexto: En caso que el jugador quiera comenzar una partida.  
	Resultado: El sistema creará un mundo con fantasmas genericos, lugares genericos y aliados si ya ingresaron al mismo sitio.  

2.	Titulo: Ver mundos disponibles  
	Contexto: En caso que el jugador quiera seleccionar un mundo.  
	Resultado: El sistema traerá un listado con los mundos disponibles.  

3.	Titulo: Obtener experiencia y habilidad  
	Contexto: En caso que el jugador quiera obtener experiencia y nuevas habilidades.  
	Evento: Cuando el jugador elimine a su enemigo o fantasma genérico.  
	Resultado: Obtendrá experiencia y habilidades.  

4.	Evento: Cuando el jugador derrote a su enemigo.  
	Resultado: Obtendrá el mejor ítem de su enemigo derrotado.  

> Como Orco, Quiero atacar para ganar experiencia  
> Resultado: Para aumentar mi experiencia  

 *Criterios de aceptación:*  
 
1.	Titulo: Quiero derrotar personajes para ganar experiencia. 
	Contexto: En caso que el Orco quiera incrementar su experiencia.
	Evento: Cuando el Orco derrote enemigos. 
	Evento(2): Cuando el Orco derrote personajes genéricos.
	Resultado: Su experiencia se incrementará de acuerdo al nivel de los derrotados.  

> Como Humano, Quiero atacar para ganar experiencia  
> Resultado: Para aumentar mi experiencia  

 *Criterios de aceptación:*  
 
1.	Titulo: Quiero derrotar personajes para ganar experiencia . 
	Contexto: En caso que el Huamno quiera incrementar su experiencia.
	Evento: Cuando el Humano derrote enemigos. 
	Evento(2): Cuando el Humano derrote personajes genéricos.
	Resultado: Su experiencia se incrementará de acuerdo al nivel de los derrotados.

> Como Elfo, Quiero atacar para ganar experiencia  
> Resultado: Para aumentar mi experiencia  

 *Criterios de aceptación:*  
 
1.	Titulo: Quiero derrotar personajes para ganar experiencia . 
	Contexto: En caso que el Elfo quiera incrementar su experiencia.
	Evento: Cuando el Elfo derrote enemigos. 
	Evento(2): Cuando el Elfo derrote personajes genéricos.
	Resultado: Su experiencia se incrementará de acuerdo al nivel de los derrotados.

> Como Personaje, Quiero acumular experiencia 
> Resultado: Para poder subir de nivel

*Criterios de aceptación:*  
	
1.	Titulo: Subir nivel  
	Contexto: El personaje podrá subir su nivel.
    Evento: Cuando el personaje derrote muchos enemigos.
	Resultado: Su experiencia se incrementará y podrá ir superando los límites de puntos para subir el nivel.  

> Como Personaje, Quiero subir de nivel 
> Resultado: Para poder asignar puntos adicionales a mis habilidades

*Criterios de aceptación:*  
	
1.	Titulo: Puntos adicionales  
	Contexto: El personaje derrota a sus enemigos.
    Evento: El personaje sube de nivel.
	Resultado: El personaje obtendrá puntos adicionales.  

2.	Titulo: Mejorar habilidades  
	Contexto: El personaje sube de nivel y acumula puntos adicionales.
    Evento: El personaje mejora sus habilidades.
	Resultado: El personaje podrá asignar los puntos adicionales a sus habilidades para mejorarlas.      
    
3.	Titulo: Mejorar manejo de Items  
	Contexto: El personaje se equipa con Items y mejora sus puntos en habilidades.
    Evento: El personaje mejora sus atributos.
	Resultado: El personaje mejorará sus atributos para tener mejor desempeño en los combates.      
    
4.	Titulo: Agregar Habilidades  
	Contexto: El personaje se añade una habilidad.
    Evento: El personaje suma una habilidad.
	Resultado: El personaje tendra una nueva habilidad que afecte sus atributos.
    
> Como Personaje, Quiero aumentar mis habilidades 
> Resultado: Para poder manipular items de manera mas eficiente

*Criterios de aceptación:*  
	
1.	Titulo: Mejorar atributos  
	Contexto: El personaje aumenta sus habilidades e incrementa el valor de ciertos atributos.
    Evento: El personaje aumenta el valor de sus atributos.
	Resultado: El personaje aumentará el valor de sus atributos.      
    
> Como Personaje, Quiero equipar items 
> Resultado: Para poder potenciar mis habilidades

*Criterios de aceptación:*  
	
1.	Titulo: Obtener Item  
	Contexto: El personaje quiere agregar un item.
    Evento: El personaje mata a otro personaje.
	Resultado: El personaje se equipará con el mejor item de su enemigo.         
    
2.	Titulo: Obtener Item  
	Contexto: El personaje quiere agregar un item.
    Evento: El personaje encuentra un item.
	Resultado: El personaje se equipará con un item que encuentre en el mapa.         
        
3.	Titulo: Atributos mejorados  
	Contexto: El personaje tiene un nuevo item.
    Evento: El personaje selecciona el item nuevo.
	Resultado: El personaje será mas fuerte con la combinación de item y habilidad.

> Como Personaje, Quiero disponer de habilidades de destreza, fuerza e inteligencia.
> Resultado: Para afectar a mis puntos de ataque, magia y defensa.

*Criterios de aceptación:*  
	
1.	Titulo: Destreza
	Contexto: El personaje quiere disponer de destreza.
    Evento: El personaje agrega a su lista de habilidades la Destreza
	Resultado: La destreza aumentará la velocidad y potencia.
         
    
2.	Titulo: Fuerza 
	Contexto: El personaje quiere disponer de fuerza.
    Evento: El personaje agrega a su lista de habilidades la Fuerza.
	Resultado: La fuerza aumentará los puntos de ataque y potencia.         
        
3.	Titulo: Inteligencia  
	Contexto: El personaje quiere disponer de inteligencia.
    Evento: El personaje agrega a su lista de habilidades la Inteligencia.
	Resultado: La inteligencia aumentará la magia (en caso de tenerla) y la defensa.

4.	Titulo: Velocidad
	Contexto: El personaje quiere disponer de velocidad.
    Evento: El personaje agrega a su lista de habilidades la Velocidad.
	Resultado: La velocidad aumentará el ataque y la velocidad.
 

5.	Titulo: Evasion 
	Contexto: El personaje quiere disponer de evasión.
    Evento: El personaje agrega a su lista de habilidades la Evasion.
	Resultado: La evasión aumentará la defensa.

6.	Titulo: Valentia
	Contexto: El personaje quiere disponer de valentía.
    Evento: El personaje agrega a su lista de habilidades la Valentia.
	Resultado: La valentía aumentará el ataque.
          

> Como Personaje, Quiero encontrarme con otros personajes en el mismo mundo.
> Resultado: Para aliarse a ellos o combatir contra ellos.

*Criterios de aceptación:*  
	
1.	Titulo: Alianzas
	Contexto: Dos o más personajes se encuentran cerca.
    Evento: Los personaje deciden unirse.
	Resultado: Los personajes forman una nueva alianza para combatir contra sus enemigos.
    
2.	Titulo: Combate
	Contexto: Dos o más personajes se encuentran cerca.
    Evento: Los personaje deciden atacarse.
	Resultado: Los personajes y sus alianzas combaten hasta definir un ganador.

> Como Personaje, Quiero aliarme con otro personaje.
> Resultado: Para combatir junto a él y aumentar la experiencia que recolectamos en ese tiempo.

*Criterios de aceptación:*

1.	Titulo: Combate junto a miembros
	Contexto: Miembros de una alianza deciden combatir.
    Evento: Combaten contra otra alianza.
	Resultado: El sistema incrementará la experiencia de los ganadores.
         
    
2.	Titulo: Alianza contra Personaje
	Contexto: Miembros de una alianza deciden combatir.
    Evento: Combaten contra un personaje.
	Resultado: El sistema incrementará la experiencia de los ganadores.         
        
3.	Titulo: Alianza contra PersonajeGenerico  
	Contexto: Miembros de una alianza deciden combatir.
    Evento: Combaten contra un personajeGenerico.
	Resultado: El sistema incrementará la experiencia de los ganadores.

> Como Personaje, Quiero combatir contra otros jugadores.
> Resultado: Para obtener sus items al derrotarlos.

*Criterios de aceptación:*

1.	Titulo: Alianza ganadora
	Contexto: Dos alianzas finalizan el combate.
    Evento: Cuando una alianza gana.
	Resultado: Se reparten los items de los perdedores.
         
    
2.	Titulo: Item de Personaje
	Contexto: Finaliza el combate entre dos personajes 
    Evento: Cuando un personaje gana a otro
	Resultado: El ganador recibe el mejor item del perdedor.         
        
3.	Titulo: Item de Genérico
	Contexto: Finaliza el combate entre un personaje y un generico.
    Evento: Cuando un personaje gana a un generico.
	Resultado: El personaje recibe el item del generico.

> Como Personaje,Quiero cambiar las alianzas establecidas cada cierta cantidad de tiempo.
> Resultado: Para poder traicionar a mis aliados.

*Criterios de aceptación:*

1.	Titulo: Salir de la alianza
	Contexto: Se cumple el tiempo limite minimo para salir de la alianza.
    Evento: El jugador decide salir la alianza.
	Resultado: El jugador deja de formar parte de la alianza.

> Como Personaje, puedo morir en combate.
> Resultado: Reaparecer en una zona segura.

*Criterios de aceptación:*

1.	Titulo: Reaparecer
	Contexto: El personaje es derrotado en combate.
    Evento: El personaje muere en combate.
	Resultado: El personaje reaparece en un lugar seguro.

> Como Personaje, Quiero agregar ataques.
> Resultado: Para poder hacer mas daño.

*Criterios de aceptación:*

1.	Titulo: Nuevo Ataque
	Contexto: El personaje adquiere experiencia y sube de nivel.
    Evento: El personaje alcanza un determinado nivel.
	Resultado: El personaje obtendrá un nuevo ataque.

> Como Personaje, Quiero dirigirme al lugar seguro.
> Resultado: Para recuperar salud.

*Criterios de aceptación:*

1.	Titulo: Sanar Personaje
	Contexto: El personaje tiene poca salud y quiere recuperarse.
    Evento: El personaje entra en la zona segura.
	Resultado: El personaje recupera su salud, pudiendo o no, llegar la misma al máximo.