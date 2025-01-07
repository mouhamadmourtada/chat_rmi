import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client {
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enter your pseudo: ");
    //     String pseudo = sc.nextLine();

    //     try {
    //         // Créer et exporter l'utilisateur
    //         ChatUserImpl userImpl = new ChatUserImpl(pseudo);
    //         ChatUser user = (ChatUser) UnicastRemoteObject.exportObject(userImpl, 0);

    //         Registry registry = LocateRegistry.getRegistry("localhost");
    //         ChatRoom chatRoom = (ChatRoom) registry.lookup("chatRoom");
            
    //         chatRoom.subscribe(user, pseudo);

            
    //         String message;
    //         while (true) {
    //             message = sc.nextLine();
    //             if (message.equals("quit")) {
    //                 chatRoom.unsubscribe(user);  // Maintenant c'est un ChatUser valide
    //                 break;
    //             }
    //             chatRoom.postMessage(pseudo, message);
    //         }

    //     } catch (Exception e) {
    //         System.err.println("Client exception: " + e.toString());
    //         e.printStackTrace();
    //     }
    // }
}