/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Item;

/**
 *
 * @author nacer
 */
public interface VendingMachineAuditInterface {
    public void recordSale(Item item) throws CannotOpenFile;
    
}
