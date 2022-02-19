
/**
 * Write a description of class EstadoForte here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EstadoForte extends Estado
{
    public EstadoForte(Personagem p){
        super(p);
        System.out.println("Estado Forte");
        p.setC(new CorreRapido());
        p.setA(new AtacaForte());
    }
    
    public void setLimites(){
        this.setLimiteInferior(71);
        this.setLimiteSuperior(100);
    }
    
    public void verificaEstado(){
        if(this.getP().getQuantidade() < this.getLimiteInferior()){
            this.getP().setVida(new EstadoNormal(this.getP()));
        }else if(this.getP().getQuantidade() > this.getLimiteSuperior()){
            this.getP().setVida(new EstadoForte(this.getP()));
        }
    }
    
    public void dano(){
        this.perdeVida(15);
    }
}
