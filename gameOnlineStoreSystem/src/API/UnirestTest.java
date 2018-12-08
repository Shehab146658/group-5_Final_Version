/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 *
 * @author Dell
 */
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import javax.net.ssl.SSLContext;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import sun.net.www.http.HttpClient;
/**
 *
 * @author Dell
 */
public class UnirestTest {
     public static void main(String[] args) 
     {    
         try{
             SSLContext sslcontext = SSLContexts.custom()
                    .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                    .build();
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);
            CloseableHttpClient httpclient = HttpClients.custom()
                    .setSSLSocketFactory(sslsf)
                    .build();
            Unirest.setHttpClient(httpclient);
                HttpResponse<JsonNode>response= Unirest.post("http://usfngm.com/login.php?password=test/post").queryString("password","098f6bcd4621d373cade4e832627b4f6").asJson();
                System.out.println(response.getBody());
            }catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
}
}
