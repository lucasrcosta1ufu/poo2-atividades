package game.States;

import game.Ataque.AtaqueMedio;
import game.Inimigo.Robo;
import game.Movimento.MovimentoRapido;
import game.Personagem.Jogador;


/**
 * Write a description of class EstadoNormal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EstadoNormal extends Estado
{
    private static Jogador jogador;
    private Robo robo;
    private int limiteInferior, limiteSuperior;
    private static EstadoNormal instancia = null;
    
    private EstadoNormal(Jogador jogador)
    {
        EstadoNormal.jogador = jogador;
        EstadoNormal.jogador.setMovimento(new MovimentoRapido());
        EstadoNormal.jogador.setAtaque(new AtaqueMedio());
        
        setLimites();
        System.out.println("Estado Normal");
    }
    
    public static synchronized EstadoNormal getInstance(Jogador jogador) {
        if(instancia == null) {
            instancia = new EstadoNormal(jogador);
        }
        return instancia;
    }
    
    @Override
    public final void setLimites()
    {
        this.setLimiteInferior(30);
        this.setLimiteSuperior(70);
    }
    
    @Override
    public void verificaEstado()
    {
        if(this.getJogador().getQuantidade() <= this.getLimiteInferior()){
            this.getJogador().setVida(EstadoPerigo.getInstancia(this.getJogador()));
        }else if(this.getJogador().getQuantidade() > this.getLimiteSuperior()){
            this.getJogador().setVida(EstadoForte.getInstancia(this.getJogador()));
        }
    }
    
    @Override
    public void dano(int dano)
    {
        this.perdeVida(dano);
    }
    
    public static synchronized EstadoNormal getInstancia(Jogador jogador) {
        if (instancia == null) {
            instancia = new EstadoNormal(jogador);            
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
