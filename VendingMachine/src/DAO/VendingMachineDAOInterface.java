/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Item;
import java.util.ArrayList;

/**
 *
 * @author nacer
 */
public interface VendingMachineDAOInterface {

    // Data Marshaling
    public void getAllItemsFromStorage() throws CannotOpenFile; // Unmarshaling data from file to het all of the items in an ArrayList 
    public void saveChangesInStorage() throws CannotOpenFile; // Save all our changes in the file
    
    // Data maanagment
    public void updateItem(String itemName, int left); // Updates an item, we will just remove one from the stock
    public Item getSpecificItem(String itemName); // Gets a specific item using it's name from the ArrayList
    public ArrayList<Item> displayableItemDetailList();
}
