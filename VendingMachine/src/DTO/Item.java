/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.math.BigDecimal;

/**
 *
 * @author nacer
 */
public class Item {
    private String name;// Item name
    private BigDecimal cost;// Item cost
    private int left;// Number of items in inventory
    
    public Item(String name, BigDecimal cost, int left){
        this.name = name;
        this.cost = cost;
        this.left = left;
    }
    
    // getters + setters
    public String getName(){ return this.name; }
    public void setName(String name) { this.name = name; }
    
    public BigDecimal getCost(){ return this.cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }
    
    public int getLeft(){ return this.left; }
    public void setLeft(int left) { this.left = left; }
}
