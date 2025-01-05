import java.io.Serializable;

public class ChatUserImpl implements ChatUser, Serializable {
    private static final long serialVersionUID = 1L; // Ensure this is consistent
    
    private final String pseudo;

    public ChatUserImpl(String pseudo) {
        this.pseudo = pseudo;
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(pseudo + " : " + message);
    }

    // @Override
    public String getPseudo() {
        return pseudo;
    }

    
}
