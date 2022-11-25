/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Wrk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import static java.lang.Thread.sleep;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gamezj
 */
public class Client extends Thread {

    private WrkTCP wrkTcp;
    private Socket socket;
    private boolean running;
    private BufferedReader in;
    private BufferedWriter out;
    private String SPLIT = ";";
    private Wrk refWrk;

    /**
     * constructeur
     *
     * @param name
     * @param socket
     * @param wrkTcp
     * @param wrk
     */
    public Client(String name, Socket socket, WrkTCP wrkTcp, Wrk wrk) {
        super(name);
        this.socket = socket;
        this.wrkTcp = wrkTcp;
        this.refWrk = wrk;

    }

    /**
     *
     * @param ms
     */
    public void attendre(long ms) {
        try {
            sleep(ms);
        } catch (InterruptedException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        String[] info;
        running = true;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (running) {
                String msg = in.readLine();

                if (msg != null) {
                    System.out.println(msg);
                    info = msg.split(SPLIT);
                    String option = info[0];
                    switch (option) {
                        case "":

                            break;
                        case "manette":
                            refWrk.setMouvement(info);
                            break;
                        case "save":
                            refWrk.createUser(option, option);
                            break;
                        case "login":
                            String[] user = info[1].split(":");
                           
                            String[] login = user[1].split(",");
                           
                            System.out.println("login[0], login[1]" + login[0] + "," + login[1]);
                            refWrk.loginUser(login[0], login[1]);
                            break;
                        case "badge":
                            refWrk.badgLogin(msg);
                            break;
                        default:
                            throw new AssertionError();
                    }
                    //  wrkServer.recevoirMessage(socket.getInetAddress().getHostAddress() + " : " + msg);

                } else {
                    running = false;
                }

                attendre(10);
            }
            wrkTcp.removeClient(this);

            socket.close();

        } catch (IOException ex) {

        }

    }

    public void ecrire(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}
