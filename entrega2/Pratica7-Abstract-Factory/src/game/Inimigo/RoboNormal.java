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
    public RoboNormal(Robo robo)
    {
        super(robo);
        robo.setMovimento(MovimentoRapido.getInstance());
        robo.setAtaque(AtaqueMedio.getInstance());
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
        if (this.getRobo().getQuantidade() <= this.getLimiteInferior()) {
            this.getRobo().setVida(new RoboPerigo(this.getRobo()));
        } else if(this.getRobo().getQuantidade() > this.getLimiteSuperior()) {
            this.getRobo().setVida(new RoboForte(this.getRobo()));
        }
    }
    
    @Override
    public void dano(int dano)
    {
        this.perdeVida(dano);
    }
}
