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
    public EstadoPerigo(Jogador p){
        super(p);
        p.setC(new MovimentoDevagar());
        p.setA(new AtaqueFraco());
        System.out.println("Estado Perigo");
    }
    
    @Override
    public void setLimites(){
        this.setLimiteInferior(0);
        this.setLimiteSuperior(29);
    }
    
    @Override
    public void verificaEstado(){
        if(this.getP().getQuantidade() <= this.getLimiteInferior()){
            this.getP().setVida(new EstadoMorto(this.getP()));
        }else if(this.getP().getQuantidade() > this.getLimiteSuperior()){
            this.getP().setVida(new EstadoNormal(this.getP()));
        }
    }
    
    @Override
    public void dano(int dano){
        this.perdeVida(dano);
    }
}
