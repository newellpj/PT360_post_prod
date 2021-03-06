<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html  ng-app="landingApp" >
<head>

<link rel="stylesheet" type="text/css" href="./presentationResources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="./presentationResources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./presentationResources/css/bootstrap-custom.css">
<link rel="stylesheet" type="text/css" href="./presentationResources/css/font-awesome.css">
<link rel="stylesheet" type="text/css" href="./presentationResources/css/responsive.css">
<link rel="stylesheet" type="text/css" href="./presentationResources/css/myStyles.css">
<link rel="stylesheet" type="text/css" href="./presentationResources/css/landing.css">
<link rel="stylesheet" type="text/css" href="./presentationResources/css/demoApp.css">
<link rel="stylesheet" type="text/css" href="./presentationResources/css/animation.css">
<link rel="stylesheet" type="text/css" href="./presentationResources/css/searchFacets.css">
<link rel="stylesheet" type="text/css" href="./presentationResources/css/customFont.css">
<link rel="stylesheet" type="text/css" href="./presentationResources/css/jquery.bxslider.css">



 <link rel="shortcut icon" href="./presentationResources/images/favicon.png" type="image/x-icon">

<script type="text/javascript" src="./presentationResources/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="./presentationResources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="./presentationResources/js/angular.min.js"></script>
<script type="text/javascript" src="./presentationResources/js/landing.js"></script>
<script type="text/javascript" src="./presentationResources/js/landingAboutUs.js"></script>
<script type="text/javascript" src="./presentationResources/js/landingMainAppDemoSupp.js"></script>
<script type="text/javascript" src="./presentationResources/js/landingMainAppDemo.js"></script>
<script type="text/javascript" src="./presentationResources/js/jquery.bxslider.min.js"></script>

<title>Personnel Tracker</title>
<style>
</style>

<script>
	 if (top.location!= self.location) {
		var href = self.location.href;
	    top.location = self.location.href;
	 }
	 $(document).ready(function(){
					 document.getElementById("openByDefault").click();
					 $('.bxslider').bxSlider({
							captions: true
					 });
          var bxViewportHeight = $(".bx-viewport").height();
          console.log("height : "+bxViewportHeight);
          if(bxViewportHeight < 300){
              $(".carouselAndBuzzSection").css("margin-bottom", "20%");
          }else{
              $(".carouselAndBuzzSection").css("margin-bottom", "0%");
          }
    });
</script>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="title" content="Personnel Tracker 360" />
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<meta name="description" content="Personnel Tracker 360 by Scion Solutions Group empowers organisations to accurately track all aspects of employee management. Matching skillset to current roles and providing performance reporting. " />

</head>
<body>


	<div id="main-box" class="main-box responsive">

<h1 class="pageHeaderLogo responsive"> Personnel Tracker <span>360</span> </h1>
<ul class="tab">
  <li><a href="javascript:void(0)" class="tablinks defaultTab glyphicon glyphicon-blackboard"
				onclick="openTab(event, 'welcomeTab')" id="openByDefault" >
				     <span style="font-family: 'Roboto Condensed',sans-serif !important;">Welcome </span></a></li>

  <li><a href="javascript:void(0)" class="tablinks glyphicon glyphicon-home" onclick="openTab(event, 'appTab')">
		  <span style="font-family: 'Roboto Condensed',sans-serif !important;"> Demo App</span></a></li>

  <li><a href="javascript:void(0)" class="tablinks glyphicon glyphicon-info-sign" onclick="openTabAboutUs(event, 'aboutTab')">
		 <span style="font-family: 'Roboto Condensed',sans-serif !important;">About Us</span></a></li>
	<div class="_stickFigureElement responsive"><img class="imgAnime" src='./presentationResources/images/profilePics/stickfigure2.png' /></div>
</ul>




<div id="welcomeTab" class="tabcontent">
    <welcome-page></welcome-page>
</div>
<div id="appTab" class="tabcontent">
    <app-page-demo></app-page-demo>
</div>
<div id="aboutTab" class="tabcontent">
    <about-us-page></about-us-page>
</div>

<br/>
    <a class="scionLogoFooter" href="http://www.scionsolutionsgroup.com/" target="_blank"> &nbsp; &nbsp; Scion Solutions Group  	&copy; 2017</a> 
    &nbsp; &nbsp; &nbsp; <i>Not supported in IE11 and previous versions. &nbsp; &nbsp; &nbsp; Hosted on AWS free tier. </i>
	</div>


</body>
</html>