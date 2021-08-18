package zadatak3;	
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

		public class Server {

			public static void main(String[] args) {
				try {
					ServerSocket ss = new ServerSocket(1234);
					System.out.println("Server je pokrenut");
					
					try {
						while (!Thread.interrupted()) {
							Socket klijent1 = ss.accept();
							Socket klijent2 = ss.accept();
							System.out.println("Uspostavljena je nova konekcija");
							cet kom = new cet(klijent1, klijent2);
							kom.start();
							
							System.out.println("Pokrenuta je nova igra");
						}

					} finally {
						ss.close();
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
