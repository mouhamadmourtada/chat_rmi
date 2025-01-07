import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ChatClient {
    private ChatClientGUI gui;
    private ChatRoom chatRoom;
    private ChatUser user;

    public ChatClient() {
        gui = new ChatClientGUI(this);
    }

    public void connect(String pseudo) {
        try {
            ChatUserImpl userImpl = new ChatUserImpl(this, pseudo);
            user = (ChatUser) UnicastRemoteObject.exportObject(userImpl, 0);
            
            Registry registry = LocateRegistry.getRegistry("localhost");
            chatRoom = (ChatRoom) registry.lookup("chatRoom");
            
            chatRoom.subscribe(user, pseudo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            chatRoom.postMessage(gui.getPseudo(), message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void receiveMessage(String message) {
        gui.displayMessage(message);
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}