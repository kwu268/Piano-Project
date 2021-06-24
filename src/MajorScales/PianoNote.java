package MajorScales;



import javax.swing.JButton;

public class PianoNote {
	private String noteName;
	private JButton buttonNote;
	private String audioPath;
	
	
	public PianoNote(String name, int xx, int yy, int wwidth, int hheight) {
		buttonNote = new JButton(name);
		buttonNote.setBounds(xx, yy, wwidth, hheight);
		noteName = name;
	}
	
	public PianoNote(String name, int xx, int yy, int wwidth, int hheight, String audio) {
		buttonNote = new JButton(name);
		buttonNote.setBounds(xx, yy, wwidth, hheight);
		noteName = name;
		audioPath = audio;
	}
	
	public String getNoteName() {
		return noteName;
	}
	
	public JButton getButton() {
		return buttonNote;
	}
	
	public String getAudioPath() {
		return audioPath;
	}
}
