 package game.States;

import game.Ataque.AtaqueFraco;
import game.Inimigo.Robo;
import game.Movimento.MovimentoDevagar;
import game.Personagem.Jogador;


/**
 * Write a description of class EstadoPerigo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EstadoPerigo extends Estado
{
    private Jogador jogador;
    private Robo robo;
    private int limiteInferior, limiteSuperior;
    private static EstadoPerigo instancia = null;
    
    public EstadoPerigo(Jogador jogador)
    {
        this.jogador = jogador;
        this.jogador.setMovimento(new MovimentoDevagar());
        this.jogador.setAtaque(new AtaqueFraco());
        
        setLimites();
        System.out.println("Estado Perigo");
    }
    
    @Override
    public void setLimites()
    {
        this.setLimiteInferior(0);
        this.setLimiteSuperior(29);
    }
    
    @Override
    public void verificaEstado()
    {
        if(this.getJogador().getQuantidade() <= this.getLimiteInferior()) {
            this.getJogador().setVida(EstadoMorto.getInstancia(this.getJogador()));
        } else if(this.getJogador().getQuantidade() > this.getLimiteSuperior()) {
            this.getJogador().setVida(EstadoNormal.getInstancia(this.getJogador()));
        }
    }
    
    @Override
    public void dano(int dano)
    {
        this.perdeVida(dano);
    }
    
    public static synchronized EstadoPerigo getInstancia(Jogador jogador) {
        if (instancia == null) {
            instancia = new EstadoPerigo(jogador);            
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
}
