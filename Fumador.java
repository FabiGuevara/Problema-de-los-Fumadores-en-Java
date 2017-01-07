/*
 * La Clase simula un fumador con cada uno de los métodos que debe realizar.
 */
package hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cúmar Cueva
 */
public class Fumador 
{
    private int Elemento;
    private String nombre;
    private boolean activo = false;
    
    public Fumador(String strNom, int Elem)
    {
        this.setElemento(Elem);
        this.setNombre(strNom);
    }

    /**
     * El proceso utilizará este método para determinar si los materiales de la mesa le sirven para empezar a fumar.
     * @param a
     * @param b
     * @return si puede o no fumar
     */
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
        } catch (InterruptedException ex) {
            Logger.getLogger(Fumador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return activo;
    }

    /**
     * Inicia el proceso de enrrollado del cigarrillo...
     * 
     * @throws java.lang.InterruptedException
     */
    public void Enrrollando() throws InterruptedException {
        System.out.println(this.getNombre() + "Enrrollando cigarrillo...");
        Thread.sleep(1 * 1000);
    }

    /**
     * El proceso que será consumido cuando todo este listo.
     * Se detiene el hilo principal para simular el proceso.
     * @throws java.lang.InterruptedException
     */
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
