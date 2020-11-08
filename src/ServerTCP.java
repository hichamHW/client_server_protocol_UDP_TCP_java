import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

    public static void main(String[] args)  throws Exception{

        ServerSocket ss = new ServerSocket(2032);
        System.out.println("Listing...");
        Socket s = ss.accept();
        System.out.println("connecting...");

        InputStream in =  s.getInputStream();
        OutputStream ou =s.getOutputStream();

        DataInput din = new DataInputStream(in);
        DataOutput dou = new DataOutputStream(ou);
        int n = din.readInt();
        System.out.println(n);

        double res = new ServerTCP().fact(n);
        System.out.println(res);

        dou.writeDouble(res);

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
