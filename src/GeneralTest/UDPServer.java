package GeneralTest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPServer {

    public static void main(String[] args) {
        try {
            System.out.println("UDP server started");
            int udpServerPort = 10006;
            DatagramSocket udpSocket = new DatagramSocket(udpServerPort);

            byte[] receivedDataFromClient = new byte[1024];
            DatagramPacket receivedUdpPacket = new DatagramPacket(receivedDataFromClient, receivedDataFromClient.length);
            udpSocket.receive(receivedUdpPacket);

            String dataFromClient = new String(receivedUdpPacket.getData());
            System.out.println("Request from client => " + dataFromClient);

            String dataToBeSent = ("Alarm request received for alarm id: "+new String(receivedDataFromClient));
            
            DatagramPacket udpPacketToBeSent = new DatagramPacket(dataToBeSent.getBytes(), dataToBeSent.getBytes().length, receivedUdpPacket.getAddress(), receivedUdpPacket.getPort());
            udpSocket.send(udpPacketToBeSent);
            System.out.println("UDP data sent to client");
            udpSocket.close();
            System.out.println("UDP server finished");
        } catch (SocketException e) {
            System.out.println("Exception occured while creating UDP socket. " + e);
        } catch (UnknownHostException e) {
            System.out.println("Exception occured while fetching the UDP client address. " + e);
        } catch (IOException e) {
            System.out.println("Exception occured while sending UDP packet over UDP socket. " + e);
        }

    }

}
