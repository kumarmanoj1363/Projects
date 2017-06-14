import java.io.IOException;
import java.io.InputStreamReader;



public class Demo  {

	public static  void main(String[] args)throws IOException
	{
		
		
		String url  = "http://192.168.1.252:8080/R405";
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		conn.setRequestMethod("POST");
		
		
	  conn.setRequestProperty("X-M2M-Origin","S64" );
	  conn.setRequestProperty("Content-Type", "application/json;ty=23" );
	  conn.setRequestProperty("X-M2M-RI","1234");
	  conn.setRequestProperty ("Accept","application/json");
	  
	  String params = "{\"m2m:sub\":{\"rn\":\"sub_UD_MK1_state1\",\"enc\":{\"net\":[3]},\"\nu\":[\"S64\",\" http://192.168.1.31:8080/StreetLightApplication/NotiHandler\"],\"nct\":1}}";
	  
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
	  
	  System.out.println(resCode);
	  System.out.println(response.toString());
	  
	  System.out.println(response.length());

	  
	  
	  
	  
	  
	}
}
