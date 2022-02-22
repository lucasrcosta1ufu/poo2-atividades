package Personagens;

import Ataque.*;

public class Assassino extends Personagem
{
	private String path = "./res/character4.png";
	
	public Assassino()
	{
		super("Assassino", path);
		super.setAtaque(new AtacaForte());
	}
}
