# Problema-de-los-Fumadores-en-Java
Considere una zona de fumadores en donde se encuentran 3 fumadores y un tabaquero.  
1. Cada fumador representa un hilo que realiza la actividad de “fumar” de manera infinita. 
2. Cada fumador debe esperar antes de fumar a que se den ciertas condiciones (tener todos los suministros para fumar), que dependen de la actividad del hilo que representa al tabaquero. 
3. El tabaquero produce suministros para que los fumadores puedan fumar, también en un bucle infinito. 
4. Es importante tener en cuenta que la solución que se diseñe deberá permitir que varios fumadores fumen simultáneamente para asegurar una “concurrencia real”.  

Requisitos del funcionamiento de los fumadores y del tabaquero:  
* Antes de fumar es necesario hacer un cigarro, para ello el fumador necesita tres ingredientes: tabaco, papel arroz y cerillos. 
* Uno de los fumadores tiene solamente papel arroz, otro solamente tabaco y el otro tiene solamente cerillos. 
* El tabaquero coloca aleatoriamente en el mostrador de la zona de fumadores dos ingredientes diferentes de los tres que se necesitan para hacer un cigarro, a continuación desbloquea al fumador que tiene el tercer ingrediente y después espera el aviso. 
* El fumador desbloqueado toma los dos ingredientes del mostrador, avisa al tabaquero para que pueda seguir sirviendo ingredientes y fuma durante un tiempo después de hacer su cigarro. 
* El tabaquero vuelve a poner dos ingredientes aleatorios en el mostrador y se repite el ciclo.    Además para poder encontrar una solución segura al problema de los fumadores:   Los fumadores retiran los ingredientes del mostrador de una sola vez.  Un fumador sólo vuelve a crear su cigarro cuando terminó de fumarse su último cigarrillo.  “Fumar” lleva un tiempo, que se puede simular utilizando el método sleep(…).  Los fumadores no pueden reservarse ingredientes que ya estén depositados en el mostrador para formar el siguiente cigarro. Por ejemplo, si el tabaquero coloca tabaco y papel, mientras que el fumador que tiene los cerillos está fumando, el tabaco y el papel permanecerán en el mostrador hasta que el fumador aludido termine de fumar su cigarro y retire de una sola vez dichos ingredientes del mostrador.   

REQUISITOS QUE HA DE SATISFACER EL PROGRAMA:   
1. Utilizar un monitor para programar la sincronización entre los hilos en la simulación del problema. 
2. No se permite el uso de bloques synchronized dentro del código de los hilos. El uso de synchronized deberá estar en el recurso compartido (monitor), es decir, sus métodos deberán estar sincronizados. 
3.  Para implementar la comunicación entre los hilos deberán utilizarse las instrucciones wait() y notify() o notifyAll(). 
4. No use la instrucción sleep(…)  dentro de un método synchronized.   

ACTIVIDADES A REALIZAR:  
1. Implementar un programa concurrente en Java que solucione el problema de los fumadores de acuerdo con la especificación anterior  hilos, exclusión mutua, monitores, sincronización y comunicación. 
2. No deberá haber interbloqueos entre los hilos evitando así el bloqueo del programa. 
3. Se deberán producir mensajes en la salida estándar que permitan hacer un seguimiento de la ejecución de los hilos, por ejemplo: 
* El tabaquero deberá indicar cuándo produce suministros y qué suministros produce.
* Cada fumador debe indicar cuándo espera, qué productos espera y cuando comienza y finaliza de fumar. 
