/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author nacer
 */
public class CannotOpenFile extends Exception {
    CannotOpenFile(String message){
        super(message);
    }
    CannotOpenFile(String message, Exception e) {
        super(message, e);
    }
}
