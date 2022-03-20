/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Inimigo.Robo;
import game.Personagem.Jogador;

/**
 *
 * @author Usuario
 */
public abstract class GameFactory
{
    public abstract Jogador criarJogador();
    public abstract Robo criarInimigos();
    public abstract void criarCenario();
}
