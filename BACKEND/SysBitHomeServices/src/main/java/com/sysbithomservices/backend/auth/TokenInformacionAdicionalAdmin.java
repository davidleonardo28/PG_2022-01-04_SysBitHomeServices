package com.sysbithomservices.backend.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.sysbithomservices.backend.modelo.entity.Administrador;
import com.sysbithomservices.backend.modelos.servicios.InterfaceAdministradorServicios;

@Component
public class TokenInformacionAdicionalAdmin implements TokenEnhancer {

	@Autowired
	private InterfaceAdministradorServicios intServAdmin;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Administrador admin = intServAdmin.findByUsername(authentication.getName());
		Map<String, Object> info = new HashMap<>();

		if (admin != null) {
			info.put("info_adicional", authentication.getName());

			info.put("username", admin.getCodAdmin() + ": " + admin.getUsername());

			((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		}
		return accessToken;
	}

}
