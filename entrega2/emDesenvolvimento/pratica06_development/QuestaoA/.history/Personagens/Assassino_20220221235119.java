package Personagens;

public class Assassino implements Personagem
{
	private String path = "./res/character4.png";
	
	public Assassino()
	{
		super("Assassino", path);
		super.setAtaque(new AtacaForte());
	}
}
