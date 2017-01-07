
//  FABIOLA GUEVARA SORIANO
//  DANIEL REYES SANCHEZ
import java.util.Random;

public class ZonaFumadores 
{   
    public static void main(String[] args) 
    {
        Fumador []fumadores = new Fumador[3];  // tres fumadores
        Mostrador mostrador = new Mostrador(); // memoria compartida
        Tabaquero tabaquero = new Tabaquero(200,mostrador); 
        
        System.out.println("Bienvenidos, esta es la zona de fumadores");

        fumadores[0] = new Fumador("ALBERT ",300,mostrador,0); 
        fumadores[1] = new Fumador("DANIEL ",50,mostrador,1);
        fumadores[2] = new Fumador("ALFREDO ",5,mostrador,2);

        fumadores[0].start();
        fumadores[1].start();
        fumadores[2].start();
        tabaquero.start();
        
        try{
     	 	fumadores[0].join();
        	fumadores[1].join();
        	fumadores[2].join();
     	 	tabaquero.join();
        }catch(InterruptedException e){;}
    }
}
