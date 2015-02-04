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
 * Lägg till ljud för varje action som behöver ljud.
 * ex: punchSound -> getAudioClip
 */
	AudioClip jumpSound;
	
	public void loadSounds(){
		backgroundSound();
	}
	
	protected void backgroundSound(){
		
		try{
/*
 * Välj fil för bakgrunds musiken -> continious loop
 */
			backgroundMusic = new AudioStream(new FileInputStream(""));
			backgroundData = backgroundMusic.getData();
			backgroundLoop = new ContiniousAudioDataStream(backgroundData);
		}catch(IOException e){
			System.out.println("Fel på backgroundsmusic");
		}
		soundPlayer.start(backgroundLoop); 
	}
	
	protected void actionSoundMethod(){
/*
 * Välj namn på filen -> Action -> Keypressed/Movement sound
 * För varje action -> en metod -> för varje keypressed -> ljud om det krävs.
 * Skapa ny metod (annan namn) med samma try/catch -> Välj ny fil -> ny AudioClip 
 */
		try{
		actionSound = getAudioClip(getCodeBase(), "");
		
		}catch (IOException e){
			System.out.println("Fel på action sound filen");
		}
		actionSound.play();
	}
	
/*
 * Exemple ljud metod.
 * Hopp ljud. jumpSoundMethod() i input för keypressed "jump".
 */
	protected void jumpSoundMethod(){
		try{
		jumpSound = getAudioClip(getCodeBase(), "");
		
		}catch (IOException e){
			System.out.println("Fel på action sound filen");
		}
		jumpSound.play();
	}
	
}
