package MajorScales;
import java.awt.Color;

import javax.swing.JButton;

public class BMajor implements Scale {
	
	private static JButton[] buttons = new JButton[8];


	@Override
	public void getNotes(JButton[] test) {
		int note = 0;
		for (int parse = 0; parse < test.length; parse++) {
			if (note > 8) break;
			if (note == 0) {
				if (test[parse].getText().equals("B1")) {
					buttons[note] = test[parse];
					note++;
					System.out.println(test[parse].getText());
				}
			}
			else if (note == 1) {
				if (test[parse].getText().equals("C#/Db2")) {
					buttons[note] = test[parse];
					note++;
					System.out.println(test[parse].getText());
				}
			}
			else if (note == 2)	{
				if (test[parse].getText().equals("D#/Eb2")) {
					buttons[note] = test[parse];
					note++;
					System.out.println(test[parse].getText());
				}
			}
			else if (note == 3)	{
				if (test[parse].getText().equals("E2")) {
					buttons[note] = test[parse];
					note++;
					System.out.println(test[parse].getText());
				}
			}
			else if (note == 4) {
				if (test[parse].getText().equals("F#/Gb2")) {
					buttons[note] = test[parse];
					note++;
					System.out.println(test[parse].getText());
				}
			}
			else if (note == 5) {
				if (test[parse].getText().equals("G#/Ab2")) {
					buttons[note] = test[parse];
					note++;
					System.out.println(test[parse].getText());
				}
			}
			else if (note == 6) {
				if (test[parse].getText().equals("A#/Bb2")) {
					buttons[note] = test[parse];
					note++;
					System.out.println(test[parse].getText());
				}
			}
			else if (note == 7) {
				if (test[parse].getText().equals("B2")) {
					buttons[note] = test[parse];
					note++;
					System.out.println(test[parse].getText());
				}
			}
		}	
	}

	@Override
	public void Highlight() {
		for (int i =0; i < 8; i++) {
			
			buttons[i].setBackground(Color.pink);
		}
		
	}

	@Override
	public JButton[] setScale(JButton[] test) {
		getNotes(test);
		Highlight();
		return buttons;
	}

}
