/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Ataque.Poder;
import game.Escudo.Escudo;
import game.Helpers.JLabelData;
import game.Helpers.Posicao;
import game.Inimigo.Robo;
import game.Personagem.Jogador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Dictionary;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public abstract class Game extends JPanel
{
    private Jogador jogador = null;
    private ArrayList<Robo> enemy = null;
    private ArrayList<Escudo> escudos;
    protected final Font EnemyStatusFont = new Font("Serif", Font.BOLD, 20);
    protected final Font baseFont = new Font("Serif", Font.BOLD, 60);
    
    public abstract void jogar(Game game) throws InterruptedException;
    public abstract Jogador criaPersonagem();

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public ArrayList<Robo> getRobos() {
        return enemy;
    }

    public void setRobos(ArrayList<Robo> enemy) {
        this.enemy = enemy;
    }

    public ArrayList<Escudo> getEscudos() {
        return escudos;
    }

    public void setEscudos(ArrayList<Escudo> escudos) {
        this.escudos = escudos;
    }

    @Override
    public void paint(Graphics g)
    {
        Robo robo;
        Graphics2D g2d = (Graphics2D) g;
        JLabelData labelData;
        JLabelData jogadorLabel = (JLabelData) Utilities
            .personagemData.get("jlabel");
        
        // The call to "super.paint(g)", cleans the screen
        super.paint(g); 
        
        // The instruction; "g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON)" makes the borders of the figures smoother

        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        // RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (jogador == null || enemy == null) {
            return;
        }

        escudos.forEach((Escudo escudo) -> {
            // g2d.fillOval(((Escudo) escudo).getX(), ((Escudo) escudo).getY(), 30, 30);
            g2d.drawImage(
                escudo.getImage(),
                ((Escudo) escudo).getX(),
                ((Escudo) escudo).getY(),
                30,
                30,
                null
            );
        });
        
        // g2d.drawString(jogador.getQuantidade(), 0 ,0);
        this.drawJogador(
            g2d,
            jogador,
            jogadorLabel
        );
        
        if (jogador.isAttacking()) {
            if (jogador.getAtaque() instanceof Poder) {
                Posicao ataqueDecodadoPosicao = (Posicao) Utilities
                    .ataqueDecoradoData.get("posicao");

                g2d.drawImage(
                    ((Poder) jogador.getAtaque()).getImage(),
                    jogador.getX() +
                        ataqueDecodadoPosicao.getX(),
                    jogador.getY() +
                        ataqueDecodadoPosicao.getY(),
                    (Integer) Utilities.ataqueDecoradoData.get("width"),
                    (Integer) Utilities.ataqueDecoradoData.get("height"),
                    null         
                );
            }
        }
        
        for (int i = 0; i < enemy.size(); i++) {
            robo = enemy.get(i);            
            this.drawRobo(g2d, robo, Utilities.enemysData.get(i));
        }
    }

    public void drawJogador(Graphics2D g2d, Jogador jogador, JLabelData jogadorLabel)
    {
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
        g2d.fillRect(
            jogadorLabel.getBackgroundPosX(),
            jogadorLabel.getBackgroundPosY(),
            jogadorLabel.getWidth(),
            jogadorLabel.getHeight()
        );

        g2d.setColor(Color.RED);
        g2d.setFont(EnemyStatusFont);
         
        g2d.drawString(
            getPorcentagemVida(jogador, "Jogador: "),
            jogadorLabel.getTextPosX(),
            jogadorLabel.getTextPosY()
        );
    }

    public void drawRobo(Graphics2D g2d, Robo robo, Dictionary<String, Object> enemyData)
    {
        JLabelData labelData = (JLabelData) enemyData.get("jlabel");
        Color color = (Color) enemyData.get("color");
        
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
        g2d.fillRect(
            labelData.getBackgroundPosX(),
            labelData.getBackgroundPosY(),
            labelData.getWidth(),
            labelData.getHeight()
        );

        g2d.setColor(color);
        g2d.setFont(EnemyStatusFont);
        
        g2d.drawString(
            getPorcentagemVida(robo, robo.getNome() + ":"),
            labelData.getTextPosX(),
            labelData.getTextPosY()
        );
    }

    public String getPorcentagemVida(Jogador jogador, String preffix)
    {
        return String.format("%s %d", preffix, jogador.getQuantidade());
    }

    public String getPorcentagemVida(Robo robo, String preffix)
    {
        return String.format("%s %d", preffix, robo.getQuantidade());
    }
}
