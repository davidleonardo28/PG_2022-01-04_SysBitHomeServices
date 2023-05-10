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

import com.sysbithomservices.backend.modelo.DAO.InterfaceAdminstrador;
import com.sysbithomservices.backend.modelo.entity.Administrador;

@Service("adminService")
public class ServicesAdministradoresImpl implements InterfaceAdministradorServicios, UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(ServicesAdministradoresImpl.class);
	
	@Autowired
	private InterfaceAdminstrador intAdminDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Administrador> findAll() {
		return (List<Administrador>) intAdminDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Administrador findById(int id) {
		return intAdminDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Administrador save(Administrador contratantes) {
		return intAdminDAO.save(contratantes);
	}

	@Override
	@Transactional
	public void delete(int id) {
		intAdminDAO.deleteById(id);
	}

	@Override
	public Administrador findByUsername(String username) {
		return intAdminDAO.findByUsername(username);
		
	}
		
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Administrador admin = intAdminDAO.findByUsername(username);
		
		logger.debug(username);
		
		if(admin == null) {
			logger.error("Error en el Login: No existe el administrador'"+username+"' en el sistema");
			throw new UsernameNotFoundException("Error en el Login: No existe el administrador'"+username+"' en el sistema");
		}
		
		List<GrantedAuthority> authorities = admin.getSupervisados()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombRole()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(admin.getUsername(), admin.getPassword(), admin.getEnable(), true, true, true, authorities);
	}
}
