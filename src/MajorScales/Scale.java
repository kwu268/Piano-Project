package MajorScales;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public interface Scale {
	
	String[] scaleKeys = new String[8];
	
	public void getNotes(HashMap<String,JButton> test);
	
	public void Highlight();
	
	public JButton[] setScale(HashMap<String,JButton> allPianoKeys);

}
