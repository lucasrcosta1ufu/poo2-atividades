package Personagens;

import Ataque.*;

public class Assassino extends Personagem {
	private static final String path = "./res/character4.png";

	public Assassino() {
		super("Assassino", Assassino.path);
		super.setAtaque(new AtacaForte());
	}
}
