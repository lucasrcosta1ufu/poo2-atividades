package game.States;

import game.Ataque.AtaqueForte;
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
    public EstadoForte(Jogador jogador)
    {
        super(jogador);
        jogador.setMovimento(new MovimentoRapido());
        jogador.setAtaque(new AtaqueForte());
        System.out.println("Estado Forte");
    }
    
    @Override
    public void setLimites()
    {
        this.setLimiteInferior(71);
        this.setLimiteSuperior(100);
    }
    
    @Override
    public void verificaEstado()
    {
        if(this.getJogador().getQuantidade() <= this.getLimiteInferior()){
            this.getJogador().setVida(new EstadoNormal(this.getJogador()));
        }else if(this.getJogador().getQuantidade() > this.getLimiteSuperior()){
            this.getJogador().setVida(new EstadoForte(this.getJogador()));
        }
    }
    
    @Override
    public void dano(int dano)
    {
        this.perdeVida(dano);
    }
}
