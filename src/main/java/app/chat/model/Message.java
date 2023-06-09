package app.chat.model;

import app.chat.util.MessageState;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message implements Comparable<Message> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int MessageID;

    @Column(name = "sender", nullable = false)
    private String sender;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "sent_date", nullable = false)
    private Date sentDate;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "state", nullable = false)
//    private MessageState state;


    public Message(String sender, String content, Date sentDate) {
        this.sender = sender;
        this.content = content;
        this.sentDate = sentDate;
    }


    @Override
    public int compareTo(Message o) {
        return this.sentDate.compareTo(o.sentDate);
    }

}
