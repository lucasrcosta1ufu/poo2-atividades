package game.States;

import game.Ataque.AtaqueForte;
import game.Inimigo.Robo;
import game.Movimento.MovimentoRapido;
import game.Personagem.Jogador;


/**
 * Write a description of class EstadoForte here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EstadoForte extends Estado
{
    private static Jogador jogador;
    private Robo robo;
    private int limiteInferior, limiteSuperior;
    private static EstadoForte instancia = null;
    
    private EstadoForte(Jogador jogador)
    {
        EstadoForte.jogador = jogador;
        EstadoForte.jogador.setMovimento(new MovimentoRapido());
        EstadoForte.jogador.setAtaque(AtaqueForte.getInstance());
        
        setLimites();
        System.out.println("Estado Forte");
    }
    
    public static synchronized EstadoForte getInstance(Jogador jogador) {
        if(instancia == null) {
            instancia = new EstadoForte(jogador);
        }
        return instancia;
    }
    
    @Override
    public final void setLimites()
    {
        this.setLimiteInferior(71);
        this.setLimiteSuperior(100);
    }
    
    @Override
    public void verificaEstado()
    {
        if (this.getJogador().getQuantidade() <= this.getLimiteInferior()) {
            this.getJogador().setVida(EstadoNormal.getInstance(this.getJogador()));
        }
    }
    
    @Override
    public void dano(int dano)
    {
        this.perdeVida(dano);
    }
    
    public static synchronized EstadoForte getInstancia(Jogador jogador) {
        if (instancia == null) {
            instancia = new EstadoForte(jogador);            
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
