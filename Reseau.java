import java.net.*;
public class Reseau {
    static int port = 3879;
    DatagramSocket socket;
    DatagramPacket packet;
    
    InetAddress ipAdv;
    InetAddress myIp;
    
    byte[] buffer;
    
    public Reseau(String yourIp){
        try {
            this.socket = new DatagramSocket(this.port);
            this.buffer = new byte[15];
            this.packet = new DatagramPacket(this.buffer,this.buffer.length);
            this.myIp = InetAddress.getByName(null);
            this.ipAdv = InetAddress.getByName(yourIp);
        }
            catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public String Receive(){
        String chaine = "";
        try {
            this.socket.receive(this.packet);
            chaine = new String(this.packet.getData(),0,this.packet.getLength());
        }
	catch(Exception e) {
            e.printStackTrace(); 
	}
	return chaine;
    }
    
    public void Send(String mess){
        try {
            this.buffer = mess.getBytes();

            this.packet = new DatagramPacket(this.buffer,this.buffer.length,this.ipAdv,this.port);
            this.socket.send(this.packet);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
