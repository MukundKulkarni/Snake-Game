import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


class SimpleAudioPlayer
{
	Long currentFrame;
	Clip clip;

	String status;

	AudioInputStream audioInputStream;
	static String filePath;

	public SimpleAudioPlayer()
		throws UnsupportedAudioFileException,
		IOException, LineUnavailableException
	{
		// create AudioInputStream object
		audioInputStream =
				AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

		// create clip reference
		clip = AudioSystem.getClip();

		// open audioInputStream to the clip
		clip.open(audioInputStream);

		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void play()
	{
		//start the clip
		clip.start();

		status = "play";
	}
}


public class Main{
    public static void main(String[] args){

        JFrame obj = new JFrame();
        Gameplay gameplay = new Gameplay();
		try
		{
			String filePath = "clip.wav";
			SimpleAudioPlayer audioPlayer =
							new SimpleAudioPlayer();

			audioPlayer.play();

			while (true)
			{
			}
		}

		catch (Exception ex)
		{
			System.out.println("Error with playing sound.");
			ex.printStackTrace();

		}

        obj.setBounds(10,10,905,700);
        obj.setBackground(Color.DARK_GRAY);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gameplay);

    }
}
