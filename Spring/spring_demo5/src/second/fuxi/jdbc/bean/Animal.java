package second.fuxi.jdbc.bean;

import org.springframework.stereotype.Component;

@Component
public class Animal {
    private Integer id;
    private String username;
    private String ustatus;

    public Animal(Integer id, String username, String ustatus) {
        this.id = id;
        this.username = username;
        this.ustatus = ustatus;
    }

    public Animal() {
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", ustatus='" + ustatus + '\'' +
                '}';
    }
}
