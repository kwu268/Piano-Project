package MajorScales;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public interface Scale {
	
	String[] scaleKeys = new String[8];
	
	public void getCurrentNote(HashMap<String,PianoNote> allPianoKeys, int note, String currentPianoKey);
	
	public void getNotes(HashMap<String,PianoNote> test);
	
	public void Highlight();
	
	public JButton[] setScale(HashMap<String,PianoNote> allPianoKeys);

}
