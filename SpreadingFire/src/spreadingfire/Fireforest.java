/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadingfire;
//123456788900765432
/**
 *
 * @author Tee
 */
public class Fireforest  {
    Tree[][] tree;
    static Forest forest;
    
    public Fireforest(Forest forest){
        this.forest = forest;
        tree = new Tree[forest.getNumTree()][forest.getNumTree()];
        //System.out.println(forest.getNumTree());
        for(int i = 0 ; i < forest.getNumTree(); i++){
            for(int j = 0 ; j < forest.getNumTree() ; j++){
                tree[i][j] = new Tree();
                //tree[i][j].setState(0);
                if(i == forest.getNumTree()/2 && j == forest.getNumTree()/2) {
                    tree[i][j].setState(2);
                }
                
                if(i == 0 || i == forest.getNumTree()-1 || j == 0 || j == forest.getNumTree()-1){
                    tree[i][j].setState(0);
                } 
            }
        }
        forest.update(tree);
    }
  
}
