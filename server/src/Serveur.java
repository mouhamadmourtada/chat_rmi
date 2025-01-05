import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class Serveur {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry ready.");
    
            ChatRoomImpl obj = new ChatRoomImpl();
            // ChatUserImpl user1 = new ChatUserImpl("user1");
            System.out.println("Attempting to export object...");
    
            ChatRoom chatRoom = (ChatRoom) UnicastRemoteObject.exportObject(obj, 0);
            // ChatUser chatUser = (ChatUser) UnicastRemoteObject.exportObject(user1, 0);
    
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("chatRoom", chatRoom);
            // registry.rebind("chatUser", chatUser);
    
            System.out.println("Server ready");
            
        } catch (java.rmi.server.ExportException e) {
            System.err.println("Object already exported: " + e.toString());
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }


    }
    
}
