/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;

/**
 *
 * @author nacer
 */
public class UserIO implements UserIOInterface {
    
    final private Scanner console = new Scanner(System.in);
    
    @Override
    public void print(String msgPrompt)
    {
        System.out.println(msgPrompt);
    }
        
    @Override
    public String readString(String msgPrompt)
    {
        System.out.println(msgPrompt);
        return console.nextLine();
    }
    
    @Override
    public float readFloat(String msgPrompt)
    {
        boolean invalidInput = true;
        float num = 0;
        while (invalidInput) {
            try {
                String stringValue = this.readString(msgPrompt);
                num = Float.parseFloat(stringValue);
                invalidInput = false; 
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
        return num;    
    }
    
    @Override
    public float readFloat(String msgPrompt, float min)
    {
        float result;
        do {
            result = readFloat(msgPrompt);
        } while (result < min);

        return result;
    }
    
    @Override
    public int readInt(String msgPrompt)
    {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
                String stringValue = this.readString(msgPrompt);
                num = Integer.parseInt(stringValue);
                invalidInput = false; 
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
        return num;
    }        
            
    @Override
    public int readInt(String msgPrompt, int min, int max)
    {
        int result;
        do {
            result = readInt(msgPrompt);
        } while (result < min || result > max);

        return result;
    }
}
