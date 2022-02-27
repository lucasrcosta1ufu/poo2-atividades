package game.States;

import game.Ataque.AtaqueMedio;
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
    public EstadoNormal(Jogador jogador)
    {
        super(jogador);
        jogador.setMovimento(new MovimentoRapido());
        jogador.setAtaque(new AtaqueMedio());
        System.out.println("Estado Normal");
    }
    
    @Override
    public void setLimites()
    {
        this.setLimiteInferior(30);
        this.setLimiteSuperior(70);
    }
    
    @Override
    public void verificaEstado()
    {
        if(this.getJogador().getQuantidade() <= this.getLimiteInferior()){
            this.getJogador().setVida(new EstadoPerigo(this.getJogador()));
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
