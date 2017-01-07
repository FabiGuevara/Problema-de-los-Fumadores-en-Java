
//  FABIOLA GUEVARA SORIANO
//  DANIEL REYES SANCHEZ

public class Mostrador 
{
    private final boolean LIBRE=true;
    private final boolean OCUPADO=false;

    private final boolean TIENE=true;
    private final boolean NOTIENE=false;

    private final boolean QUIERO=true;
    private final boolean NOQUIERO=false;

    //boolean edoMostrador;
    
    boolean papelArroz, tabaco, cerillos;
    boolean []campana = new boolean[3]; 
    boolean []puedesFumar = new boolean[3]; 
    
    public Mostrador()
    {
        //edoMostrador=LIBRE;

        papelArroz = NOTIENE; 
        tabaco = NOTIENE;
        cerillos = NOTIENE;

        puedesFumar[0] = false;
        puedesFumar[1] = false;
        puedesFumar[2] = false;

    }

    public synchronized void PonerPapel()
    {
        papelArroz = TIENE;
        notifyAll();
    }

    public synchronized void PonerTabaco()
    {
        tabaco = TIENE;
        notifyAll();
    }

    public synchronized void PonerCerillos()
    {
       cerillos = TIENE;
       notifyAll();
    }

    public synchronized void DesbloquearFumador1()
    {
        //El fumador uno tiene papel arroz
        tabaco = NOTIENE;
        cerillos = NOTIENE;
        puedesFumar[0] = true;

        notifyAll();
		campana[0] = NOQUIERO;
      }

    public synchronized void DesbloquearFumador2()
    {
        //El fumador dos tiene tabaco
        papelArroz = NOTIENE;
        cerillos = NOTIENE;
        puedesFumar[1] = true;

        campana[1] = NOQUIERO;
        notifyAll();
    }

    public synchronized void DesbloquearFumador3()
    {
        //El fumador dos tiene cerillos
        papelArroz = NOTIENE;
        tabaco = NOTIENE;
        puedesFumar[2] = true;
        
        campana[2] = NOQUIERO;
        notifyAll();
    }

    //
    public synchronized void TomarCigarro(int fumador)
    {
        while(puedesFumar[fumador] == true)
        {
            try{
                wait();
            }catch(Exception e){}
    	}
        
        puedesFumar[fumador] = false;
        notifyAll();
    }

	// se detiene rapido
    public synchronized void SoltarCigarro (int fumador)
    {
        puedesFumar[fumador] = false;
        switch(fumador)
        {
            case 0 :
                    tabaco = NOTIENE;
                    cerillos = NOTIENE;
                    break;
            case 1 :
                    papelArroz = NOTIENE;
                    cerillos = NOTIENE;
                    break;
            case 2 :
                    papelArroz = NOTIENE;
                    tabaco = NOTIENE;
                    break;
            default :
                    System.out.println("Tus aleatorios estan mal (SOLTARCIGARRO), revisalos ;)");
        }
        notifyAll();
    }

	//No funciona
    public synchronized void ComplacerFumador(int fumador) // bloquea o desbloquea
    {
        while(campana[fumador] == OCUPADO)
        {
            try{
                wait();
            }catch(Exception e){}
        }

        switch(fumador)
        {
            case 0 :
                    DesbloquearFumador1();
                    break;
            case 1 :
                    DesbloquearFumador2();
                    break;
            case 2 :
                    DesbloquearFumador3();
                    break;
            default :
                    System.out.println("Tus aleatorios estan mal (COMPLACERFUMADOR), revisalos ;)");
        }
        notifyAll();
    }

    //No cambia
    public synchronized void EsperandoAFumador(int fumador)
    {
        while(puedesFumar[fumador] == true)
        {
            try{
                wait();
            }catch(Exception e){}
        }
        notifyAll();
    }

 	//No funciona
    public synchronized void TocarCampana(int opcion)
    {
        campana[opcion] = QUIERO;
    }
    
}

    /*
    //-----------------------------------------------------
    //FUNCIONES NO NECESARIAS

    public synchronized void TomarMostrador()    
    {
        while(edoMostrador==OCUPADO){
            try{
                wait();
            }catch(Exception e){}
        }
        
        edoMostrador=OCUPADO;
    }

    public synchronized  void SoltarMostrador() // No hay ningun recurso en el mostrador 
    {
        edoMostrador=LIBRE;
        notifyAll();
    }

    public synchronized boolean estadoMostrador()
    {
    	return edoMostrador;
    }
    */
