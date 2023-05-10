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

import com.sysbithomservices.backend.modelo.DAO.InterfaceColaboradores;
import com.sysbithomservices.backend.modelo.entity.Colaboradores;

@Service("colabService")
public class ServicesColaboradoresImpl implements InterfaceColaboradoresServicios, UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(ServicesContratantesImpl.class);
	
	@Autowired
	private InterfaceColaboradores intColDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Colaboradores> findAll() {
		return (List<Colaboradores>) intColDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Colaboradores findById(int id) {
		return intColDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Colaboradores save(Colaboradores colaboradores) {
		return intColDAO.save(colaboradores);
	}

	@Override
	@Transactional
	public void delete(int id) {
		intColDAO.deleteById(id);
	}

	@Override
	public Colaboradores findByUsername(String username) {
		return intColDAO.findByUsername(username);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Colaboradores colab = intColDAO.findByUsername(username);
		
		logger.debug(username);
		
		if(colab == null) {
			logger.error("Error en el Login: No existe el administrador'"+username+"' en el sistema");
			throw new UsernameNotFoundException("Error en el Login: No existe el administrador'"+username+"' en el sistema");
		}
		
		List<GrantedAuthority> authorities = colab.getSupervisados()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombRole()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(colab.getUsername(), colab.getClaveUcr(), colab.getEnable(), true, true, true, authorities);
	}	
}
