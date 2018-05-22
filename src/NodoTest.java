import static org.junit.Assert.*;

import org.junit.Test;

public class NodoTest 
{

		@Test
		public void testCostruttoreNodo() 
		{
			Iscrizione iscritto=new Iscrizione();
			Nodo n=new Nodo(iscritto);
			assertTrue("Costruttore nodo", n.getInfo().equals(iscritto) && n.getLink()==null);
		}

		@Test
		public void testSetInfo() 
		{
			Iscrizione i=new Iscrizione();
			Iscrizione i1=new Iscrizione();
			Nodo n=new Nodo(i);
			n.setInfo(i1);
			assertTrue("setInfo",n.getInfo().equals(i1) && n.getLink()==null);
		}
		
		@Test
		public void testSetLink() 
		{
			Iscrizione i=new Iscrizione();
			Iscrizione i1=new Iscrizione();
			Nodo nodo1=new Nodo(i);
			Nodo nodo2=new Nodo(i1);
			nodo1.setLink(nodo2);
			assertTrue("setLink",nodo1.getInfo().equals(i1) && nodo1.getLink()==nodo2);
		}
	}


