package Personagens;

public class Mago implements Personagem
{
	private String path = "./res/character2.png";
	
	public Mago()
	{
		super("Mago", path);
		super.setAtaque(new AtacaMEdio());
	}
}
