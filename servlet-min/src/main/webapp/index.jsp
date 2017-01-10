<html>
<body>
	<h1>Servlets</h1>
	Servlet es un programa Java para extenter las capacidades del servidor.
	Principalmente utiliza el protocolo HTTP.
	<h2>Caracteristicas</h2>
	<ul>
		<li>each request is handled by a separate Java thread within the
			web server process, thereby avoiding the overhead associated with
			forking processes within the HTTP daemon.</li>
		<li>there is only one copy that persists across requests and is
			shared between threads.</li>
		<li>Only a single instance answers all requests concurrently.
			This reduces memory usage and eases the management of persistent
			data.</li>
	</ul>
	<h2>Life Cycle</h2>
	A servlet's life cycle is managed via the init(), service() and
	destroy() methods.
	<ol>
		<li><a href="./lc/lifecycle.html">init()</a>: Web container
			initializes the servlet instance by calling the init() method,
			passing an object implementing the javax.servlet.ServletConfig
			interface. This configuration object allows the servlet to access
			name-value initialization parameters from the web application.</li>
		<li><a href="./lc/lifecycle.html">service()</a>: Each request is
			serviced in its own separate thread. The web container calls the
			service() method of the servlet for every request. The service()
			method determines the kind of request being made and dispatches it to
			an appropriate method to handle the request. The developer of the
			servlet must provide an implementation for these methods. If a
			request is made for a method that is not implemented by the servlet,
			the method of the parent class is called, typically resulting in an
			error being returned to the requester.</li>
		<li><a href="./lc/lifecycle.html">destroy()</a>: Method that
			takes the servlet out of service. The destroy() method, like init(),
			is called only once in the lifecycle of a servlet.</li>
	</ol>

	<h2>
		<a href="./samples/samples.html">Samples</a>
	</h2>




</body>
</html>
