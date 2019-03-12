/**
 * @author Frank Edward Daza González
 * 2019-03-11
 */
package com.nicesoft.backendapirest.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Frank Edward Daza González
 * 2019-03-11
 */
@Service
public class UploadFileService implements IUploadFileService {
	
	private final Logger log = LoggerFactory.getLogger(UploadFileService.class);
	private final static String DIRECTORIO_UPLOAD = "uploads";

	/** 
	 * (non-Javadoc)
	 * @see com.nicesoft.backendapirest.service.IUploadFileService#cargar(java.lang.String)
	 */
	@Override
	public Resource cargar(String nombreFoto) throws MalformedURLException {
		Path rutaArchivo = this.getPath(nombreFoto);
		log.info(rutaArchivo.toString());
		Resource resource = null;
		resource = new UrlResource(rutaArchivo.toUri());
		
		if (!resource.exists() && !resource.isReadable()) {
			rutaArchivo = Paths.get("src/main/resources/static/images").resolve("notuser.png").toAbsolutePath();
			
			resource = new UrlResource(rutaArchivo.toUri());
			
			log.error("Error no se pudo cargar la imagen: " + nombreFoto);
		}
		
		return resource;
	}

	/** 
	 * (non-Javadoc)
	 * @see com.nicesoft.backendapirest.service.IUploadFileService#copiar(org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public String copiar(MultipartFile archivo) throws IOException {
		String nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename().replace(" ", "_");
		Path rutaArchivo = this.getPath(nombreArchivo);
		log.info(rutaArchivo.toString());
		Files.copy(archivo.getInputStream(), rutaArchivo);
		
		return nombreArchivo;
	}

	/** 
	 * (non-Javadoc)
	 * @see com.nicesoft.backendapirest.service.IUploadFileService#eliminar(java.lang.String)
	 */
	@Override
	public Boolean eliminar(String nombreFoto) {
		if (nombreFoto != null && nombreFoto.length() > 0) {
			Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
			File archivoFotoAnterior = rutaFotoAnterior.toFile();
			
			if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
				archivoFotoAnterior.delete();
				return true;
			}
		}
		return false;
	}

	/** 
	 * (non-Javadoc)
	 * @see com.nicesoft.backendapirest.service.IUploadFileService#getPath(java.lang.String)
	 */
	@Override
	public Path getPath(String nombreFoto) {
		return Paths.get(DIRECTORIO_UPLOAD).resolve(nombreFoto).toAbsolutePath();
	}

}
