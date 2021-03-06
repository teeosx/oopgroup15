/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadingfire;

import com.sun.j3d.utils.scenegraph.io.state.com.sun.j3d.utils.behaviors.mouse.MouseBehaviorState;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CLOSED_OPTION;
import javax.swing.JTextField;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Tee
 */
public class GUI extends javax.swing.JFrame {

    Forest forest;
    Thread t;
    Fireforest fireforest;
    burn b;
    Tree[][] tree;
    boolean step = false;
    boolean onmouse = false;
    
    public GUI() {
        
        initComponents();
        forest = new Forest();
        fireforest = new Fireforest(forest);
        add(forest);
        b = new burn();
        b.setG(this);
        setExtendedState(MAXIMIZED_BOTH);
        forest.setG(this);
        setVisible(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        breset = new javax.swing.JButton();
        bstart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        final int FPS_MIN = 10;
        final int FPS_MAX = 50;
        final int FPS_INIT = 15;
        jSlider1 = new javax.swing.JSlider(JSlider.HORIZONTAL,
            FPS_MIN, FPS_MAX, FPS_INIT);
        probbutton = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spreading a Fire\n");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setName("frame"); // NOI18N
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        breset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spreadingfire/Images/Folders-OS-System-Restore-Metro-icon.png"))); // NOI18N
        breset.setBorderPainted(false);
        breset.setPreferredSize(new java.awt.Dimension(177, 140));
        breset.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bresetMouseMoved(evt);
            }
        });
        breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bresetActionPerformed(evt);
            }
        });

        bstart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spreadingfire/Images/Folders-OS-My-Videos-Metro-icon.png"))); // NOI18N
        bstart.setBorderPainted(false);
        bstart.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bstartMouseMoved(evt);
            }
        });
        bstart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bstartMouseClicked(evt);
            }
        });
        bstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bstartActionPerformed(evt);
            }
        });

        jLabel1.setText("Density");

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setSnapToTicks(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setPaintLabels(true);
        jSlider1.setOpaque(false);
        jSlider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                JSlider slider = (JSlider) evt.getSource();
                if (!slider.getValueIsAdjusting()) {
                    int value = slider.getValue();
                    jLabel5.setText(String.valueOf(value*value) + " grid");
                    if(value == 10) {

                        forest.setSizeCell(50);
                        repaint();

                    }else if(value == 20 ){
                        repaint();
                        forest.setSizeCell(30);
                    }
                    else if(value == 30){
                        repaint();
                        forest.setSizeCell(20);
                    }
                    else if(value == 40) {
                        repaint();
                        forest.setSizeCell(15);
                    }
                    else if(value == 50) {
                        repaint();
                        forest.setSizeCell(12);
                    }
                    else {
                        repaint();
                    }

                    forest.setNumTree(value);

                    //add(forest);

                    forest.repaint();
                    //System.out.println(value);
                    //JOptionPane.showMessageDialog(null, "Forest with"+ value*value + "Trees");
                }
            }
        });

        probbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spreadingfire/Images/Folders-OS-Configure-alt-1-Metro-icon.png"))); // NOI18N
        probbutton.setText("       Probability set.");
        probbutton.setBorderPainted(false);
        probbutton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                probbuttonMouseMoved(evt);
            }
        });
        probbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                probbuttonMouseClicked(evt);
            }
        });
        probbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                probbuttonActionPerformed(evt);
            }
        });
        probbutton.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                probbuttonPropertyChange(evt);
            }
        });

        jRadioButton1.setText("Auto Mode OFF");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spreadingfire/Images/coollogo_com-29201736.png"))); // NOI18N

        repaint();
        jLabel3.setText("---");

        jLabel4.setFont(new java.awt.Font("Trajan Pro 3", 0, 18)); // NOI18N
        jLabel4.setText("Current");

        jLabel5.setText("  ---");

        jRadioButton2.setText("Random Deactivate");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Trajan Pro", 0, 36)); // NOI18N
        jLabel6.setText("  Step = 0   ");

        jLabel7.setFont(new java.awt.Font("Yuppy SC", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 153));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spreadingfire/Images/Folders-OS-Default-Metro-icon.png"))); // NOI18N
        jButton1.setText("Help");
        jButton1.setToolTipText("");
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jRadioButton3.setText("Lightning OFF");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton4.setText("Lightning Spread");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NONE","NORTH", "SOUTH", "EAST","WEST" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"NONE", "LOW", "HIGH" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Wind Direction");

        jLabel9.setText("Wind Level");

        jToggleButton1.setText("SOUND");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jRadioButton5.setText("GrowTree");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioButton6.setText("StrongTree");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("STOP");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton5)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(26, 26, 26)
                        .addComponent(jRadioButton2)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bstart)
                        .addGap(67, 67, 67)
                        .addComponent(breset, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(probbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(breset, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bstart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(probbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4)
                            .addComponent(jToggleButton1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton6)
                            .addComponent(jToggleButton2))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );

        jButton1.getAccessibleContext().setAccessibleName("helpbut");

        pack();
    }// </editor-fold>//GEN-END:initComponents
        // reset button
    private void bresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bresetActionPerformed
        
        fireforest = new Fireforest(forest);
        forest.reset();
        b.setCnt(0);
        b.setAddcnt(0);
        b.setNumprob(0);
        jLabel6.setText("Step = 0");
        jLabel3.setText("---");
        jLabel5.setText("---");
        b.setStop(true);
        repaint();
    }//GEN-LAST:event_bresetActionPerformed

    private void probbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_probbuttonActionPerformed
     
    }//GEN-LAST:event_probbuttonActionPerformed
        // set numprob
    private void probbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_probbuttonMouseClicked
        // TODO add your handling code here:
        String prob = JOptionPane.showInputDialog(null, "Enter Probability percentage !");

        try {
            int numprob = Integer.parseInt(prob);
            // set numprob in program
            b.setNumprob(numprob);
            // input < 0 or > 100 dont have prob
            if (numprob < 0 || numprob > 100) {
                JOptionPane.showMessageDialog(null, "Error occur! Input only 0 - 100");
            } else {
                JOptionPane.showMessageDialog(null, "Probability set to " + numprob + " %");
                //System.out.println(numprob); test it is work
                jLabel3.setText(String.valueOf(numprob) + " %");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please insert only Integer");
        }
    }//GEN-LAST:event_probbuttonMouseClicked

    private void probbuttonPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_probbuttonPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_probbuttonPropertyChange
    // program run
    private void bstartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bstartMouseClicked

        t = new Thread() {
            public void run() {
                b.setStop(false);
                // auto
                if (step == true) {
                    while(!b.finish()){
                        b.step();
                        jLabel6.setText("Step = " + String.valueOf(b.getCnt()));
                    }               
                    repaint();
                // step by step    
                } else {
                    if(!b.finish()){
                        b.step();
                        jLabel6.setText("Step = " + String.valueOf(b.getCnt()));
                    }
                }              
            }       
        };

        t.start();
    }//GEN-LAST:event_bstartMouseClicked

    private void bstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bstartActionPerformed

    }//GEN-LAST:event_bstartActionPerformed
    // program run step by step
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if (jRadioButton1.isSelected() == true) {
            jRadioButton1.setText("Auto Mode ON");
            step = true;
        } else {
            step = false;
            jRadioButton1.setText("Auto Mode OFF");
        }

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
//        
    }//GEN-LAST:event_jRadioButton2ActionPerformed
    // set random initiate it tree or empty or burn
    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked

        // button on
        if (jRadioButton2.isSelected() == true) {
            try {
                String probtree = JOptionPane.showInputDialog(null, "Input Tree Percentage");
                int numprobtree = Integer.parseInt(probtree);
                // set prob of tree
                forest.setNumprobtree(numprobtree);
                // input < 0 or > 100 prob tree will be 100
                if (numprobtree < 0 || numprobtree > 100) {
                    JOptionPane.showMessageDialog(null, "Error occur! Input only 0 - 100\n Now value set to 100");
                    forest.setNumprobtree(100);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please insert only 0-100\n Now value set to 100");
                forest.setNumprobtree(100);

            }
            try {
                String probburn = JOptionPane.showInputDialog(null, "Input Burning Percentage");
                int numprobburn = Integer.parseInt(probburn);
                // set prob burn
                forest.setNumprobburn(numprobburn);
                // input probburn < 0 or > 100 proburn will be random 1-10
                if (numprobburn < 0 || numprobburn > 100) {
                    JOptionPane.showMessageDialog(null, "Error occur! Input only 0 - 100\n Now value will random");
                    forest.setNumprobburn((int)(Math.random() * 10));
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please insert only 0-100\n Now value will random");
                forest.setNumprobburn((int)(Math.random() * 10));
            }
            forest.setRan(true);
            
            jRadioButton2.setText("Random Mode Activated");
            
            if (forest.getNumprobburn() < 0 || forest.getNumprobburn() > 100) {
                forest.setNumprobburn(0);
            }
            else if (forest.getNumprobtree() < 0 || forest.getNumprobtree() > 100) {
                forest.setNumprobtree(100);
            }else{
               
                
            }
            
            this.setTitle("--- Random Mode Activated ---" + " ಥ‿ಥ Current Tree is " + forest.getNumprobtree() + " %" + " Burning " + forest.getNumprobburn() + " % ಥ‿ಥ");
            forest.reset();
            repaint();
        
        } else {
            
            forest.setRan(false);
            forest.reset();
            repaint();
            jRadioButton2.setText("Random Deactivate");
            this.setTitle("Spreading a fire");
        
        }
    }//GEN-LAST:event_jRadioButton2MouseClicked
        // set text
    private void bstartMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bstartMouseMoved

        jLabel7.setText("Click to start");

    }//GEN-LAST:event_bstartMouseMoved
        // set text
    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

        jLabel7.setText("");
    }//GEN-LAST:event_formMouseMoved
        // set text
    private void bresetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bresetMouseMoved
        jLabel7.setText("Reset the probability");
    }//GEN-LAST:event_bresetMouseMoved
        // set text
    private void probbuttonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_probbuttonMouseMoved
        jLabel7.setText("Set the probability");
    }//GEN-LAST:event_probbuttonMouseMoved
        // help button
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/teeosx/oopgroup15/wiki/Software-Documentation").toURI());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1MouseClicked
        // set lighting and problighting
    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        try {
            // set lighting and setproblighting
            if (jRadioButton3.isSelected()) {
                b.setLighting(true);
                jRadioButton3.setText("Lightning ON");
                String problight = JOptionPane.showInputDialog(null, "Input the probability of lightning",JOptionPane.QUESTION_MESSAGE);
                int numproblight = Integer.parseInt(problight);
                b.setNumproblight(numproblight);
                repaint();
                // input < 0 or > 100 set problight 0 
                if (numproblight < 0 || numproblight > 100) {
                    JOptionPane.showMessageDialog(null, "Error occur! Input only 0 - 100\n Now value set to 0");
                    b.setNumproblight(0);
                }
                // button off
            } else {
                jRadioButton3.setText("Lightning OFF");
                b.setNumproblight(0);
                b.setLighting(false);
                repaint();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Plese insert only number");
            b.setNumproblight(0);
            
            jRadioButton3.setText("Lightning OFF");
            
            repaint();
        }
        
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed


    }//GEN-LAST:event_jRadioButton3ActionPerformed
        // set wind direction
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String direction = jComboBox1.getSelectedItem().toString();
        // set direction north
        if (direction.equals("NORTH")) {
          b.setWinddirection(1);
        }
        // set direction south
        else if (direction.equals("SOUTH")){
          b.setWinddirection(3);  
        }
        // set direction east
        else if (direction.equals("EAST")){
          b.setWinddirection(2);  
        }
        // set direction west
        else if (direction.equals("WEST")){
          b.setWinddirection(4);
        // set direction none
        }else{
          b.setWinddirection(0);
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed
        // set wind level
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
         String windlevel = jComboBox2.getSelectedItem().toString();
         //set low into number in class burn
        if (windlevel.equals("LOW")) {
         b.setWindlevel(1);
        }
        // set high
        else if (windlevel.equals("HIGH")){
         b.setWindlevel(2);
         // set none
        }else{
         b.setWindlevel(0);  
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed
        // set lighting spread
    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton4.isSelected()){
            b.setLightingspread(true);
          
        }else{
            b.setLightingspread(false);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed
   // button for set lighting sound
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        
        if(jToggleButton1.isSelected()){
            b.setLightsound(true);
         
        }else{
            b.setLightsound(false);          
       
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed
    // button for setgrow and progrow
    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        try {
            // when select setboolean and set probgrow for calculate
            if (jRadioButton5.isSelected()) {
                b.setGrow(true);
                jRadioButton5.setText("TreeGrow On");
               String probgrow = JOptionPane.showInputDialog(null, "Input the probability of growTree",JOptionPane.QUESTION_MESSAGE);
               int numprobgrow = Integer.parseInt(probgrow);
               b.setNumprobgrow(numprobgrow);
                repaint();
                // if input number < 0 or > 100 it will be 0
                if (numprobgrow < 0 || numprobgrow > 100) {
                    JOptionPane.showMessageDialog(null, "Error occur! Input only 0 - 100\n Now value set to 0");
                    b.setNumprobgrow(0);
                }
            } else {
                // button off
                jRadioButton5.setText("TreeGrow OFF");
                b.setGrow(false);
                b.setNumprobgrow(0);
                repaint();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Plese insert only number");
            jRadioButton5.setText("TreeGrow OFF");
            b.setGrow(false);
            b.setNumprobgrow(0);
            repaint();
        }
    }//GEN-LAST:event_jRadioButton5ActionPerformed
    // button to set tree burn two time
    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        if(jRadioButton6.isSelected()){
            b.setBurntwo(true);
            forest.setBurn(true);
        }else{
            b.setBurntwo(false); 
            forest.setBurn(false);
            }           
    }//GEN-LAST:event_jRadioButton6ActionPerformed
    // button stop program
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
            
        b.setStop(true); 
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new GUI().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton breset;
    private javax.swing.JButton bstart;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JButton probbutton;
    // End of variables declaration//GEN-END:variables

}
