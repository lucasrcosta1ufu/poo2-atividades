package Personagens;

import Ataque.Ataca;

/**
 * Write a description of interface Personagem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Personagem
{
    private String tipo;
    private Ataca ataque;
    private ImageIO character;

    public Personagem(ImageIO ca)

	public ImageIO getCharacter()
	{
		return this.character;
	}

	public void setCharacter(ImageIO character)
	{
		this.character = character;
	}

	public String getTipo()
    {
		return this.tipo;
	}

	public void setTipo(String tipo)
    {
		this.tipo = tipo;
	}

	public Ataca getAtaque()
    {
		return this.ataque;
	}

	public void setAtaque(Ataca ataque)
    {
		this.ataque = ataque;
	}
}
