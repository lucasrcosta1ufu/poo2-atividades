import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Write a description of class EstadoMorto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EstadoMorto extends Estado
{
    public EstadoMorto(Personagem p){
        super(p);
        System.out.println("Estado Morto");
        morte();
    }
    
    public void setLimites(){
        this.setLimiteInferior(0);
        this.setLimiteSuperior(0);
    }
    
    public void verificaEstado(){
        if(this.getP().getQuantidade() < this.getLimiteInferior()){
            this.getP().setVida(new EstadoPerigo(this.getP()));
        }else if(this.getP().getQuantidade() > this.getLimiteSuperior()){
            this.getP().setVida(new EstadoForte(this.getP()));
        }
    }
    
    public void perdeVida(int lostLife){
        this.morte();
    }
    
    public void morte(){
        JOptionPane.showMessageDialog(null,"Game over");
        System.exit(0);
    }
    
    public void dano(){
        this.morte();
    }
}
