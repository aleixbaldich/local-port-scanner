
import java.net.Socket;
import java.io.IOException;

public class PortScanner {

    public static boolean isPortOpen(String host, int port){
        try(Socket socket = new Socket(host,port)){
            return true;
        }catch(IOException e){
            return false;
        }
    }
    public static void main(String args[]){
        String host = "localhost";

         System.out.println("Scanning host: " + host);

        for(int i=1 ; i<=1024; i++){
            if (isPortOpen(host, i)){
                System.out.println("Port OPEN: " + i );
            }
        }
        System.out.println("Scan completed.");
    }
}