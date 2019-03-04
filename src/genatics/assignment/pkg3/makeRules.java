/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genatics.assignment.pkg3;

/**
 *
 * @author go
 */
class makeRules {
    private String Name;
    private double Value;

    public makeRules(String Name, double Value) {
        this.Name = Name;
        this.Value = Value;
    }    
    public makeRules(String Name ) {
        this.Name = Name;
       
    }    

    public void setValue(double Value) {
        this.Value = Value;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public double getValue() {
        return Value;
    }
    
}
