
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

public class PortScanner {

    static Map<Integer,String> portName = new HashMap<>();

    public static void addKnownPorts(){
        portName.put(20, "FTP data");
        portName.put(21, "FTP control");
        portName.put(22, "SSH");
        portName.put(23, "Telnet");
        portName.put(25, "SMTP");
        portName.put(53, "DNS");
        portName.put(67, "DHCP server");
        portName.put(68, "DHCP client");
        portName.put(80, "HTTP");
        portName.put(135, "Windows RPC");
        portName.put(443, "HTTPS");
        portName.put(445, "SMB / Windows file sharing");
    }

    public static boolean isPortOpen(String host, int port){
        try(Socket socket = new Socket()){
             socket.connect(new InetSocketAddress(host, port), 200);
            return true;
        }catch(IOException e){
            return false;
        }
    }


    public static String getServiceName(int port){

        String service = portName.get(port);
        if(service != null){
            return service;
        }
        return "Unknown service";
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String host;

        addKnownPorts();

        if(args.length>0){
            host = args[0];
        }
        else{
            System.out.println("Enter host to scan: ");
            host = scanner.nextLine();
        }
       

        System.out.println("Scanning host: " + host);

        for(int i=1 ; i<=1024; i++){
            if (isPortOpen(host, i)){
                System.out.println("Port OPEN: " + i + " "+ getServiceName(i) );
            }
        }
        System.out.println("Scan completed.");
    }
}