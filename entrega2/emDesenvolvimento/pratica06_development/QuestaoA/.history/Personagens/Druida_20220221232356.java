package Personagens;

public class Druida implements Personagem
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
