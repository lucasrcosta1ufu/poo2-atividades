/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qa;

/**
 *
 * @author Usuario
 */
public class Main {
    static final Runtime run = Runtime.getRuntime();
    static Process pro;

    public static void main(String args[]) {
        try {
            Game g = new Game();
            g.jogar(g);
        } catch (InterruptedException e) {
            System.out.println(e);
            System.out.println("InterruptedException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
