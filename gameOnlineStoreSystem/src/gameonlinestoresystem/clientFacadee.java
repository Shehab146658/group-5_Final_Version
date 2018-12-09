/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameonlinestoresystem;
import API.UnirestTest;
import gameonlinestoresystem.Category;
import gameonlinestoresystem.Item;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import RMI.ClientFacade;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import java.util.Observable;
import java.util.Scanner;
import javax.net.ssl.SSLContext;
import mongoDB.DB;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Dell
 */
public class clientFacadee extends UnicastRemoteObject implements ClientFacade {

    
    private final Vendor vendor;
    private final systemAdmin admin;
    private final customerService service;
    private final AccountManager manager;
   private final Customer customer;
   public clientFacadee(AccountManager manager,Vendor vendor,systemAdmin admin,customerService service,Customer customer) throws RemoteException {
        this.manager=manager;
        this.vendor=vendor;
        this.admin=admin;
        this.service=service;
        this.customer=customer;
    }


  
       @Override
    public String notify(String customerID, String vendorID, String customerServiceID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    


    @Override
    public String update() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public String api(String password)
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
                HttpResponse<JsonNode>response= Unirest.post("http://usfngm.com/login.php?password="+password).asJson();
                System.out.println(response.getBody());
                return response.getBody().toString();
            }catch (Exception e) {
            return "Exception: " + e.getMessage();
            
        }
        
    }

    @Override
    public Boolean verifyLogin(int category, int id, String password) throws RemoteException 
    {
        DB db=new DB();
        UnirestTest ap=new UnirestTest();
        String encPass= ap.api(password);
        System.out.println("logging in");
        Customer cust = db.getCustomerByID(id);
        
        String encPass1=cust.getPassword();
        System.out.println(encPass1);
        System.out.println(encPass);   
        
        if(!encPass1.equals(encPass)) {
            System.out.println("login failed");
            return false;
        } else {
            System.out.println("login successful");
            return true;
        }
        
    }



}
   

    
    


