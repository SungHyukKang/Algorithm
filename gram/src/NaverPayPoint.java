import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class NaverPayPoint {

   private static class CustomizedHostnameVerifier implements HostnameVerifier { 
      
      public boolean verify(String hostname, SSLSession session) {  
         return true; 
      }
   }
   

   

   
   public static void main(String[] args)  {
         
      //String targeturl="https://dev.apis.naver.com/livartmall/naverpay/payments/v1/naverpoint-save";
      
      // 운영
      String targeturl="https://apis.naver.com/livartmall/naverpay/payments/v1/naverpoint-save";

          try{
             
             URL url=new URL(targeturl);

             HttpsURLConnection connection2  =   (HttpsURLConnection) url.openConnection();
              connection2.setHostnameVerifier(new CustomizedHostnameVerifier())  ;
             connection2.setRequestMethod("GET");
             
             connection2.setDoOutput(true);
             connection2.setDoInput(true);
             
             connection2.setRequestProperty("X-Naver-Client-Id", "EfCFDB7AeBdKmg1tA98o"); 
             connection2.setRequestProperty("X-Naver-Client-Secret", "FLo_7i9mEg");
             
             OutputStream os = null;

             String data = "paymentId="+"20201111NP2178680554";
             
             os = connection2.getOutputStream();
             os.write(data.getBytes());
             os.flush();

             InputStream is =connection2.getInputStream();   
      
             ByteArrayOutputStream baos = null;
             
             String response;
             
             int responseCode = connection2.getResponseCode();
             
             if(responseCode == HttpsURLConnection.HTTP_OK) {    
                baos = new ByteArrayOutputStream();    
                byte[] byteBuffer = new byte[1024];    
                byte[] byteData = null;    
                int nLength = 0;    
                
                while((nLength = is.read(byteBuffer, 0, byteBuffer.length)) != -1) {        
                
                   baos.write(byteBuffer, 0, nLength);  
             
                }   
                byteData = baos.toByteArray();        
                response = new String(byteData);    
                
                JSONParser jsonParser = new JSONParser();
                
                JSONObject responseJSON = (JSONObject) jsonParser.parse(response);
                String code = (String) responseJSON.get("code");    
                String message = (String) responseJSON.get("message");    

                String paymentId = "";
                
                if("Success".equals(code)){
                     HashMap<String, Object> body = (HashMap)responseJSON.get("body");
                     paymentId = body.get("paymentId").toString();
                     System.out.println(paymentId);
                 }else{
                    System.out.println(message);
                 }
             }

         }catch(IOException e){
            e.printStackTrace();
            
            String exCause="";
            
            String exceptionName= e.getClass().getName();
            
            if(exceptionName.equals("java.net.MalformedURLException")){
               exCause="MalformedURLException URL : [ "+targeturl + "]";
            }else if(exceptionName.equals("java.net.UnknownHostException")){
               exCause="UnknownHostException  URL : [ "+targeturl + "]";
            }else if(exceptionName.equals("java.io.FilenotFoundException")){
               exCause="FilenotFoundException  URL : [ "+targeturl + "]";
            }else if(exceptionName.equals("java.net.ConnectionException")){
               exCause="ConnectionException   : [ "+e.toString() + "]";
            }else if(exceptionName.equals("java.io.IOException")){
               exCause="IOException    : [ "+e.toString() + "]";
            }
            System.out.println(exCause);
         }  
          catch(ParseException pe){
            pe.printStackTrace() ; 
         }
       
   }

}



