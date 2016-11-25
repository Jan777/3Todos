package servidor;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

// obtenido de https://andrejserafim.wordpress.com/2010/10/07/testing-threads-with-junit/s
public class ServidorTest {

	@Test
	public void pruebaThreadServidor() throws InterruptedException{
		 Servidor s = new Servidor() {
		     @Override 
		     public void run() {
		    	 Assert.fail();
		      }           
	     };
		Thread t1 = new Thread(s);
		t1.start();
		t1.join();
	}

	@Test public void testCase2Threads() throws InterruptedException {
        final ArrayList<Integer> threadsCompleted = new ArrayList< Integer >();
        Runnable runnable1 = new Runnable() {
            @Override 
            public void run() {
                Assert.fail();
                threadsCompleted.add(1);
            }
        };
         
        Runnable runnable2 = new Runnable() {
            @Override 
            public void run() {
                Assert.assertTrue( true );
                threadsCompleted.add(2);
            }
        };
         
        Thread t1 = new Thread( runnable1 );
        Thread t2 = new Thread( runnable2 );
         
        t1.start();
        t2.start();
        t1.join();
        t2.join();
         
        System.out.println( "Threads completed: " + threadsCompleted );
        Assert.assertEquals(2, threadsCompleted.size());
    }
	
	
	
}
