import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import MajorScales.MajorFactory;
import MajorScales.PianoNote;
import javax.swing.JLabel;
import javax.swing.JPanel;
//Done:
//Finsihed cleaning major key classes, added makeButton() function, 
// and remade WhiteKeys() function
//Change object allPianoKeys to use the PianoNote object
//Change all instances of allPianoKeys to use PianoNote object
//Adjust the offset for the piano keys
//change hasmap to pianoNote class 
//make Factory 
//Change Class Names to Capitalized
//Clean up clear Button code
//Clean up unused variables and comments
//make note class containing audio and bounds and Jbutton properties 

//TODO:
//make one Scale class to replace each Major scale class since they use the same functions 

public class Piano implements ActionListener {
	//Boundary numbers white keys
	private final int OFFSET = 40;
	private final int KEY_WIDTH = 77;
	private final int WHITE_KEY_WIDTH = 78;
	private final int WHITE_KEY_HEIGHT = 231;
	private final int WHITE_KEY_Y =	233;
	//Boundary numbers black keys
	private final int BLACK_KEY_HEIGHT = 192;
	private final int BLACK_KEY_Y =	41;
	
	private final String BASE_AUDIO_PATH = "C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\";
	private final String[] KEYS = {"C", "G", "D", "A", "E", "B", "F#", "C#", "F", "Bb", "Eb", "Ab", "Db", "Gb", "Cb"};
	private final String[] WHITE_KEYS = {"C1", "D1", "E1", "F1", "G1", "A1", "B1", "C2", "D2", "E2", "F2", "G2", "A2", "B2" };
	private final String[] BLACK_KEYS = {"C# Db1","D# Eb1", "F# Gb1", "G# Ab1", "A# Bb1", "C# Db2", "D# Eb2", "F# Gb2", "G# Ab2", "A# Bb2" };
	
	private JFrame frame;	
	private JButton clear;
	private static JButton[] highlightedButtons;	
	private JLabel majorTitle;
	private JLabel sharps;	
	private JComboBox<String> sharpMajorScales;
	private static PianoNote[] createdButtons = new PianoNote[24];
	private static HashMap<String,PianoNote> allPianoKeys = new HashMap<String,PianoNote>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Piano window = new Piano();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Piano() {
		initialize();
	}

	private void createBlackButtons() {
		int noteValue = -5;
		int leftover = 14;
		for (int i = 0; i < BLACK_KEYS.length; i++) {
			if ( BLACK_KEYS[i].charAt(0) == 'C' || BLACK_KEYS[i].charAt(0) == 'F') {
				noteValue += KEY_WIDTH *2;
			}
			else {
				noteValue += KEY_WIDTH;
			}
			PianoNote currentNote = new PianoNote(BLACK_KEYS[i], noteValue, BLACK_KEY_Y, WHITE_KEY_WIDTH, BLACK_KEY_HEIGHT, (BASE_AUDIO_PATH + BLACK_KEYS[i] + ".wav"));
			createdButtons[leftover + i] = currentNote;
		}	
	}
	
	private void createWhiteButtons() {
		int noteValue = OFFSET;	
		for (int i = 0; i < WHITE_KEYS.length; i++) {
			noteValue += KEY_WIDTH; 
			PianoNote currentNote = new PianoNote(WHITE_KEYS[i], noteValue, WHITE_KEY_Y, WHITE_KEY_WIDTH, WHITE_KEY_HEIGHT, BASE_AUDIO_PATH + WHITE_KEYS[i] + ".wav"); 
			createdButtons[i] = currentNote; 
		}	
	}
	
