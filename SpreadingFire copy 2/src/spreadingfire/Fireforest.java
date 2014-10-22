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
public class Fireforest {
    Tree[][] tree;
    Forest forest;
    
    public Fireforest(Forest forest){
        this.forest = forest;
        tree = new Tree[forest.getNumTree()][forest.getNumTree()];
        for(int i = 0 ; i < forest.getNumTree(); i++){
            for(int j = 0 ; j < forest.getNumTree() ; j++){
                tree[i][j] = new Tree();
                //tree[i][j].setState(0);
                if(i == 0 || i == tree.length-1 || j == 0 || j == tree.length-1){
                    tree[i][j].setState(0);
                } 
            }
        }
        forest.update(tree);
    }
  
}
