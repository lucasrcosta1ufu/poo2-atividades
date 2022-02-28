package game.Inimigo;

import java.util.Scanner;

/**
 * Write a description of class RoboMorto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RoboMorto extends RoboEstado
{
    public RoboMorto(Robo r)
    {
        super(r);
        morte();
    }
    
    @Override
    public void setLimites()
    {
        this.setLimiteInferior(0);
        this.setLimiteSuperior(0);
    }
    
    @Override
    public void verificaEstado()
    {
        if(this.getRobo().getQuantidade() < this.getLimiteInferior()){
            this.getRobo().setVida(new RoboMorto(this.getRobo()));
        }else if(this.getRobo().getQuantidade() > this.getLimiteSuperior()){
            this.getRobo().setVida(new RoboMorto(this.getRobo()));
        }
    }
    
    @Override
    public void perdeVida(int lostLife)
    {
        this.morte();
    }
    
    public void morte()
    { 
        System.out.printf("Robo %s morto.\n",this.getRobo().getNome());
        //javax.swing.JOptionPane.showMessageDialog(null, "You win :)");
        //System.exit(0);
    }
    
    @Override
    public void dano(int dano)
    {
        this.morte();
    }
}
