/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DTO.Item;
import ServiceLayer.Change;
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
    
    public void displayMenu(ArrayList<Item> items){
        for(int i = 0; i<items.size(); i++){
            io.print( (i+1) + "- " + items.get(i).getName() + " " + items.get(i).getCost() + "$" );
        }
        //return io.readInt("Enter a valid option", 0, items.size());
    }
    
    public float askForMoney(){
        io.print("Insert money.\t\t0 or less will turn off the machine.");
        return io.readFloat("Invalid input. Try again.");
    }
    
    public int askForChoice(int max){
        io.print("Enter 0 to turn off the machine");
        io.print("Choose the item you want to buy");
        return io.readInt("Enter a valid option",0,max);
    }
    
    public float notEnoughMoney(float moneyInsideMachine){
        io.print("Insufficient funds. Insert more money");
        io.print(moneyInsideMachine+"$");
        return io.readFloat("Invalid input. Try again.");
    }
    
    public void displayChange(Change c){
        io.print("Change :");
        if(c.getDollars()>0) { io.print(c.getDollars() + " Dollars"); }
        if(c.getQuarters()>0) { io.print(c.getQuarters() + " Quarters"); }
        if(c.getDimes()>0) { io.print(c.getDimes() + " Dimes"); }
        if(c.getNickels()>0) { io.print(c.getNickels() + " Nickels"); }
        if(c.getPennies()>0) { io.print(c.getPennies() + " Pennies"); }
    }
}
