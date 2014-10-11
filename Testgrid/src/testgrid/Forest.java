/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgrid;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;


public class Forest extends JFrame{

public Forest(){
this.setSize(290,339);
this.setDefaultCloseOperation(JFrame.EXI­T_ON_CLOSE);
this.setVisible(true);

}
public void paint(Graphics g){
g.setColor(Color.BLACK);
g.drawRect(40, 40, 30, 30);
}
}
