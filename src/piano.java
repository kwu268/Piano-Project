import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;


import javax.swing.JLabel;

public class piano implements ActionListener {
	private Theory t;
	private JFrame frame;
	//White Buttons
	private JButton C1;
	private JButton D1;
	private JButton E1;
	private JButton F1;
	private JButton G1;
	private JButton A1;
	private JButton B1;
	private JButton C2;
	private JButton D2;
	private JButton E2;
	private JButton F2;
	private JButton G2;
	private JButton A2;
	private JButton B2;
	
	private JButton Clear;
	
	//Black Buttons 
	private JButton CD1;
	private JButton DE1;
	private JButton FG1;
	private JButton GA1;
	private JButton AB1;
	private JButton CD2;
	private JButton DE2;
	private JButton FG2;
	private JButton GA2;
	private JButton AB2;
	
	//Button Array
	private JButton[] buttons;

	
	
	//Labels
	private JLabel MajorTitle;
	private JLabel Sharps;
	private JLabel Flats;
	
	//Combo Boxes
	private JComboBox<String> SharpMajorScales;

	
	//String Arrays
	private String[] Keys = {"C", "G", "D", "A", "E", "B", "F#", "C#", "F", "Bb", "Eb", "Ab", "Db", "Gb", "Cb"};
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					piano window = new piano();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public piano() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1086, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		C1 = new JButton("C1");
		C1.setBounds(20, 233, 58, 231);
		C1.addActionListener(this);
		frame.getContentPane().add(C1);
		
		D1 = new JButton("D1");
		D1.setBounds(77, 233, 58, 231);
		D1.addActionListener(this);
		frame.getContentPane().add(D1);
		
		E1 = new JButton("E1");
		E1.setBounds(134, 233, 58, 231);
		E1.addActionListener(this);
		frame.getContentPane().add(E1);
		
		F1 = new JButton("F1");
		F1.setBounds(190, 233, 58, 231);
		F1.addActionListener(this);
		frame.getContentPane().add(F1);
		
		G1 = new JButton("G1");
		G1.setBounds(248, 233, 58, 231);
		G1.addActionListener(this);
		frame.getContentPane().add(G1);
		
		A1 = new JButton("A1");
		A1.setBounds(304, 233, 58, 231);
		A1.addActionListener(this);
		frame.getContentPane().add(A1);
		
		B1 = new JButton("B1");
		B1.setBounds(362, 233, 58, 231);
		B1.addActionListener(this);
		frame.getContentPane().add(B1);
		
		C2 = new JButton("C2");
		C2.setBounds(421, 233, 58, 231);
		C2.addActionListener(this);
		frame.getContentPane().add(C2);
		
		D2 = new JButton("D2");
		D2.setBounds(477, 233, 58, 231);
		D2.addActionListener(this);
		frame.getContentPane().add(D2);
		
		E2 = new JButton("E2");
		E2.setBounds(534, 233, 58, 231);
		E2.addActionListener(this);
		frame.getContentPane().add(E2);
		
		F2 = new JButton("F2");
		F2.setBounds(587, 233, 58, 231);
		F2.addActionListener(this);
		frame.getContentPane().add(F2);
		
		G2 = new JButton("G2");
		G2.setBounds(641, 233, 58, 231);
		G2.addActionListener(this);
		frame.getContentPane().add(G2);
		
		A2 = new JButton("A2");
		A2.setBounds(697, 233, 58, 231);
		A2.addActionListener(this);
		frame.getContentPane().add(A2);
		
		B2 = new JButton("B2");
		B2.setBounds(754, 233, 58, 231);
		B2.addActionListener(this);
		frame.getContentPane().add(B2);
		
		CD1 = new JButton("C#/Db");
		CD1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		CD1.setBounds(50, 43, 58, 192);
		CD1.addActionListener(this);
		frame.getContentPane().add(CD1);
		
		DE1 = new JButton("D#/Eb");
		DE1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		DE1.setBounds(107, 43, 58, 192);
		DE1.addActionListener(this);
		frame.getContentPane().add(DE1);
		
		FG1 = new JButton("F#/Gb");
		FG1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		FG1.setBounds(219, 43, 58, 192);
		FG1.addActionListener(this);
		frame.getContentPane().add(FG1);
		
		GA1 = new JButton("G#/Ab");
		GA1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GA1.setBounds(277, 43, 58, 192);
		GA1.addActionListener(this);
		frame.getContentPane().add(GA1);
		
		AB1 = new JButton("A#/Bb");
		AB1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		AB1.setBounds(334, 43, 58, 192);
		AB1.addActionListener(this);
		frame.getContentPane().add(AB1);
		
		CD2 = new JButton("C#/Db    2");
		CD2.setFont(new Font("Tahoma", Font.PLAIN, 7));
		CD2.setBounds(448, 43, 58, 192);
		CD2.addActionListener(this);
		frame.getContentPane().add(CD2);
		
		DE2 = new JButton("D#/Eb 2");
		DE2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		DE2.setBounds(504, 43, 58, 192);
		DE2.addActionListener(this);
		frame.getContentPane().add(DE2);
		
