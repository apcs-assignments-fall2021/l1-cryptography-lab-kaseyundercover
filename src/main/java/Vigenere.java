import java.util.Scanner;

public class Vigenere {
    public static char encryptCaesarLetter(char ch, int key) {
        int maxvalue= 'z'-key;
        int capmax='Z'-key;
            if (ch >= 'a' && ch <= maxvalue) {
                char convert=(char)(ch+key);
                return convert;}

            else if (ch > maxvalue) {
                char convert=(char)(ch-(26-key));
                return convert;}

            else if (ch >= 'A' && ch <= capmax) {
                char convert=(char)(ch+key);
                return convert;}

            else if (ch > capmax) {
                char convert=(char)(ch-(26-key));
               return convert;}

            else {
                char convert=(char)(ch);
//                char convert = (char) (ch - (key+26));
                return convert;}
    }

    public static char decryptCaesarLetter(char ch, int key) {
        int maxvalue = 'a' + key;
        int capmax = 'A' + key;
            if (ch >= maxvalue && ch <= 'z') {
                char convert = (char) (ch - key);
                return convert;
            } else if (ch > maxvalue) {
                char convert = (char) (ch + (26 - key));
                return convert;
            } else if (ch >= capmax && ch <= 'Z') {
                char convert = (char) (ch - key);
                return convert;
            } else if (ch > capmax) {
                char convert = (char) (ch + (26 - key));
                return convert;
            } else {
                char convert=(char)(ch);
//                char convert = (char) (ch + (26 - key));
                return convert;
            }


        }


    public static String encryptVigenere(String message, String key) {
        int keyIndex=0;
        String result = "";
       for (char i = 0; i < message.length(); i++) {
           int y = key.charAt(keyIndex) - 'A';
           char x = (message.charAt(i));
           char z = encryptCaesarLetter(x, y);

//           System.out.println(x + " " + y);

           if (message.charAt(i) >= 'A' && message.charAt(i)<='Z' ){
               keyIndex=keyIndex+1;}
           else if (message.charAt(i) >= 'a' && message.charAt(i)<='z' ){
               keyIndex=keyIndex+1;}
           else{keyIndex=keyIndex+0;}

           result=result+z;
           if (keyIndex==key.length()){
               keyIndex=0;
           }

       }
    return result;

    }

    public static String decryptVigenere(String message, String key) {
        int keyIndex=0;
        String result = "";
        for (char i = 0; i < message.length(); i++) {
            int y = key.charAt(keyIndex) - 'A';
            char x = (message.charAt(i));
            char z = decryptCaesarLetter(x, y);
//            System.out.println(x + " " + y);
            if (message.charAt(i) >= 'A' && message.charAt(i)<='Z' ){
            keyIndex=keyIndex+1;}
            else if (message.charAt(i) >= 'a' && message.charAt(i)<='z' ){
                keyIndex=keyIndex+1;}
            else{
                keyIndex=keyIndex+0;
            }
            result=result+z;
            if (keyIndex==key.length()){
                keyIndex=0;

            }

        }
        return result;

    }


    public static void main(String[] args) {
//       System.out.println(encryptCaesarLetter('H',2));

        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
