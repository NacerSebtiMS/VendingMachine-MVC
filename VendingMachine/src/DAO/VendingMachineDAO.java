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
public class VendingMachineDAO implements VendingMachineDAOInterface {
    private ArrayList<Item> items;
    
    public ArrayList<Item> getItems(){ return this.items; }
}