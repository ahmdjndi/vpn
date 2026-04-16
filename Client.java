import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("10.8.0.51", 12345);
            System.out.println("Terhubung ke server");

            PrintWriter out = new PrintWriter(
                    s.getOutputStream(), true);

            Scanner input = new Scanner(System.in);

            String pesan;

            // kirim pesan terus (bisa chat manual)
            while (true) {
                System.out.print("Ketik pesan: ");
                pesan = input.nextLine();

                out.println(pesan);

                if (pesan.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            out.close();
            s.close();
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}