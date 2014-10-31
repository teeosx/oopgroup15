/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package firelogic;

import java.util.Scanner;

/**
 *
 * @author Game
 */
public class FireLogic {

    public static void main(String[] args) {
        int step = 0;
        lololo lo = new lololo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert Size : "); 
        int size = sc.nextInt();
        lo.setSize(size);
        System.out.print("Insert Prob : "); 
        int prob = sc.nextInt();
        lo.setProb(prob);
        lo.createForest();
        System.out.println("");
        System.out.println("step " + step);
        lo.print();
        step++;
         
        while(lo.finish() == false){
            System.out.println("");
            System.out.println("step " + step);
            step++;
            lo.search();
            lo.reset();
            lo.print();
            
        }

    }
    

    
    
}
