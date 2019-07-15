package pl.sda.eventmanager.mymanager.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserForm {

    @NotNull
    @Size(min=2, max=30)
    private String nick;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    public UserForm() {
    }

    public UserForm(String nick, String email, String password) {
        this.nick = nick;
        this.email = email;
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserForm userForm = (UserForm) o;
        return Objects.equals(nick, userForm.nick) &&
                Objects.equals(email, userForm.email) &&
                Objects.equals(password, userForm.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, email, password);
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
