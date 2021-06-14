var stompClient = null;

function connect(username) {
	var socket = new SockJS('/hello');
	stompClient = Stomp.over(socket);
	stompClient.connect({ username: username, }, function() {
		console.log(socket._transport.url);
		var sessionId = /\/([^\/]+)\/websocket/.exec(socket._transport.url)[1];
		console.log(sessionId);
		console.log('Web Socket is connected');
		stompClient.subscribe('/users/queue/messages', function(message) {
			$("#message").text(message.body);
		});
	});
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect($("#username").val());
	});
	$("#send").click(function() {
		stompClient.send("/app/hello", {}, $("#name").val());
	});
});