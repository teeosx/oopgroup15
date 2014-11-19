/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadingfire;

import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author Tee
 */
public class Forest extends JPanel {

    Tree tree[][];
    private int numTree;
    private int sizeCell;
    private boolean ran;
    private int numprobtree ;
    private int numprobburn ;
    GUI g;

    public void setG(GUI g) {
        this.g = g;
    }

    public boolean isRan() {
        return ran;
    }

    public void setRan(boolean ran) {
        this.ran = ran;
    }

    public Forest() {
        
        numTree = 50;
        sizeCell = 12;
        setSize(650, 650);

    }

    public void update(Tree[][] tree) {
        this.tree = tree;
        repaint();
    }

    public void paintComponent(Graphics g) {       
        for (int i = 0; i < getNumTree(); i++) {
            for (int j = 0; j < getNumTree(); j++) {
                
                int x = (i + 1) * getSizeCell(); //เก็บพิกัดของแต่ละต้น พิกัด x
                int y = (j + 1) * getSizeCell(); // พิกัด y
                
                // set empty to yellow
                if (tree[i][j].getState() == 0) {
                    g.setColor(Color.yellow);
                // set tree to green     
                } else if (tree[i][j].getState() > 0 && tree[i][j].getState() < 5 ) {
                    
                    if(tree[i][j].getState() == 1){
                       g.setColor(new Color(193,254,25));
                   
                    }else if(tree[i][j].getState() == 2){
                       g.setColor(new Color(143,232,0));
                   
                    }else if(tree[i][j].getState() == 3){
                       g.setColor(new Color(126,172,0));
                    
                    }else{
                       g.setColor(Color.GREEN.darker());
                    }
                // set burn to red    
                }else {
                    
                    if(tree[i][j].getState() == 5){
                       g.setColor(Color.red);
                    
                    // when tree burn 2 time
                    }else{
                       g.setColor(Color.red.darker());
                    }                    
                }

                g.fillRect(x + 2, y + 2, getSizeCell() - 2, getSizeCell() - 2);

            }
        }
    }

    public int getNumTree() {
        return numTree;
    }

    public void setNumTree(int numTree) {
        this.numTree = numTree;
        reset();
    }

    public void setNumprobtree(int numprobtree) {
        this.numprobtree = numprobtree;
    }

    public void setNumprobburn(int numprobburn) {
        this.numprobburn = numprobburn;
    }
       
    public int getNumprobtree() {
        return numprobtree;
    }

    public int getNumprobburn() {
        return numprobburn;
    }

    public void reset() {
       
        tree = new Tree[numTree][numTree];
        for (int i = 0; i < numTree; i++) {
            for (int j = 0; j < numTree; j++) {
                
                tree[i][j] = new Tree();
                
                // when random initiate empty tree or burn
                if (ran == true) {
                    // border
                    if (i == 0 || i == numTree - 1 || j == 0 || j == numTree - 1) {
                        tree[i][j].setState(0);
                    // check it tree or empty   
                    } else if (random(numprobtree)== true) {
                        // tree is burn
                        if (random(numprobburn) == true) {
                            tree[i][j].setState(5);
                        // random young to old tree    
                        } else {
                            tree[i][j].setState((int) (Math.random() * 4 + 1));
                        }
                    // this is empty    
                    } else {
                        tree[i][j].setState(0);
                    }
                // starter burn at center
                } else {
                    // set burn
                    if (i == numTree / 2 && j == numTree / 2) {
                        tree[i][j].setState(5);
                    }
                    // set border
                    else if (i == 0 || i == numTree - 1 || j == 0 || j == numTree - 1) {
                        tree[i][j].setState(0);
                    // set tree young - old    
                    }else{
                        tree[i][j].setState((int) (Math.random() * 4 + 1));
                    }
                }
            }
        }
    }

    public Tree[][] getTree() {
        return tree;
    }

    public void setTree(Tree[][] tree) {
        this.tree = tree;
    }

    public int getSizeCell() {
        return sizeCell;
    }

    public void setSizeCell(int sizeCell) {
        this.sizeCell = sizeCell;
        repaint();
    }

    void sizeCell() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void Tree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean random(int a) {
        int rnd = (int) (Math.random() * 100);
        return rnd < a;
    }
  
}
