import java.io.*;
import java.time.LocalDate;

    public class Members {

        String name;
        String personNumber;
        LocalDate latestPaymentDate;

       public static int findMembers(String Members, String [] list) {
            for (int i = 0; i < list.length; i++) {
                if (i % 2 == 0) {
                    String[] thisMember = list[i].split(", ");
                    if (thisMember[0].equals(Members.trim()) || thisMember[1].equalsIgnoreCase(Members.trim())) {
                    return i;
                }
                }
            }
            return -1;
        }

        public static void controlMember(String identity, String name, String createFile) throws IOException {
            String str;
            String context = "";
            BufferedReader br = new BufferedReader(new FileReader(createFile));

            while ((str = br.readLine()) !=null) {
                context += str + "\n";
            }
            try (PrintWriter outstream = new PrintWriter(new BufferedWriter(new FileWriter(createFile)));) {
                File secondFile = new File(createFile);
                String customInfo = identity + " " + name + " " + LocalDate.now();
                context += customInfo + "\n";
                outstream.append(context);
            }
        }

        public String getPersonNumber () {
            return personNumber;
        }

        public LocalDate getLatestPaymentDate() {
            return latestPaymentDate;
        }

        public Members (String name, String personNumber, LocalDate latestPaymentDate){
        }
    }


