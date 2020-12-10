/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.*;
import DTO.Item;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 *
 * @author nacer
 */
public class VendingMachineDAO implements VendingMachineDAOInterface {
    private ArrayList<Item> items;
    
    public ArrayList<Item> getItems(){ return this.items; }
    
    public void getAllItemsFromStorage() throws CannotOpenFile// Unmarshaling data from file to het all of the items in an ArrayList 
    {
        
    }
    
    public void saveChangesInStorage() throws CannotOpenFile // Save all our changes in the file
    
    {
        PrintWriter output;
        try{
            output = new PrintWriter(new FileWriter ("OutFile.txt"));
        } catch (IOException exception) {
            throw new CannotOpenFile("Cannot write to the file.");
        }
        for (Item i : items )
        {
            output.println(i.getName() + "::" + i.getCost() + "::" + i.getLeft());
            output.println(i);
        }
        output.flush();
        output.close();
        
    }
    
    public void updateItem(String itemName, int left) // Updates an item, we will just remove one from the stock
    {
    
    }
    
    public Item getSpecificItem(String itemName) // Gets a specific item using it's name from the ArrayList
    {

    }

}
