package Personagens;

import Ataque.*;

public class Sacerdote implements Personagem
{
	private String path = "./res/character3.png";
	
	public Sacerdote()
	{
		super("Sacerdote", path);
		super.setAtaque(new AtacaFraco());
	}
}
