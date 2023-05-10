package com.sysbithomservices.backend.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.sysbithomservices.backend.modelo.entity.Contratantes;
import com.sysbithomservices.backend.modelos.servicios.InterfaceContratantesServicios;

@Component
public class TokenInformacionAdicionalCont implements TokenEnhancer {

	@Autowired
	private InterfaceContratantesServicios intServCont;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Contratantes cont = intServCont.findByUsername(authentication.getName());
		Map<String, Object> info = new HashMap<>();

		if (cont != null) {
			info.put("info_adicional", authentication.getName());

			info.put("username", cont.getCodUce() + ": " + cont.getUsername());
	
			((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		}
		return accessToken;
	}

}
