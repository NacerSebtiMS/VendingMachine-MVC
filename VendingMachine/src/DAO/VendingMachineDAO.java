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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacer
 */
public class VendingMachineDAO implements VendingMachineDAOInterface {
    private ArrayList<Item> items;
    private String dataFile = "DataStorage.txt";
    
    public VendingMachineDAO() throws CannotOpenFile{
        this.getAllItemsFromStorage();
    }
    
    public ArrayList<Item> getItems(){ return this.items; }
    
    public void getAllItemsFromStorage() throws CannotOpenFile// Unmarshaling data from file to het all of the items in an ArrayList 
    {
        // Data unmarshaling
        Scanner sc;
        try {
            sc = new Scanner(
            new BufferedReader(new FileReader(dataFile)));
        } catch (FileNotFoundException ex) {
            throw new CannotOpenFile("File not found.");
        }
        
        // go through the file line by line
        String[] chunks;
        Item item;
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();  
            
            // Split the input
            chunks = currentLine.split("::");
            
            // Create the item
            
            item = new Item(chunks[0], Float.parseFloat(chunks[1]),Integer.parseInt(chunks[2]));
            
            // Store it in the ArrayList
            items.add(item);
        }
    }
    
    public void saveChangesInStorage() throws CannotOpenFile // Save all our changes in the file
    
    {
        PrintWriter output;
        try{
            output = new PrintWriter(new FileWriter (dataFile));
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
        int index = 0;
        while(items.get(index).getName() != itemName && index < items.size()) {
            index++;
        }
        Item i = new Item(itemName,items.get(index).getCost(),left);
        items.set(index, i);
    }
    
    public Item getSpecificItem(String itemName) // Gets a specific item using it's name from the ArrayList
    {
        int index = 0;
        while(items.get(index).getName() != itemName && index < items.size()) {
            index++;
        }
        return items.get(index);    
    }

}
