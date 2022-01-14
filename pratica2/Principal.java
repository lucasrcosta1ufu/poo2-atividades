
/**
 * Write a description of class Principal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Principal
{
    public static void main() throws InterruptedException {
        Personagem p;
        
        System.out.println("------------------Personagem--------------------");
        p = new Personagem();
        System.out.println("Vida: " + p.getQuantidade());
        p.recompensa();  
        p.recompensa();  
        p.recompensa();  
        p.recompensa(); 
          
        p.recompensa();   
        p.recompensa();   
        p.recompensa(); 
        System.out.println("Vida: " + p.getQuantidade());  
        p.atacando();                    
        p.atacando();    
        p.atacando();
        p.atacando(); 
        p.atacando(); 
        p.atacando(); 
        p.atacando();
        p.atacando();
        p.atacando();
        p.atacando();
        System.out.println("Vida: " + p.getQuantidade());
        Thread.sleep(500);
        p.atacando();

        
    }
}