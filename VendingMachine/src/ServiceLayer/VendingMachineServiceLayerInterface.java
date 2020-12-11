/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAO.CannotOpenFile;
import DTO.Item;
import java.util.ArrayList;

/**
 *
 * @author nacer
 */
public interface VendingMachineServiceLayerInterface {
   public Change computeChange(float userMoney, float itemCost) throws InsufficientFundsException;
   public void updateItem(String itemName) throws NoItemInventoryException, CannotOpenFile; // Updates an item, we will just remove one from the stock
   public Item getSpecificItem(String itemName); // Gets a specific item using it's name from the ArrayList
   public ArrayList<Item> displayableItemDetailList(); // Returns a list of all displayable items
   public void turnOff() throws CannotOpenFile;
   
}
