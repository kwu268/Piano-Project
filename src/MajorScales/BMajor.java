package MajorScales;
import java.awt.Color;
import java.util.HashMap;

import javax.swing.JButton;

public class BMajor implements Scale {
	private static JButton[] buttons = new JButton[8];
	private static String[] scaleKeys = {"B1", "C# Db2", "D# Eb2", "E2", "F# Gb2", "G# Ab2", "A# Bb2", "B2"};
	
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
