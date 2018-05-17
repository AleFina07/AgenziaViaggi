
public class Nodo 
{

	private Iscrizione info;
	private Nodo link;
	
	public Nodo (Iscrizione persona)
	{
		setInfo(persona);
		link=null;
	}

	public Iscrizione getInfo() {
		return info;
	}

	public void setInfo(Iscrizione info) 
	{
		this.info = new Iscrizione( info);
	}

	public Nodo getLink() {
		return link;
	}

	public void setLink(Nodo link) {
		this.link = link;
	}
}
