<!DOCTYPE HTML>
<html>
<head>

<script type="text/javascript">
	//<![CDATA[

	var invocation = new XMLHttpRequest();
	var url = 'https://localhost:9443/websocket-v1/';
	var invocationHistoryText;

	function callOtherDomain() {
		if (invocation) {
			invocation.open('GET', url, true);
			invocation.onreadystatechange = handler;
			invocation.setRequestHeader('Content-Type', 'application/xml');
			invocation.send();
		} else {
			invocationHistoryText = "No Invocation TookPlace At All";
			var textNode = document.createTextNode(invocationHistoryText);
			var textDiv = document.getElementById("sse");
			textDiv.appendChild(textNode);
		}

	}
	function handler(evtXHR) {
		if (invocation.readyState == 4) {
			if (invocation.status == 200) {
				var response = invocation.response;
				//var invocationHistory = response.getElementsByTagName('invocationHistory').item(0).firstChild.data;
				//invocationHistoryText = document.createTextNode(invocationHistory);
				var textDiv = document.getElementById("sse");
				textDiv.append(response);

			} else
				alert("Invocation Errors Occured");
		} else
			dump("currently the application is at" + invocation.readyState);
	}
	//]]>
</script>

</head>
<body>

	<p>
		<input type="button" value="Click to Invoke Another Site"
			onclick="callOtherDomain()">
	</p>

	<div id="sse"></div>

</body>
</html>