package pl.sda.eventmanager.mymanager.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class EmailForm {

    @Email
    @NotEmpty(message = "To jest wlasna wiadomosc do walidacji czy email nie jest pusty")
    private String email;

    @Length(min = 1, max = 10)
    @NotBlank
    private String title;

    @Length(min = 1, max = 255)
    @NotBlank
    private String content;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
