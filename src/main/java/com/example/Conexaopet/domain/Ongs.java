package com.example.Conexaopet.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_ongs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Ongs implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String corporate_name;
    private String email;
    private String contact;
    private String password;

    public Ongs(String corporate_name, String email, String contact, String password) {
        this.corporate_name = corporate_name;
        this.email = email;
        this.contact = contact;
        this.password = password;
    }

    @OneToMany(mappedBy = "ongs")
    private List<Address> address = new ArrayList<>();

    @OneToMany(mappedBy = "ongs")
    private List<Pets> pets = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(()->"read");
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
