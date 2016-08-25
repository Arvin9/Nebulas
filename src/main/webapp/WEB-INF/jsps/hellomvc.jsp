<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="site.nebulas.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.io.File" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<!-- Bootstrap -->
	<link href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=path%>/resources/css/chat.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="<%=path%>/resources/js/bootstrap.min.js"></script>
		
	
</head>
<body>
<div class="container">
	<button type="button" class="btn btn-default" aria-label="Left Align">
	  <span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
	</button>
	
	<button type="button" class="btn btn-default btn-lg">
	  <span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star
	</button>
	
	<div class="alert alert-danger" role="alert">
	  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	  <span class="sr-only">Error:</span>
	  Enter a valid email address
	</div>
	
	
	<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
	<span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>
	<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
	<span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
	
	
	<a href="#">Inbox <span class="badge">42</span></a>

	<button class="btn btn-primary" type="button">
		<span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
	  	<span class="badge">4</span>
	</button>
	
	<button class="btn btn-primary" type="button">
		<span class="glyphicon glyphicon-thumbs-down" aria-hidden="true"></span>
	  	<span class="badge">4</span>
	</button>
	
	<button class="btn btn-primary" type="button">
		<span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
	  	<span class="badge">4</span>
	</button>
	
	
	<div class="alert alert-warning alert-dismissible" role="alert">
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	  <strong>Warning!</strong> Better check yourself, you're not looking too good.
	</div>
	
	
	<button type="button" id="myButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off">
	  Loading state
	</button>
	
	<script>
	  $('#myButton').on('click', function () {
	    var $btn = $(this).button('loading')
	    setTimeout(function(){$btn.button('reset')},3000);
	    
	  })
	</script>
	
	
	<a class="btn btn-primary hide" role="button" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
	  Link with href
	</a>
	<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
	  Button with data-target
	</button>
	<div class="collapse" id="collapseExample">
	  <div class="well">
	    ...
	  </div>
	</div>
	
	
	<!-- FQA -->
	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Collapsible Group Item #1
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Collapsible Group Item #2
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          Collapsible Group Item #3
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div class="panel-body">
        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
      </div>
    </div>
  </div>
</div>
	
	<!-- /FQA -->
	
	
	<!-- Area Charts:Morris --><!-- Chat -->
          <div class="col-md-6">
            <div  class="widget-container scrollable chat" style="height: 427px;">
              <div class="heading">
                <i class="icon-comments"></i>聊天工具<i class="icon-smile pull-right"></i>
              </div>
              <div class="widget-content padded" id="scroll">
                <ul id="scrolValue">
                  <li>
                    <img width="30" height="30" src="images/avatar-male.jpg" />
                    <div class="bubble">
                      <a class="user-name" href="#">管理员</a>
                      <p class="message">
                          有些人离开了之后才发现，离开的人是自己的最爱。——《东邪西毒》
                      </p>
                      <p class="time">
                        <strong>今天 </strong>下午 3:53
                      </p>
                    </div>
                  </li>
                  <li class="current-user">
                    <img width="30" height="30" src="images/avatar-female.jpg" />
                    <div class="bubble">
                      <a class="user-name" href="#">王晓</a>
                      <p class="message">
                          尽管你一脸不真诚，但我听着很高兴。——《梦想照进现实》
                      </p>
                      <p class="time">
                        <strong>今天 </strong>下午 3:53
                      </p>
                    </div>
                  </li>
                  <li>
                    <img width="30" height="30" src="images/avatar-male.jpg" />
                    <div class="bubble">
                      <a class="user-name" href="#">管理员</a>
                      <p class="message">
                          眼泪是我的望远镜。透过它，我见到天堂。——《爱的太迟》
                      </p>
                      <p class="time">
                        <strong>今天 </strong>下午 3:53
                      </p>
                    </div>
                  </li>
                  <li>
                    <img width="30" height="30" src="images/avatar-male.jpg" />
                    <div class="bubble">
                      <a class="user-name" href="#">管理员</a>
                      <p class="message">
                          那些流泪的人真的是为了爱吗？ ——《盛夏光年》
                      </p>
                      <p class="time">
                        <strong>今天 </strong>下午 3:53
                      </p>
                    </div>
                  </li>
                </ul>
              </div>
              <div class="post-message">
                <input class="form-control" placeholder="请输入您需要发送的信息…" type="text"><input 

type="submit" value="发送">
              </div>
            </div>
          </div>
          <!-- End Chat -->
	
	<div>
	</div>
	
	
	
	<script>
	document.getElementById('scroll').scrollTop = document.getElementById('scrolValue').scrollHeight;
	</script>
	
	
	
	<ul class="nav nav-stacked">
	  <li role="presentation" class="active">
	  	<a href="#">Home</a>
		  	<ul class="nav nav-stacked">
		  <li role="presentation" class="active"><a href="#">Home</a></li>
		  <li role="presentation"><a href="#">Profile</a></li>
		  <li role="presentation"><a href="#">Messages</a></li>
		</ul>	
	  </li>
	  <li role="presentation"><a href="#">Profile</a></li>
	  <li role="presentation"><a href="#">Messages</a></li>
	</ul>
	
	
</div>

</body>
</html>