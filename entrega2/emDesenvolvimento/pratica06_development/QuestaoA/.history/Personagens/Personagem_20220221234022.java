package Personagens;

import Ataque.Ataca;
import Helpers.Image;

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

    public Personagem(ImageIO character)
    {
        this.character = character;
    }

    public Personagem(String path)
    {
        this.character = Image.getImage(path);
    }

    public Personagem(String tipo, ImageIO character)
    {
        this.tipo = tipo;
        this.character = character;
    }

    public Personagem(String tipo, String path)
    {
        this.tipo = tipo;
        this.character = Image.getImage(path);
    }

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