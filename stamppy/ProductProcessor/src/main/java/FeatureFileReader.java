package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FeatureFileReader {
	
	public static List<String> getFeaturesList(File file){
		List<String> features = new ArrayList<String>();
		BufferedReader br = null;
		try {	
			br = new BufferedReader(new FileReader(file)); 
		    String line;
		    while ((line = br.readLine()) != null) {
		       features.add(line);
		       System.out.println(line);
		    }
		    br.close();
		    return features;
		}catch(IOException e){
			System.out.println(e.getMessage());
			return null;
		}

	}

}
