public class Star implements Network {

    private int numberOfVertices;
    private Vertex[] hub;

    public Star(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        createModel();
    }

    @Override
    public void createModel() {
        hub = new Vertex[numberOfVertices];
        for (int i = 0, name = 'a'; i < numberOfVertices; i++, name++) {
            hub[i] = new Vertex((char)name);
        }
    }

    @Override
    public Vertex find(char sourceName, char destinationName) {
        System.out.println("Hub has been visited");
        for (Vertex v: hub) {
            if (v.getName() == destinationName) {
                return v;
            }
        }
        throw new VertexNotFoundException("Could not find vertex" + destinationName);
    }

    @Override
    public void sendMessage(char sourceName, char destinationName, String message) {
        Vertex messageSentTo = find(sourceName, destinationName);
        messageSentTo.addNewMessageSent(message + " (" + sourceName + " sent a message to " + sourceName + ").");
        messageSentTo.addNewMessageRecieved(message + " ( " + destinationName + " received a message from " + sourceName + ").");
        System.out.println("Message successfully sent from " + sourceName + " to " + destinationName);

    }
}