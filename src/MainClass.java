import java.io.IOException;
import java.time.LocalDateTime;

public class MainClass {

	public static void main(String[] args) 
	{
		LocalDateTime dataPartenza1=LocalDateTime.of(2018 , 5, 31, 0, 0);
		LocalDateTime dataPartenza2=LocalDateTime.of(2018 , 7, 6, 0, 0);
		LocalDateTime dataPartenza3=LocalDateTime.of(2018 , 8, 13, 0, 0);
		Iscrizione i1=new Iscrizione("Alessandro", "Finazzi"+" ", 1, dataPartenza1,"Maldive");
		Iscrizione i2=new Iscrizione("Alessandra", "Finazzo"+" ", 1, dataPartenza2,"Caraibi");
		Iscrizione i3=new Iscrizione("Alessandru", "Finassi"+" ", 1, dataPartenza3, "Egitto");
			
		
		
			System.out.println(i1.toString());
		
		
		
		//***************scrittura*********************
				try 
				{
					TextFile file=new TextFile("prova.txt", 'W');
					file.toFile("Prova1");
					file.toFile("Prova2");
					file.toFile("Prova3");
					file.closeFile();
					System.out.println("Scrittura effettuata correttamente");
				} 
				catch (IOException e) 
				{
					System.out.println("Impossibile aprire il file in scrittura");
				} catch (FileException e) 
				{
					System.out.println(e.toString());
				}
				
			
				//***************lettura*********************
				String rigaLetta;

				TextFile file2 = null;
				
				try 
				{
					file2=new TextFile("prova.txt", 'R');
					while(true)
					{
						rigaLetta=file2.fromFile();
						System.out.println(rigaLetta);
					}
					
				} 
				catch (IOException e) 
				{
					System.out.println("impossibile aprire il file in lettura");
				} 
				catch (FileException e) 
				{
					System.out.println(e.toString());
				} 
				catch (EccezioneTextFileEOF e) 
				{
					try 
					{
						file2.closeFile();
					} 
					catch (IOException e1) 
					{
						System.out.println("impossibile accedere al file");
					}
				}

	}

}
