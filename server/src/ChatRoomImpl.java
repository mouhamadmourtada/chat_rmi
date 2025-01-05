// Chat must be imported from a JAR file named ChatInterfaces.jar. this jar file is located in the archive folder. the archive folder is located in ../
// import List

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;


public class ChatRoomImpl implements ChatRoom {

    private final List<ChatUser> clients = new ArrayList<>();

    public ChatRoomImpl() {
        super();
    }

    @Override
    public void subscribe(ChatUser client, String pseudo) throws RemoteException {
        // client = new ChatUserImpl(pseudo);
        clients.add(client);
        // return client;
    }

    
    @Override
    public void postMessage(String pseudo, String message) {
        clients.forEach(client -> {
            try {
                client.displayMessage(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void unsubscribe(ChatUser chatUser) throws RemoteException {
        clients.removeIf(client -> client.equals(chatUser));
    }
}