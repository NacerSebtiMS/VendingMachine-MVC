/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DTO.Item;
import ServiceLayer.Change;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author nacer
 */
public class VendingMachineView {
    private UserIO io;
    
    public VendingMachineView(){
        this.io = new UserIO();
    }
    
    public void skipLine(){
        io.print("");
    }
    
    public void displayMenuItem(int itemNumber, String itemName, BigDecimal itemCost){
        io.print( itemNumber + "- " + itemName + " " + itemCost + "$" );       
    }
    
    public BigDecimal askForMoney(){
        io.print("");
        io.print("Insert money.");
        io.print("0 or less will turn off the machine.");
        return io.readBigDecimal("Enter you input money.");
    }
    
    public int askForChoice(int max){
        io.print("");
        io.print("Enter 0 to turn off the machine");
        io.print("Choose the item you want to buy");
        return io.readInt("Enter a valid option.",0,max);
    }
    
    public BigDecimal notEnoughMoney(BigDecimal moneyInsideMachine){
        io.print("");
        io.print("Insufficient funds. Insert more money");
        io.print(moneyInsideMachine+"$");
        return io.readBigDecimal("Enter sufficient money.");
    }
    
    public void displayChange(){
        io.print("");
        io.print("Change :");
    }
    public void displayChange(int amount, String coinType){
        io.print(amount + " " + coinType);
    }
    public void displayNoChange(){
        io.print("");
        io.print("No Change to give back");
    }
}
