package Personagens;

import Ataque.*;

public class Paladino extends Personagem {
	private static String path = "./res/character1.png";

	public Paladino() {
		super("Paladino", path);
		super.setAtaque(new AtacaForte());
	}
}
