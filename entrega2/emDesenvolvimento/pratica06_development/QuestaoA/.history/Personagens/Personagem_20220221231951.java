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
