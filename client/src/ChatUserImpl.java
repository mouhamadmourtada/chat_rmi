import java.rmi.RemoteException;

public class ChatUserImpl implements ChatUser {
    private String pseudo;
    private ChatClient client;

    public ChatUserImpl(ChatClient client, String pseudo) {
        this.client = client;
        this.pseudo = pseudo;
    }

    @Override
    public void displayMessage(String message) throws RemoteException {
        client.receiveMessage(message);
    }

    @Override
    public String getPseudo() throws RemoteException {
        return pseudo;
    }
}