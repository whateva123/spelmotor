package spelmotorn;

import java.applet.AudioClip;
import java.io.*;
import sun.audio.*;
import javax.sound.*;

public class Sound {
	
	AudioPlayer soundPlayer = AudioPlayer.player;
	AudioStream backgroundMusic;
	AudioData backgroundData;	
	ContinousAudioDataStream backgroundLoop = null;
	
	AudioClip actionSound;
/*
 * L�gg till ljud f�r varje action som beh�ver ljud.
 * ex: punchSound -> getAudioClip
 */
	
	public void loadSounds(){
		backgroundSound();
	}
	
	protected void backgroundSound(){
		
		try{
/*
 * V�lj fil f�r bakgrunds musiken -> continious loop
 */
			backgroundMusic = new AudioStream(new FileInputStream(""));
			backgroundData = backgroundMusic.getData();
			backgroundLoop = new ContiniousAudioDataStream(backgroundData);
		}catch(IOException e){
			System.out.println("Fel p� backgroundsmusic");
		}
		soundPlayer.start(backgroundLoop);
	}
	
	protected void actionSoundMethod(){
/*
 * V�lj namn p� filen -> Action -> Keypressed/Movement sound
 * F�r varje action -> en metod -> f�r varje keypressed -> ljud om det kr�vs.
 */
		try{
		actionSound = getAudioClip(getCodeBase(), "");
		
		}catch (IOException e){
			System.out.println("Fel p� action sound filen");
		}
		actionSound.play();
		
	}
}
