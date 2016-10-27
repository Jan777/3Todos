package criterios_aceptacion;

import java.io.Console;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import habilidades.*;
import items.*;
import razas.*;

// Falta todo


/***
 * 
 * 12)	 Como Personaje, quiero cambiar las alianzas establecidas cada cierta cantidad de tiempo.
 * Motivación: Para poder traicionar a mis aliados.
 * 
 ***/

public class Historia12Test {


	/***
	 * 
	 * 1.	Dado un Personaje miembro de una Alianza, cuando se exceda el tiempo mínimo de pertenencia en la 
	 * misma y decida abandonarla, entonces el Personaje deja de formar parte de ésta. 
	 * 
	 ***/
	
	@Test
	public void historia12Criterio01_Test() throws FileNotFoundException{
		
		Long inicio = System.currentTimeMillis();
		Alianza pro = crearAlianzaPro();
		//Assert.assertEquals(2, pro.cantidadMiembrosAlianza());
		Personaje p = new Humano("Mauricio Macri","123");
		Scanner in = new Scanner(System.in);
		System.out.println("¿Desea salir de la alianza?S/N: ");
    	String respuesta = in.nextLine();
    	if(respuesta.equals("S"))
    	{
        	pro.dejarAlianza(p);
    		Assert.assertEquals(1, pro.cantidadMiembrosAlianza());
    	}
    	in.close();
    	/*
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

	        @Override
	        public void run()
	        {
	        	Long fin = System.currentTimeMillis();
	        	System.out.println(fin - inicio);
	        	if(fin - inicio > 6000)
	        	{
		        	
		    		timer.cancel();
	        	}
	        }
	        };
	    timer.schedule(task, 10, 1000);*/
	}
	
	private Alianza crearAlianzaPro()
	{
		Personaje p1 = new Humano("Mauricio Macri","123");
		Personaje p2 = new Humano("Eugenia Vidal","123");
		p1.setClase(new Chaman());
		p2.setClase(new Guerrero());
		p1.setUbicacion(new Ubicacion(0, 0));
		p2.setUbicacion(new Ubicacion(3, 0));
		
		/*
		 * Creaciï¿½n de alianza
		 * */
		Alianza a = new Alianza("Pro");
		
		/*
		 * Agrego personajes a la Alianza 
		 * */
		
		a.formarAlianza(p1);
		
		for(Personaje p : a.getIntegrantes())
		{
			/*Verifico que estén cerca en un radio = 2*/
			if(p2.seEncuentraCerca(p))
			{
				a.formarAlianza(p2);
				break;
			}
		}
		return a;
	}
	
	
	/***
	 * 
	 * 2.	Dado un Personaje, cuando se encuentre cercano a otro e interactúen, entonces éste podrá combatir 
	 * contra él hasta definir un ganador.
	 * 
	 ***/
	
	@Test
	public void historia12Criterio02_Test() throws FileNotFoundException{
		/*
		 * @mauroat - 24/10/16:
		 * Creo odavía no puede probarse
		 * */
		
	}
	
	
}
