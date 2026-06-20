package SystemDesign;

import java.util.ArrayList;
import java.util.Arrays;

class User {
    String Name;
    String Email;
    String PhoneNumber;
    String Profile;
    Long lastSeen;
    Boolean isOnline;
}

class Conversation {
    String type = "private/group";
    ArrayList<String> participants = new ArrayList<>(Arrays.asList("Abhishek", "Kushal"));
    Long createdAt;
    String lastMessageId;
    Long lastMessageTime;
}

class Message {
    String messageId;
    String message;
    Long timeStamp;
    String userId;
    String ConversationId;
    boolean status;
    Long createdAt;
}

class MessageStatus{
    String messageId;
    Boolean status;
    Long readAt;
    String userId;
}

class UserConversation {
    String ConversationId;
    String UserId;
    String LastReadMessage;
    Integer unreadCount;
}

public class ChatSystem {
}