/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAO.CannotOpenFile;
import DAO.VendingMachineAudit;
import DAO.VendingMachineDAO;
import DTO.Item;
import java.util.ArrayList;

/**
 *
 * @author nacer
 */
public class VendingMachineServiceLayer implements VendingMachineServiceLayerInterface {
    VendingMachineDAO dao;
    VendingMachineAudit log;
    
    public VendingMachineServiceLayer() throws CannotOpenFile{
        this.dao = new VendingMachineDAO();
        this.log = new VendingMachineAudit();
    }

    @Override
    public Change computeChange(float userMoney, float itemCost) throws InsufficientFundsException {
        int leftover = ((int) (userMoney*100)) - ((int) (itemCost*100));
        Change c;
        if(leftover<0){
            c = new Change(0);
            c.setDollars(-1);
        } else {
            c = new Change(leftover);
        }
        return c;
    }

    @Override
    public void updateItem(String itemName) throws NoItemInventoryException, CannotOpenFile {
        Item i = getSpecificItem(itemName);
        if(i.getLeft()-1 < 0){
            throw new NoItemInventoryException("Not enough items in inventory.");
        } else {
            dao.updateItem(itemName, i.getLeft()-1);
            log.recordSale(i);
        }
    }

    @Override
    public Item getSpecificItem(String itemName) {
        return this.dao.getSpecificItem(itemName);
    }

    @Override
    public ArrayList<Item> displayableItemDetailList() {
        return this.dao.displayableItemDetailList();
    }

    @Override
    public void turnOff() throws CannotOpenFile {
        this.dao.saveChangesInStorage();
    }
    
}
