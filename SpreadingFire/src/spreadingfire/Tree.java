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
    public static  final int TREE1 = 1;
    public static  final int TREE2 = 2;
    public static  final int TREE3 = 3;
    public static  final int TREE4 = 4;
    public static  final int BURN1 = 5;
    public static  final int BURN2 = 6;
    private int step;
    private int state;
    private int lightstep;
 
    public Tree(){
        state = TREE1;
        step = 0;
        lightstep = 0;
    }

    public void setState(int state) {
    // set is tree, empty or fire    
        this.state = state;
    }

    public int getState() {
    // get is tree, empty or fire    
        return state;
    }
    
    public int getstep() {
    // get step for check spread    
        return step;
    }
    
    public void stepDown(int step){ 
    // step - 1
        this.step -= step;
    }
    
    public void setstep(int step) {
    // set step for spreading lighting or tree burn 2 time    
        this.step += step;
    }
    
    public void stateUp(){
    // use for make tree evolution young - old    
        this.state += 1;
    }

    public int getLightstep() {
        return lightstep;
    }

    public void setLightstep(int lightstep) {
        this.lightstep = lightstep;
    }
    public void stepLightDown() {
        lightstep -= 1;
    }
    
}
