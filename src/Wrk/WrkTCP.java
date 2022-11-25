package Wrk;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;


/**
 * @author GamezJ
 * @version 1.0
 * @created 15-nov.-2022 08:16:12
 */
public class WrkTCP extends Thread {

	private volatile BufferedReader in;
	private volatile BufferedReader out;
	private Wrk refWrk;
	private boolean running;
	private volatile Socket socket;
	private WrkTCP wrkTcp;
        private ServerSocket serverSocket;
        private volatile ArrayList<Client> clients;
        private Client client;
	public WrkTCP(Wrk refWrk){
            this.refWrk = refWrk;
          
	}
        public void demarrerServeur(int port) {
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(1000);
            System.out.println("serveur en ligne");
        } catch (IOException ex) {
           
        } catch (Exception exc) {
        
        }
        clients = new ArrayList<>();
    }
         public void arreterServeur() {
        try {
            serverSocket.close();
        } catch (IOException ex) {
           
        }

    }

	
	/**
	 * 
	 * @param string
	 */
	public void EnvoieMessage(String string){
            client.ecrire(string);
	}

	public boolean isRunning(){
		return false;
	}

	/**
	 * 
	 * @param string
	 * @param socket
	 * @param wrk
	 */
	public void Listner(String string, Socket socket, Wrk wrk){

	}

	 public void run() {
        running = true;
        while (running) {
            try {
                synchronized (serverSocket) {
                    Socket socketClient = serverSocket.accept();
                     client = new Client(socketClient.getInetAddress().getHostAddress(), socketClient, this, refWrk);
                    clients.add(client);
                    client.start();
                   
                    attendre(10);
                }
            } catch (SocketTimeoutException ex) {
                // rien car timeout
            } catch (IOException exc) {
                System.out.println("Erreur " + exc);
            }
        }
        for (Client client : clients) {
            if (client != null) {
                client.setRunning(false);
                try {
                    client.join();
                    client = null;
                } catch (InterruptedException ex) {

                }
            }
        }
        System.gc();
     //   wrk.recevoirMessageInfo("Serveur fermé");
    }

	public void setRunning(){

	}
         public void attendre(long ms) {
        try {
            sleep(ms);
        } catch (InterruptedException ex) {

        }
    }
         public void removeClient(Client client) {
        clients.remove(client);
    }
}//end WrkTCP