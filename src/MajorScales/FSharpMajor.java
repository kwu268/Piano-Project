package MajorScales;
import java.awt.Color;
import java.util.HashMap;

import javax.swing.JButton;

public class FSharpMajor implements Scale{
	
	private static JButton[] buttons = new JButton[8];
		
	private static String[] scaleKeys = {"F# Gb1", "G# Ab1", "A# Bb1", "B1", "C# Db2", "D# Eb2", "F2", "F# Gb2"};
	
	public void getCurrentNote(HashMap<String,PianoNote> allPianoKeys, int note, String currentPianoKey) {
		buttons[note] = allPianoKeys.get(currentPianoKey).getButton();
	}

	public void getNotes(HashMap<String,PianoNote> allPianoKeys) {
		for (int i = 0; i < scaleKeys.length; i++) {	
			getCurrentNote(allPianoKeys, i, scaleKeys[i]);				
		}
	}

	public void Highlight() {
		for (int i =0; i < 8; i++) {			
			buttons[i].setBackground(Color.pink);
		}	
	}

	@Override
	public JButton[] setScale(HashMap<String,PianoNote> allPianoKeys) {
		getNotes(allPianoKeys);
		Highlight();
		return buttons;
	}
}
