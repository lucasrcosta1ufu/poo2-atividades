package Personagens;

import Ataque.*;

public class Paladino extends Personagem {
	private static final String path = "./res/character1.png";

	public Paladino() {
		super("Paladino", Paladino.path);
		super.setAtaque(new AtacaForte());
	}
}
