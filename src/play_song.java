import javazoom.jl.player.Player;

import java.io.FileInputStream;

public class play_song implements Runnable {
    long total_length;
    long current_position;
    boolean ispaused=false;
    FileInputStream file;
    Player playMP3;

    @Override
    public void run() {
        try {
            file = new FileInputStream("src/songs/Auld Lang Syne (Instrumental) - Jingle Punks.mp3");
            if (ispaused)
            {
                file.skip(current_position);
            }
            total_length=file.available();
            playMP3 = new Player(file);
            playMP3.play();
        } catch (Exception e) {
            System.out.println(e);
        }

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
            System.out.println(current_position);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

}
