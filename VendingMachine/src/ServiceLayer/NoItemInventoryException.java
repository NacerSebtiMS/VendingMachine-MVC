/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

/**
 *
 * @author nacer
 */
public class NoItemInventoryException extends Exception {
    NoItemInventoryException(String message){
        super(message);
    }
    NoItemInventoryException(String message, Exception e) {
        super(message, e);
    }
}
