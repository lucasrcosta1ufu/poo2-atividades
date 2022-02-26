package game.Inimigo;

import game.Ataque.AtaqueMedio;
import game.Movimento.MovimentoRapido;


/**
 * Write a description of class RoboNormal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoboNormal extends RoboEstado
{    
    public RoboNormal(Robo r){
        super(r);
        r.setC(new MovimentoRapido());
        r.setA(new AtaqueMedio());
    }
    
    public void setLimites(){
        this.setLimiteInferior(30);
        this.setLimiteSuperior(70);
    }
    
    public void verificaEstado(){
        if(this.getR().getQuantidade() <= this.getLimiteInferior()){
            this.getR().setVida(new RoboPerigo(this.getR()));
        }else if(this.getR().getQuantidade() > this.getLimiteSuperior()){
            this.getR().setVida(new RoboForte(this.getR()));
        }
    }
    
    @Override
    public void dano(int dano){
        this.perdeVida(dano);
    }
}
