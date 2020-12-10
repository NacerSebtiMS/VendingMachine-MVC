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
public class Change {
    int dollars; // 100 cents
    int quarters; // 25cents
    int dimes; // 10 cents
    int nickels; // 5 cents
    int pennies; // 1 cent
    
    public Change(float input) throws InsufficientFundsException{
        if(input<0){
            throw new InsufficientFundsException("Not enough funds.");
        } else {
            int cents = (int) (input*100);
            int[] change;
            
            change = euclideanDivision(cents,100);
            this.dollars = change[0];
            
            change = euclideanDivision(change[1],25);  
            this.quarters = change[0];
            
            change = euclideanDivision(change[1],10);  
            this.dimes = change[0];
            
            change = euclideanDivision(change[1],5);  
            this.nickels = change[0];
            
            this.pennies = change[1];
        }
    }
    
    private int[] euclideanDivision(int a, int b){
        int r = a%b;
        int q = (a - r)/b;
        int[] div = {q,r};
        return div;
    }
    
    // Functions to compute the change
    
    public int getDollars(){ return this.dollars; }
    public void setDollars(int dollars) { this.dollars = dollars; }
    
    public int getQuarters(){ return this.quarters; }
    public void setQuarters(int quarters) { this.quarters = quarters; }
    
    public int getDimes(){ return this.dimes; }
    public void setDimes(int dimes) { this.dimes = dimes; }
    
    public int getNickels(){ return this.nickels; }
    public void setNickels(int nickels) { this.nickels = nickels; }
    
    public int getPennies(){ return this.pennies; }
    public void setPennies(int pennies) { this.pennies = pennies; }
}
