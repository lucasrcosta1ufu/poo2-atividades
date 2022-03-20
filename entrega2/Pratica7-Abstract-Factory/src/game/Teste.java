package game;

public class Teste
{
    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    
    public static void main(String args[])
        throws InterruptedException
    {
        Utilities.readConfigs();
        
        MedievalGame g = MedievalGame.getInstance();
        g.jogar(g);
    }
}
