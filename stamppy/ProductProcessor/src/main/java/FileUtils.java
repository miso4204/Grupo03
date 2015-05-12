package main.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;

public class FileUtils {
	
	
	public static void runEarGenerator() throws IOException, MavenInvocationException{

		String generatedProjectPath = "resources/outputProject/stamppy/pom.xml";
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile( new File(generatedProjectPath) );
		request.setGoals( Arrays.asList( "clean", "install" ) );

		Invoker invoker = new DefaultInvoker();
		invoker.setMavenHome(new File("/apache-maven-3.1.1"));
		invoker.execute( request );
	}
	
	public static void copyEar() throws IOException{
		File file = new File("resources/outputProject/stamppy/stamppyProject-ear/target/stamppy.ear");
		while(true){
			if(file.exists()){
				System.out.println("...");
				break;
			}	
		}
		copyFile(file, new File("resources/ear/stamppy.ear"));
	}
	
	public static void deleteExistingProject(){
		
		File directory = new File("resources/outputProject/stamppy");
    	if(!directory.exists()){
    		return;
        }else{
           try{
               delete(directory);
           }catch(IOException e){
               e.printStackTrace();
               return;
           }
        }
	}
	
	public static void copySourceProjec(){
		File srcFolder = new File("resources/projectSource/stamppy");
    	File destFolder = new File("resources/outputProject/stamppy");
 
    	if(!srcFolder.exists()){
 
           System.out.println("Directory does not exist.");
           return;
 
        }else{
 
           try{
        	copyFolder(srcFolder,destFolder);
           }catch(IOException e){
        	e.printStackTrace();
        	return;
           }
        }
 
    	System.out.println("Done");
	}
	
	public static void copyFile(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	}
	
	public static void replaceFileContent(String oldString, String newString, String file) throws IOException{
		Path path = Paths.get(file);
		Charset charset = StandardCharsets.UTF_8;

		String content = new String(Files.readAllBytes(path), charset);
		content = content.replaceAll(oldString, newString);
		Files.write(path, content.getBytes(charset));
		System.out.println(newString+" replaced");
	}
	
	
	private static void delete(File file)
	    	throws IOException{
	 
	    	if(file.isDirectory()){
	    		if(file.list().length==0){
	    		   file.delete();
	    		   System.out.println("Directory is deleted : " 
	                                                 + file.getAbsolutePath());
	    		}else{
	        	   String files[] = file.list();
	        	   for (String temp : files) {
	        	      File fileDelete = new File(file, temp);
	        	     delete(fileDelete);
	        	   }
	        	   if(file.list().length==0){
	           	     file.delete();
	        	     System.out.println("Directory is deleted : " 
	                                                  + file.getAbsolutePath());
	        	   }
	    		}
	 
	    	}else{
	    		file.delete();
	    		System.out.println("File is deleted : " + file.getAbsolutePath());
	    	}
	    }
	
	public static void copyFolder(File src, File dest)
	    	throws IOException{
	 
	    	if(src.isDirectory()){
	    		if(!dest.exists()){
	    		   dest.mkdir();
	    		   System.out.println("Directory copied from " 
	                              + src + "  to " + dest);
	    		}
	    		String files[] = src.list();
	 
	    		for (String file : files) {
	    		   File srcFile = new File(src, file);
	    		   File destFile = new File(dest, file);
	    		   copyFolder(srcFile,destFile);
	    		}
	 
	    	}else{
	    		InputStream in = new FileInputStream(src);
	    	        OutputStream out = new FileOutputStream(dest); 
	 
	    	        byte[] buffer = new byte[1024];
	 
	    	        int length;
	    	        while ((length = in.read(buffer)) > 0){
	    	    	   out.write(buffer, 0, length);
	    	        }
	    	        in.close();
	    	        out.close();
	    	        System.out.println("File copied from " + src + " to " + dest);
	    	}
	    }	

}
