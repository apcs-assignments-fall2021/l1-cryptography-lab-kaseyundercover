import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String result= "";
        for (char i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 'a' && message.charAt(i) <= 'w') {
                char convert=(char)(message.charAt(i)+3);
                result = (result + convert);}

            else if (message.charAt(i) > 'w') {
                char convert=(char)(message.charAt(i)-23);
              result =(result+convert);}

              else if (message.charAt(i) >= 'A' && message.charAt(i) <= 'W') {
                    char convert=(char)(message.charAt(i)+3);
            result =(result+convert);}

              else if (message.charAt(i) > 'W') {
                    char convert=(char)(message.charAt(i)-23);
                result =(result+convert);}

              else {
                char convert = (char) (message.charAt(i) - 23);
                result =(result + message.charAt(i));
            }




        }
        return result;
    }
    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String result= "";
        for (char i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 'd' && message.charAt(i) <= 'z') {
                char convert=(char)(message.charAt(i)-3);
                result = (result + convert);}

            else if (message.charAt(i) >= 'a' && message.charAt(i) <= 'd' ) {
                char convert=(char)(message.charAt(i)+23);
                result =(result+convert);}

                else if (message.charAt(i) >= 'D' && message.charAt(i) <= 'Z') {
                    char convert=(char)(message.charAt(i)-3);
                    result =(result+convert);}

                else if (message.charAt(i) >= 'A' && message.charAt(i) <= 'D' ) {
                    char convert=(char)(message.charAt(i)+23);
                    result =(result+convert);}

            else {
                char convert = (char) (message.charAt(i) -23);
                result =(result + message.charAt(i));}



        }
        return result;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String result= "";
        int maxvalue= 'z'-key;
        int capmax='Z'-key;
        for (char i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= 'a' && message.charAt(i) <= maxvalue) {
                char convert=(char)(message.charAt(i)+key);
                result = (result + convert);}

            else if (message.charAt(i) > maxvalue) {
                char convert=(char)(message.charAt(i)-(26-key));
                result =(result+convert);}

            else if (message.charAt(i) >= 'A' && message.charAt(i) <= capmax) {
                char convert=(char)(message.charAt(i)+key);
                result =(result+convert);}

            else if (message.charAt(i) > capmax) {
                char convert=(char)(message.charAt(i)-(26-key));
                result =(result+convert);}

            else {
                char convert = (char) (message.charAt(i) - (key+26));
                result =(result + message.charAt(i));
            }




        }
        return result;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String result= "";
        int maxvalue= 'a'+key;
        int capmax='A'+key;
        for (char i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= maxvalue && message.charAt(i) <= 'z') {
                char convert=(char)(message.charAt(i)-key);
                result = (result + convert);}

            else if (message.charAt(i) > maxvalue ) {
                char convert=(char)(message.charAt(i)+(26-key));
                result =(result+convert);}

            else if (message.charAt(i) >= capmax && message.charAt(i) <= 'Z') {
                char convert=(char)(message.charAt(i)-key);
                result =(result+convert);}

            else if (message.charAt(i) > capmax) {
                char convert=(char)(message.charAt(i)+(26-key));
                result =(result+convert);}

            else {
                char convert = (char) (message.charAt(i)+(26-key));
                result =(result + message.charAt(i));}



        }
        return result;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Enter the key for your message: ");
            int key = scan.nextInt();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesarKey(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Enter the key for your message: ");
            int key = scan.nextInt();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesarKey(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
