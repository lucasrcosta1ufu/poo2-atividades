package game.Personagem.Medieval;

import game.Ataque.Medieval.DisparoMagico;
import game.Ataque.Medieval.ForcaAnimal;
import game.Ataque.Medieval.GolpeSagrado;
import game.Ataque.Medieval.MilLaminasCortantes;
import game.Ataque.Medieval.Encantamento;
import game.Helpers.Posicao;
import game.Personagem.Jogador;
import game.Utilities;
import java.io.IOException;


public class SimplePersonagemMedievalFactory {
    public static Jogador criaPersonagem(float valor)
        throws IOException
    {
        Jogador personagem = null;
        
        if (valor <= 0.2f) {
            personagem = createDruida();

        } else if (valor <= 0.4f) {
            personagem = createPaladino();

        } else if (valor <= 0.6f) {
            personagem = createMago();

        } else if (valor <= 0.8f) {
            personagem = createSacerdote();

        } else if (valor <= 1f) {
            personagem = createAssassino();

        }

        return personagem;
    }

    public static Mago createMago()
        throws IOException
    {
        Jogador p = new Mago(
            (Posicao) Utilities.medievalData.personagemData.get("posicao"),
            (Integer) Utilities.medievalData.personagemData.get("width"),
            (Integer) Utilities.medievalData.personagemData.get("height")
        );       
        
        p.setAtaque(DisparoMagico.getInstance(p.getAtaque())); 
        
        return (Mago) p;
    }

    public static Paladino createPaladino()
        throws IOException
    {
        Paladino p = new Paladino(
            (Posicao) Utilities.medievalData.personagemData.get("posicao"),
            (Integer) Utilities.medievalData.personagemData.get("width"),
            (Integer) Utilities.medievalData.personagemData.get("height")
        );        
        
        p.setAtaque(GolpeSagrado.getInstance(p.getAtaque())); 
        
        return (Paladino) p;
    }

    public static Sacerdote createSacerdote()
        throws IOException
    {
        Jogador p = new Sacerdote(
            (Posicao) Utilities.medievalData.personagemData.get("posicao"),
            (Integer) Utilities.medievalData.personagemData.get("width"),
            (Integer) Utilities.medievalData.personagemData.get("height")
        );      
        
        p.setAtaque(Encantamento.getInstance(p.getAtaque())); 
        
        return (Sacerdote) p;
    }

    public static Assassino createAssassino()
        throws IOException
    {
        Jogador p = new Assassino(
            (Posicao) Utilities.medievalData.personagemData.get("posicao"),
            (Integer) Utilities.medievalData.personagemData.get("width"), 
            (Integer) Utilities.medievalData.personagemData.get("height")
        );    
        
        p.setAtaque(MilLaminasCortantes.getInstance(p.getAtaque())); 
        
        return (Assassino) p;
    }

    public static Druida createDruida()
        throws IOException
    {
        Jogador p = new Druida(
            (Posicao) Utilities.medievalData.personagemData.get("posicao"),
            (Integer) Utilities.medievalData.personagemData.get("width"),
            (Integer) Utilities.medievalData.personagemData.get("height")
        );     
        
        p.setAtaque(ForcaAnimal.getInstance(p.getAtaque())); 
        
        return (Druida) p; 
    }
}
