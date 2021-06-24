package MajorScales;
import java.util.HashMap;

import javax.swing.JButton;

import MajorScales.AFlatMajor;
import MajorScales.AMajor;
import MajorScales.BFlatMajor;
import MajorScales.BMajor;
import MajorScales.CFlatMajor;
import MajorScales.CMajor;
import MajorScales.CSharpMajor;
import MajorScales.DFlatMajor;
import MajorScales.DMajor;
import MajorScales.EFlatMajor;
import MajorScales.EMajor;
import MajorScales.FMajor;
import MajorScales.FSharpMajor;
import MajorScales.GFlatMajor;
import MajorScales.GMajor;
import MajorScales.PianoNote;

public class MajorFactory {
	private CMajor Cmaj = new CMajor();
	private GMajor Gmaj = new GMajor();
	private DMajor Dmaj = new DMajor();
	private AMajor Amaj = new AMajor();
	private BMajor Bmaj = new BMajor();
	private EMajor Emaj = new EMajor();
	private FSharpMajor FSmaj = new FSharpMajor();
	private CSharpMajor CSmaj = new CSharpMajor();
	private FMajor Fmaj = new FMajor();
	private BFlatMajor BFmaj = new BFlatMajor();
	private EFlatMajor EFmaj = new EFlatMajor();
	private AFlatMajor AFmaj = new AFlatMajor();
	private DFlatMajor DFmaj = new DFlatMajor();
	private GFlatMajor GFmaj = new GFlatMajor();
	private CFlatMajor CFmaj = new CFlatMajor();
	private  JButton[] buttons = new JButton[8];
	private  HashMap<String,PianoNote> allPianoKeys;
	
	public MajorFactory(HashMap<String,PianoNote> pianoKeys) {
		allPianoKeys = pianoKeys;
	}
	
	public JButton[] getMajor(String MajorType){
	      if(MajorType == null) {
	         return null;
	      }	
	      
	      if(MajorType.equals("C")) {
	    	  buttons = Cmaj.setScale(allPianoKeys);	 
	      } 	      
	      else if (MajorType.equals("G")) {   
	    	  buttons = Gmaj.setScale(allPianoKeys);	    	  
	      } 	      
	      else if (MajorType.equalsIgnoreCase("D")) {
	    	  buttons = Dmaj.setScale(allPianoKeys); 
		  }  
	      else if (MajorType.equalsIgnoreCase("A")) {
	    	  buttons = Amaj.setScale(allPianoKeys);
		  }	   
	      else if (MajorType.equalsIgnoreCase("E")) {
	    	  buttons = Emaj.setScale(allPianoKeys);
		  }	      
	      else if (MajorType.equalsIgnoreCase("B")) {
	    	  buttons = Bmaj.setScale(allPianoKeys);
		  }	      
	      else if (MajorType.equalsIgnoreCase("F#")) {
	    	  buttons = FSmaj.setScale(allPianoKeys);
		  }	      
	      else if (MajorType.equalsIgnoreCase("C#")) {
	    	  buttons = CSmaj.setScale(allPianoKeys);
		  }	      
	      else if (MajorType.equalsIgnoreCase("F")) {
	    	  buttons = Fmaj.setScale(allPianoKeys); 
		  }	      
	      else if (MajorType.equalsIgnoreCase("Bb")) {
	    	  buttons = BFmaj.setScale(allPianoKeys);
		  }	      
	      else if (MajorType.equalsIgnoreCase("Eb")) {
	    	  buttons = EFmaj.setScale(allPianoKeys);
		  }	      
	      else if (MajorType.equalsIgnoreCase("Ab")) {
	    	  buttons = AFmaj.setScale(allPianoKeys);
		  }	      
	      else if (MajorType.equalsIgnoreCase("Db")) {
	    	  buttons = DFmaj.setScale(allPianoKeys);
		  }	     
	      else if (MajorType.equalsIgnoreCase("Gb")) {
	    	  buttons = GFmaj.setScale(allPianoKeys);  
		  }  else if (MajorType.equalsIgnoreCase("Cb") ){
	    	  buttons = CFmaj.setScale(allPianoKeys);
		  }
	      return buttons;   
	}
}
