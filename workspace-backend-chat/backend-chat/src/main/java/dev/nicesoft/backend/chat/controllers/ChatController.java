package dev.nicesoft.backend.chat.controllers;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import dev.nicesoft.backend.chat.domain.Mensaje;

@Controller
public class ChatController {

	
	@SendTo("/chat/mensaje")
	@MessageMapping("/mensaje")
	public Mensaje recibeMensaje(Mensaje mensaje) {
		mensaje.setFecha(new Date().getTime());
		mensaje.setTexto("Recibido por el broker: " + mensaje.getTexto());
		return mensaje;
	}
	
}
