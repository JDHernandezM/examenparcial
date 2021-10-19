package vender_telefonos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vender_telefonos.dao.IUsuarioDAO;
import vender_telefonos.model.Usuario;


//se puede renombar o dar apodo a los services
@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private IUsuarioDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = userDAO.findOneByUsername(username); //from usuario where username := username

		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		usuario.getRoles().forEach( rol -> {
			authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		
		//Usuario es el de bd y User el objeto que spring necesita
		UserDetails userDetails = new User(usuario.getUsername(), usuario.getPassword(), authorities);
		
		return userDetails;
	}
}

