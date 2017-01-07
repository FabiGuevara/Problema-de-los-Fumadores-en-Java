
//  FABIOLA GUEVARA SORIANO
//  DANIEL REYES SANCHEZ


import java.util.Random;

public class Tabaquero extends Thread
{
    private final boolean SELECCIONADO=true;
    private final boolean NOSELECCIONADO=false;

    private Mostrador mostrador;
    private long milis;
    int fumadorSeleccionado;
    private String nombre ;

    public Tabaquero(long milis, Mostrador suministros) 
    {
        this.milis = milis;
        this.mostrador = suministros;
        fumadorSeleccionado = 2; // tenia 0
    }

    public void run()
    {
        while(true)
        {
            //la primera vez todos los fumadores estan bloqueados, por lo que el tabaquero toma el mostrador:::

            fumadorSeleccionado = ((int) (Math.random() * 3)); //se genera un numero aleatorio de 0-2
            
            
            mostrador.ComplacerFumador(fumadorSeleccionado); //se complace al fumador seleccionado
            if(fumadorSeleccionado==0)
            	nombre = "ALBERT";
            if(fumadorSeleccionado==1)
            	nombre = "DANIEL";
            if(fumadorSeleccionado==0)
            	nombre = "ALFREDO";
            	 
            System.out.println("TABAQUERO suministrando a: " + nombre ); // fumadorSeleccionado);

            mostrador.EsperandoAFumador(fumadorSeleccionado);
        }
    }
}

