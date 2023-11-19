  var stompClient = null;

  function connect() {
      let socket = new SockJS("/server1");
      stompClient = Stomp.over(socket);
      stompClient.connect({}, function (frame) {
          console.log("Connected : " + frame);
          stompClient.subscribe("/topic/return-to", function (response) {
            showmessage(JSON.parse(response.body));
        });
      });
  }
  connect(); 
  
  
  function showmessage(matchdata) {
      $("#teams").append(`${matchdata.team1} VS ${matchdata.team2}`);
      $("#time").append(`${matchdata.date} : ${matchdata.time}`);
  }