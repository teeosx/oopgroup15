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
    public int step;
    
    private int state;



    
    public Tree(){
        state = TREE1;
        step = 0;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }


    public int getstep() {
        return step;
    }

    public void stepDown(int step) {
        this.step -= step;
    }

    public void setstep(int step) {
        this.step += step;
    }
    public void stateUp(){
        this.state += 1;
    }
}
