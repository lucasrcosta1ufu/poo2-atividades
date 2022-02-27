package game.States;

import game.Ataque.AtaqueFraco;
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
    public EstadoPerigo(Jogador jogador)
    {
        super(jogador);
        jogador.setMovimento(new MovimentoDevagar());
        jogador.setAtaque(new AtaqueFraco());
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
        if(this.getJogador().getQuantidade() <= this.getLimiteInferior()){
            this.getJogador().setVida(new EstadoMorto(this.getJogador()));
        }else if(this.getJogador().getQuantidade() > this.getLimiteSuperior()){
            this.getJogador().setVida(new EstadoNormal(this.getJogador()));
        }
    }
    
    @Override
    public void dano(int dano)
    {
        this.perdeVida(dano);
    }
}
