/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Item;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacer
 */
public class VendingMachineAudit implements VendingMachineAuditInterface {
    private static final String LOGFILE = "log.txt";
    @Override
    public void recordSale(Item item) throws CannotOpenFile {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(LOGFILE,true));
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            String logMessage = "["+formatter.format(date)+"] Sold : "+item.getName()+" "+item.getCost().toString()+"$";
            out.println(logMessage);
            out.flush();
            out.close();
        } catch (IOException ex) {
            throw new CannotOpenFile("Cannot log.");
        }
    }
    
}
