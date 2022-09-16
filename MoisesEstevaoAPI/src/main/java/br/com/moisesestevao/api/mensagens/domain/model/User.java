package br.com.moisesestevao.api.mensagens.domain.model;

import br.com.moisesestevao.api.auth.domain.model.Perfil;
import br.com.moisesestevao.api.mensagens.domain.form.UserForm;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Getter
@Setter
public class User implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
	private String username;
    private String password;
    private String nome;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Perfil> perfis;

    public User(UserForm form){
        this.username = form.getEmail();
        this.nome = form.getNome();
        this.password = form.getSenha();
    }

    public User(){

    }
    
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return perfis;
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
