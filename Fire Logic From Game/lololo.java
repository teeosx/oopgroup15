/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package firelogic;

/**
 *
 * @author Game
 */
public class lololo {
    private int size;
    private int prob;
    int tree[][] ;
    boolean check[][] ;

     public boolean finish() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tree[i][j] == 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setProb(int prob) {
        this.prob = prob;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public void createForest(){
        tree = new int[size][size];
        check = new boolean[size][size];
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(i == 0 || j == 0 || i == size-1 || j == size -1){
                    tree[i][j] = 0;
                }else if( i == size/2 && j == size/2){
                    tree[i][j] = 2;
                }else{
                    tree[i][j] = 1;
                }
                    
            }
        }
            
    }
    public void print(){
         for(int i = 0 ; i < size ; i++){
            for(int j=0 ; j < size ; j++){
                System.out.print(tree[i][j] + " ");
                  }
                System.out.println("");
                }
            }
    public void search() {
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                if (tree[i][j] == 2 && check[i][j] == false ) {
                    tree[i][j] = 0;
                    north(i, j);
                    south(i, j);
                    west(i, j);
                    east(i, j);
                }
            }
        }
    }
    private void north(int x, int y) {
        if (tree[x][y - 1] == 1 && random(prob) == true) {
            tree[x][y - 1] = 2;
            check[x][y - 1] = true;
        }       // north
    }

    private void south(int x, int y) {
        if (tree[x][y + 1] == 1 && random(prob) == true) {
            tree[x][y + 1] = 2;
            check[x][y + 1] = true;
        }    // south
    }

    private void west(int x, int y) {
        if (tree[x - 1][y] == 1 && random(prob) == true) {
            tree[x - 1][y] = 2;
            check[x - 1][y] = true;
        }       // west
    }

    private void east(int x, int y) {
        if (tree[x + 1][y] == 1 && random(prob) == true) {
            tree[x + 1][y] = 2;
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
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                check[i][j] = false;
            }
        }
    }
}

    
    

