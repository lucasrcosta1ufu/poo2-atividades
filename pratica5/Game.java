import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Font;
import java.util.Iterator;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Game extends JPanel {

    private final int height = 571;
    private final int width = 999;
    private Robo r1, r2, r3;
    private ArrayList<Robo> robos;
    private Jogador jogador;
    private ArrayList<Escudo> escudos;
    private Font EnemyStatusFont = new Font("Serif", Font.BOLD, 20);
    private ArrayList<Poder> poderes;
    private BufferedImage character, enemy1, enemy2, enemy3;

    public Game() {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
        // So that the JPanel object receives the keyboard notifications it is necessary
        // to include
        // the instruction setFocusable(true), which allows KeyboardExample to receive
        // the focus.

    }

    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));

            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A ) {
                jogador.moveToLeft();
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                jogador.moveToRight();
            }

            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                jogador.moveToUp();
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                jogador.moveToDown();
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                jogador.enviaAtaque(robos);
            }

            if (e.getKeyCode() == KeyEvent.VK_P) {
                jogador.coletaEscudo(escudos);
            }
            
            if (e.getKeyCode() == KeyEvent.VK_1) {
                jogador.coletaEscudo(escudos);
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }

    public void paint(Graphics g) {
        Robo robo;
        super.paint(g); // The call to "super.paint(g)", cleans the screen

        Graphics2D g2d = (Graphics2D) g;
        // The instruction; "g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON)" makes the borders of the figures smoother

        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON);

        escudos.forEach((Escudo escudo) -> {
            // g2d.fillOval(((Escudo) escudo).getX(), ((Escudo) escudo).getY(), 30, 30);
            g2d.drawImage(escudo.getImage(), ((Escudo) escudo).getX(), ((Escudo) escudo).getY(), 30, 30, null);
        });
        
        // g2d.drawString(jogador.getQuantidade(), 0 ,0);
        this.drawJogador(g2d, jogador, 850, 2);
        g2d.drawString(getPorcentagemVida(jogador, "Jogador:"), 856, 21);

        // ROBO 1------------ //
        if (robos.size() >= 1) {
            robo = robos.get(0);
            this.drawRobo(g2d, robo, 850, 32);
            g2d.drawString(getPorcentagemVida(robo, robo.getNome() + ":"), 856, 51);

        }

        // ROBO 2------------- //
        if (robos.size() >= 2) {
            robo = robos.get(1);
            this.drawRobo(g2d, robo, 850, 62);
            g2d.drawString(getPorcentagemVida(robo, robo.getNome() + ":"), 856, 81);
        }

        // ROBO 3------------- //
        if (robos.size() == 3) {
            robo = robos.get(2);
            this.drawRobo(g2d, robo, 850, 92);
            g2d.drawString(getPorcentagemVida(robo, robo.getNome() + ":"), 856, 111);
        }

    }

    public void drawJogador(Graphics2D g2d, Jogador jogador, int posX, int posY) {
        // g2d.fillOval(jogador.getX(), jogador.getY(), 20, 20);
        g2d.drawImage(
            jogador.getAvatar(),
            jogador.getX(),
            jogador.getY(),
            jogador.getWidth(),
            jogador.getHeight(),
            null
        );

        // -- Jogador -- //
        g2d.setColor(Color.WHITE);
        g2d.fillRect(posX,posY, 140, 26);

        g2d.setColor(Color.RED);
        g2d.setFont(EnemyStatusFont);
    }

    public void drawRobo(Graphics2D g2d, Robo robo, int posX, int posY) {
        // g2d.fillOval(robos.get(2).getX(), robos.get(2).getY(), 20, 20);
        g2d.drawImage(
            robo.getAvatar(),
            robo.getX(),
            robo.getY(),
            robo.getWidth(),
            robo.getHeight(),
            null
        );

        // --- Robo 3 --- //
        g2d.setColor(Color.WHITE);
        g2d.fillRect(posX, posY, 140, 26);

        g2d.setColor(robo.getCor());
        g2d.setFont(EnemyStatusFont);
    }

    public String getPorcentagemVida(Jogador jogador, String preffix) {
        return String.format("%s %d", preffix, jogador.getQuantidade());
    }

    public String getPorcentagemVida(Robo robo, String preffix) {
        return String.format("%s %d", preffix, robo.getQuantidade());
    }

    public void jogar(Game game) throws InterruptedException {
        System.out.println("------------- Comeca jogo --------------");
        Font baseFont = new Font("Serif", Font.BOLD, 60);
        Escudo eForte, eMedio, eFraco;
        Poder soco,chute,especial;

        JFrame frame = new JFrame("RoboHunt");

        ImageIcon background = new ImageIcon("./res/map.png");
        System.out.println(background);

        inputImage();

        JLabel label = new JLabel();
        JLabel lifeJogador = new JLabel(),
            lifeR1 = new JLabel(),
            lifeR2 = new JLabel(),
            lifeR3 = new JLabel();

        robos = new ArrayList<Robo>();
        escudos = new ArrayList<Escudo>();

        label.setBounds(0, 0, width, height);
        label.setIcon(background);

        game.setLayout(null);
        game.add(label);

        // ------- //

        lifeJogador.setFont(baseFont);
        lifeR1.setFont(baseFont);
        lifeR2.setFont(baseFont);
        lifeR3.setFont(baseFont);

        lifeJogador.setText("Vida Jogador");
        lifeR1.setText("Vida r1");
        lifeR2.setText("Vida r2");
        lifeR3.setText("Vida r3");

        game.add(lifeJogador);
        game.add(lifeR1);
        game.add(lifeR2);
        game.add(lifeR3);
        // ------- //

        frame.add(game);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        r1 = new Robo(200, 400, width, height, 70, 70, "Robo 1", Color.BLUE, enemy1);
        r2 = new Robo(400, 10, width, height, 70, 70, "Robo 2", Color.GREEN, enemy2);
        r3 = new Robo(150, 50, width, height, 70, 70, "Robo 3", Color.ORANGE, enemy3);
        jogador = new Jogador(50, 400, width, height, 40, 40, character);

        robos.add(r1);
        robos.add(r2);
        robos.add(r3);

        jogador.addObserver(robos.get(0));
        jogador.addObserver(robos.get(1));
        jogador.addObserver(robos.get(2));

        eFraco = new EscudoFraco();
        eFraco.setRandomicPosition(width, height);
        eMedio = new EscudoMedio();
        eMedio.setRandomicPosition(width, height);
        eForte = new EscudoForte();
        eForte.setRandomicPosition(width, height);

        escudos.add(eFraco);
        escudos.add(eMedio);
        escudos.add(eForte);

        while (true) {
            if (robos.size() == 0) {
                JOptionPane.showMessageDialog(null, "Voce ganhou!");
                break;
            }
            
            jogador.show();
            game.repaint();
            Thread.sleep(50);
        }
        System.exit(0);
    }

    private void inputImage() {
        InputStream cs = getClass().getResourceAsStream("./res/character.png");
        InputStream es1 = getClass().getResourceAsStream("./res/enemy1.png");
        InputStream es2 = getClass().getResourceAsStream("./res/enemy2.png");
        InputStream es3 = getClass().getResourceAsStream("./res/enemy3.png");
        try {
            character = ImageIO.read(cs);
            enemy1 = ImageIO.read(es1);
            enemy2 = ImageIO.read(es2);
            enemy3 = ImageIO.read(es3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
