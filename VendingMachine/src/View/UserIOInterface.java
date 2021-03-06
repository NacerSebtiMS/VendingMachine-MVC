/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.math.BigDecimal;

/**
 *
 * @author nacer
 */
public interface UserIOInterface {
    
    public void print(String msgPrompt);
    public String readString(String msgPrompt);
    
    public BigDecimal readBigDecimal(String msgPrompt);
    public BigDecimal readBigDecimal(String msgPrompt, BigDecimal min);
    
    public int readInt(String msgPrompt);
    public int readInt(String msgPrompt, int min, int max);
    
}
