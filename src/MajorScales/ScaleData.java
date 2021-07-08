package MajorScales;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JButton;

public class ScaleData {

	private HashMap<String,String[]> allKeys = new HashMap<String,String[]>();
	
	private JButton[] buttons = new JButton[8];

	private String[][] scaleNotes = { {"C1", "D1", "E1", "F1", "G1", "A1", "B1", "C2"},
								 {"G1", "A1", "B1", "C2", "D2", "E2", "F# Gb2", "G2"}, 
								 {"D1", "E1", "F# Gb1", "G1", "A1", "B1", "C# Db2", "D2"},
								 {"A1", "B1", "C# Db2", "D2", "E2", "F# Gb2", "G# Ab2", "A2"},
								 {"E1", "F# Gb1", "G# Ab1", "A1", "B1", "C# Db2", "D# Eb2", "E2"},
								 {"B1", "C# Db2", "D# Eb2", "E2", "F# Gb2", "G# Ab2", "A# Bb2", "B2"},
								 {"F# Gb1", "G# Ab1", "A# Bb1", "B1", "C# Db2", "D# Eb2", "F2", "F# Gb2"},
								 {"C# Db1", "D# Eb1", "F1", "F# Gb1", "G# Ab1", "A# Bb1", "C2", "C# Db2"},
								 {"F1", "G1", "A1", "A# Bb1", "C2", "D2", "E2", "F2"},
								 {"A# Bb1", "C2", "D2", "D# Eb2", "F2", "G2", "A2", "A# Bb2"},
								 {"D# Eb1", "F1", "G1", "G# Ab1", "A# Bb1", "C2", "D2", "D# Eb2"},
								 {"G# Ab1", "A# Bb1", "C2", "C# Db2", "D# Eb2", "F2", "G2", "G# Ab2"},
								 {"C# Db1", "D# Eb1", "F1", "F# Gb1", "G# Ab1", "A# Bb1", "C2", "C# Db2"},
								 {"F# Gb1", "G# Ab1", "A# Bb1", "B1", "C# Db2", "D# Eb2", "F2", "F# Gb2"},
								 {"B1", "C# Db2", "D# Eb2", "E2", "F# Gb2", "G# Ab2", "A# Bb2", "B2"} };
	
	
	private String[] scaleName = { "C", "G", "D", "A", "E", "B", "F#", "C#", "F", "Bb", "Eb", "Ab", "Db", "Gb", "Cb" };
	
	
	public ScaleData() {
		for (int i = 0; i < scaleName.length; i++ ) {
			allKeys.put(scaleName[i], scaleNotes[i]);
		}
	}
	
	public void getCurrentNote(HashMap<String,PianoNote> allPianoKeys, int note, String currentPianoKey) {
		buttons[note] = allPianoKeys.get(currentPianoKey).getButton();
	}

	public void getNotes(HashMap<String,PianoNote> allPianoKeys, String noteKey) {
		for (int i = 0; i < allKeys.get(noteKey).length; i++) {	
			getCurrentNote(allPianoKeys, i, allKeys.get(noteKey)[i]);				
		}
	}

	public void highlightButtons() {
		for (int i =0; i < 8; i++) {			
			buttons[i].setBackground(Color.pink);
		}	
	}

	public JButton[] setScale(HashMap<String,PianoNote> allPianoKeys, String noteKey) {
		getNotes(allPianoKeys, noteKey);
		highlightButtons();
		return buttons;
	}
	
	
}
