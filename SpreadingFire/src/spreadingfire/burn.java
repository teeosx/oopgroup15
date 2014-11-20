/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spreadingfire;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Tee
 */
public class burn {

    Forest f = Fireforest.forest;
    boolean check[][] = new boolean[f.getNumTree()][f.getNumTree()];
    private boolean lighting , burntwo , grow , stop;
    private int cnt , addcnt , windlevel , numprobgrow , numproblight , numprob , winddirection;
    GUI g;

    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }

    public void setBurntwo(boolean burntwo) {
        this.burntwo = burntwo;
    }

    public void setGrow(boolean grow) {
        this.grow = grow;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void setWindlevel(int windlevel) {
        this.windlevel = windlevel;
    }

    public void setNumprobgrow(int numprobgrow) {
        this.numprobgrow = numprobgrow;
    }


    public void setNumproblight(int numproblight) {
        this.numproblight = numproblight;
    }

    public void setNumprob(int numprob) {
        this.numprob = numprob;
    }
    
    // check program finish or not
    public boolean finish() {
        for (int i = 0; i < f.getNumTree(); i++) {
            for (int j = 0; j < f.getNumTree(); j++) {
                // when button stop on program stop
                if (stop == true) {
                    return true;
                // when have burning tree or have lighting button on or grow tree button on program will run
                } else if (f.tree[i][j].getState() >= 5 || (lighting == true && f.tree[i][j].getState() > 0
                        && f.tree[i][j].getState() < 5) || grow == true) {
                    return false;
                }
            }
        }
        // program will stop
        return true;
    }
    // use for search everything like lighting , grow tree , burn spread
    public void search() {
        
        for (int i = 1; i < f.getNumTree() - 1; i++) {
            for (int j = 1; j < f.getNumTree() - 1; j++) {
                
                // tree develop every step
                if (f.tree[i][j].getState() >= 1 && f.tree[i][j].getState() <= 3) {
                    f.tree[i][j].stateUp();
                }
                // if cell = empty and grow button on and probability grow = true will do
                if (f.tree[i][j].getState() == 0 && grow == true && random(numprobgrow) == true) {
                    
                    // change cell empty to young tree
                    f.tree[i][j].setState(1);
                    check[i][j] = true;
                    
                }
                // if cell = tree and lighting button on and prob lighting = true will get lighting
                else if (f.tree[i][j].getState() >= 1 && f.tree[i][j].getState() < 5 
                        && lighting == true && random(g.numproblight) == true  ) {
                    // this when problight * probcatch true tree burn
                    if (random(g.numproblight * g.numprob / 100) == true) {
                        
                        if (g.lightsound == true) {
                            try {
                                String gongFile = "/Users/Game/GitHub/oopgroup15/SpreadingFire/src/spreadingfire/thunder-03.wav";
                                InputStream in = new FileInputStream(gongFile);

                                // create an audiostream from the inputstream
                                AudioStream audioStream = new AudioStream(in);

                                // play the audio clip with the audioplayer class
                                AudioPlayer.player.start(audioStream);

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "File not Found");
                            }
                        }
                        // when lighting spread on tree will spread in next 5 step
                        else if (g.lightningspread == true) {
                            
                            f.tree[i][j].setState(5);
                            f.tree[i][j].setstep(4);
                        
                        // tree burn normally    
                        } else {
                            
                            f.tree[i][j].setState(5);
                            
                        }
                    }
                // when cell = burn 
                } else if (f.tree[i][j].getState() >= 5 && check[i][j] == false) {
                    // have step it dont spreading now
                    if(f.tree[i][j].getstep() > 0){     
                        // step down and burn number 2
                        f.tree[i][j].stepDown(1);
                        f.tree[i][j].setState(6);
                        
                    }else{
                    // this cell be empty and check spread
                        f.tree[i][j].setState(0);
                        north(i, j);
                        south(i, j);
                        east(i, j);
                        west(i, j);
                    } 
                } 
            }
        }
    }
    
    // check cell north
    private void north(int x, int y) {
        
        if ("NORTH".equals(g.getDirection()) && windlevel > 0) {

            if (f.tree[x][y - 1].getState() >= 1 && f.tree[x][y - 1].getState() < 5
                    && f.tree[x][y - 2].getState() >= 1 && f.tree[x][y - 2].getState() < 5
                    && random(g.numprob) == true) {

                set(x, y - 1);
                set(x, y - 2);

            } else if (f.tree[x][y - 1].getState() >= 1 && f.tree[x][y - 1].getState() < 5
                    && f.tree[x][y - 2].getState() < 1 && f.tree[x][y - 2].getState() > 4
                    && random(g.numprob) == true) {

                set(x, y - 1);

            }

        } else if ("SOUTH".equals(g.getDirection()) && windlevel == 2) {

        } else {
            if (f.tree[x][y - 1].getState() >= 1 && f.tree[x][y - 1].getState() < 5
                    && random(g.numprob) == true) {

                set(x, y - 1);

            }

        }
    }

    private void south(int x, int y) {
        if ("SOUTH".equals(g.getDirection()) && windlevel > 0) {

            if (f.tree[x][y + 1].getState() >= 1 && f.tree[x][y + 1].getState() <= 5
                    && f.tree[x][y + 2].getState() >= 1 && f.tree[x][y + 2].getState() <= 5
                    && random(g.numprob) == true) {

                set(x, y + 1);
                set(x, y + 2);

            } else if (f.tree[x][y + 1].getState() == 1 && f.tree[x][y + 1].getState() <= 5
                    && f.tree[x][y + 2].getState() < 1 && f.tree[x][y + 2].getState() >= 5
                    && random(g.numprob) == true) {

                set(x, y + 1);

            }

        } else if ("NORTH".equals(g.getDirection()) && windlevel == 2) {

        } else {
            if (f.tree[x][y + 1].getState() >= 1 && f.tree[x][y + 1].getState() < 5
                    && random(g.numprob) == true) {

                set(x, y + 1);

            }

        }
    }

    private void west(int x, int y) {
        if ("WEST".equals(g.getDirection()) && windlevel > 0) {

            if (f.tree[x - 1][y].getState() >= 1 && f.tree[x - 1][y].getState() <= 5
                    && f.tree[x - 2][y].getState() >= 1 && f.tree[x - 2][y].getState() <= 5
                    && random(g.numprob) == true) {

                set(x - 1, y);
                set(x - 2, y);

            } else if (f.tree[x - 1][y].getState() >= 1 && f.tree[x - 1][y].getState() <= 5
                    && f.tree[x - 2][y].getState() < 1 && f.tree[x - 2][y].getState() >= 5
                    && random(g.numprob) == true) {

                set(x - 1, y);

            }

        } else if ("EAST".equals(g.getDirection()) && windlevel == 2) {

        } else {
            if (f.tree[x - 1][y].getState() >= 1 && f.tree[x - 1][y].getState() < 5
                    && random(g.numprob) == true) {

                set(x - 1, y);

            }

        }
    }

    private void east(int x, int y) {
        if ("EAST".equals(g.getDirection()) && windlevel > 0) {

            if (f.tree[x + 1][y].getState() >= 1 && f.tree[x + 1][y].getState() <= 5
                    && f.tree[x + 2][y].getState() >= 1 && f.tree[x + 2][y].getState() <= 5
                    && random(g.numprob) == true) {

                set(x + 1, y);
                set(x + 2, y);

            } else if (f.tree[x + 1][y].getState() >= 1 && f.tree[x + 1][y].getState() <= 5
                    && f.tree[x + 2][y].getState() < 1 && f.tree[x + 2][y].getState() >= 5
                    && random(g.numprob) == true) {

                set(x + 1, y);

            }

        } else if ("WEST".equals(g.getDirection()) && windlevel == 2) {

        } else {
            if (f.tree[x + 1][y].getState() >= 1 && f.tree[x + 1][y].getState() < 5
                    && random(g.numprob) == true) {

                set(x + 1, y);

            }

        }
    }

    private void set(int x, int y) {

        if (burntwo == true) {

            f.tree[x][y].setState(5);
            f.tree[x][y].setstep(1);
            check[x][y] = true;

        } else {
            if (check[x][y] == false) {
                f.tree[x][y].setState(5);
            }
            check[x][y] = true;

        }
    }

    private boolean random(int a) {
        int rnd = (int) (Math.random() * 99 + 1);
        if (rnd <= a) {
            return true;

        } else {
            return false;
        }

    }

    public void reset() {
        for (int i = 1; i < check.length - 1; i++) {
            for (int j = 1; j < check.length - 1; j++) {
                check[i][j] = false;
            }
        }
    }

    public void setG(GUI g) {
        this.g = g;
    }

    public void runfire() {
        //int cnt = 0;
        try {
            while (!finish()) {
                step();
            }

        } catch (Exception e) {

        }

    }

    public void step() {
        try {
            search();
            reset();

            if (finish() == true) {
                if (addcnt == 0) {
                    addcnt++;
                    cnt++;
                } else {
                }
            } else {
                cnt++;
            }
            f.update(f.tree);

            Thread.sleep(100);
        } catch (Exception e) {

        }
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getCnt() {
        return cnt;
    }

    public void setAddcnt(int addcnt) {
        this.addcnt = addcnt;
    }

}
