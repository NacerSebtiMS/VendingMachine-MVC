/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DTO.Item;
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
}
