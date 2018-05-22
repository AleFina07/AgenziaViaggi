import static org.junit.Assert.*;

import org.junit.Test;

public class IscrizioneTest {

	
	
	@Test
	public void testCostruttoreIscrizioneDefault() 
	{
		Iscrizione iscrizione=new Iscrizione();
		assertTrue("Costruttore di default Iscrizione",iscrizione.getId()==0);
	}

	@Test
	public void testSetId() 
	{
		Iscrizione iscritto=new Iscrizione();
		iscritto.setId(1);
		assertTrue("setIdAccesso",iscritto.getId()==1);
	}
	



}
