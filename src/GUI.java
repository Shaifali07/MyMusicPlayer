import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame frame;
    JButton play, pause, resume, stop;
    ImageIcon icon_play, icon_pause, icon_resume, icon_stop;
    JPanel panel = new JPanel();
    JPanel center = new JPanel();
    JLabel l;


    JMenu menu = new JMenu("File");
    JMenuItem item1 = new JMenuItem();
    JMenuBar mb = new JMenuBar();

    play_song a1 = new play_song();
    Thread play_the_song;
    Thread resume_the_song;

    public GUI() {
        frame = new JFrame("MY MUSIC PLAYER");
        frame.setSize(400, 200);
        item1 = new JMenuItem("open");
        menu.add(item1);
        mb.add(menu);
        icon_play = new ImageIcon("src/images/play-button.png");
        icon_pause = new ImageIcon("src/images/pause-button.png");
        icon_resume = new ImageIcon("src/images/resume-button.png");
        icon_stop = new ImageIcon("src/images/stop-button.png");
        l = new JLabel("No file selected",SwingConstants.CENTER);
        play = new JButton(icon_play);
        play.addActionListener(this);
        pause = new JButton(icon_pause);
        pause.addActionListener(this);
        resume = new JButton(icon_resume);
        resume.addActionListener(this);
        stop = new JButton(icon_stop);
        stop.addActionListener(this);
        item1.addActionListener(this);
        frame.add(l,BorderLayout.CENTER);

        panel.add(play);
        panel.add(pause);
        panel.add(resume);
        panel.add(stop);
//        center.add(l);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
//        frame.getContentPane().add(BorderLayout.CENTER, center);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play ) {
            if(! a1.is_file_selcted())
            {
                l.setText("Please select the file");
                frame.add(l,BorderLayout.CENTER);
                frame.setVisible(true);
            }
            if (play_the_song == null || !play_the_song.isAlive()) {
                play_the_song = new Thread(a1);
                play_the_song.start();
            }
        }
//            frame.getContentPane().setBackground(Color.pink);
        if (e.getSource() == pause) {
            a1.pause_song();
        }
        if (e.getSource() == resume) {
            if(! a1.is_file_selcted())
            {
                l.setText("Please select the file");
                frame.add(l,BorderLayout.CENTER);
                frame.setVisible(true);
            }
            if (play_the_song == null || !play_the_song.isAlive()) {
                play_the_song = new Thread(a1);
                play_the_song.start();
            }
        }
        if (e.getSource() == stop)
            a1.stop_song();
        if (e.getSource() == item1) {
            String file_path = a1.file_opener();
            l.setText(file_path);
            frame.add(l,BorderLayout.CENTER);
            frame.setVisible(true);
        }
    }
}