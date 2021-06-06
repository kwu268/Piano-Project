	
public class Theory {
	private static final String[][] String = null;
	private String[] Sharpnotes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
	private String[] Flatnotes = {"C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab", "A", "Bb", "B"};
	private String[] Sharpmaj = {"C", "G", "D", "A", "E", "B", "F#", "C#"};
	private String[] Flatmaj = {"F", "Bb", "Eb", "Ab", "Db", "Gb", "Cb"};
	
	
	public String[] makeMajor(String key) {
		//Sharp = 1 while flat = 0
		int type = -1;
		int pos =-1;
		String[] scale = new String[8];
		
		for (int i = 0; i < Sharpmaj.length; i++) {
			if (key.equals(Sharpmaj[i])) {
				type = 1;
				for (int j =0; j < Sharpnotes.length; j++) {
					if (key.equals(Sharpnotes[j])) {
						pos = j;
						break;
					}
				}
				
				break;
			}
		}
		if (type == -1) {
			
			type = 0;
			for (int j =0; j < Flatnotes.length; j++) {
				if (key.equals(Flatnotes[j])) {
					pos = j;
					break;
				}
			}
		}
		//Semitones + tones 
		
		//sharp key signature
		if (type == 1) {			
			if (key.equals("C#")) {
				scale[0] = "C#";
				scale[1] =  "D#";
				scale[2] =  "E#";
				scale[3] = "F#";
				scale[4] =  "G#";
				scale[5] =  "A#";
				scale[6] = "B#";
				scale[7] =  "C#";	
			}
			else if (key.equals("F#")) {
				scale[0] = "F#";
				scale[1] =  "G#";
				scale[2] =  "A#";
				scale[3] = "B";
				scale[4] =  "C#";
				scale[5] =  "D#";
				scale[6] = "E#";
				scale[7] =  "F#";	
			}
			else {
				scale[0] = Sharpnotes[pos];
				scale[1] = Sharpnotes[pos+2];
				scale[2] = Sharpnotes[pos+4];
				scale[3] = Sharpnotes[pos+5];
				scale[4] = Sharpnotes[pos+7];
				scale[5] = Sharpnotes[pos+9];
				scale[6] = Sharpnotes[pos+11];
				scale[7] = scale[0];		
			}
					
		}
		
		if (type == 0) {
			if (key.equals("Cb")) {
				scale[0] = "Cb";
				scale[1] =  "Db";
				scale[2] =  "Eb";
				scale[3] = "Fb";
				scale[4] =  "Gb";
				scale[5] =  "Ab";
				scale[6] = "Bb";
				scale[7] =  "Cb";	
			}
			else if ( key.equals("Gb")) {
				scale[0] = "Gb";
				scale[1] =  "Ab";
				scale[2] =  "Bb";
				scale[3] = "C";
				scale[4] =  "Db";
				scale[5] =  "Eb";
				scale[6] = "F";
				scale[7] =  "Gb";	
			}

			else {
				scale[0] = Flatnotes[pos];
				scale[1] = Flatnotes[pos+2];
				scale[2] = Flatnotes[pos+4];
				scale[3] = Flatnotes[pos+5];
				scale[4] = Flatnotes[pos+7];
				scale[5] = Flatnotes[pos+9];
				scale[6] = Flatnotes[pos+11];
				scale[7] = scale[0];		
			}
					
							
		}
		
		
		for (int i =0; i < scale.length; i++) {
			System.out.println(scale[i]);
		}
		return scale;
	}
	
	public static void main(String[] args) {
		Theory t = new Theory();
		t.makeMajor("D");
		
	}
	}

