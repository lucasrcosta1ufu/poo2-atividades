
/**
 * Write a description of interface Estado here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Estado
{
    private Personagem p;
    private int limiteInferior, limiteSuperior;
    
    public Estado(Personagem P){
        this.p = P;
        setLimites();
    }
    
    public Personagem getP(){
        return this.p;
    }
    
    public void setP(Personagem p){
        this.p = p;
    }
    
    public int getLimiteInferior(){
        return this.limiteInferior;
    }
    
    public void setLimiteInferior(int limiteInferior){
        this.limiteInferior = limiteInferior;
    }
    
    public int getLimiteSuperior(){
        return this.limiteSuperior;
    }
    
    public void setLimiteSuperior(int limiteSuperior){
        this.limiteSuperior = limiteSuperior;
    }
    
    public void perdeVida(int lostLife){
        this.p.setQuantidade(this.p.getQuantidade() - lostLife);
        verificaEstado();
    }
    
    public void ganhaVida(){
         if(this.p.getQuantidade() >= 100){
            this.p.setQuantidade(100);
        }else{
            this.p.setQuantidade(this.p.getQuantidade() + 10);
        }
        verificaEstado();
    }
    
    public abstract void setLimites();
    
    public abstract void dano();
    
    public abstract void verificaEstado();
    
}
