import java.util.Scanner;

/**
 * Write a description of class EstadoMorto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EstadoMorto extends Estado
{
    public EstadoMorto(Jogador p){
        super(p);
        System.out.println("Morto");
        morte();
    }
    
    public void setLimites(){
        this.setLimiteInferior(0);
        this.setLimiteSuperior(0);
    }
    
    public void verificaEstado(){
        if(this.getP().getQuantidade() < this.getLimiteInferior()){
            this.getP().setVida(new EstadoMorto(this.getP()));
        }else if(this.getP().getQuantidade() > this.getLimiteSuperior()){
            this.getP().setVida(new EstadoMorto(this.getP()));
        }
    }
    
    public void perdeVida(int lostLife){
        this.morte();
    }
    
    public void morte(){
        javax.swing.JOptionPane.showMessageDialog(null, "Game Over :/");
        System.exit(0);
    }
    
    public void dano(int dano){
        this.morte();
    }
}
