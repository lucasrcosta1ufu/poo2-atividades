public class Teste {
    static final Runtime run = Runtime.getRuntime();
    static Process pro;

    public static void main(String args[]) {
        try {
            Game g = new Game();
            g.jogar(g);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
