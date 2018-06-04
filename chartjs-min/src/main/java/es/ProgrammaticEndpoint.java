package es;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;

public class ProgrammaticEndpoint extends Endpoint {

	// TODO: carga al iniciar la aplicación
	// ServerEndpointConfig.Builder.create(ProgrammaticEndpoint.class, "/endpoint").build();

	@OnOpen
	public void open(Session session) {
	}

	@OnClose
	public void close(Session session) {
	}

	@OnError
	public void onError(Throwable error) {
	}

	@Override
	public void onOpen(Session session, EndpointConfig config) {
		// TODO Auto-generated method stub
	}
}
