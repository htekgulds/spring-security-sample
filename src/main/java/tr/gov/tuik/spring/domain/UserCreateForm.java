package tr.gov.tuik.spring.domain;

import org.hibernate.validator.constraints.NotEmpty;
import tr.gov.tuik.spring.domain.enums.Role;

import javax.validation.constraints.NotNull;

/**
 * Created by Hasan TEKGÜL
 * on 6/2/2015
 */
public class UserCreateForm {

    @NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeat = "";

    @NotNull
    private Role role = Role.USER;

    public UserCreateForm() {
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

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
