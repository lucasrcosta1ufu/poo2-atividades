package game;

public class Teste
{
    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    
    public static void main(String args[])
        throws InterruptedException
    {
        Utilities.readConfigs();
        
        RPGGame g = new RPGGame();
        g.jogar(g);
        
    }
}
