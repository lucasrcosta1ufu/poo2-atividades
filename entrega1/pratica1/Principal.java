
/**
 * Write a description of class Principal here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Principal
{
    public static void main(){
        
    
        Personagem p;
        
        System.out.println("Personagem 01");
        p = new Personagem01();
        p.pulo();
        p.corrida();
        p.ataque();
        

        System.out.println("Personagem 02");
        p = new Personagem02();
        p.pulo();
        p.corrida();
        p.ataque();
        
        System.out.println("Personagem 03");
        p = new Personagem03();
        p.pulo();
        p.corrida();
        p.ataque();

        System.out.println("Personagem NOVO 03");
        p.pulo();
        p.corrida();
        p.setA(new AtacaFraco());
        p.ataque();

        
    }
}