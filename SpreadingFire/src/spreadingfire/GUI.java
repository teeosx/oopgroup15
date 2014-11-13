/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadingfire;

import com.sun.j3d.utils.scenegraph.io.state.com.sun.j3d.utils.behaviors.mouse.MouseBehaviorState;
import java.awt.Desktop;
import java.net.URL;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CLOSED_OPTION;
import javax.swing.JTextField;

/**
 *
 * @author Tee
 */
public class GUI extends javax.swing.JFrame {

    static Forest forest;
    String prob;
    int numprob;
    String problight;
    int numproblight;
    Fireforest fireforest;
    burn b;
    Tree[][] tree;
    boolean step = false;
    String probtree;
    String probburn;
    int numprobtree;
    int numprobburn;
    boolean onmouse = false;

    public GUI() {
        initComponents();
        forest = new Forest();
        fireforest = new Fireforest(forest);
        add(forest);
        //jSlider1.addForest(forest)
        b = new burn();
        b.setG(this);
        setExtendedState(MAXIMIZED_BOTH);
        forest.setG(this);
        setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spreading a Fire\n");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setName("frame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        breset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spreadingfire/Folders-OS-System-Restore-Metro-icon.png"))); // NOI18N
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

        bstart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spreadingfire/Folders-OS-My-Videos-Metro-icon.png"))); // NOI18N
        bstart.setBorderPainted(false);
        bstart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bstartMouseClicked(evt);
            }
        });
        bstart.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bstartMouseMoved(evt);
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

        probbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spreadingfire/Folders-OS-Configure-alt-1-Metro-icon.png"))); // NOI18N
        probbutton.setText("       Probability set.");
        probbutton.setBorderPainted(false);
        probbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                probbuttonMouseClicked(evt);
            }
        });
        probbutton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                probbuttonMouseMoved(evt);
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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spreadingfire/coollogo_com-29201736.png"))); // NOI18N

        repaint();
        jLabel3.setText("---");

        jLabel4.setFont(new java.awt.Font("Trajan Pro 3", 0, 18)); // NOI18N
        jLabel4.setText("Current");

        jLabel5.setText("---");

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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/spreadingfire/Folders-OS-Default-Metro-icon.png"))); // NOI18N
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NONE","NORTH", "SOUTH", "EAST","WEST" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"NONE", "LOW", "HIGH" }));

        jLabel8.setText("Wind Direction");

        jLabel9.setText("Wind Level");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(26, 26, 26)
                                .addComponent(jRadioButton2)
                                .addGap(8, 8, 8))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bstart)
                                .addGap(67, 67, 67)
                                .addComponent(breset, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(113, 113, 113)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
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
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(324, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jButton1.getAccessibleContext().setAccessibleName("helpbut");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bresetActionPerformed
        fireforest = new Fireforest(forest);
        forest.reset();
        // forest.update(tree);
        b.setCnt(0);
        b.setAddcnt(0);
        jLabel6.setText("Step = 0");
        jLabel3.setText("---");
        numprob = 0;
        jLabel5.setText("---");
        repaint();
    }//GEN-LAST:event_bresetActionPerformed

    private void probbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_probbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_probbuttonActionPerformed

    private void probbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_probbuttonMouseClicked
        // TODO add your handling code here:
        prob = JOptionPane.showInputDialog(null, "Enter Probability percentage !");

        try {
            numprob = Integer.parseInt(prob);
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

    private void bstartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bstartMouseClicked
        Thread t = new Thread() {
            public void run() {
                if (step == true) {
                    b.runfire();
                    jLabel6.setText("Step = " + String.valueOf(b.getCnt()));
                    repaint();
                } else {
                    b.step();
                    jLabel6.setText("Step = " + String.valueOf(b.getCnt()));
                }

            }
        };
        t.start();
    }//GEN-LAST:event_bstartMouseClicked

    private void bstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bstartActionPerformed

    }//GEN-LAST:event_bstartActionPerformed

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

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked

        if (jRadioButton2.isSelected() == true) {
            try {
                probtree = JOptionPane.showInputDialog(null, "Input Tree Percentage");
                numprobtree = Integer.parseInt(probtree);
                if (numprobtree < 0 || numprobtree > 100) {
                    JOptionPane.showMessageDialog(null, "Error occur! Input only 0 - 100\n Now value set to 100");
                    numprobtree = 100;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please insert only 0-100\n Now value set to 100");
                numprobtree = 100;

            }
            try {
                probburn = JOptionPane.showInputDialog(null, "Input Burning Percentage");
                numprobburn = Integer.parseInt(probburn);
                if (numprobburn < 0 || numprobburn > 100) {
                    JOptionPane.showMessageDialog(null, "Error occur! Input only 0 - 100\n Now value will random");
                    numprobburn = (int) (Math.random() * 10);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please insert only 0-100\n Now value will random");
                numprobburn = (int) (Math.random() * 10);
            }
            forest.ran = true;
            jRadioButton2.setText("Random Mode Activated");
            if (numprobburn < 0 || numprobburn > 100) {
                numprobburn = 0;
            }
            if (numprobtree < 0 || numprobtree > 100) {
                numprobtree = 1000;
            }
            this.setTitle("--- Random Mode Activated ---" + " ಥ‿ಥ Current Tree is " + numprobtree + " %" + " Burning " + numprobburn + " % ಥ‿ಥ");
            forest.reset();
            repaint();
        } else {
            forest.ran = false;
            forest.reset();
            repaint();
            jRadioButton2.setText("Random Deactivate");
            this.setTitle("Spreading a fire");
        }
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void bstartMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bstartMouseMoved

        jLabel7.setText("Click to start");

    }//GEN-LAST:event_bstartMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

        jLabel7.setText("");
    }//GEN-LAST:event_formMouseMoved

    private void bresetMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bresetMouseMoved
        jLabel7.setText("Reset the probability");
    }//GEN-LAST:event_bresetMouseMoved

    private void probbuttonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_probbuttonMouseMoved
        jLabel7.setText("Set the probability");
    }//GEN-LAST:event_probbuttonMouseMoved

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/teeosx/oopgroup15/wiki/Software-Documentation").toURI());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        try {
            if(jRadioButton3.isSelected()){
                b.lighting = true;
                jRadioButton3.setText("Lightning ON");
                problight = JOptionPane.showInputDialog(null, "Input the probability of lightning");
                numproblight = Integer.parseInt(problight);
                repaint();
            if (numproblight < 0 || numproblight > 100) {
                    JOptionPane.showMessageDialog(null, "Error occur! Input only 0 - 100\n Now value set to 0");
                    numproblight = 0;
                }
            }else{
                jRadioButton3.setText("Lightning OFF");
                numproblight = 0;
                repaint();
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Plese insert only number");
            jRadioButton3.setText("Lightning OFF");
            repaint();
        }

    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed

    }//GEN-LAST:event_jRadioButton3ActionPerformed

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
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton probbutton;
    // End of variables declaration//GEN-END:variables

    public int getNumprob() {
        return numprob;
    }

    public int getNumprobtree() {
        return numprobtree;
    }

    public int getNumproblight() {
        return numproblight;
    }

    public void setNumproblight(int numproblight) {
        this.numproblight = numproblight;
    }

    public int getNumprobburn() {
        return numprobburn;
    }
}
