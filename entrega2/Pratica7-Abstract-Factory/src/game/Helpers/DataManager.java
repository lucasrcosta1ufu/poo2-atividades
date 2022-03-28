/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Helpers;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author Usuario
 */
public class DataManager
{    
    public Dictionary<String, Object> personagemData = new Hashtable<>();
    public Dictionary<String, Object> ataqueDecoradoData = new Hashtable<>();
    public Dictionary<String, String> characterPaths = new Hashtable<>();
    public Dictionary<String, String> ataqueImagesPath = new Hashtable<>();
    public ArrayList<Dictionary<String, Object>> enemysData = new ArrayList<>();
    private String backgroundPath;

    public Dictionary<String, Object> getPersonagemData() {
        return personagemData;
    }

    public void setPersonagemData(Dictionary<String, Object> personagemData) {
        this.personagemData = personagemData;
    }

    public Dictionary<String, Object> getAtaqueDecoradoData() {
        return ataqueDecoradoData;
    }

    public void setAtaqueDecoradoData(Dictionary<String, Object> ataqueDecoradoData) {
        this.ataqueDecoradoData = ataqueDecoradoData;
    }

    public Dictionary<String, String> getCharacterPaths() {
        return characterPaths;
    }

    public void setCharacterPaths(Dictionary<String, String> characterPaths) {
        this.characterPaths = characterPaths;
    }

    public Dictionary<String, String> getAtaqueImagesPath() {
        return ataqueImagesPath;
    }

    public void setAtaqueImagesPath(Dictionary<String, String> ataqueImagesPath) {
        this.ataqueImagesPath = ataqueImagesPath;
    }

    public ArrayList<Dictionary<String, Object>> getEnemysData() {
        return enemysData;
    }

    public void setEnemysData(ArrayList<Dictionary<String, Object>> enemysData) {
        this.enemysData = enemysData;
    }

    public String getBackgroundPath() {
        return backgroundPath;
    }

    public void setBackgroundPath(String backgroundPath) {
        this.backgroundPath = backgroundPath;
    }
        
    
}
