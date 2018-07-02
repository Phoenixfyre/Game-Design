package edu.virginia.engine.util;

import java.io.File;
import java.util.HashMap;
import javax.sound.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class SoundManager {
	HashMap<String, Clip> sound = new HashMap<String, Clip>();
	//MediaPlayer mp = new MediaPlayer();
	
	public SoundManager(){
		this.sound = new HashMap<String, Clip>();

		
	}
	
	public void LoadSoundEffect(String id, String fileName){
		Clip effect= null;
		
		try 
		{
			AudioInputStream soundef = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
			effect = AudioSystem.getClip();
			effect.open( soundef);
		}
		catch ( Exception e ){
			e.printStackTrace();
		}
		
		if (effect != null)
			if (!sound.containsKey(id))
				sound.put(id, effect);
		
	}
	public void PlaySoundEffect(String id) {
		if ( sound.get(id).isRunning() )
			sound.get(id).stop();
		sound.get(id).setFramePosition(0);
		sound.get(id).start();
		
	}
	@SuppressWarnings("static-access")
	public void playMusic(String id) {
		if (sound.get(id).isRunning() )
			sound.get(id).stop();
		sound.get(id).setFramePosition(0);
		sound.get(id).start();
		sound.get(id).loop(sound.get(id).LOOP_CONTINUOUSLY);
	}
	public void loadMusic(String id, String fileName){
		
			Clip music= null;
			
			try 
			{
				AudioInputStream mus = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
				 music = AudioSystem.getClip();
				 music.open( mus );
			}
			catch ( Exception e ){
				e.printStackTrace();
			}
			
			if ( music != null)
				if (!sound.containsKey(id))
					sound.put(id,  music);
			
	}
}
