/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controller.VendingMachineController;
import DAO.CannotOpenFile;
import ServiceLayer.InsufficientFundsException;
import ServiceLayer.NoItemInventoryException;

/**
 *
 * @author nacer
 */
public class Application {
    public static void main(String[] args) throws CannotOpenFile, InsufficientFundsException, NoItemInventoryException{
        VendingMachineController controller = new VendingMachineController();
        controller.run();
    }
    
}
