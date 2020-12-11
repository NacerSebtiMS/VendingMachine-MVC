/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.math.BigDecimal;
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
    public BigDecimal readDouble(String msgPrompt)
    {
        boolean invalidInput = true;
        BigDecimal num = BigDecimal.ZERO;
        while (invalidInput) {
            try {
                String stringValue = this.readString(msgPrompt);
                num = BigDecimal.valueOf(Double.parseDouble(stringValue));
                invalidInput = false; 
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
        return num;    
    }
    
    @Override
    public BigDecimal readDouble(String msgPrompt, BigDecimal min)
    {
        BigDecimal result;
        do {
            result = readDouble(msgPrompt);
        } while (result.compareTo(min)<0);

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
