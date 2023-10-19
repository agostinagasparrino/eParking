package com.tallerwebi.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NOTIFICATION")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String message;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "is_read")
    private boolean isRead;
    private NotificationType type;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private MobileUser user;

    public Notification(String title, String message, Date creationDate, MobileUser user) {
        this.title = title;
        this.message = message;
        this.creationDate = creationDate;
        this.user = user;
        this.isRead = false;
    }

    public Notification() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public MobileUser getUser() {
        return user;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isRead() {
        return isRead;
    }

    public NotificationType getType() {
        return type;
    }
}
