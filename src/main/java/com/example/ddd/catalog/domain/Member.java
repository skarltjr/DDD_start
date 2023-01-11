package com.example.ddd.catalog.domain;

import com.example.ddd.catalog.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "member")
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "member_name",nullable = false)
    private String name;
    @Embedded
    private Password password;
    @Email
    @Column(name = "member_email",nullable = false)
    private String email;

    public Member(String name,Password password,String email){
        this.name = name;
        setPassword(password);
        setEmail(email);
    }

    /**
     * 비밀번호는 변경할 수 있다.
     * - 이전과 동일한 비밀번호로 변경할 수 없다.
     *
     * 이메일은 변경할 수 있다.
     * - 이전과 동일한 이메일로 변경할 수 없다.
     * */

    // 비밀번호 변경
    public void changePassword(Password oldPassword,Password newPassword){
        if (!password.match(oldPassword.getValue())){
            throw new IllegalArgumentException(ErrorCodes.PASSWORD_NOT_MATCH);
        }
        setPassword(newPassword);
    }

    private void setPassword(Password newPassword) {
        this.password = newPassword;
    }


    // 이메일 변경
    public void changeEmail(String oldEmail,String newEmail){
        if (this.email.equals(oldEmail)){
            throw new IllegalArgumentException(ErrorCodes.ALREADY_USED_EMAIL);
        }
        setEmail(newEmail);
    }

    private void setEmail(String newEmail) {
        this.email = newEmail;
    }
}
