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
    public EstadoForte(Jogador p){
        super(p);
        p.setC(new MovimentoRapido());
        p.setA(new AtaqueForte());
        System.out.println("Estado Forte");
    }
    
    @Override
    public void setLimites(){
        this.setLimiteInferior(71);
        this.setLimiteSuperior(100);
    }
    
    @Override
    public void verificaEstado(){
        if(this.getP().getQuantidade() <= this.getLimiteInferior()){
            this.getP().setVida(new EstadoNormal(this.getP()));
        }else if(this.getP().getQuantidade() > this.getLimiteSuperior()){
            this.getP().setVida(new EstadoForte(this.getP()));
        }
    }
    
    @Override
    public void dano(int dano){
        this.perdeVida(dano);
    }
}
