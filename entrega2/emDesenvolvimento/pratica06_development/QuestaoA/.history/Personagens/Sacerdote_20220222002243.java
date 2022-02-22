package Personagens;

import Ataque.*;

public class Sacerdote extends Personagem {
	private static String path = "./res/character3.png";

	public Sacerdote() {
		super("Sacerdote", path);
		super.setAtaque(new AtacaFraco());
	}
}
