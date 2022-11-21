package Wrk;

import java.io.BufferedReader;
import java.net.Socket;


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

	public WrkTCP(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param string
	 */
	public void EnvoieMessage(String string){

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

	public void run(){

	}

	public void setRunning(){

	}
}//end WrkTCP