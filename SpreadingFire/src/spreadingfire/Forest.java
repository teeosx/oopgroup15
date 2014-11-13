/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadingfire;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author Tee
 */
public class Forest extends JPanel {

    Tree tree[][];
    private int numTree;
    private int sizeCell;
    boolean ran = false;
    //String probtree = "";
    int numprobtree = 90;
    //String probburning = "";
    int numprobburning = 20;
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
        
        //tree = new Tree[getNumTree()][getNumTree()];
        setSize(650, 650);

        //repaint();
    }

    public void update(Tree[][] tree) {
        this.tree = tree;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < getNumTree(); i++) {
            for (int j = 0; j < getNumTree(); j++) {
                int x = (i + 1) * getSizeCell(); //เก็บพิกัดของแต่ละต้น พิกัด x
                int y = (j + 1) * getSizeCell(); // พิกัด y
                if (tree[i][j].getState() == 0) {
                    g.setColor(Color.yellow);
                } else if (tree[i][j].getState() == Tree.TREE) {
                    g.setColor(Color.green.darker());
                }else {
                    g.setColor(Color.RED);
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

    public void reset() {
        //numprobtree = Integer.parseInt(probtree);
        //numprobburning = Integer.parseInt(probburning);
        tree = new Tree[numTree][numTree];
        //System.out.println(forest.getNumTree());
        for (int i = 0; i < numTree; i++) {
            for (int j = 0; j < numTree; j++) {
                tree[i][j] = new Tree();
                //tree[i][j].setState(0);
                if (ran == true) {
                    if (i == 0 || i == numTree - 1 || j == 0 || j == numTree - 1) {
                        tree[i][j].setState(0);
                    } else if (random(g.numprobtree)== true) {
                        if (random(g.numprobburn) == true) {
                            tree[i][j].setState(2);
                        } else {
                            tree[i][j].setState(1);
                        }
                    } else {
                        tree[i][j].setState(0);
                    }

                } else {
                    if (i == numTree / 2 && j == numTree / 2) {
                        tree[i][j].setState(2);
                    }
                    if (i == 0 || i == numTree - 1 || j == 0 || j == numTree - 1) {
                        tree[i][j].setState(0);
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
        if (rnd < a) {
            return true;
        } else {
            return false;
        }
    }
}
