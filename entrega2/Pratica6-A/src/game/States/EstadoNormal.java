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
    public EstadoNormal(Jogador p){
        super(p);
        p.setC(new MovimentoRapido());
        p.setA(new AtaqueMedio());
        System.out.println("Estado Normal");
    }
    
    @Override
    public void setLimites(){
        this.setLimiteInferior(30);
        this.setLimiteSuperior(70);
    }
    
    @Override
    public void verificaEstado(){
        if(this.getP().getQuantidade() <= this.getLimiteInferior()){
            this.getP().setVida(new EstadoPerigo(this.getP()));
        }else if(this.getP().getQuantidade() > this.getLimiteSuperior()){
            this.getP().setVida(new EstadoForte(this.getP()));
        }
    }
    
    @Override
    public void dano(int dano){
        this.perdeVida(dano);
    }
}
