import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ConsoleInput 
{

	private InputStreamReader input;
	private BufferedReader reader;
	
	public ConsoleInput ()
	{
		input=new InputStreamReader (System.in);
		reader=new BufferedReader(input);
	}
	
	public int readInt() throws NumberFormatException, IOException
	{
		return (Integer.parseInt(reader.readLine()));
	}
	
	public short readShort() throws NumberFormatException, IOException
	{
		return (Short.parseShort(reader.readLine()));
	}
	
	public long readLong() throws NumberFormatException, IOException
	{
		return (Long.parseLong(reader.readLine()));
	}
	
	public byte readByte() throws NumberFormatException, IOException
	{
		return (Byte.parseByte(reader.readLine()));
	}
	
	public float readFloat() throws NumberFormatException, IOException
	{
		return (Float.parseFloat(reader.readLine()));
	}
	
	public double readDouble() throws NumberFormatException, IOException
	{
		return (Double.parseDouble(reader.readLine()));
	}
	
	public boolean readBoolean() throws NumberFormatException, IOException
	{
		return (Boolean.parseBoolean(reader.readLine()));
	}
	
	public char readChar() throws IOException
	{
		return (reader.readLine().charAt(0));
	}
	
	public String readString() throws IOException
	{
		return reader.readLine();
	}
	
	public Date readDate() throws ParseException, IOException
	{
		SimpleDateFormat data= new SimpleDateFormat("dd/MM/yyyy");
		return (data.parse(reader.readLine()));
	}
	
{
		
	}
}
