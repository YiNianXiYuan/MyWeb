function timeCount() {
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth();
    var day = date.getDate();
    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();
    if (hour < 10) {
        hour = "0" + hour;
    }
    if (minute < 10) {
        minute = "0" + minute;
    }
    if (second < 10) {
        second = "0" + second;
    }
    var time = hour + ":" + minute + ":" + second;
    // document.getElementById("time").value = time;   input赋值
    document.getElementById("time").innerHTML = time;
}

window.setInterval(timeCount, 1000);