	private void setupButtons() {	
		for (int i = 0; i < createdButtons.length; i++) {
			String noteName = createdButtons[i].getNoteName();
			JButton currentButton = createdButtons[i].getButton();		
			currentButton.addActionListener(this);
			frame.getContentPane().add(currentButton);
			allPianoKeys.put(noteName, createdButtons[i]); 
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1500, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		createWhiteButtons();
		createBlackButtons();
		setupButtons();
		
		sharpMajorScales = new JComboBox<String>(KEYS);
		sharpMajorScales.setBounds(1300, 39, 46, 22);
		sharpMajorScales.addActionListener(this);
		frame.getContentPane().add(sharpMajorScales);
		
		sharps = new JLabel("Keys:");
		sharps.setBounds(1250, 43, 46, 14);
		frame.getContentPane().add(sharps);
		
		majorTitle = new JLabel("Major Scale Keys");
		majorTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		majorTitle.setBounds(1250, 14, 106, 14);
		frame.getContentPane().add(majorTitle);
		
		clear = new JButton("clear Highlights");
		clear.setBounds(1250, 430, 146, 23);
		clear.setBackground(Color.green);
		frame.add(clear);
		clear.addActionListener(this);
		
		setKeyColour();	
	}
	
	public void setKeyColour() {
		for (Map.Entry<String,PianoNote> note : allPianoKeys.entrySet()) {
			if (note.getValue().getNoteName().length() > 2) note.getValue().getButton().setBackground(Color.gray);
			else note.getValue().getButton().setBackground(Color.white);
		}	
	}
		
	public void highlightMajorScales (int KeyChoice) {
		setKeyColour();
		MajorFactory scaleFactory = new MajorFactory(allPianoKeys);
		switch(KeyChoice) {			
			case 0: 
				highlightedButtons = scaleFactory.getMajor("C");			
				break;
			case 1:
				highlightedButtons = scaleFactory.getMajor("G");
				break;		
			case 2:
				highlightedButtons = scaleFactory.getMajor("D");
				break;
			case 3:
				highlightedButtons = scaleFactory.getMajor("A");
				break;
			case 4:
				highlightedButtons = scaleFactory.getMajor("E");
				break;
			case 5:
				highlightedButtons = scaleFactory.getMajor("B");
				break;
			case 6:
				highlightedButtons = scaleFactory.getMajor("F#");
				break;			
			case 7:
				highlightedButtons = scaleFactory.getMajor("C#");
				break;			
			case 8:
				highlightedButtons = scaleFactory.getMajor("F");
				break;				
			case 9:
				highlightedButtons = scaleFactory.getMajor("Bb");
				break;				
			case 10:
				highlightedButtons = scaleFactory.getMajor("Eb");
				break;				
			case 11:
				highlightedButtons = scaleFactory.getMajor("Ab");
				break;			
			case 12:
				highlightedButtons = scaleFactory.getMajor("Db");
				break;				
			case 13:
				highlightedButtons = scaleFactory.getMajor("Gb");
				break;
			case 14:
				highlightedButtons = scaleFactory.getMajor("Cb");
				break;
			} 
	 }
	 
	public AudioInputStream playPianoKeyAudio(String location) throws Exception {	 
		AudioInputStream aIS = AudioSystem.getAudioInputStream(new File(location));
		Clip clip = AudioSystem.getClip();
		clip.open(aIS);
		clip.start();
		return aIS;
	 }
	 
	// This function overrides the audio function and handles playing audio for each piano key, as well as the dropdown bar which is responsible for highlighting the keys depending on type of scale.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sharpMajorScales) {			
			int KeyChoice = sharpMajorScales.getSelectedIndex();
			highlightMajorScales(KeyChoice);	
		} else if (e.getSource() == clear) setKeyColour();
		
		else if (e.getSource() == allPianoKeys.get("C1").getButton()) {
				try {
					AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("C1").getAudioPath());
				}
				 catch (Exception e1) {
					e1.printStackTrace();
				}
		} else if (e.getSource() == allPianoKeys.get("D1").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("D1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("E1").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("E1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("F1").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("F1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("G1").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("G1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("A1").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("A1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("B1").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("B1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("C2").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("C2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("D2").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("D2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("E2").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("E2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("F2").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("F2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("G2").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("G2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("A2").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("A2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("B2").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("B2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("C# Db1").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("C# Db1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("D# Eb1").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("D# Eb1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("F# Gb1").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("F# Gb1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("G# Ab1").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("G# Ab1").getAudioPath());
			}
			 catch (Exception e1) {			
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("A# Bb1").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("A# Bb1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("C# Db2").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("C# Db2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("D# Eb2").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("D# Eb2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("F# Gb2").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("F# Gb2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("G# Ab2").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("G# Ab2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == allPianoKeys.get("A# Bb2").getButton()) {
			try {
				AudioInputStream aIS = playPianoKeyAudio(allPianoKeys.get("A# Bb2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}		
	}
}

