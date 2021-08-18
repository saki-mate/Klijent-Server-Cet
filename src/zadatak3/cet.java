package zadatak3;
//u cetu kao da prepoznaje znak $ ili e i da to cuva kao listu u neku sumu npr.
//i sve to da loguje u neki fajl
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class cet extends Thread{
	
	Socket socket, socket1;
	BufferedReader in, in1;
	PrintWriter out, out1, f;
	LocalDateTime ldt;
	
	public cet(Socket socket, Socket socket1) throws IOException {
		this.socket = socket;
		this.socket1= socket1;
		
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		
		this.in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
		this.out1 = new PrintWriter(new OutputStreamWriter(socket1.getOutputStream()), true);
		}
	
	@Override
	public void run() {
		try {
			f = new PrintWriter(new FileWriter("src\\zadatak3\\istorija"));
			
			String ime = in.readLine();
			String ime1 = in1.readLine();
			
			System.out.println("Dobro dosli: " + ime + " i " + ime1);
 
			out.println("1");
			out1.println("2");
			while(true) {

				String odgovor = in.readLine();
				System.out.println(odgovor);
				
				synchronized(f) {
				f.write(LocalDateTime.now() + ime + ": " + odgovor + "\n");
				f.flush();
				}
				out1.println(odgovor);
				
				String odgovor1 = in1.readLine();

				out.println(odgovor1);
				
				f.write(LocalDateTime.now() + ime1 + " " + odgovor1 + "\n");
				f.flush();

			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			f.close();
			try {
				socket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
