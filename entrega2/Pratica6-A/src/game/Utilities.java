/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Helpers.ColorFinder;
import game.Helpers.Dir;
import game.Helpers.Json;
import game.Helpers.Posicao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Usuario
 */
public class Utilities {
    private static String PATH;
    public static String backgroundPath;
    public static Dictionary<String, Object> personagemData;
    public static ArrayList<Dictionary<String, Object>> enemysData;
    public final static int HEIGHT = 571;
    public final static int WIDTH = 999;

    public Utilities() {
        PATH = Dir.configsPath() + "/base-data.json";
    }

    public static String getPATH() {
        return PATH;
    }

    public Utilities(String path) {
        PATH = path;
    } 
    
    @SuppressWarnings("UseOfObsoleteCollectionType")
    public static void readConfigs()
    {
        try {
            PATH = Dir.configsPath() + "/base-data.json";
            personagemData = new Hashtable<>();
            enemysData = new ArrayList<>();
            
            Json jsonContent = new Json(PATH);
            JSONObject obj = jsonContent.read();
            
            load(obj);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | JSONException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static JSONObject getSubjects(JSONObject obj)
        throws JSONException
    {
        return (JSONObject) obj.get("subjects");
    }
   
    private static void load(JSONObject obj)
        throws JSONException
    {
        JSONObject subject = getSubjects(obj);
        
        loadBackground(obj);
        loadPersonagemData(subject);
        loadEnemyData(subject);
    }
    
    private static void loadBackground(JSONObject obj)
        throws JSONException
    {
        backgroundPath = obj.getString("background");
    }
    
    private static void loadPersonagemData(JSONObject obj)
        throws JSONException
    {
        JSONObject personagem = obj.getJSONObject("personagem");
        JSONObject posicao = personagem.getJSONObject("posicao");
        JSONObject dimensions = personagem.getJSONObject("dimensions");
        Posicao pos = new Posicao(
            posicao.getInt("x"),
            posicao.getInt("y"),
            Utilities.WIDTH - dimensions.getInt("w"),
            Utilities.HEIGHT - dimensions.getInt("h")
        );
                
        personagemData.put(
            "name",
            personagem.getString("name")
        );
        personagemData.put(
            "image",
            personagem.getString("image")
        );
        personagemData.put(
            "jlabelName",
            personagem.getString("jlabelName")
        );
        personagemData.put(
            "width",
            dimensions.getInt("w")
        );
        personagemData.put(
            "height",
            dimensions.getInt("h")
        );
        personagemData.put(
            "posicao",
            pos
        );
    }
    
    private static void loadEnemyData(JSONObject obj)
        throws JSONException
    {
        JSONObject enemy = null;
        JSONObject posicao = null;
        JSONObject dimensions = null;
        JSONArray enemys = obj.getJSONArray("enemys");
        Dictionary<String, Object> enemyData = null;        
        
        for (int i = 0; i < enemys.length(); i++) {
            enemyData = new Hashtable<>();
            enemy = enemys.getJSONObject(i);
            
            posicao = enemy.getJSONObject("posicao");
            dimensions = enemy.getJSONObject("dimensions");
            
            Posicao pos = new Posicao(
                posicao.getInt("x"),
                posicao.getInt("y"),
                Utilities.WIDTH - dimensions.getInt("w"),
                Utilities.HEIGHT - dimensions.getInt("h")
            );
        
            enemyData.put(
                "name",
                enemy.getString("name")
            );
            enemyData.put(
                "image",
                enemy.getString("image")
            );
            enemyData.put(
                "jlabelName",
                enemy.getString("jlabelName")
            );
            enemyData.put(
                "color",
                ColorFinder.getColorByName(enemy.getString("color"))
            );
            enemyData.put(
                "width",
                dimensions.getInt("w")
            );
            enemyData.put(
                "height",
                dimensions.getInt("h")
            );
            enemyData.put(
                "posicao",
                pos
            );
            
            enemysData.add(enemyData);
        }
    }
}
