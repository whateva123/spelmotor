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
	AudioClip jumpSound;
	
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
 * Skapa ny metod (annan namn) med samma try/catch -> V�lj ny fil -> ny AudioClip 
 */
		try{
		actionSound = getAudioClip(getCodeBase(), "");
		
		}catch (IOException e){
			System.out.println("Fel p� action sound filen");
		}
		actionSound.play();
	}
	
/*
 * Exemple ljud metod.
 * Hopp ljud. jumpSoundMethod() i input f�r keypressed "jump".
 */
	protected void jumpSoundMethod(){
		try{
		jumpSound = getAudioClip(getCodeBase(), "");
		
		}catch (IOException e){
			System.out.println("Fel p� action sound filen");
		}
		jumpSound.play();
	}
	
}
