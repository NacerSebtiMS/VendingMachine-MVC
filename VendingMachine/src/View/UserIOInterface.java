/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author nacer
 */
public interface UserIOInterface {
    public float readFloat(String msgPrompt);
    public float readFloat(String msgPrompt, float min);
    
    public int readInt(String msgPrompt);
    public int readInt(String msgPrompt, int min, int max);
    
}
