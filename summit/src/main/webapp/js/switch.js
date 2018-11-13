$(function () {
    // $.ajax({
    //     url: "",
    //     type: "get",
    //     dataType: "json"
    // success:function(result){
    //     $("#table").html("");
    //     var perferences=result.data;
    //     $(perferences).each(function(n,value){
    //         var tr="<input id='"+value.id+"' class='bu' type='button' value='"+value.name+"'>";
    //         $("#table").append(tr);
    //     });
    // },
    // error:function(){
    //     alert("请求失败!");
    // }
    // });
});

var values = [];
var ids = [];

function cal(event) {
    var oP = document.getElementById("context");
    var obj = event.target || event.srcElement;
    if (obj.nodeName != "INPUT") {
        return;
    }
    var value = obj.value;
    var id = obj.id;

    if (value == "清空") {
        values = [];
        ids = [];
        oP.innerHTML = "";
    } else if (value == "全选") {
        values = [];
        ids = [];
        oP.innerHTML = "";
        $("#table .bu").each(function () {
            values.push($(this).attr("value"));
            ids.push($(this).attr("id"));
        })
        for (var a in values) {
            oP.innerHTML = oP.innerHTML + values[a] + " ";
        }
    } else if (value == "OK!") {
        // $.ajax({
        //     url: "",
        //     data: "text=" + ids,
        //     type: "post",
        //     dataType: "json"
        // success:function(result){
        //     window.location.replace("http://119.23.232.119:8090/index");
        // },
        // error:function(){
        //     alert("请求失败!");
        // }
        // });
    } else {
        values.push(value);
        if (values.length > 1) {
            for (var i = 0; i < values.length - 1; i++) {
                if (values[i] == value) {
                    values[i]="";
                    values.pop();
                }
            }
        }
        ids.push(id);
        if (ids.length > 1) {
            for (var i = 0; i < ids.length - 1; i++) {
                if (ids[i] == id) {
                    ids[i]="";
                    ids.pop();
                }
            }
        }
        oP.innerHTML = "";
        for (var a in values) {
            oP.innerHTML = oP.innerHTML + values[a] + " ";
        }
    }
}