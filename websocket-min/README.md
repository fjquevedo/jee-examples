# WebSocket
WebSocket API (JSR 356) permite crear, configurar y desplegar WebSockets endpoints en aplicaciónes web.

Los Endpoints pueden ser: Programmatic endpoints y Annotated endpoints.   

* Programmatic endpoint.

	public class ProgrammaticEndpoint extends Endpoint { ... }


* Annotated endpoint.
	
	@ServerEndpoint("/endpoint")
	public class AnnotatedEndpoint { ... }



