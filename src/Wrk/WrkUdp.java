package Wrk;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Properties;
import javax.imageio.ImageIO;

/**
 * @author GamezJ
 * @version 1.0
 * 
 */
public class WrkUdp implements ItfWrkUdpWrkRobot {

    private DatagramSocket datagramSocket;
    private Wrk refWrk;
    private boolean running;
    private byte[] img;
    private String ip = "192.168.53.1";
    private InetAddress address;

    /**
     *initialise le socket et définit l'adresse ip.
     */
    public WrkUdp() {
        try {
            datagramSocket = new DatagramSocket();
            address = InetAddress.getByName(lireProperties().getProperty("IP"));
        } catch (Exception e) {
        }

    }
     private Properties lireProperties() throws IOException {
        Properties conf = new Properties();
        conf.load(new FileInputStream("config/ip.conf"));
        return conf;
    }

   

    /**
     *
     * @param image byte[] contanant l'image a envoyer
     * découpe l'image en plusieurs morceau de façon a la faire passer dans un packet.
     */
    public void sendVideod(byte[] image) {
        float nombreDecoupe = image.length / Short.MAX_VALUE;
        for (int i = 0; i < nombreDecoupe; i++) {
            byte[] packet = Arrays.copyOfRange(image, (int) (i * nombreDecoupe), (int) (i * nombreDecoupe + Short.MAX_VALUE));
            try {
                InetAddress.getByName(ip).getAddress();
                DatagramPacket dp = new DatagramPacket(packet, packet.length, address, 8889);

                datagramSocket.send(dp);
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}//end WrkUdp
