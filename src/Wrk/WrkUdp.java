package Wrk;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/**
 * @author GamezJ
 * @version 1.0
 * @created 15-nov.-2022 08:16:12
 */
public class WrkUdp implements ItfWrkUdpWrkRobot {

    private DatagramSocket datagramSocket;
    private Wrk refWrk;
    private boolean running;
    private byte[] img;
    private String ip = "192.168.53.1";
    private InetAddress address;

    public WrkUdp() {
        try {
            datagramSocket = new DatagramSocket();
            address = InetAddress.getByName("192.168.53.1");
        } catch (Exception e) {
        }

    }

    /**
     *
     * @param image
     */
    public void sendVideo(byte[] image) {
        if (image != null) {

            DatagramPacket packet
                    = new DatagramPacket(image, image.length, address, 8889);
            System.out.println("ouuiiiiii");
            try {
                datagramSocket.send(packet);
                System.out.println("envoyé");
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public byte[] getip() {
        String[] addrs = ip.split("\\.");
        if (addrs.length != 4) {
            throw new IllegalArgumentException("ip should be a x.x.x.x");
        }
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            int a = Integer.parseInt(addrs[i]);
            if (a > 255) {
                
            }
        }
        return null;
    }
    

    public void sendVideod(byte[] frame) {
        float nombreDecoupe = frame.length / Short.MAX_VALUE;
        for (int i = 0; i < nombreDecoupe; i++) {
            byte[] packet = Arrays.copyOfRange(frame, (int) (i * nombreDecoupe), (int) (i * nombreDecoupe + Short.MAX_VALUE));
            try {
                InetAddress.getByName(ip).getAddress();
                DatagramPacket dp = new DatagramPacket(packet, packet.length, address, 42069);
              
            datagramSocket.send(dp);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}//end WrkUdp
