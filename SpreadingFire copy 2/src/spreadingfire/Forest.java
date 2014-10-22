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
public class Forest extends JPanel{
    Tree tree[][];
    private int numTree;
    private int sizeCell;
    
    public Forest(){
        numTree = 100;
        sizeCell = 6;
        //tree = new Tree[getNumTree()][getNumTree()];
        setSize (650,650);
        
        //repaint();
    }
    
    public void update(Tree[][] tree){
        this.tree = tree;
        repaint();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0 ; i < getNumTree() ; i++){
            for(int j = 0 ; j < getNumTree() ; j++){
                int x = (i+1) * getSizeCell(); //เก็บพิกัดของแต่ละต้น พิกัด x
                int y = (j+1) * getSizeCell(); // พิกัด y
                //tree[i][j] = new Tree();
                if (tree[i][j].getState()== 0) {
                    g.setColor(Color.yellow);
                } else if (tree[i][j].getState()== Tree.TREE) {
                    g.setColor(Color.green.darker());
                } else {
                    g.setColor(Color.RED);
                }
               // g.setColor(Color.green.darker());
                g.fillRect(x+2,y+2,getSizeCell()-2,getSizeCell()-2); 
                // g.fillRect(x+1,y+1,getSizeCell()-1,getSizeCell()-1); 
                
            }
        }
    }

    public int getNumTree() {
        return numTree;
    }

    public void setNumTree(int numTree) {
        this.numTree = numTree;
        //repaint();
        
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
    
    
}
