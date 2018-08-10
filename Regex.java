package newsproject;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
public class Regex {
	public static void main(String[] args) {
		/*Connecting the Website*/
		URL url = null;
		try {
			url = new URL("https://inshorts.com/en/read");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		URLConnection urlcon = null;
		try {
			urlcon = url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		/*Connecting the Website Ends Here*/
		
		
		/*Retrieving HTml data from the Website*/
		InputStream stream = null;
		try {
			stream = urlcon.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		int i;  
		String str="";
		try {
			while((i=stream.read())!=-1){  
			str+=(char)i; 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		/*Retrieving HTml data from the Website ends here*/

		 
		
		Pattern p=Pattern.compile("<span itemprop=\"headline\">(.+?)</span>");
		List<String> s=new ArrayList<String>();
		Matcher m=p.matcher(str);
		int numberofnews=0;
		while(m.find()) {
		s.add(m.group().replaceAll("<span itemprop=\\\"headline\\\">|</span>", ""));
		numberofnews++;
		}
		
		
		CardLayoutExample cl=new CardLayoutExample(s,numberofnews);  
        cl.setSize(400,400);  
        cl.setVisible(true);  
    
		
		
		
	}
}
