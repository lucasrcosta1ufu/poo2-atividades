package Personagens;

import Ataque.*;

public class Druida extends Personagem {
	private static String path = "./res/character0.png";

	public Druida() {
		super("Druida", path);
		super.setAtaque(new AtacaFraco());
	}
}
