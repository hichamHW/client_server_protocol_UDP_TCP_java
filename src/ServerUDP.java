import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerUDP {
    public static void main(String[] args) throws  Exception {
        DatagramSocket socket =new DatagramSocket(3232);
        System.out.println("Listing...");
        byte[] benv = new byte[1024];
        byte[] brec = new byte[1024];
        ///// receiving/////
        DatagramPacket dpr =new DatagramPacket(brec,brec.length);
        socket.receive(dpr);
        System.out.println("connecting...");
        String str = new String(dpr.getData(),0,dpr.getLength());
        System.out.println(str);
        //////sending///
        int n = Integer.parseInt(str);
        double res = new ServerUDP().fact(n);
        String str1 = String.valueOf(res);
        benv = str1.getBytes();
        DatagramPacket dp = new DatagramPacket(benv,benv.length,dpr.getAddress(),dpr.getPort());
        socket.send(dp);


    }
    public double fact(int n){
        double res = 1;
        if(n == 1 || n == 0 ){
            return  res;
        }
        for (int i = 1;i<= n; i++){
            res = res * i;
        }

        return  res;
    }
}
