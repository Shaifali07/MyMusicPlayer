import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame frame;
    JButton play, pause,resume,stop;
    ImageIcon icon_play,icon_pause,icon_resume,icon_stop;
    JPanel panel = new JPanel();
    play_song a1=new play_song();
    Thread play_the_song;
    Thread resume_the_song;
public GUI()
{
    frame=new JFrame("MY MUSIC PLAYER");
    frame.setSize(400,200);

    icon_play =new ImageIcon("src/images/play-button.png");
    icon_pause =new ImageIcon("src/images/pause-button.png");
    icon_resume =new ImageIcon("src/images/resume-button.png");
    icon_stop =new ImageIcon("src/images/stop-button.png");
    play= new JButton(icon_play);
    play.addActionListener(this);
    pause= new JButton(icon_pause);
    pause.addActionListener(this);
    resume= new JButton(icon_resume);
    resume.addActionListener(this);
    stop= new JButton(icon_stop);
    stop.addActionListener(this);


    panel.add(play);
    panel.add(pause);
    panel.add(resume);
    panel.add(stop);
    frame.getContentPane().add(BorderLayout.SOUTH,panel);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play) {
            play_the_song= new Thread(a1);
            play_the_song.start();
        }
//            frame.getContentPane().setBackground(Color.pink);
        if(e.getSource() == pause) {
              a1.pause_song();
        }
        if(e.getSource() == resume) {
            resume_the_song = new Thread(a1);
            resume_the_song.start();
        }
        if(e.getSource() == stop)
            a1.stop_song();

    }
}