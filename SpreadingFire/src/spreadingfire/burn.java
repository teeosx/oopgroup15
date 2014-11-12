/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadingfire;

import java.awt.Color;

/**
 *
 * @author Tee
 */
public class burn {

    Forest f = Fireforest.forest;
    boolean check[][] = new boolean[f.getNumTree()][f.getNumTree()];
    GUI g;
    int cnt;
    int addcnt;
    int lightstep = 0;

    public boolean finish() {
        for (int i = 0; i < f.getNumTree(); i++) {
            for (int j = 0; j < f.getNumTree(); j++) {
                if (f.tree[i][j].getState() == 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public void search() {
        for (int i = 1; i < f.getNumTree() - 1; i++) {
            for (int j = 1; j < f.getNumTree() - 1; j++) {
                lightstep++;
                if (f.tree[i][j].getState() == 2 && check[i][j] == false) {
                    f.tree[i][j].setState(0);
                    north(i, j);
                    south(i, j);
                    west(i, j);
                    east(i, j);
                    
                    
                    
                }else if(f.tree[i][j].getState() == 1 && random(g.numproblight) == true){
                    if(random(g.numproblight*g.numprob/100)== true){
                    f.tree[i][j].setState(3);
                    
                    }
                    
                }
            }
        }
    }

    private void north(int x, int y) {
        if (f.tree[x][y - 1].getState() == 1 && random(g.numprob) == true) {
            f.tree[x][y - 1].setState(2);
            check[x][y - 1] = true;
        }       // north
    }

    private void south(int x, int y) {
        if (f.tree[x][y + 1].getState() == 1 && random(g.numprob) == true) {
            f.tree[x][y + 1].setState(2);
            check[x][y + 1] = true;
        }    // south
    }

    private void west(int x, int y) {
        if (f.tree[x - 1][y].getState() == 1 && random(g.numprob) == true) {
            f.tree[x - 1][y].setState(2);
            check[x - 1][y] = true;
        }       // west
    }

    private void east(int x, int y) {
        if (f.tree[x + 1][y].getState() == 1 && random(g.numprob) == true) {
            f.tree[x + 1][y].setState(2);
            check[x + 1][y] = true;
        }       // east  
    }

    private boolean random(int a) {
        int rnd = (int) (Math.random() * 100);
        if (rnd < a) {
            return true;
        } else {
            return false;
        }
    }

    public void reset() {
        for (int i = 1; i < check.length - 1; i++) {
            for (int j = 1; j < check.length - 1; j++) {
                check[i][j] = false;
            }
        }
    }

    public void setG(GUI g) {
        this.g = g;
    }

    public void runfire() {
        //int cnt = 0;
        try {
            while (!finish()) {
                step();
            }

        } catch (Exception e) {
        }
    }

    public void step() {
        try {
            search();
            reset();

           
            if(finish() == true){
                if(addcnt == 0){
                    addcnt++;
                    cnt++;
                }else{
                }
            }else{
                   cnt++;
            }
             f.update(f.tree);
            
            Thread.sleep(100);
        } catch (Exception e) {

        }
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getCnt() {
        return cnt;
    }
    public void setAddcnt(int addcnt) {
        this.addcnt = addcnt;
    }

}
