package spelmotorn;

import java.applet.*;
import java.io.*;
import sun.audio.*;

public class Sound{
	
	AudioPlayer soundPlayer = AudioPlayer.player;
	AudioStream backgroundMusic;
	AudioStream soundFile;
	AudioData backgroundData;
	AudioData soundData;
	ContinuousAudioDataStream backgroundLoop = null;
	
	AudioClip actionSound;
	AudioClip jumpSound;

	String filePath = "";
	
	Sound(String filePath){
		this.filePath = filePath;
	}
	
 	public String getPath(){
 		return this.filePath;
 	}
 	
 	public void playSound(){
 		try{
 			soundFile = new AudioStream(new FileInputStream(getPath()));
 			soundData = soundFile.getData();
 		}catch (IOException e){
 			System.out.println("Fel på filen");
 		}
 		soundPlayer.start(soundFile);
 	}
 	
 	public void playSoundBackground(){
 		try{
 			backgroundMusic = new AudioStream(new FileInputStream(getPath()));
 			backgroundData = backgroundMusic.getData();
 			backgroundLoop = new ContinuousAudioDataStream(backgroundData);
 		}catch(IOException e){
 			soundPlayer.start(backgroundLoop);
 		}
 	}

}