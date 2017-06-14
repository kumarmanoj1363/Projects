import java.net.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class Demo  {

	public static  void main(String[] args)throws IOException
	{
		
		
		String url  = "http://192.168.1.252:8080/R0";
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("POST");
		
		
	  conn.setRequestProperty("X-M2M-Origin","S" );
	  conn.setRequestProperty("Content-Type", "application/json;ty=2" );
	  conn.setRequestProperty("X-M2M-RI","1234");
	  conn.setRequestProperty ("Accept","application/json");
	  
	  String params = "m2m:ae :'api ': 'ADN-AE-UD_NAME','rr':'true', 'Ibl':'UD_MK', 'rn':'adn_ae_UD_MK','poa':'192.168.1.252:8080'";
	  
	  conn.setDoOutput(true);
	  
	  DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	  wr.writeBytes(params);
	  wr.flush();
	  wr.close();
	  
	  int resCode = conn.getResponseCode();
	  System.out.println();
	  
	  BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	  String line;
	  StringBuffer response = new StringBuffer();
	  while((line = br.readLine()) != null) {
		  response.append(line);
	  }
	  br.close();
	  System.out.println(response.toString());
	  
	  
	  
	  
	  
	  
	  
	}
}
