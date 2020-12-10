/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAO.VendingMachineDAO;
import DTO.Item;

/**
 *
 * @author nacer
 */
public class VendingMachineServiceLayer implements VendingMachineServiceLayerInterface {
    VendingMachineDAO dao;
    
    VendingMachineServiceLayer(){
        this.dao = new VendingMachineDAO();
    }

    @Override
    public Change computeChange(float userMoney, float itemCost) throws InsufficientFundsException {
        return new Change(userMoney - itemCost);
    }

    @Override
    public void updateItem(String itemName) throws NoItemInventoryException {
        Item i = getSpecificItem(itemName);
        if(i.getLeft()-1 < 0){
            throw new NoItemInventoryException("Not enough items in inventory.");
        } else {
            dao.updateItem(itemName, i.getLeft()-1);
        }
    }

    @Override
    public Item getSpecificItem(String itemName) {
        return this.dao.getSpecificItem(itemName);
    }
    
}