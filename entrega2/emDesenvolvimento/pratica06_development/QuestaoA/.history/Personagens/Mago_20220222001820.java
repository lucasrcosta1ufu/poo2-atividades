package Personagens;

import Ataque.*;

public class Mago extends Personagem
{
	private String path = "./res/character2.png";
	
	public Mago()
	{
		super("Mago", path);
		super.setAtaque(new AtacaMedio());
	}
}
