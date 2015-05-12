package gui;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.java.FeatureFileConverter;
import main.java.FeatureFileReader;
import main.java.ProductAssembler;


public class FileChooser extends JPanel implements ActionListener {
	
	static private final String newline = "\n";

	  JButton openButton, saveButton, runButton;
	  
	  File configFile;
	  
	  String outPutFolder;

	  JTextArea log;

	  JFileChooser fc;
	 

	  public FileChooser() {
	    super(new BorderLayout());

	    //Create the log first, because the action listeners
	    //need to refer to it.
	    log = new JTextArea(5, 20);
	    log.setMargin(new Insets(5, 5, 5, 5));
	    log.setEditable(false);
	    JScrollPane logScrollPane = new JScrollPane(log);

	    //Create a file chooser
	    fc = new JFileChooser();

	    //Uncomment one of the following lines to try a different
	    //file selection mode. The first allows just directories
	    //to be selected (and, at least in the Java look and feel,
	    //shown). The second allows both files and directories
	    //to be selected. If you leave these lines commented out,
	    //then the default mode (FILES_ONLY) will be used.
	    //
	    //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

	    //Create the open button. We use the image from the JLF
	    //Graphics Repository (but we extracted it from the jar).
	    openButton = new JButton("Open config file");
	    openButton.addActionListener(this);

	    //Create the save button. We use the image from the JLF
	    //Graphics Repository (but we extracted it from the jar).
	    saveButton = new JButton("Set output folder");
	    saveButton.addActionListener(this);
	    
	    runButton = new JButton("Run");
	    runButton.addActionListener(this);

	    //For layout purposes, put the buttons in a separate panel
	    JPanel buttonPanel = new JPanel(); //use FlowLayout
	    buttonPanel.add(openButton);
	    buttonPanel.add(saveButton);
	    buttonPanel.add(runButton);

	    //Add the buttons and the log to this panel.
	    add(buttonPanel, BorderLayout.PAGE_START);
	    add(logScrollPane, BorderLayout.CENTER);
	  }

	  public void actionPerformed(ActionEvent e) {

	    //Handle open button action.
	    if (e.getSource() == openButton) {
	    	FileFilter filter = new FileNameExtensionFilter("Config files","config");
	    	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    	fc.addChoosableFileFilter(filter);
	      int returnVal = fc.showOpenDialog(FileChooser.this);

	      if (returnVal == JFileChooser.APPROVE_OPTION) {
	        configFile = fc.getSelectedFile();
	        //This is where a real application would open the file.
	        log.append("Opening: " + configFile.getName() + "." + newline);
	      } 
	      log.setCaretPosition(log.getDocument().getLength());

	      //Handle save button action.
	    } else if (e.getSource() == saveButton) {
	        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        fc.setAcceptAllFileFilterUsed(false);
	        int returnVal = fc.showOpenDialog(this);
	      if (returnVal == JFileChooser.APPROVE_OPTION) {
	        File file = fc.getSelectedFile();
	        outPutFolder = file.getAbsolutePath();
	        //This is where a real application would save the file.
	        log.append("Output Folder: " + outPutFolder + "." + newline);
	      }
	      log.setCaretPosition(log.getDocument().getLength());
	    }else if (e.getSource() == runButton) {
	    	if(configFile != null && outPutFolder != null){
	    		List<String> features = FeatureFileReader.getFeaturesList(configFile);
	    		FeatureFileConverter featureFile = new FeatureFileConverter(features);
	    		ProductAssembler.createProduct(featureFile, outPutFolder);
	    	}else{
	    		if(configFile==null){
	    			log.append("Debe elegir un archivo de configuracion de producto");
	    		}else{
	    			log.append("Debe elegir una ruta donde se generara el ear");
	    		}
	    	}
	    }
	  }

	  /** Returns an ImageIcon, or null if the path was invalid. */
	  protected static ImageIcon createImageIcon(String path) {
	    java.net.URL imgURL = FileChooser.class.getResource(path);
	    if (imgURL != null) {
	      return new ImageIcon(imgURL);
	    } else {
	      System.err.println("Couldn't find file: " + path);
	      return null;
	    }
	  }

	  /**
	   * Create the GUI and show it. For thread safety, this method should be
	   * invoked from the event-dispatching thread.
	   */

	public static void createAndShowGUI() {
	    //Make sure we have nice window decorations.
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JDialog.setDefaultLookAndFeelDecorated(true);

	    //Create and set up the window.
	    JFrame frame = new JFrame("HEXAGRAM product assembler");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    //Create and set up the content pane.
	    JComponent newContentPane = new FileChooser();
	    newContentPane.setOpaque(true); //content panes must be opaque
	    frame.setContentPane(newContentPane);

	    //Display the window.
	    frame.pack();
	    frame.setVisible(true);
	  }
	
}
