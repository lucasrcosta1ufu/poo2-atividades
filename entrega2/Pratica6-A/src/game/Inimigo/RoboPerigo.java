package game.Inimigo;

import game.Ataque.AtaqueFraco;
import game.Movimento.MovimentoDevagar;


/**
 * Write a description of class RoboPerigo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoboPerigo extends RoboEstado
{    
    public RoboPerigo(Robo robo)
    {
        super(robo);
        robo.setMovimento(new MovimentoDevagar());
        robo.setAtaque(new AtaqueFraco());
    }
    
    @Override
    public void setLimites()
    {
        this.setLimiteInferior(1);
        this.setLimiteSuperior(29);
    }
    
    @Override
    public void verificaEstado()
    {
        if(this.getRobo().getQuantidade() <= this.getLimiteInferior()){
            this.getRobo().setVida(new RoboMorto(this.getRobo()));
        }else if(this.getRobo().getQuantidade() > this.getLimiteSuperior()){
            this.getRobo().setVida(new RoboNormal(this.getRobo()));
        }
    }
    
    @Override
    public void dano(int dano)
    {
        this.perdeVida(dano);
    }
}
