package logicandlanguague;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLparse {
	Pattern linksReg,protocolReg;
	Matcher matcher;
	File file;
	public HTMLparse(File file){
		
		//regular expressions
		linksReg=Pattern.compile("<a[^>]+href=[\"']?([^'\"> ]+)[\"']?[^>]*>");
		protocolReg= Pattern.compile("(#.+?(?=')|[a-z]+:)");
		this.file =  file;
	}
	
	//puts all lines of the html file into an arraylist
	public ArrayList<String> getLines(){
		
		ArrayList<String> html = new ArrayList<String>();
		String s;
		Scanner scr=null;
		
		try{
			scr = new Scanner(file);
			scr.useDelimiter("\r\n");
			while(scr.hasNext()){
				s=scr.next();
				System.out.println("line normal: "+s);
				html.add(s);
				
			}
		}catch(FileNotFoundException ex){
			System.err.println("file not foudn");
		}
		return html;
	}
	
	//where the parsing magic happens
	public void parse(ArrayList<String> s){
		
		System.out.println("ALL <a href> links in HTML file");
		
		//goes through every single line in the document
		for(int i=0;i<s.size();i++){
			
			// parse links first
			matcher=linksReg.matcher(s.get(i));
			
			while(matcher.find()){
				
				System.out.println("Line: "+i +" "+matcher.group());
				
				//parse the already parsed links to see the type of link
				matcher=protocolReg.matcher(matcher.group());
				
				while(matcher.find()){
					System.out.print("Line: "+i+" "+"Type: ");
					System.out.print(matcher.group()+"\n");
					
				}
				
			}
		

		}

	
	}

}
