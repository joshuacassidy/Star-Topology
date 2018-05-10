public class Main {

    public static void main(String[] args) {
        int numberOfConnectedDevices = 5;
        Star star = new Star(numberOfConnectedDevices);
        for (int i = 'a'; i < 'a'+numberOfConnectedDevices; i++) {
            star.sendMessage('a', (char) i, "message");
        }
    }
}

