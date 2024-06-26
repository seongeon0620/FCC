//StompJS 라이브러리를 이용해 데이터를 주고 받는다. 
//JSON 형태로 데이터를 전달한다 
//브로커주소 전달자 프로토콜은 ws 또는 wss이다. 
//설정파일에 사용한 값으로 시작을 한다. 
//포트번호는 웹서버와 같은것을 사용한다 
//stompClient -- 데이터를 주고 받을 객체가 된다. 
//StompJs -  아 라이브러는 스프이에서 제공 
//const 상수 stomClient  상수에 개체를 할당한다. 그럼 상수(final) 라서 새로운 객체로 바꾸진 못한다
//객체 안의 정보를 바꾸는 건 가능하다. 
const stompClient = new StompJs.Client({
	
	//설정파일의 이부분registry.addEndpoint("/testwebsocket");
    brokerURL: 'ws://127.0.0.1:9000/aaasocket'
});

//접속요청이 왔을때 처리함수전달 (화살표함수)
//접속요청이 오면 웹소켓의 경우에 별도로 서버와 클라이언트 개념이 없다. 서로 주고 받을 수 있디 
stompClient.onConnect = (frame) => {
    setConnected(true);//연결을한다. 
    console.log('Connected: ' + frame); //연결요청받은 로그를 남긴다 
    //	registry.enableSimpleBroker("/topic");
    //정보를 기다린다, /topic/greetins 로 오면 
    //greeting =>  Message객체 
    //let roomid = $("#roomid").val();
    let topic = `/topic/all`;
    stompClient.subscribe(topic, (greeting) => {
		console.log( greeting );  //
		//이데이터가 문자열로 온다.  => JSON.parse   {name:"홍길동"}  '{name:"홍길동"}'
        showGreeting(JSON.parse(greeting.body));
    });
};

//소켓에러처리
stompClient.onWebSocketError = (error) => {
    console.log('Error with websocket', error);
};

//잘못올때의 에러처리 
stompClient.onStompError = (frame) => {
    console.log('Broker reported error: ' + frame.headers['message']);
    console.log('Additional details: ' + frame.body);
};

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

//registry.setApplicationDestinationPrefixes("/app"); 
//@MessageMapping("/hello")
//서버로 정보를 보낸다ㅑ. 
//JSON.stringify : JSON 객체를 문자열로 바꿔서 보낸다.
function sendName() {
	let roomid ="all";
	let destination = `/app/all`;
	console.log( destination );
    stompClient.publish({
        //destination: "/app/hello",
        destination:destination,
        body: JSON.stringify(
			{
		     'roomid':"all",
			 'mem_nickname': $("#mem_nickname").val(),
			 'message':$(".message-type-box").val()
			}
		)
    });
}

// 수신 하면 화면에 뿌림
function showGreeting(data) {
	
	if( data.mem_nickname == $("#mem_nickname").val() ) {
		return;
	}
	
	let now = new Date();
	let hh = now.getHours();
	let min = now.getMinutes();

	let ampm = hh >= 12 ? "pm" : "am";
	hh = hh % 12;
	hh = hh ? hh : 12;
	hh = hh < 10 ? "0" + hh : hh;
	min = min < 10 ? "0" + min : min;

	let time = hh + ":" + min + " " + ampm;

	let receptionMag = `
		<div class="hstack gap-3 align-items-start mb-7 justify-content-start">
			<img src="/images/profile/user-6.jpg" width="40" height="40" class="rounded-circle" />
			<div>
				<h6 class="fs-2 text-muted">${data.mem_nickname}</h6>
				<div class="p-2 bg-light rounded-1 d-inline-block text-dark fs-3">
					${data.message}
					</div> <div class="d-block fs-2">
					${time}
					</div>
				</div>
			</div>
		</div>`;

	$(".message-type-box")
		.parents(".chat-application")
		.find(".active-chat")
		.append(receptionMag);
}

//함수를 여기서 붙인다. 앞부분의 html  submit 버튼의 기능 차단이 가능하다
//원래 submit  가 생기면 자바스크립트의 기본매개변수(event)-내장객체, 발생했던 모든 이벤트에 대한 
//정보를 갖고 있는 객체이다. => jquery 나 다른 라이브러리 매개변수로 전달된다. e 
//e -> 이벤트 객체 
// preventDefault : submit가 무조건 서버로 정보를 전송하는데 이를 차단하는 기능을 하다.
 
$(function() {
	stompClient.activate();

	$("#message").on("keyup", function(key) {
		if (key.keyCode == 13) {
			sendName()
		}
	});

    /*$("form").on('submit', (e) => e.preventDefault());//서브밋 버튼의 원래 기능차단
    $( "#connect" ).click(() => connect());
    $( "#disconnect" ).click(() => disconnect());
    $( "#send" ).click(() => sendName());*/
});






