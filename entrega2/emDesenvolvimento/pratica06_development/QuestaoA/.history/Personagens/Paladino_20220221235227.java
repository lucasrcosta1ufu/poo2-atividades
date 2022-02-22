package Personagens;

import Ataque.*;

public class Paladino implements Personagem
{
	private String path = "./res/character1.png";
	
	public Paladino()
	{
		super("Paladino", path);
		super.setAtaque(new AtacaForte());
	}
}
