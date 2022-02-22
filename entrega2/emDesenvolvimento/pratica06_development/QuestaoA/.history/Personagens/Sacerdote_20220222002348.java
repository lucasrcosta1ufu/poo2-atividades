package Personagens;

import Ataque.*;

public class Sacerdote extends Personagem {
	private static final String path = "./res/character3.png";

	public Sacerdote() {
		super("Sacerdote", Sacerdote.path);
		super.setAtaque(new AtacaFraco());
	}
}
