package pl.sda.eventmanager.mymanager.dto;

//  @Data - adnotacja nie została użyta ponizej, jednakże jest zbiorem adnotacji
//  @Getter, @Setter, @ToString, @EqualsAndHashCode

import java.util.Objects;

public class LoginForm {

    private String nick;
    private String password;
    private String email;

    public LoginForm() {
    }

    public LoginForm(String login, String password) {
        this.nick = login;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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
        LoginForm loginForm = (LoginForm) o;
        return Objects.equals(nick, loginForm.nick) &&
                Objects.equals(password, loginForm.password) &&
                Objects.equals(email, loginForm.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, password, email);
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "login='" + nick + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
