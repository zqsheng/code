

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GreetingServer extends  Thread {
    private ServerSocket serverSocket;
    public GreetingServer(int port) throws IOException{
        serverSocket=new ServerSocket(port);
        serverSocket.setSoTimeout(100000);

    }
    public void run(){
        while (true){
            System.out.println("waiting remote connect ,port:"+serverSocket.getLocalPort()+".........");
            try {
                Socket server =serverSocket.accept();
                System.out.println("remote host ipaddress"+server.getRemoteSocketAddress());
                DataInputStream in =new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out=new DataOutputStream(server.getOutputStream());
                out.writeUTF("think you connect me:"+server.getLocalAddress()+"\nGoodBye!");
                server.close();

            }catch (SocketTimeoutException s){
                System.out.println("socket timed out!");
                break;
            }

            catch (IOException e) {
                e.printStackTrace();
                break;
            }

        }
    }
    public static void main(String[] args){
        int port =Integer.parseInt(args[0]);
        try {
            Thread thread=new GreetingServer(port);
            thread.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
