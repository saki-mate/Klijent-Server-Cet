package zadatak3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class Klijent1 {

	public static void main(String[] args) {
		
		try {
		Socket s = new Socket("localhost", 1234);
		System.out.println("klijent1");
		try {

			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Kako se zoves klijentu1?");
			String ime = stdIn.readLine();
			out.println(ime);

			String i = in.readLine();
			//prvi si
			if(i.equals("1")) {
				System.out.println("Zapocni komunikaciju");
				while(true) {
				String poruka = stdIn.readLine();
				out.println(poruka);
			
				String odgovor = in.readLine();
				System.out.println(odgovor);
				}
			}else {
				System.out.println("Sacekaj kolegu da posalje nesto");
				
				while(true) {
				String odgovor = in.readLine();
				System.out.println(odgovor);
				
				String poruka = stdIn.readLine();
				out.println(poruka);
				}
			}

		} finally {
			s.close();
		}
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
