/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Personagem.Jogador;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public abstract class Game extends JPanel
{
    public abstract void jogar(Game game) throws InterruptedException;
    public abstract Jogador criaPersonagem();
}
