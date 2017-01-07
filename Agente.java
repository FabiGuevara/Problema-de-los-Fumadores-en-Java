/*
 * Será la clase que controle la distribución de los materiales
 * Pues estos son infinitos.
 */
package hilos;

/**
 *
 * @author qmarqeva
 */
public class Agente
{
    int numRepartos;
    int a;
    int b;

    public Agente()
    {
        a = 0;
        b = 2;
    }

    public int[] RepartirElemento()
    {
        int num[] = new int[2];
        a++;
        if(a==3)
            a = 0;
        b++;
        if(b==3)
            b = 0;
        num[0] = a;
        num[1] = b;
        return num;
    }
}
