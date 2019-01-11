$(document).ready(function(){
    $.getJSON("/getIndexInitInfo",function(result){
        console.log(result);
        //初始化页面信息
        $("#user-type-box").text(result.userType);
        $("#user-college-box").text(result.college);
        $("#student-name-box").text(result.name);
        //根据权限，初始化左边菜单
        if(result.permission == 0){
          $("#group-manager-box").remove();
          $("#control-box").empty();
        }
        else if(result.permission == 1 || result.permission == 2){
          $("#control-box").empty();
        }
        else {
          //sa user
          //do not delete element
        }

    });
});


//退出登陆
$("#logout-link").click(function(){
  alert("logout");
  $.getJSON("/userLogout", function(res){
    if (res.status == 200){
      alert("再见，" + res.username);
      }
      else {
        alert(res.info);
      }
      window.location = "/login.html";
    });
});
