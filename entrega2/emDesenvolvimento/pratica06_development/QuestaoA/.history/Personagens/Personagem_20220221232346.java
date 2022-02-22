package Personagens;

import Ataque.Ataca;

/**
 * Write a description of interface Personagem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Personagem
{
    private String tipo;
    private Ataca ataque;
    private ImageIO character;

	public ImageIO getCharacter() {
		return this.character;
	}

	public void setCharacter(ImageIO character) {
		this.character = character;
	}

	public void setTipo(String tipo);

	public void setAtaque(Ataca ataque);

	public String getTipo();

	public Ataca getAtaque();
}
