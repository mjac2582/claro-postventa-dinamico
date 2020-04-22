/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.claro.postventa.dinamico.resource.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Singleton;
import javax.ws.rs.core.Application;

import pe.com.claro.common.property.Constantes;
import pe.com.claro.common.resource.exception.GeneralRuntimeException;
import pe.com.claro.common.resource.exception.ProviderExceptionMapper;

@Singleton
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<>();

		resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
		resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
		resources.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);
		addRestResourceClasses(resources);
		return resources;
	}

	@Override
	public Map<String, Object> getProperties() {
        String nombrePropertieExterno = Constantes.PROPERTIES_EXTERNOS;
        Map<String, Object> dataProperties = new HashMap<String, Object>();
        dataProperties.putAll(readProperties(nombrePropertieExterno, false));
        return dataProperties;
    }

	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(pe.com.claro.postventa.dinamico.resource.DinamicoResource.class);
		resources.add(ProviderExceptionMapper.class);
	}

	private Map<String, Object> readProperties(String fileInClasspath, Boolean interno) {
		InputStream is = null;
		String urlServer = Constantes.TEXTO_VACIO;
		try {
			if (interno) {
                is = this.getClass().getClassLoader().getResourceAsStream(fileInClasspath);
            } else {
            	urlServer = System.getProperty(Constantes.PROPERTIES_KEY) + Constantes.NOMBRE_API + File.separator + fileInClasspath;
                is = new FileInputStream(urlServer);
            }
			Map<String, Object> map = new HashMap<String, Object>();
			Properties properties = new Properties();
			properties.load(is);
			map.putAll(properties.entrySet().stream()
					.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue())));
			is.close();
			return map;
		} catch (Exception e) {
			if (is != null) {
				try {
					is.close();
				} catch (IOException ex) {
					throw new GeneralRuntimeException("No se pudo cerrar el archivo " + fileInClasspath + " - " + urlServer , ex);
				}
			}
			throw new GeneralRuntimeException("No se puede leer el archivo " + fileInClasspath + " - " + urlServer , e );
		}
	}

}
