
import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;
import java.net.InetSocketAddress;

public class PortScanner {

    public static boolean isPortOpen(String host, int port){
        try(Socket socket = new Socket()){
             socket.connect(new InetSocketAddress(host, port), 200);
            return true;
        }catch(IOException e){
            return false;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String host;

        System.out.println("Enter host to scan: ");
        host = scanner.nextLine();

        System.out.println("Scanning host: " + host);

        for(int i=1 ; i<=1024; i++){
            if (isPortOpen(host, i)){
                System.out.println("Port OPEN: " + i );
            }
        }
        System.out.println("Scan completed.");
    }
}