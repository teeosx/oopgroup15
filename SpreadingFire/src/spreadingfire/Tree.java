/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadingfire;

/**
 *
 * @author Tee
 */
public class Tree {
    public static  final int EMPTY = 0;
    public static  final int TREE = 1;
    public static  final int BURN = 2;
    public boolean light ;
    public int lightstep;
    
    private int state;



    
    public Tree(){
        state = TREE;
        light = false;
        lightstep = 3;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
       public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    public int getLightstep() {
        return lightstep;
    }

    public void LightstepDown(int lightstep) {
        this.lightstep -= lightstep;
    }
    
}
