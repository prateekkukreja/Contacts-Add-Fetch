package commons;

import java.util.Random;

public class Utilities {

    public String getRandValString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public Long getRandValInt() {
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        Long saltStr = Long.parseLong(salt.toString());
        return saltStr;
    }

    public int getInt() {

        int num = 0;
        int max = 20;
        int min = 5;
        Random rand = new Random();
        num = rand.nextInt((max - min) + 1) + min;

        return num;
    }

}