		FG2 = new JButton("F#/Gb");
		FG2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		FG2.setBounds(615, 43, 58, 192);
		FG2.addActionListener(this);
		frame.getContentPane().add(FG2);
		
		GA2 = new JButton("G#/Ab");
		GA2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GA2.setBounds(672, 43, 58, 192);
		GA2.addActionListener(this);
		frame.getContentPane().add(GA2);
		
		AB2 = new JButton("A#/Bb");
		AB2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		AB2.setBounds(731, 43, 58, 192);
		AB2.addActionListener(this);
		frame.getContentPane().add(AB2);
		
		
		SharpMajorScales = new JComboBox(Keys);
		SharpMajorScales.setBounds(981, 39, 46, 22);
		SharpMajorScales.addActionListener(this);
		frame.getContentPane().add(SharpMajorScales);
		
		
		Sharps = new JLabel("Keys:");
		Sharps.setBounds(936, 43, 46, 14);
		frame.getContentPane().add(Sharps);
		
		MajorTitle = new JLabel("Major Scale Keys");
		MajorTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		MajorTitle.setBounds(939, 14, 106, 14);
		frame.getContentPane().add(MajorTitle);
		
		Clear = new JButton("Clear Highlights");
		Clear.setBounds(914, 430, 146, 23);
		Clear.addActionListener(this);
		Clear.setBackground(Color.GREEN);
		frame.getContentPane().add(Clear);
		
		WhiteKeys();
		
