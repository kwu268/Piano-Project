package MajorScales;
import java.util.HashMap;

import javax.swing.JButton;


import MajorScales.PianoNote;

public class MajorFactory {
	
	private  JButton[] buttons = new JButton[8];
	private  HashMap<String,PianoNote> allPianoKeys;
	
	public MajorFactory(HashMap<String,PianoNote> pianoKeys) {
		allPianoKeys = pianoKeys;
	}
	
	public JButton[] getMajor(String MajorType){
		ScaleData test = new ScaleData();
	      if(MajorType == null) {
	         return null;
	      }	
	      
	      if(MajorType.equals("C")) {
	    	  buttons = test.setScale(allPianoKeys, "C");	 
	      } 	      
	      else if (MajorType.equals("G")) {   
	    	  buttons = test.setScale(allPianoKeys, "G");	     	  
	      } 	      
	      else if (MajorType.equalsIgnoreCase("D")) {
	    	  buttons = test.setScale(allPianoKeys, "D");	 
		  }  
	      else if (MajorType.equalsIgnoreCase("A")) {
	    	  buttons = test.setScale(allPianoKeys, "A");	 
		  }	   
	      else if (MajorType.equalsIgnoreCase("E")) {
	    	  buttons = test.setScale(allPianoKeys, "E");	 
		  }	      
	      else if (MajorType.equalsIgnoreCase("B")) {
	    	  buttons = test.setScale(allPianoKeys, "B");	 
		  }	      
	      else if (MajorType.equalsIgnoreCase("F#")) {
	    	  buttons = test.setScale(allPianoKeys, "F#");	 
		  }	      
	      else if (MajorType.equalsIgnoreCase("C#")) {
	    	  buttons = test.setScale(allPianoKeys, "C#");	 
		  }	      
	      else if (MajorType.equalsIgnoreCase("F")) {
	    	  buttons = test.setScale(allPianoKeys, "F");	 
		  }	      
	      else if (MajorType.equalsIgnoreCase("Bb")) {
	    	  buttons = test.setScale(allPianoKeys, "Bb");	 
		  }	      
	      else if (MajorType.equalsIgnoreCase("Eb")) {
	    	  buttons = test.setScale(allPianoKeys, "Eb");	 
		  }	      
	      else if (MajorType.equalsIgnoreCase("Ab")) {
	    	  buttons = test.setScale(allPianoKeys, "Ab");	 
		  }	      
	      else if (MajorType.equalsIgnoreCase("Db")) {
	    	  buttons = test.setScale(allPianoKeys, "Db");	 
		  }	     
	      else if (MajorType.equalsIgnoreCase("Gb")) {
	    	  buttons = test.setScale(allPianoKeys, "Gb");	 
		  }  else if (MajorType.equalsIgnoreCase("Cb") ){
	    	  buttons = test.setScale(allPianoKeys, "Cb");	 
		  }
	      return buttons;   
	}
}
