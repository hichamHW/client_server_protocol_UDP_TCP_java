import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientTCP {
    public static void main(String[] args) throws Exception{

        Socket s =new Socket("localhost",2032);

        InputStream in =  s.getInputStream();
        OutputStream ou =s.getOutputStream();

        DataInput din = new DataInputStream(in);
        DataOutput dou = new DataOutputStream(ou);

        Scanner scanner = new Scanner(System.in);
        int n ;

      do {
          System.out.println("N doit sup ou egale a  0 !");
          String str = scanner.nextLine();
          n = Integer.parseInt(str);
      }while (n<0);
      dou.writeInt(n);
      double res = din.readDouble();
      System.out.println("le fac de "+n + " est "+ res);


    }
}
