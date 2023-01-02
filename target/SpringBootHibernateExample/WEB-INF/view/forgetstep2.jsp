<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]><html class="ie8 no-js" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9 no-js" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html class="no-js">
<!--<![endif]-->

<head>
    <title>Clip-One - Responsive Admin Template</title>
    <link rel="shortcut icon" href="favicon.ico" />
    <!-- start: META -->
    <meta charset="utf-8" />
    <!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="Responsive Admin Template build with Twitter Bootstrap and jQuery" name="description" />
    <meta content="ClipTheme" name="author" />
    <!-- end: META -->
    <!-- start: MAIN CSS -->
    <link type="text/css" rel="stylesheet" href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Raleway:400,100,200,300,500,600,700,800,900/" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/font-awesome.min.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/clip-font.min.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/skins/all.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/perfect-scrollbar.min.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/sweetalert.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/main.min.css" />
    <link type="text/css" rel="stylesheet" href="adminResources/css/main-responsive.min.css" />
    <link type="text/css" rel="stylesheet" media="print" href="adminResources/css/print.min.css" />
    <link type="text/css" rel="stylesheet" id="skin_color" href="adminResources/css/light.min.css" />
    <!-- end: MAIN CSS -->
    <!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
    <!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
    <!-- <script type="text/javascript">
    function checkPassword() {
    	 var password = $("#password").val();
    	    var confirmPassword = $("#confirmpassword").val();
    	    

    	    if (password != confirmPassword)
    	        $("#spanpassword").html("Passwords do not match!");
    	    else
    	        $("#spanpassword").html("Passwords match.");
    	    
		
	}
    </script> -->
</head>

<body class="login example1">

    <div class="main-login col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
        <div class="logo">
            CLIP<i class="clip-clip"></i>ONE
        </div>
        <!-- start: LOGIN BOX -->
        <div class="box-login">
            <h3>Sign in to your account</h3>
            <p>
                Please enter your name and password to log in.
            </p>
            
            <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
			<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
            
            <f:form class="form-login" action="passupdate" method="get" modelAttribute="modelcheckuser">
                <div class="errorHandler alert alert-danger no-display">
                    <i class="fa fa-remove-sign"></i> You have some form errors. Please check below.
                </div>
                <f:hidden path="loginId"/><f:hidden path="role"/><f:hidden path="enabled"/><f:hidden path="username"/>
                <fieldset>
                <div class="form-group">
                        OTP<span class="input-icon">
                           <input type="text" name="OTP" id="otp">
                            <i class="fa fa-lock"></i>
                        </span>
                        <span id="otpSpn"></span>
                    </div>
                    <div class="form-group">
                        Password: <span class="input-icon">
                           <f:password path="password" class="form-control" id="input" name="password" placeholder="Password"/>
                            <i class="fa fa-lock"></i>
                        </span>
                    </div>
                    <div class="form-group">
                        Confirm password:<span class="input-icon">
                            <input type="password"  class="form-control"  id="reinput" name="password_again" placeholder="confirmPassword"/>
                            <i class="fa fa-lock"></i>
                        </span>
                    </div>
                    <div class="form-group form-actions">
                        
                    </div>
                    <div class="form-actions">
                        <label for="remember" class="checkbox-inline">
                            <input type="checkbox" class="grey remember" name="remember">
                            Keep me signed in
                        </label>
                        <button type="submit"  id="calculate" disabled="disabled" class="btn btn-bricky pull-right">
                            Login <i class="fa fa-arrow-circle-right"></i>
                        </button>
                    </div>
                    <div class="new-account">
                        Don't have an account yet?
                        <a href="register" class="register">
                            Create an account
                        </a>
                    </div>
                </fieldset>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </f:form>
        </div>
        <!-- end: LOGIN BOX -->
        
        <!-- start: REGISTER BOX -->
        
        
        
        
        <!-- end: REGISTER BOX -->
        <!-- start: COPYRIGHT -->
        <div class="copyright">
            <script>
                document.write(new Date().getFullYear())
            </script> &copy; clip-one by cliptheme.
        </div>
        <!-- end: COPYRIGHT -->
    </div>

    <!-- start: MAIN JAVASCRIPTS -->
    <!--[if lt IE 9]>
            <script src="adminResources/js/respond.min.js"></script>
            <script src="adminResources/js/excanvas.min.js"></script>
            <script src="adminResources/js/jquery.min.js"></script>
            <![endif]-->
    <!--[if gte IE 9]><!-->
    <script type="text/javascript" src="adminResources/js/jquery.min.js"></script>
    <!--<![endif]-->
    <script type="text/javascript" src="adminResources/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="adminResources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="adminResources/js/bootstrap-hover-dropdown.min.js"></script>
    <script type="text/javascript" src="adminResources/js/jquery.blockUI.js"></script>
    <script type="text/javascript" src="adminResources/js/icheck.min.js"></script>
    <script type="text/javascript" src="adminResources/js/perfect-scrollbar.jquery.min.js"></script>
    <script type="text/javascript" src="adminResources/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="adminResources/js/sweetalert.min.js"></script>
    <script type="text/javascript" src="adminResources/js/main.min.js"></script>
    <!-- end: MAIN JAVASCRIPTS -->
    <!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
    <script src="adminResources/js/jquery.validate.min.js"></script>
    <script src="adminResources/js/login.min.js"></script>
    <!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->

		<script type="text/javascript">
		
		var generatedOTP = <%=session.getAttribute("generatedOTP")%>;
		
		$("#otp").keyup(function(){
			
			
			
			if(generatedOTP == $("#otp").val()){
				$("#otpSpn").html("OTP Matched.");
				$("#otpSpn").css("color" , "green");
				$("#otpSpn").css("font-weight" , "bold");
				 $("#calculate").attr("disabled" , false);
			}
			else{
				$("#otpSpn").html("Wrong OTP.");
				$("#otpSpn").css("color" , "red");
				$("#otpSpn").css("font-weight" , "bold");
				$("#calculate").attr("disabled" , true);
			}
			
		});
		
/*  		 $("#input").keyup(function(){
			 // $('#result').val(md5(input.value));
		  }); */
		  
		  $("#reinput").keyup(function(){
			 
			  if(($("#input").val() == $("#reinput").val()))
			{
				 $("#calculate").attr("disabled" , false);
				 console.log("pwd matched");
			 } 
			 else{
				 $("#calculate").attr("disabled" , true);
				 console.log("pwd not matched");
			 }
		  });
		  
		
		</script>



    <script>
        jQuery(document).ready(function() {
            Main.init();
            Login.init();
        });
    </script>

</body>

</html>