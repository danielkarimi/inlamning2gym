import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;

    public class Main {
        public static void main(String[] args) throws IOException {

            Members m = new Members("d", "a", LocalDate.now());
            String firstRow = "";
            String secondRow = "";
            String[] list;


            try {
                BufferedReader file = new BufferedReader(new FileReader("src/Customers.txt"));
                while ((firstRow = file.readLine()) != null) {
                    secondRow += firstRow + "\n";
                }

                list = secondRow.split("\n");
                String answer = JOptionPane.showInputDialog("Skriv in ditt namn eller personnummer: ");
                int customPlace = Members.findMembers(answer, list);
                if (customPlace != -1) {
                    LocalDate today = LocalDate.now();
                    LocalDate oneYearAgo = today.minusYears(1);
                    LocalDate latestPayment = LocalDate.parse(list[customPlace + 1]);

                    if (latestPayment.isBefore(oneYearAgo) ||
                            latestPayment.equals(oneYearAgo)) {
                        JOptionPane.showMessageDialog(null, list[customPlace] + " har varit medlem förut");

                    } else {

                        String[] payingMember = list[customPlace].split(", ");
                        m.controlMember(payingMember[0], payingMember[1], "src/gymFile.txt");
                        JOptionPane.showMessageDialog(null, list[customPlace] + " är medlem just nu");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, " Har inte varit medlem förut");

                }
            } catch (IOException e) {
                System.out.println("Its a error in the system");
            }
        }
    }







