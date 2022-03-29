 package game.Models.States;

import game.Models.Ataque.AtaqueFraco;
import game.Models.Inimigo.Inimigo;
import game.Models.Movimento.MovimentoDevagar;
import game.Models.Personagem.Jogador;


/**
 * Write a description of class EstadoPerigo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EstadoPerigo extends Estado
{
    private Jogador jogador;
    private Inimigo robo;
    private int limiteInferior, limiteSuperior;
    private static EstadoPerigo instancia = null;
    
    private EstadoPerigo(Jogador jogador)
    {
        this.jogador = jogador;
        this.jogador.setMovimento(MovimentoDevagar.getInstance());
        this.jogador.setAtaque(AtaqueFraco.getInstance());
        
        setLimites();
        System.out.println("Estado Perigo");
    }
    
    public static synchronized EstadoPerigo getInstance(Jogador jogador) {
        if(instancia == null) {
            instancia = new EstadoPerigo(jogador);
        }
        return instancia;
    }
    
    @Override
    public final void setLimites()
    {
        this.setLimiteInferior(0);
        this.setLimiteSuperior(34);
    }
    
    @Override
    public void verificaEstado()
    {
        if(this.getJogador().getQuantidade() <= this.getLimiteInferior()) {
            this.getJogador().setVida(EstadoMorto.getInstance(this.getJogador()));
        } else if(this.getJogador().getQuantidade() > this.getLimiteSuperior()) {
            this.getJogador().setVida(EstadoNormal.getInstance(this.getJogador()));
        }
    }
    
    @Override
    public void dano(int dano)
    {
        this.perdeVida(dano);
    }
    
    public Jogador getJogador()
    {
        return this.jogador;
    }
    
    public void setJogador(Jogador jogador)
    {
        this.jogador = jogador;
    }
    
    public Inimigo getRobo()
    {
        return this.robo;
    }
    
    public void setRobo(Inimigo robo)
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
