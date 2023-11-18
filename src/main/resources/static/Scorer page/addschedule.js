$(document).ready(function() {
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
  dropdown[i].addEventListener("click", function () {
    this.classList.toggle("active");
    var dropdownContent = this.nextElementSibling;
    if (dropdownContent.style.display === "block") {
      dropdownContent.style.display = "none";
    } else {
      dropdownContent.style.display = "block";
    }
  });
}

var stompClient = null;

function connect() {
    let socket = new SockJS("/server1");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("Connected : " + frame);
    });
}
connect();

function showmessage(matchdata) {  
    stompClient.subscribe("/topic/return-to", function (response) {
        showmessage(JSON.parse(response.body));
    });
    $("#team1").append(`${matchdata.team2}`);
    $("#team2").append(`${matchdata.team2}`);
    $("#time").append(`${matchdata.date}:${matchdata.time}`);
    //$("#matchdata").prepend(`<tr><td><b>${matchdata.team1}:</b><b>${matchdata.team2}:</b>${matchdata.time}:${matchdata.date}</td></tr>`);
}

function sendmessage() {
    try {
        let jsonOb = {
            team1: $("#team-name1").val(),
            team2: $("#team-name2").val(),
            time: $("#time").val(),
            date: $("#date").val()
        };
        stompClient.send("/app/matchdata", {}, JSON.stringify(jsonOb));
    } catch (error) {
        console.error("Error in sendmessage:", error);
    }
}

$
$("#add-btn").click(() => {
    sendmessage();
});
});
