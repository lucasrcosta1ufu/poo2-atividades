package game;

import game.Inimigo.Robo;
import game.Escudo.EscudoMedio;
import game.Escudo.EscudoForte;
import game.Escudo.EscudoFraco;
import game.Escudo.Escudo;
import game.Helpers.JLabelData;
import game.Helpers.Posicao;
import game.Helpers.RandomGenerator;
import game.Personagem.Jogador;
import game.Personagem.SimplePersonagemFactory;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuturisticGame extends Game
{
    private ImageIcon background;
    private static FuturisticGame instance = null;

    private FuturisticGame()
    {
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
        // So that the JPanel object receives the keyboard notifications it is necessary
        // to include
        // the instruction setFocusable(true), which allows KeyboardExample to receive
        // the focus.

    }

    public static synchronized FuturisticGame getInstance()
    {
        if(instance == null) {
            instance = new FuturisticGame();
        }
        return instance;
    }
    
    public class MyKeyListener implements KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e)
        {
            // System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));

            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A ) {
                getJogador().moveToLeft();
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                getJogador().moveToRight();
            }

            if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
                getJogador().moveToUp();
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
                getJogador().moveToDown();
            }

            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                getJogador().enviaAtaque(getRobos());
            }

            if (e.getKeyCode() == KeyEvent.VK_P) {
                getJogador().coletaEscudo(getEscudos());
            }
            
            if (e.getKeyCode() == KeyEvent.VK_1) {
                getJogador().coletaEscudo(getEscudos());
            }

        }

        @Override
        public void keyReleased(KeyEvent e)
        {
            // System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }

    @Override
    public void jogar(Game g)
        throws InterruptedException
    {
        System.out.println("------------- Comeca jogo --------------");
        
        FuturisticGame game = (FuturisticGame) g;
        Escudo eForte, eMedio, eFraco;

        JFrame frame = new JFrame("RoboHunt");

        JLabel label = new JLabel();
        JLabel lifeJogador = new JLabel();
        JLabelData jogadorLabel = (JLabelData) Utilities.personagemData.get("jlabel");
        
        
        background = new ImageIcon(Utilities.backgroundPath);
        setRobos(new ArrayList<>());
        setEscudos(new ArrayList<>());
        
        Utilities.enemysData.forEach(enemy -> {
            JLabel enemyLabel = new JLabel();
            JLabelData labelData = (JLabelData) enemy.get("jlabel");
            
            enemyLabel.setFont(baseFont);
            enemyLabel.setText(labelData.getName());
            
            game.add(enemyLabel);
        });
        
        try {
            setJogador(
                SimplePersonagemFactory
                    .criaPersonagem(RandomGenerator.getFloat())
            );
            
        } catch (IOException ex) {
            Logger.getLogger(FuturisticGame.class.getName())
                .log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        
        Utilities.enemysData.forEach(enemy -> {
            try {
                Robo robo = new Robo(
                    (Posicao) enemy.get("posicao"),
                    (Integer) enemy.get("width"),
                    (Integer) enemy.get("height"),
                    (String) enemy.get("name"),
                    (String) enemy.get("image")
                );
                getRobos().add(robo);
                getJogador().addObserver(robo);
            } catch (IOException ex) {
                Logger.getLogger(FuturisticGame.class.getName())
                    .log(Level.SEVERE, null, ex);
                
                System.exit(0);
            }
        });

        eFraco = new EscudoFraco();
        eFraco.setRandomicPosition();
        eMedio = new EscudoMedio();
        eMedio.setRandomicPosition();
        eForte = new EscudoForte();
        eForte.setRandomicPosition();

        getEscudos().add(eFraco);
        getEscudos().add(eMedio);
        getEscudos().add(eForte);

        label.setBounds(0, 0, Utilities.WIDTH, Utilities.HEIGHT);
        label.setIcon(background);

        game.setLayout(null);
        game.add(label);

        // ------- //

        lifeJogador.setFont(baseFont);
        lifeJogador.setText(jogadorLabel.getName());
        game.add(lifeJogador);
        
        // ------- //

        frame.add(game);
        frame.setSize(Utilities.WIDTH, Utilities.HEIGHT + 29);
        frame.setVisible(true);
        frame.setResizable(false);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (!getRobos().isEmpty()) {            
            getJogador().show();
            game.repaint();
            Thread.sleep(50);
        }
        
        JOptionPane.showMessageDialog(null, "Voce ganhou!");
        System.exit(0);
    }

    @Override
    public Jogador criaPersonagem()
    {
        Jogador player = null;
        try {
            player = SimplePersonagemFactory
                .criaPersonagem(RandomGenerator.getFloat());
        } catch (IOException ex) {
            Logger.getLogger(FuturisticGame.class.getName())
                .log(Level.SEVERE, null, ex);
        } finally {
            return player;
        }
    }
}
