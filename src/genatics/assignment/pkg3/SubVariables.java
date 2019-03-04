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
public class SubVariables {
    private String SubName;
    private String ShapeName;
    private float x1;
    private float x2;
    private float x3;
    private float x4;

    public SubVariables(String SubName, String ShapeName, float x1, float x2, float x3, float x4) {
        this.SubName = SubName;
        this.ShapeName = ShapeName;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
    }
        public SubVariables(String SubName, String ShapeName, float x1, float x2, float x3) {
        this.SubName = SubName;
        this.ShapeName = ShapeName;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
    }

    
    

    public void setShapeName(String ShapeName) {
        this.ShapeName = ShapeName;
    }
    
    
    public void setSubName(String SubName) {
        this.SubName = SubName;
    }
    public String getSubName() {
        return SubName;
    }

    public String getShapeName() {
        return ShapeName;
    }
    

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public void setX3(float x3) {
        this.x3 = x3;
    }

    public void setX4(float x4) {
        this.x4 = x4;
    }

    public float getX1() {
        return x1;
    }

    public float getX2() {
        return x2;
    }

    public float getX3() {
        return x3;
    }

    public float getX4() {
        return x4;
    }
    
}
