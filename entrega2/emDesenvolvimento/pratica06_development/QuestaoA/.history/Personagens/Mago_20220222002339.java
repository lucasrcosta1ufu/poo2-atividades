package Personagens;

import Ataque.*;

public class Mago extends Personagem {
	private static final String path = "./res/character2.png";

	public Mago() {
		super("Mago", Mago.path);
		super.setAtaque(new AtacaMedio());
	}
}
