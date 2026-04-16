import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(12345);
            System.out.println("Server berjalan...");
            System.out.println("Menunggu koneksi...");

            Socket client = s.accept();
            System.out.println("Client terhubung");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            String pesan;

            // membaca terus sampai client disconnect
            while ((pesan = in.readLine()) != null) {
                System.out.println("Pesan dari client: " + pesan);
            }

            System.out.println("Client disconnect");

            in.close();
            client.close();
            s.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}