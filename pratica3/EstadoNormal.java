
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
        p.setC(new CorreRapido());
        p.setA(new AtacaMedio());
    }
    
    public EstadoNormal(Robo r){
        super(r);
        r.setC(new CorreRapido());
        r.setA(new AtacaMedio());
    }
    
    public void setLimites(){
        this.setLimiteInferior(30);
        this.setLimiteSuperior(70);
    }
    
    public void verificaEstado(){
        if(this.getP().getQuantidade() <= this.getLimiteInferior()){
            this.getP().setVida(new EstadoPerigo(this.getP()));
        }else if(this.getP().getQuantidade() > this.getLimiteSuperior()){
            this.getP().setVida(new EstadoForte(this.getP()));
        }
    }
    
    public void dano(){
        this.perdeVida(10);
    }
}
