function getCookie(name) {
    var arrStr = document.cookie.split(";");
    for(var i in arrStr){
        var temp = arrStr[i].split("=");
        if(temp[0]==name){
            return window.atob(temp[1]);
        }
    }
    return "";
}

function setCookie(name, value, hours) {
    var str = name+"="+window.btoa(value);
    if(hours>0){
        var ms = hours*3600*1000;
        var date = new Date();
        date.setTime(date.getTime()+ms);
        str +="; expires="+date.toUTCString();
    }
    document.cookie=str;
}

// function addCookie(name, value) {
//     var str = name+"="+encodeURI(value);
//     var ms = 30*24*3600*1000;
//     var date = new Date();
//     date.setTime(date.getTime()+ms);
//     str +="; expires="+date.toUTCString();
//     document.cookie=str;
// }

function delCookie(name) {
    var date = new Date();
    date.setTime(date.getTime()-1);
    var value = getCookie(name);
    if(value!=null){
        document.cookie=name+"="+value+";expires="+date.toUTCString();
    }
}