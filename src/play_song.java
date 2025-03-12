import javazoom.jl.player.Player;

import java.io.FileInputStream;

public class play_song implements Runnable {
    FileInputStream file;
    Player playMP3;
    @Override
    public void run() {
        try {
            file = new FileInputStream("src/songs/Auld Lang Syne (Instrumental) - Jingle Punks.mp3");
            playMP3 = new Player(file);
            playMP3.play();
        }catch (Exception e) {
            System.out.println(e);
        }
}
