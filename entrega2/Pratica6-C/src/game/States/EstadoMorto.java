package game.States;

import game.Personagem.Jogador;

/**
 * Write a description of class EstadoMorto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EstadoMorto extends Estado
{
    public EstadoMorto(Jogador jogador)
    {
        super(jogador);
        System.out.println("Morto");
        morte();
    }
    
    @Override
    public void setLimites()
    {
        this.setLimiteInferior(0);
        this.setLimiteSuperior(0);
    }
    
    @Override
    public void verificaEstado()
    {
        if(this.getJogador().getQuantidade() < this.getLimiteInferior()){
            this.getJogador().setVida(new EstadoMorto(this.getJogador()));
        }else if(this.getJogador().getQuantidade() > this.getLimiteSuperior()){
            this.getJogador().setVida(new EstadoMorto(this.getJogador()));
        }
    }
    
    @Override
    public void perdeVida(int lostLife)
    {
        this.morte();
    }
    
    public void morte()
    {
        javax.swing.JOptionPane.showMessageDialog(null, "Game Over :/");
        System.exit(0);
    }
    
    @Override
    public void dano(int dano)
    {
        this.morte();
    }
}
