/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controller.VendingMachineController;

/**
 *
 * @author nacer
 */
public class Application {
    public static void main(String[] args){
        VendingMachineController controller = new VendingMachineController();
        controller.run();
    }
    
}
