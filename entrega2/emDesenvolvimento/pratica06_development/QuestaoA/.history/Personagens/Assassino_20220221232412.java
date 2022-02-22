package Personagens;

/**
 * Write a description of class Assassino here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Assassino implements Personagem
{
    private String tipo;
    private Ataca ataque;

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
