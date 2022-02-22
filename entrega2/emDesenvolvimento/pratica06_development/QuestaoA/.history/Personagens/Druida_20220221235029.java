package Personagens;

public class Druida implements Personagem
{
	private String path = "./res/character0.png";
	
	public Druida()
	{
		super("Druida", path);
		personagem.setAtaque(new AtacaFraco());
	}
}
