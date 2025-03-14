import javazoom.jl.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.FileInputStream;

public class play_song implements Runnable {
    JFileChooser j;



//    String file_path="src/songs/Auld Lang Syne (Instrumental) - Jingle Punks.mp3";
    FileInputStream file;
    Player playMP3;
    long total_length;
    long current_position;
    boolean ispaused=false,isFileSelected=false;
    String file_path;

    @Override
    public void run() {
        try {
            file = new FileInputStream(file_path);
            playMP3 = new Player(file);
            isFileSelected=true;
                total_length = file.available();

                if (ispaused) {
                    file.skip(current_position);
                }
                playMP3.play();


        } catch (NullPointerException e)
        {
            isFileSelected=false;
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
    public boolean is_file_selcted()
    {
        return isFileSelected;
    }
    public String file_opener(){
        j= new JFileChooser("src/songs");
        int r=j.showOpenDialog(null);
        if(r==0)
        {
            isFileSelected=true;
        }
//        System.out.println(r);
        file_path=  j.getSelectedFile().getAbsolutePath();
        return file_path;
    }
    public void stop_song(){
        try {
                playMP3.close();
            }catch (Exception e) {
                System.out.println(e);
            }
    }
    public void pause_song(){
        try {
            current_position=total_length-file.available();
            ispaused=true;
            playMP3.close();
//            System.out.println(current_position);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

}
