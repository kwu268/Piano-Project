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
//Clean up Clear Button code

//TODO:
//Clean up unused variables and comments





//make note class containing audio and bounds and Jbutton properties 
public class Piano implements ActionListener {
	protected static final String TEST = null;
	private JFrame frame;	
	private JButton Clear;
	//Button Array
	private static JButton[] HighlightedButtons;	
	private static PianoNote[] createdButtons = new PianoNote[24];
	//hashmap
	private static HashMap<String,PianoNote> allPianoKeys = new HashMap<String,PianoNote>();
	//Labels
	private JLabel MajorTitle;
	private JLabel Sharps;	
	//Combo Boxes
	private JComboBox<String> SharpMajorScales;
	//String Arrays
	private String[] Keys = {"C", "G", "D", "A", "E", "B", "F#", "C#", "F", "Bb", "Eb", "Ab", "Db", "Gb", "Cb"};
	private final String[] WHITE_KEYS = {"C1", "D1", "E1", "F1", "G1", "A1", "B1", "C2", "D2", "E2", "F2", "G2", "A2", "B2" };
	private final String[] BLACK_KEYS = {"C# Db1","D# Eb1", "F# Gb1", "G# Ab1", "A# Bb1", "C# Db2", "D# Eb2", "F# Gb2", "G# Ab2", "A# Bb2" };
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
	
	/**
	 * Launch the application.
	 */
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
	
	//adds action listener to buttons and adds buttons the frame
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
		
		SharpMajorScales = new JComboBox<String>(Keys);
		SharpMajorScales.setBounds(1300, 39, 46, 22);
		SharpMajorScales.addActionListener(this);
		frame.getContentPane().add(SharpMajorScales);
		
		Sharps = new JLabel("Keys:");
		Sharps.setBounds(1250, 43, 46, 14);
		frame.getContentPane().add(Sharps);
		
		MajorTitle = new JLabel("Major Scale Keys");
		MajorTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		MajorTitle.setBounds(1250, 14, 106, 14);
		frame.getContentPane().add(MajorTitle);
		
		Clear = new JButton("Clear Highlights");
		Clear.setBounds(1250, 430, 146, 23);
		Clear.setBackground(Color.green);
		frame.add(Clear);
		Clear.addActionListener(this);
		
		WhiteKeys();
	
	}
	
	public void WhiteKeys() {
		for (Map.Entry<String,PianoNote> note : allPianoKeys.entrySet()) {
			if (note.getValue().getNoteName().length() > 2) note.getValue().getButton().setBackground(Color.gray);
			else note.getValue().getButton().setBackground(Color.white);
		}	
	}
		
	public void MajorHighlight (int KeyChoice) {
		WhiteKeys();
		MajorFactory ScaleFactory = new MajorFactory(allPianoKeys);
		switch(KeyChoice) {			
			case 0: 
				HighlightedButtons = ScaleFactory.getMajor("C");			
				break;
			case 1:
				HighlightedButtons = ScaleFactory.getMajor("G");
				break;		
			case 2:
				HighlightedButtons = ScaleFactory.getMajor("D");
				break;
			
			case 3:
				HighlightedButtons = ScaleFactory.getMajor("A");
				break;
			case 4:
				HighlightedButtons = ScaleFactory.getMajor("E");
				break;
			//B Major
			case 5:
				HighlightedButtons = ScaleFactory.getMajor("B");
				break;
			//F# major	
			case 6:
				HighlightedButtons = ScaleFactory.getMajor("F#");
				break;			
			//C# maj	
			case 7:
				HighlightedButtons = ScaleFactory.getMajor("C#");
				break;			
			//F major	
			case 8:
				HighlightedButtons = ScaleFactory.getMajor("F");
				break;				
			//Bb major	
			case 9:
				HighlightedButtons = ScaleFactory.getMajor("Bb");
				break;				
			//Eb maj	
			case 10:
				HighlightedButtons = ScaleFactory.getMajor("Eb");
				break;				
			//Ab maj	
			case 11:
				HighlightedButtons = ScaleFactory.getMajor("Ab");
				break;			
			//Db	
			case 12:
				HighlightedButtons = ScaleFactory.getMajor("Db");
				break;				
			//Gb 
			case 13:
				HighlightedButtons = ScaleFactory.getMajor("Gb");
				break;
			//Cb	
			case 14:
				HighlightedButtons = ScaleFactory.getMajor("Cb");
				break;
			}
		 
	 }
	 
	public AudioInputStream makeAudio(String location) throws Exception {	 
		AudioInputStream aIS = AudioSystem.getAudioInputStream(new File(location));
		Clip clip = AudioSystem.getClip();
		clip.open(aIS);
		clip.start();
		return aIS;
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SharpMajorScales) {			
			int KeyChoice = SharpMajorScales.getSelectedIndex();
			MajorHighlight(KeyChoice);
		
		}
		else if (e.getSource() == Clear) {
			WhiteKeys();
		}
		
		else if (e.getSource() == allPianoKeys.get("C1").getButton()) {
				try {
					AudioInputStream aIS = makeAudio(allPianoKeys.get("C1").getAudioPath());
				}
				 catch (Exception e1) {
					e1.printStackTrace();
				}
		}
		
		else if (e.getSource() == allPianoKeys.get("D1").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("D1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("E1").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("E1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("F1").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("F1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("G1").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("G1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("A1").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("A1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("B1").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("B1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("C2").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("C2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("D2").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("D2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("E2").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("E2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("F2").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("F2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("G2").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("G2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("A2").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("A2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("B2").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("B2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("C# Db1").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("C# Db1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("D# Eb1").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("D# Eb1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("F# Gb1").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("F# Gb1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("G# Ab1").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("G# Ab1").getAudioPath());
			}
			 catch (Exception e1) {			
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("A# Bb1").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("A# Bb1").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("C# Db2").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("C# Db2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("D# Eb2").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("D# Eb2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("F# Gb2").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("F# Gb2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("G# Ab2").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("G# Ab2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == allPianoKeys.get("A# Bb2").getButton()) {
			try {
				AudioInputStream aIS = makeAudio(allPianoKeys.get("A# Bb2").getAudioPath());
			}
			 catch (Exception e1) {
				e1.printStackTrace();
			}
		}		
	}
}

