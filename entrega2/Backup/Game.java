package qa;

import Helpers.RandomFloat;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import qa.Personagens.SimplePersonagemFactory;
import qa.Personagens.Personagem;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class Game extends JPanel
{
    public static final int WIDTH = 999;
    public static final int HEIGHT = 600;
    private final int numPersonagens = 5;
    private final Font titleFont;
    private final Font paragraphFont;
    private final Font subTitleFont;
    private Personagem personagem;
    private Graphics2D g2d;
    private JPanel textContainer;
    private JLabel ataqueLabel;
    private JLabel tipoLabel;
    private JLabel descricaoLabel;
    
    public Game()
    {
        textContainer = new JPanel(
            new FlowLayout(FlowLayout.LEFT)
        );
        
        ataqueLabel = new JLabel();
        tipoLabel = new JLabel();
        descricaoLabel = new JLabel();
    
        titleFont = new Font("Arial Black", Font.BOLD, 48);
        subTitleFont = new Font("Arial Black", Font.BOLD, 24);
        paragraphFont = new Font("Arial", Font.PLAIN, 16);
    }

    public void jogar(Game game) throws InterruptedException
    {
        personagem = autoGeneratePersonagem();
        
        JFrame frame = new JFrame("CatalogoPersonagem");
        
        setLabels();
        
        frame.add(game);
        frame.add(textContainer);        
        frame.setSize(Game.WIDTH, Game.HEIGHT);
        frame.setLayout(new GridLayout(1,3)); 
        frame.setResizable(false);   
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (true) {
            game.repaint();
        }
    }
    
    private void setLabels()
    {
        tipoLabel.setFont(titleFont);
        ataqueLabel.setFont(subTitleFont);
        descricaoLabel.setFont(paragraphFont);
        
        textContainer.add(tipoLabel);
        textContainer.add(ataqueLabel);
        textContainer.add(descricaoLabel);
        textContainer.setLayout(
            new BoxLayout(
                textContainer,
                BoxLayout.PAGE_AXIS
            )
        );
    }

    public Personagem autoGeneratePersonagem()
    {
        float valor = RandomFloat.getRandom();
        return SimplePersonagemFactory
            .criaPersonagem(valor);
    }

    @Override
    public void paint(Graphics g)
    {
        // The call to "super.paint(g)", cleans the screen
        super.paint(g);

        g2d = (Graphics2D) g;

        try {
            drawPersonagem(10, 10);
            drawPersonagemData(525, 10);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName())
                .log(Level.SEVERE, null, ex);
        }
    }

    public void drawPersonagem(int posX, int posY)
        throws IOException
    {
        Image character = personagem.getCharacter();
        InputStream image = getClass()
            .getResourceAsStream(character.getPath());
        
        g2d.drawImage(
            ImageIO.read(image),
            posX,
            posY,
            character.getWidth(),
            character.getHeight(),
            null
        );
        
    }

    public void drawPersonagemData(int posX, int posY)
        throws IOException
    {
        String text = String.format(
            "<html>"
                + "<div style=\"word-wrap:break-word; margin-right: 30px\">%s</div>" + 
            "</html>",
            personagem.getDescricao()
        );
        ataqueLabel.setText(
            String.format("Ataque: %d", personagem.getAtaque().getForca())
        );
        tipoLabel.setText(personagem.getTipo());
        descricaoLabel.setText(text);
        
        ataqueLabel.setVisible(true);  
        descricaoLabel.setVisible(true);        
    }
}