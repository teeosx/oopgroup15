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
    private boolean lighting , burntwo, grow , stop , lightingspread , lightsound;
    private int cnt , addcnt , windlevel , numprobgrow , numproblight , numprob , winddirection , lightcnt;
    GUI g;

    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }

    public void setBurntwo(boolean burntwo) {
        this.burntwo = burntwo;
    }
    
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void setGrow(boolean grow) {
        this.grow = grow;
    }
    

    public void setWindlevel(int windlevel) {
        this.windlevel = windlevel;
    }

    public void setWinddirection(int winddirection) {
        this.winddirection = winddirection;
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

    public void setLightingspread(boolean lightingspread) {
        this.lightingspread = lightingspread;
    }

    public void setLightsound(boolean lightsound) {
        this.lightsound = lightsound;
    }
    
    
    
    // check program finish or not
    public boolean finish() {
        for (int i = 0; i < f.getNumTree(); i++) {
            for (int j = 0; j < f.getNumTree(); j++) {
                // when button stop on program stop
                if (stop == true){ 
                    return true;
                // when have burning tree or have lighting button on or grow tree button on program will run
                } else if (f.tree[i][j].getState() >= 5 || (lighting == true && f.tree[i][j].getState() >= 1)
                         ) {
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
                        && lighting == true && random(numproblight) == true  ) {
                    // this when problight * probcatch true tree burn
                    if (random(numproblight * numprob / 100) == true) {
                        
                        if (lightsound == true && lightcnt == 0 ) {
                            try {
                                String gongFile = "/Users/Game/GitHub/oopgroup15/SpreadingFire/src/spreadingfire/Sound/thunder-03.wav";
                                InputStream in = new FileInputStream(gongFile);

                                // create an audiostream from the inputstream
                                AudioStream audioStream = new AudioStream(in);

                                // play the audio clip with the audioplayer class
                                AudioPlayer.player.start(audioStream);
                                lightcnt++;

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "File not Found");
                            }
                        }
                        // when lighting spread spread on step 2,3 and 4 and 5 go to empty
                        if (lightingspread == true) {
                            
                            f.tree[i][j].setState(5);
                            f.tree[i][j].setLightstep(5);
                        
                        // tree burn normally    
                        } else {
                            
                            f.tree[i][j].setState(5);
                            
                        }
                    }
                // when cell = burn 
                } else if (f.tree[i][j].getState() >= 5 && check[i][j] == false) {
                    // have step it dont spreading now
                    if(f.tree[i][j].getstep() > 0 ){     
                        // step down and burn number 2
                        f.tree[i][j].stepDown(1);
                        f.tree[i][j].setState(6);
                        north(i, j);
                        south(i, j);
                        east(i, j);
                        west(i, j);
                     // when lighting spread   
                    }else if (f.tree[i][j].getLightstep() > 0){
                         // first term no spread
                        if(f.tree[i][j].getLightstep() == 5){
                            f.tree[i][j].stepLightDown();
                            f.tree[i][j].setState(6);
                         // term five go to empty   
                        }else if (f.tree[i][j].getLightstep() == 1){
                            f.tree[i][j].setState(0);
                         // term 2 , 3 ,4 spread  
                        }else{
                            f.tree[i][j].stepLightDown();
                            north(i, j);
                            south(i, j);
                            east(i, j);
                            west(i, j);
                        }
                    
                    
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
    
    // check north
    private void north(int x, int y) {
        // when wind direction = north and wind level low or high
        if (winddirection == 1 && windlevel > 0) {
            // if north 2 cell is a tree will burn 2
            if (f.tree[x][y - 1].getState() >= 1 && f.tree[x][y - 1].getState() < 5
                    && f.tree[x][y - 2].getState() >= 1 && f.tree[x][y - 2].getState() < 5
                    && random(numprob) == true) {

                set(x, y - 1);
                set(x, y - 2);
            // only north 1 cell is tree burn 1
            } else if (f.tree[x][y - 1].getState() >= 1 && f.tree[x][y - 1].getState() < 5
                    && f.tree[x][y - 2].getState() < 1 && f.tree[x][y - 2].getState() > 4
                    && random(numprob) == true) {

                set(x, y - 1);

            }
            // when wind direction = south and windlevel high no burn north
        } else if (winddirection == 3 && windlevel == 2) {
            // another winddirection and wind level
        } else {
            if (f.tree[x][y - 1].getState() >= 1 && f.tree[x][y - 1].getState() < 5
                    && random(numprob) == true) {

                set(x, y - 1);

            }

        }
    }
    // check south
    private void south(int x, int y) {
        // wind = south and wind level low or high
        if (winddirection == 3 && windlevel > 0) {
            // south 2 cell is tree and rand true will burn 2
            if (f.tree[x][y + 1].getState() >= 1 && f.tree[x][y + 1].getState() < 5
                    && f.tree[x][y + 2].getState() >= 1 && f.tree[x][y + 2].getState() < 5
                    && random(numprob) == true) {

                set(x, y + 1);
                set(x, y + 2);
            // only south 1 cell is tree will burn 1
            } else if (f.tree[x][y + 1].getState() >= 1 && f.tree[x][y + 1].getState() < 5
                    && f.tree[x][y + 2].getState() < 1 && f.tree[x][y + 2].getState() >= 5
                    && random(numprob) == true) {

                set(x, y + 1);

            }
        // wind = north and windlevel high dont do sout
        } else if (winddirection == 1 && windlevel == 2) {
        
        // normal burn 1 cel south
        } else {
            if (f.tree[x][y + 1].getState() >= 1 && f.tree[x][y + 1].getState() < 5
                    && random(numprob) == true) {

                set(x, y + 1);

            }
        }
    }
    // check west
    private void west(int x, int y) {
        // winddirection = west and windlevel low or high
        if (winddirection == 4 && windlevel > 0) {
            // 2 left cell is tree will burn 2
            if (f.tree[x - 1][y].getState() >= 1 && f.tree[x - 1][y].getState() <= 5
                    && f.tree[x - 2][y].getState() >= 1 && f.tree[x - 2][y].getState() <= 5
                    && random(numprob) == true) {

                set(x - 1, y);
                set(x - 2, y);
            // only 1 left cell is tree will burn 1
            } else if (f.tree[x - 1][y].getState() >= 1 && f.tree[x - 1][y].getState() <= 5
                    && f.tree[x - 2][y].getState() < 1 && f.tree[x - 2][y].getState() >= 5
                    && random(numprob) == true) {

                set(x - 1, y);

            }
        // winddirection = east and windlevel high dont do anything
        } else if (winddirection == 2 && windlevel == 2) {
       
            // normal burn left cell if it a tree and random = true
        } else {
            if (f.tree[x - 1][y].getState() >= 1 && f.tree[x - 1][y].getState() < 5
                    && random(numprob) == true) {

                set(x - 1, y);

            }
        }
    }
    // check east
    private void east(int x, int y) {
        // winddirection = east and windlevel low or high
        if (winddirection == 2 && windlevel > 0) {
            // 2 right cell is tree will burn 2
            if (f.tree[x + 1][y].getState() >= 1 && f.tree[x + 1][y].getState() < 5
                    && f.tree[x + 2][y].getState() >= 1 && f.tree[x + 2][y].getState() < 5
                    && random(numprob) == true) {

                set(x + 1, y);
                set(x + 2, y);
            // only 1 right cell is tree
            } else if (f.tree[x + 1][y].getState() >= 1 && f.tree[x + 1][y].getState() < 5
                    && f.tree[x + 2][y].getState() < 1 && f.tree[x + 2][y].getState() >= 5
                    && random(numprob) == true) {

                set(x + 1, y);

            }
        // winddirection = west and windlevel high dont do right cell
        } else if (winddirection == 4 && windlevel == 2) {
        // right cell burn 1
        } else {
            if (f.tree[x + 1][y].getState() >= 1 && f.tree[x + 1][y].getState() < 5
                    && random(numprob) == true) {

                set(x + 1, y);

            }
        }
    }
    // to set tree burn
    private void set(int x, int y) {
        // when tree have 2 time for burn
        if (burntwo == true) {
            if (check[x][y] == false){
            f.tree[x][y].setState(5);
            f.tree[x][y].setstep(1);
            check[x][y] = true;
            }
        // normally burn
        } else {
            if (check[x][y] == false) {
                f.tree[x][y].setState(5);
                check[x][y] = true;
            }
        }
    }
    // for it burn or lighting or grow or not
    private boolean random(int a) {
        int rnd = (int) (Math.random() * 99+1 );
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
        lightcnt = 0;
    }

    public void setG(GUI g) {
        this.g = g;
    }
    // run 
    public void runfire() {
        //int cnt = 0;
        try {
            while (!finish()) {
                step();
            }

        } catch (Exception e) {

        }

    }
    // run program step by step
    public void step() {
        try {
            search();
            reset();
            //for step in finish
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
