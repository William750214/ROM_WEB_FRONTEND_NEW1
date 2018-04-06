function showDatetime() {
    postMessage(new Date());
}

setInterval("showDatetime()", 1000);

