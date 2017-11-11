package es;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/endpoint1")
public class AnnotatedEndPoint {

	@OnMessage
	public String mensaje(String mensaje) {
		System.out.println(mensaje);
		return "hola desde el servidor el mensaje es :" + mensaje;
	}

	@OnOpen
	public void open(Session session) {
	}

	@OnClose
	public void close(Session session) {
	}

	@OnError
	public void onError(Throwable error) {
	}
}
