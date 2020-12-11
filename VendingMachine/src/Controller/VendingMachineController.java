/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CannotOpenFile;
import DTO.Item;
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
    
    public void run(){
        // Main loop use view functions for the display
        boolean machineOn = true;
        float money;
        while(machineOn){
            ArrayList<Item> items = this.service.displayableItemDetailList();
            displayMenu(items);
            money = inputMoney();
            if(money<=0){
                machineOn = false;
                turnOff();
            }
        }
    }
    
    private void displayMenu(ArrayList<Item> items){      
        this.view.displayMenu(items);
    }
    
    private float inputMoney(){
        return view.askForMoney();
    }
    
    private void turnOff(){
        
    }
    
}
