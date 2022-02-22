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

	public String getTipo();
	public void setTipo(String tipo);
	public Ataca getAtaque();
	public void setAtaque(Ataca ataque);
}
