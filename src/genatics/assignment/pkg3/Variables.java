/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genatics.assignment.pkg3;

/**
 *
 * @author Mustafa
 */
public class Variables {
    
    private String Name;
    private float Value;
    private int numofset;

    public Variables(String Name, float Value,int num) {
        this.Name = Name;
        this.Value = Value;
        this.numofset = num;
    }    
    public Variables(String Name ,int num ) {
        this.Name = Name;
        this.numofset = num;
    }    

    public void setValue(float Value) {
        this.Value = Value;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public float getValue() {
        return Value;
    }
    public int geNumberOfSet() {
        return numofset;
    }
    
}
