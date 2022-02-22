package Personagens;

import Ataque.*;

public class Druida extends Personagem
{
	private String path = "./res/character0.png";
	
	public Druida()
	{
		super("Druida", path);
		super.setAtaque(new AtacaFraco());
	}
}
