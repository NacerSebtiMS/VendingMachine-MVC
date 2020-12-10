/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DTO.Item;

/**
 *
 * @author nacer
 */
public interface VendingMachineServiceLayerInterface {
   public Change computeChange(float userMoney, float itemCost) throws InsufficientFundsException;
   public void updateItem(String itemName) throws NoItemInventoryException; // Updates an item, we will just remove one from the stock
   public Item getSpecificItem(String itemName); // Gets a specific item using it's name from the ArrayList
   
}
