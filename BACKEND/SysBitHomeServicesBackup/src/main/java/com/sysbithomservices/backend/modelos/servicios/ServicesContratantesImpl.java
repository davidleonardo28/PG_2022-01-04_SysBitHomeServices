package com.sysbithomservices.backend.modelos.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sysbithomservices.backend.modelo.DAO.InterfaceContratantes;
import com.sysbithomservices.backend.modelo.entity.Contratantes;

@Service("contService")
public class ServicesContratantesImpl implements InterfaceContratantesServicios, UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(ServicesContratantesImpl.class);
	
	@Autowired
	private InterfaceContratantes intContDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Contratantes> findAll() {
		return (List<Contratantes>) intContDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Contratantes findById(int id) {
		return intContDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Contratantes save(Contratantes contratantes) {
		return intContDAO.save(contratantes);
	}

	@Override
	@Transactional
	public void delete(int id) {
		intContDAO.deleteById(id);
	}

	@Override
	public Contratantes findByUsername(String username) {
		return intContDAO.findByUsername(username);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Contratantes cont = intContDAO.findByUsername(username);
		
		logger.debug(username);
		
		if(cont == null) {
			logger.error("Error en el Login: No existe el administrador'"+username+"' en el sistema");
			throw new UsernameNotFoundException("Error en el Login: No existe el administrador'"+username+"' en el sistema");
		}
		
		List<GrantedAuthority> authorities = cont.getSupervisados()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombRole()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(cont.getUsername(), cont.getClaveUce(), cont.getEnable(), true, true, true, authorities);
	}
}
