/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CannotOpenFile;
import DTO.Item;
import ServiceLayer.Change;
import ServiceLayer.InsufficientFundsException;
import ServiceLayer.NoItemInventoryException;
import ServiceLayer.VendingMachineServiceLayer;
import View.VendingMachineView;
import java.util.ArrayList;

/**
 *
 * @author nacer
 */
public class VendingMachineController {
    private VendingMachineServiceLayer service; 
    private VendingMachineView view;
    
    public VendingMachineController() throws CannotOpenFile{
        this.service = new VendingMachineServiceLayer();
        this.view = new VendingMachineView();
    }
    
    public void run() throws CannotOpenFile, InsufficientFundsException, NoItemInventoryException{
        // Main loop use view functions for the display
        boolean machineOn = true;
        double money;
        int choice;
        Change change;
        while(machineOn){
            ArrayList<Item> items = this.service.displayableItemDetailList();
            displayMenu(items);
            money = inputMoney();
            if(money<=0){
                machineOn = false;
                turnOff();
            } else {
                choice = menuChoice(items.size());
                if(choice==-1){
                    machineOn = false;
                    turnOff();
                    change = new Change(0);
                } else {
                    do{
                        change = service.computeChange( money, items.get(choice).getCost() );
                        if(change.getDollars() == -1){
                            money += insufficientFunds(money);
                        }
                    }while(change.getDollars() == -1);
                }
                if(choice !=-1){
                    confirmPurchase( items.get(choice) );
                    displayChange(change);
                }
            }
        }
    }
    
    private void displayMenu(ArrayList<Item> items){
        this.view.skipLine();
        for(int i = 0; i<items.size(); i++){
            this.view.displayMenuItem(i+1, items.get(i).getName(), items.get(i).getCost());
        }
    }
    
    private double inputMoney(){
        return this.view.askForMoney();
    }
    
    private void turnOff() throws CannotOpenFile{
        this.service.turnOff();
    }
    
    private int menuChoice(int listSize){
        return this.view.askForChoice(listSize) - 1;
    }
    
    private double insufficientFunds(double amountIn){
        return this.view.notEnoughMoney(amountIn);
    }
    
    private void displayChange(Change c){
        if(c.noChange()){
            view.displayNoChange();
        } else {
            this.view.displayChange();
            if(c.getDollars()>0) { view.displayChange(c.getDollars(), "Dollars"); }
            if(c.getQuarters()>0) { view.displayChange(c.getQuarters(), "Quarters"); }
            if(c.getDimes()>0) { view.displayChange(c.getDimes(), "Dimes"); }
            if(c.getNickels()>0) { view.displayChange(c.getNickels(), "Nickels"); }
            if(c.getPennies()>0) { view.displayChange(c.getPennies(), "Pennies"); }
        }
    }
    
    private void confirmPurchase(Item i) throws NoItemInventoryException, CannotOpenFile{
        this.service.updateItem(i.getName());
    }
    
}
