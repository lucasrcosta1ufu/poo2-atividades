package game.States;

import game.Inimigo.Robo;
import game.Personagem.Jogador;

/**
 * Write a description of class EstadoMorto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EstadoMorto extends Estado
{
    private Jogador jogador;
    private Robo robo;
    private int limiteInferior, limiteSuperior;
    private static EstadoMorto instancia = null;
    
    public EstadoMorto(Jogador jogador)
    {
        this.jogador = jogador;
        
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
            this.getJogador().setVida(EstadoMorto.getInstancia(this.getJogador()));
        }else if(this.getJogador().getQuantidade() > this.getLimiteSuperior()){
            this.getJogador().setVida(EstadoMorto.getInstancia(this.getJogador()));
        }
    }
    
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
    
    public static synchronized EstadoMorto getInstancia(Jogador jogador) {
        if (instancia == null) {
            instancia = new EstadoMorto(jogador);            
        }
        return instancia;
    }
    
    public Jogador getJogador()
    {
        return this.jogador;
    }
    
    public void setJogador(Jogador jogador)
    {
        this.jogador = jogador;
    }
    
    public Robo getRobo()
    {
        return this.robo;
    }
    
    public void setRobo(Robo robo)
    {
        this.robo = robo;
    }
    
    public int getLimiteInferior()
    {
        return this.limiteInferior;
    }
    
    public void setLimiteInferior(int limiteInferior)
    {
        this.limiteInferior = limiteInferior;
    }
    
    public int getLimiteSuperior(){
        return this.limiteSuperior;
    }
    
    public void setLimiteSuperior(int limiteSuperior)
    {
        this.limiteSuperior = limiteSuperior;
    }
    
    public void ganhaVida()
    {
        if(this.jogador.getQuantidade() >= 100){
            this.jogador.setQuantidade(100);
        } else {
            this.jogador.setQuantidade(this.jogador.getQuantidade() + 10);
        }
        verificaEstado();
    }
}
