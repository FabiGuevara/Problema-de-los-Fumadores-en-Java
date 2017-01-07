/*
 * La Clase simula un fumador con cada uno de los métodos que debe realizar.
 */

public class Fumador1 
{
    private int Elemento;
    private String nombre;
    private boolean activo = false;
    private Mostrador mostrador;
    private long milis;
    private int recurso;
    
    public Fumador1(String Nombre, int recurso)
    {
        this.setElemento(recurso);
        this.setNombre(Nombre);
    }

    /* El proceso utilizara este metodo para determinar si los materiales de la mesa le sirven para empezar a fumar.
       return si puede o no fumar  */
    
    public boolean puedoFumar(int a, int b) 
    {        
        try 
        {
        	activo = false;            
            if ((a + b + Elemento) == 3)
            {
                activo = true;
                Enrrollando();
                Fumando();                
            }
        } 
        	catch (InterruptedException ex) {;}
        return activo;
    }

    /** Inicia el proceso de enrrollado del cigarrillo...  */
    public void Enrrollando() throws InterruptedException {
        System.out.println(this.getNombre() + "Enrrollando cigarrillo...");
        Thread.sleep(1 * 600);
    }

    /**
     * El proceso que será consumido cuando todo este listo.
     * Se detiene el hilo principal para simular el proceso.     */   
     	
     	public void Fumando() throws InterruptedException {
        System.out.println("Empezando a fumar....");
        Thread.sleep(((int) (Math.random() * 10)) * 500);
        System.out.println("Termina de fumar...");
    }

    public int getElemento() 
    {
        return Elemento;
    }

    public void setElemento(int Elemento)
    {
        this.Elemento = Elemento;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public boolean isActivo()
    {
        return activo;
    }

    public void setActivo(boolean activo)
    {
        this.activo = activo;
    }
}
