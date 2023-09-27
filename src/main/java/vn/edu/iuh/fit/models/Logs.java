package vn.edu.iuh.fit.models;

import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "bigint")
    private long id;

    @Column(columnDefinition = "varchar(50)")
    private String account_id;

    @Column(columnDefinition = "datetime")
    private Timestamp login_time;

    @Column(columnDefinition = "datetime")
    private Timestamp logout_time;

    @Column(columnDefinition = "varchar(250)")
    private String notes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Logs() {
    }

    public Logs(String account_id, Timestamp login_time, Timestamp logout_time, String notes) {
        this.account_id = account_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "id=" + id +
                ", account_id='" + account_id + '\'' +
                ", login_time=" + login_time +
                ", logout_time=" + logout_time +
                ", notes='" + notes + '\'' +
                '}';
    }

    public Timestamp getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Timestamp login_time) {
        this.login_time = login_time;
    }

    public Timestamp getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(Timestamp logout_time) {
        this.logout_time = logout_time;
    }
}
