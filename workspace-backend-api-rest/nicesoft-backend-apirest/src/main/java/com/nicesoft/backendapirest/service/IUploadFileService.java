/**
 * @author Frank Edward Daza González
 * 2019-03-11
 */
package com.nicesoft.backendapirest.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Frank Edward Daza González
 * 2019-03-11
 */
public interface IUploadFileService {
	
	public Resource cargar(String nombreFoto) throws MalformedURLException;
	
	public String copiar(MultipartFile archivo) throws IOException;
	
	public Boolean eliminar(String nombreFoto);
	
	public Path getPath(String nombreFoto);

}
