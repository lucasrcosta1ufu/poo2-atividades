package game.States;


import game.Inimigo.Robo;
import game.Personagem.Jogador;


/**
 * Write a description of interface Estado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Estado
{    
    public abstract void setLimites();    
    public abstract void dano(int dano);    
    public abstract void verificaEstado();
    public abstract void ganhaVida();
}
