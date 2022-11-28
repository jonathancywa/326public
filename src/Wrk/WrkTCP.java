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
 *
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

    /**
     *
     * @param refWrk
     */
    public WrkTCP(Wrk refWrk){
            this.refWrk = refWrk;
          
	}

    /**
     *permet d'initialiser le socket
     * @param port port a utiliser pour le socket
     */
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

    /**
     *permet de stoper le serveur
     */
    public void arreterServeur() {
        try {
            serverSocket.close();
        } catch (IOException ex) {
           
        }

    }

	
	/**
	 * permet d'envoyer des messages au client
	 * @param string message a envoyer
	 */
	public void EnvoieMessage(String string){
            client.ecrire(string);
	}

    /**
     *
     * @return
     */
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

    /**
     *permet de lancer le thread
     */
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

    /**
     *
     */
    public void setRunning(){

	}

    /**
     *
     * @param ms
     */
    public void attendre(long ms) {
        try {
            sleep(ms);
        } catch (InterruptedException ex) {

        }
    }

    /**
     *
     * @param client
     */
    public void removeClient(Client client) {
        clients.remove(client);
    }
}//end WrkTCP