// https://docs.bitfinex.com/docs

var ws = new WebSocket("wss://api.bitfinex.com/ws");
ws.onopen = function(){
    ws.send(JSON.stringify({"event":"subscribe",
                            "channel":"ticker",
                            "pair":"BTCUSD"
                            }
    ));
};

ws.onmessage = function(msg){
    var response = JSON.parse(msg.data);
    console.log("response == " + response);
    var hb = response[1];
    if(hb != "hb"){
        console.log("response == " + response);
        document.getElementById("btc").innerHTML = Number(response[1]).toLocaleString('en-US', {style: 'currency', currency: 'USD'});
    }
};

