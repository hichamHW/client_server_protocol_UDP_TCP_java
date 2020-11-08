import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) throws  Exception{
        DatagramSocket socket = new DatagramSocket();
        byte[] benv = new byte[1024];
        byte[] brec = new byte[1024];


        ////////////////sending////////
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        benv =str.getBytes();
        InetAddress adresse = InetAddress.getByName("localhost");
        int port = 3232;
        DatagramPacket dp = new DatagramPacket(benv,benv.length,adresse,port);
        socket.send(dp);
        ////////////////receive////////
        DatagramPacket dpr =new DatagramPacket(brec,brec.length);
        socket.receive(dpr);
        String str1 = new String(dpr.getData(),0,dpr.getLength());
        System.out.println(str1);
    }

}
