import javazoom.jl.player.Player;

import java.io.FileInputStream;

public class stop_song implements Runnable {
       @Override
        public void run(play_song playMP3) {
            try {
                playMP3.stop();
            }catch (Exception e) {
                System.out.println(e);
            }

}
