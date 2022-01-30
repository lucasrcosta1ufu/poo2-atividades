

public class Teste
{
    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    
    public static void main(String args[])throws InterruptedException {
        Game g = new Game();
        g.jogar(g);
    }
}
