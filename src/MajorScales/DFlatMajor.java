package MajorScales;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JButton;

public class DFlatMajor implements Scale {	
	private static JButton[] buttons = new JButton[8];
	private static String[] scaleKeys = {"C# Db1", "D# Eb1", "F1", "F# Gb1", "G# Ab1", "A# Bb1", "C2", "C# Db2"};
	
	public void getCurrentNote(HashMap<String,PianoNote> allPianoKeys, int note, String currentPianoKey) {
		buttons[note] = allPianoKeys.get(currentPianoKey).getButton();
	}

	public void getNotes(HashMap<String,PianoNote> allPianoKeys) {
		for (int i = 0; i < scaleKeys.length; i++) {	
			getCurrentNote(allPianoKeys, i, scaleKeys[i]);				
		}
	}

	public void highlightButtons() {
		for (int i =0; i < 8; i++) {			
			buttons[i].setBackground(Color.pink);
		}	
	}

	@Override
	public JButton[] setScale(HashMap<String,PianoNote> allPianoKeys) {
		getNotes(allPianoKeys);
		highlightButtons();
		return buttons;
	}
}