		//make scale class 
		//make highlighter class 
		//use dictionaries 
		
		
		JButton[] temp =  {C1, D1, E1, F1, G1, A1, B1, C2, D2, E2, F2, G2, A2, B2, CD1, DE1, FG1, GA1, AB1, CD2, DE2, FG2, GA2, AB2};
		buttons = temp;
	}
	
	public void WhiteKeys() {
		C1.setBackground(Color.white);
		D1.setBackground(Color.white);
        E1.setBackground(Color.white);
		F1.setBackground(Color.white);
		G1.setBackground(Color.white);
		A1.setBackground(Color.white);
		B1.setBackground(Color.white);
		C2.setBackground(Color.white);
		D2.setBackground(Color.white);
		E2.setBackground(Color.white);
	    F2.setBackground(Color.white);
		G2.setBackground(Color.white);
		A2.setBackground(Color.white);
		B2.setBackground(Color.white);
		
		//Black Buttons 
		CD1.setBackground(Color.gray);
		DE1.setBackground(Color.gray);
		FG1.setBackground(Color.gray);
		GA1.setBackground(Color.gray);
		AB1.setBackground(Color.gray);
		CD2.setBackground(Color.gray);
		DE2.setBackground(Color.gray);
		FG2.setBackground(Color.gray);
		GA2.setBackground(Color.gray);
		AB2.setBackground(Color.gray);
	}
		
	
	//hi asdasd asdasd
	 public void MajorHighlight (int KeyChoice) {
		 switch(KeyChoice) {
			
			case 0: 
				for (int i =0; i < 8; i++) {
					//System.out.println(buttons[i]);
					buttons[i].setBackground(Color.pink);
				}
				break;
			
			case 1:
				G1.setBackground(Color.PINK);
				A1.setBackground(Color.PINK);
				B1.setBackground(Color.PINK);
				C2.setBackground(Color.PINK);
				D2.setBackground(Color.PINK);
				E2.setBackground(Color.PINK);
				FG2.setBackground(Color.PINK);
				G2.setBackground(Color.PINK);
				break;
			
			case 2:
				D1.setBackground(Color.PINK);
				E1.setBackground(Color.PINK);
				FG1.setBackground(Color.PINK);
				G1.setBackground(Color.PINK);
				A1.setBackground(Color.PINK);
				B1.setBackground(Color.PINK);
				CD2.setBackground(Color.PINK);
				D2.setBackground(Color.PINK);
				break;
			
			case 3:
				A1.setBackground(Color.PINK);
				B1.setBackground(Color.PINK);
				CD2.setBackground(Color.PINK);
				D2.setBackground(Color.PINK);
				E2.setBackground(Color.PINK);
				FG2.setBackground(Color.PINK);
				GA2.setBackground(Color.PINK);
				A2.setBackground(Color.PINK);
				break;
			case 4:
				E1.setBackground(Color.PINK);
				FG1.setBackground(Color.PINK);
				GA1.setBackground(Color.PINK);
				A1.setBackground(Color.PINK);
				B1.setBackground(Color.PINK);
				CD2.setBackground(Color.PINK);
				DE2.setBackground(Color.PINK);
				E2.setBackground(Color.PINK);
				break;
			//B Major
			case 5:
				B1.setBackground(Color.PINK);
				CD2.setBackground(Color.PINK);
				DE2.setBackground(Color.PINK);
				E2.setBackground(Color.PINK);
				FG2.setBackground(Color.PINK);
				GA2.setBackground(Color.PINK);
				AB2.setBackground(Color.PINK);
				B2.setBackground(Color.PINK);
				break;
			//F# major	
			case 6:
				FG1.setBackground(Color.PINK);
				GA1.setBackground(Color.PINK);
				AB1.setBackground(Color.PINK);
				B1.setBackground(Color.PINK);
				CD2.setBackground(Color.PINK);
				DE2.setBackground(Color.PINK);
				F2.setBackground(Color.PINK);
				FG2.setBackground(Color.PINK);
				break;
				
			//C# maj	
			case 7:
				CD1.setBackground(Color.PINK);
				DE1.setBackground(Color.PINK);
				F1.setBackground(Color.PINK);
				FG1.setBackground(Color.PINK);
				GA1.setBackground(Color.PINK);
				AB1.setBackground(Color.PINK);
				C2.setBackground(Color.PINK);
				CD2.setBackground(Color.PINK);
				break;
				
			//F major	
			case 8:
				F1.setBackground(Color.PINK);
				G1.setBackground(Color.PINK);
				A1.setBackground(Color.PINK);
				AB1.setBackground(Color.PINK);
				C2.setBackground(Color.PINK);
				D2.setBackground(Color.PINK);
				E2.setBackground(Color.PINK);
				F2.setBackground(Color.PINK);
				break;
				
			//Bb major	
			case 9:
				AB1.setBackground(Color.PINK);
				C2.setBackground(Color.PINK);
				D2.setBackground(Color.PINK);
				DE2.setBackground(Color.PINK);
				F2.setBackground(Color.PINK);
				G2.setBackground(Color.PINK);
				A2.setBackground(Color.PINK);
				AB2.setBackground(Color.PINK);
				break;
				
			//Eb maj	
			case 10:
				DE1.setBackground(Color.PINK);
				F1.setBackground(Color.PINK);
				G1.setBackground(Color.PINK);
				GA1.setBackground(Color.PINK);
				AB1.setBackground(Color.PINK);
				C2.setBackground(Color.PINK);
				D2.setBackground(Color.PINK);
				DE2.setBackground(Color.PINK);
				break;
				
			//Ab maj	
			case 11:
				GA1.setBackground(Color.PINK);
				AB1.setBackground(Color.PINK);
				C2.setBackground(Color.PINK);
				CD2.setBackground(Color.PINK);
				DE2.setBackground(Color.PINK);
				F2.setBackground(Color.PINK);
				G2.setBackground(Color.PINK);
				GA2.setBackground(Color.PINK);
				break;
				
			//Db	
			case 12:
				CD1.setBackground(Color.PINK);
				DE1.setBackground(Color.PINK);
				F1.setBackground(Color.PINK);
				FG1.setBackground(Color.PINK);
				GA1.setBackground(Color.PINK);
				AB1.setBackground(Color.PINK);
				C2.setBackground(Color.PINK);
				CD2.setBackground(Color.PINK);
				break;
				
			//Gb 
			case 13:
				FG1.setBackground(Color.PINK);
				GA1.setBackground(Color.PINK);
				AB1.setBackground(Color.PINK);
				B1.setBackground(Color.PINK);
				CD2.setBackground(Color.PINK);
				DE2.setBackground(Color.PINK);
				F2.setBackground(Color.PINK);
				FG2.setBackground(Color.PINK);
				break;
				
			//Cb	
			case 14:
				B1.setBackground(Color.PINK);
				CD2.setBackground(Color.PINK);
				DE2.setBackground(Color.PINK);
				E2.setBackground(Color.PINK);
				FG2.setBackground(Color.PINK);
				GA2.setBackground(Color.PINK);
				AB2.setBackground(Color.PINK);
				B2.setBackground(Color.PINK);
				break;
			}
		 
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SharpMajorScales) {
			WhiteKeys();			
			int KeyChoice = SharpMajorScales.getSelectedIndex();
			MajorHighlight(KeyChoice);
		
		}
		else if (e.getSource() == Clear) {
			WhiteKeys();
		}
		
		else if (e.getSource() == C1) {
				try {
					AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\c3.wav"));
					Clip clip = AudioSystem.getClip();
					clip.open(aIS);
					clip.start();
				}
				 catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
		else if (e.getSource() == D1) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(3) d3.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == E1) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(5) e3.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == F1) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(6) f3.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == G1) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(8) g3.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == A1) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(22) a4.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == B1) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(24)b4.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == C2) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(13)c4.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == D2) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(15) d4.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == E2) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(17) e4.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == F2) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(18) f4.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == G2) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(20) g4.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == A2) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\a5.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == B2) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\b5.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == CD1) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(2) c-3.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == DE1) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(4) d-3.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == FG1) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(7) f-3.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == GA1) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(9) g-3.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == AB1) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(23) a-4.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == CD2) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(14) c-4.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == DE2) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(16) d-4.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == FG2) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(19) f-4.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == GA2) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\(21) g-4.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == AB2) {
			try {
				AudioInputStream aIS = AudioSystem.getAudioInputStream(new File("C:\\Users\\me\\Desktop\\mp3 Notes\\saved\\a-5.wav"));
				Clip clip = AudioSystem.getClip();
				clip.open(aIS);
				clip.start();
			}
			 catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
			
			
	}
		// TODO Auto-generated method stub
}

