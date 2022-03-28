/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Escudo.Escudo;
import game.Helpers.JLabelData;
import game.Inimigo.Inimigo;
import game.Personagem.Jogador;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Dictionary;
import javax.swing.ImageIcon;

/**
 *
 * @author Usuario
 */
public interface Game
{
    public void jogar(Game game) throws InterruptedException;
    public void drawJogador(Graphics2D g2d, Jogador jogador, JLabelData jogadorLabel);
    public void drawRobo(Graphics2D g2d, Inimigo robo, Dictionary<String, Object> enemyData);
    public void setJogador(Jogador jogador);
    public void setEscudos(ArrayList<Escudo> escudos);
    public void setEnemys(ArrayList<Inimigo> enemys);
    public void setBackgroundGame(ImageIcon background);
    public Jogador getJogador();
    public ArrayList<Escudo> getEscudos();
    public ArrayList<Inimigo> getEnemys();
    public ImageIcon getBackgroundGame();
    public void setProximaFase();
}
