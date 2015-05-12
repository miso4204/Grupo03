package main.java;

import gui.FileChooser;

public class Main {
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		      public void run() {
		    	  FileChooser.createAndShowGUI();
		      }
		    });

	}

}
