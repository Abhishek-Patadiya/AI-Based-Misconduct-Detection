<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8]><html class="ie8 no-js" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9 no-js" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html class="no-js">
<!--<![endif]-->

<head>
    <title>Register Profile</title>
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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/adminResources/css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/adminResources/css/font-awesome.min.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/adminResources/css/clip-font.min.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/adminResources/css/all.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/adminResources/css/perfect-scrollbar.min.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/adminResources/css/sweetalert.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/adminResources/css/main.min.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/adminResources/css/main-responsive.min.css" />
    <link type="text/css" rel="stylesheet" media="print" href="${pageContext.request.contextPath }/adminResources/css/print.min.css" />
    <link type="text/css" rel="stylesheet" id="skin_color" href="${pageContext.request.contextPath }/adminResources/css/light.min.css" />
    <!-- end: MAIN CSS -->
    <!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
    <!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->

</head>

<body class="login example1" style="background-color: #ad9fa85c">

    <div class="main-login col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
        <div class="logo">
            You Look Great Today !!
        </div>
        <!-- start: LOGIN BOX -->
        <div class="box-login">
            <h3>Sign in to your account</h3>
            <p>
                Please enter your email and password to log in.
            </p>
            <%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
            
            <sp:form class="form-register" action="registerinsert" modelAttribute="registermodel" method="get">
                <div class="errorHandler alert alert-danger no-display">
                    <i class="fa fa-remove-sign"></i> You have some form errors. Please check below.
                </div>
                <fieldset>
                    <div class="form-group">
                        <sp:input class="form-control" path="fullName" name="full_name" placeholder="FullName"/>
                    </div>
                    <div class="form-group">
                        <sp:textarea path="address" class="form-control" placeholder="Address"/>
                    </div>
                    
                    
                    <div class="form-group">
                      Gender:   <label class="radio-inline">Female</label>
                         <sp:radiobutton value="female"  path="gender"/>
                         
                         <label class="radio-inline">Male</label>
                         <sp:radiobutton value="male"  path="gender"/>
                    </div> 
                    <p>
                        Enter your account details below:
                    </p>
                    <div class="form-group">
                        <span class="input-icon">
                            <sp:input class="form-control" placeholder="Email" path="loginVO.username"/>
                            <i class="fa fa-envelope"></i>
                        </span>
                    </div>
                    <div class="form-group">
                        <span class="input-icon">
                            <sp:input type="password" class="form-control" id="password" placeholder="Password" path="loginVO.password"/>
                            <i class="fa fa-lock"></i>
                        </span>
                    </div>
                    <div class="form-group">
                        <span class="input-icon">
                            <input type="password" class="form-control" name="password_again" placeholder="Password Again"/>
                            <i class="fa fa-lock"></i>
                        </span>
                    </div>
                    <div class="form-group">
                    
                    		<sp:checkbox path="" value="agree"/>
<!--                             <label for="agree" class="checkbox-inline">
 -->                                I agree to the Terms of Service and Privacy Policy
    <!--                         </label> -->
                    </div>
                    <div class="form-actions">
                        <a href="?box=login" class="btn btn-light-grey go-back">
                            <i class="fa fa-circle-arrow-left"></i> Back
                        </a>
                        <button type="submit" class="btn btn-bricky pull-right">
                            Submit <i class="fa fa-arrow-circle-right"></i>
                        </button>
                    </div>
                </fieldset>
            </sp:form>
        </div>
        <!-- end: LOGIN BOX -->
        <!-- start: FORGOT BOX -->
        <div class="box-forgot">
            <h3>Forget Password?</h3>
            <p>
                Enter your e-mail address below to reset your password.
            </p>
            <form class="form-forgot">
                <div class="errorHandler alert alert-danger no-display">
                    <i class="fa fa-remove-sign"></i> You have some form errors. Please check below.
                </div>
                <fieldset>
                    <div class="form-group">
                        <span class="input-icon">
                            <input type="email" class="form-control" name="email" placeholder="Email">
                            <i class="fa fa-envelope"></i>
                        </span>
                    </div>
                    <div class="form-actions">
                        <a href="?box=login" class="btn btn-light-grey go-back">
                            <i class="fa fa-circle-arrow-left"></i> Back
                        </a>
                        <button type="submit" class="btn btn-bricky pull-right">
                            Submit <i class="fa fa-arrow-circle-right"></i>
                        </button>
                    </div>
                </fieldset>
            </form>
        </div>
        <!-- end: FORGOT BOX -->
        <!-- start: REGISTER BOX -->
        <div class="box-register">
            <h3>Sign Up</h3>
            <p>
                Enter your personal details below:
            </p>
            <form class="form-register">
                <div class="errorHandler alert alert-danger no-display">
                    <i class="fa fa-remove-sign"></i> You have some form errors. Please check below.
                </div>
                <fieldset>
                    <div class="form-group">
                        <input type="text" class="form-control" name="full_name" placeholder="Full Name">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="address" placeholder="Address">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="city" placeholder="City">
                    </div>
                    
                    <p>
                        Enter your account details below:
                    </p>
                    <div class="form-group">
                        <span class="input-icon">
                            <input type="email" class="form-control" name="email" placeholder="Email">
                            <i class="fa fa-envelope"></i>
                        </span>
                    </div>
                    <div class="form-group">
                        <span class="input-icon">
                            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                            <i class="fa fa-lock"></i>
                        </span>
                    </div>
                    <div class="form-group">
                        <span class="input-icon">
                            <input type="password" class="form-control" name="password_again" placeholder="Password Again">
                            <i class="fa fa-lock"></i>
                        </span>
                    </div>
                    <div class="form-group">
                        <div>
                            <label for="agree" class="checkbox-inline">
                                <input type="checkbox" class="grey agree" id="agree" name="agree">
                                I agree to the Terms of Service and Privacy Policy
                            </label>
                        </div>
                    </div>
                    <div class="form-actions">
                        <a href="?box=login" class="btn btn-light-grey go-back">
                            <i class="fa fa-circle-arrow-left"></i> Back
                        </a>
                        <button type="submit" class="btn btn-bricky pull-right">
                            Submit <i class="fa fa-arrow-circle-right"></i>
                        </button>
                    </div>
                </fieldset>
            </form>
        </div>
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
            <script src="${pageContext.request.contextPath }/adminResources/js/respond.min.js"></script>
            <script src="${pageContext.request.contextPath }/adminResources/js/excanvas.min.js"></script>
            <script src="${pageContext.request.contextPath }/adminResources/js/jquery.min.js"></script>
            <![endif]-->
    <!--[if gte IE 9]><!-->
    <script type="text/javascript" src="${pageContext.request.contextPath }/adminResources/js/jquery.min.js"></script>
    <!--<![endif]-->
    <script type="text/javascript" src="${pageContext.request.contextPath }/adminResources/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/adminResources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/adminResources/js/bootstrap-hover-dropdown.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/adminResources/js/jquery.blockUI.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/adminResources/js/icheck.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/adminResources/js/perfect-scrollbar.jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/adminResources/js/jquery.cookie.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/adminResources/js/sweetalert.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/adminResources/js/main.min.js"></script>
    <!-- end: MAIN JAVASCRIPTS -->
    <!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
    <script src="${pageContext.request.contextPath }/adminResources/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath }/adminResources/js/login.min.js"></script>
    <!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->

    <script>
        jQuery(document).ready(function() {
            Main.init();
            Login.init();
        });
    </script>

</body>

</html>