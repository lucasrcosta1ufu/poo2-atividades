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
    private Jogador jogador;
    private Robo robo;
    private int limiteInferior, limiteSuperior;
    
    public Estado(Jogador jogador)
    {
        this.jogador = jogador;
        setLimites();
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
    
    public void perdeVida(int lostLife)
    {
        this.jogador.setQuantidade(this.jogador.getQuantidade() - lostLife);
        verificaEstado();
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
    
    public abstract void setLimites();
    
    public abstract void dano(int dano);
    
    public abstract void verificaEstado();
    
}
