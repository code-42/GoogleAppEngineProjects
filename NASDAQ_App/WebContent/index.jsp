<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta content="PUT DESCRIPTION HERE" name="description">
	<meta content="IE=edge" http-equiv="X-UA-Compatible">
	<meta content="width=device-width, initial-scale=1" name="viewport"><!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<!-- Latest compiled and minified CSS -->
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"><!-- Optional theme -->
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet"><!-- MY CUSTOM CSS THAT OVERRIDES BOOTSTRAP -->
	<link href="css/index.css" rel="stylesheet">
	<!--<link href="css/navbar.css" rel="stylesheet">-->
	<!--<link href="css/content.css" rel="stylesheet">-->
	<title>INDEX PAGE TEMPLATE</title><!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<header role="banner">
		<div class="navbar-wrapper">
			<nav class="navbar navbar-default navbar-inverse navbar-static-top navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<button aria-controls="navbar" aria-expanded="false" class="navbar-toggle collapsed" data-target="#navbar" data-toggle="collapse" type="button">
						  <span class="sr-only">Toggle navigation</span> 
						  <span class="icon-bar"></span> 
						  <span class="icon-bar"></span> 
						  <span class="icon-bar"></span>
						</button> 
						<a class="navbar-brand" href="#">My Portfolio</a>
					</div>
					<div class="navbar-collapse collapse" id="navbar">
						<ul class="nav navbar-nav">
							<li class="active">
								<a href="#">Home</a>
							</li>
							<li class="dropdown">
								<a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown" href="#" role="button">About Me<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li>
										<a href="https://www.linkedin.com/in/edward-dupre-9b859b143/" target="_blank">LinkedIn</a>
									</li>
									<li>
										<a href="https://www.facebook.com" target="_blank">facebook</a>
									</li><!-- 
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                  -->
								</ul>
							</li>
							<li class="dropdown">
								<a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown" href="#" role="button">Contact<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<!--  Element div not allowed as child of element ul in this context.   -->
									<!--<div id="emailform">-->
									<!--<li id="sayhi">Say Hello!</li>-->
									<!--<form action="mailto:edwd42@intracitygeeks.org">-->
									<!--  <li>    -->
									<!--    <input id="email" type="email" placeholder="Enter your email here">-->
									<!--  </li>-->
									<!--  <li>-->
									<!--    <input id="submit" type="submit">-->
									<!--  </li>-->
									<!--</form>-->
									<!--</div>-->
								</ul>
							</li>
							<li class="dropdown">
								<a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown" href="#" role="button">Places<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li>
										<a href="#tribute">A Tribute Page</a>
									</li>
									<li>
										<a href="survey_form/index.html" target="_blank">ACME Survey Company</a>
									</li>
									<li>
										<a href="#NASDAQapp">My first MEAN Stack App</a>
									</li>
									<li>
										<a href="http://intracitygeeks.org/careerdevs/" target="_blank">CareerDevs</a>
									</li>
									<li>
										<a href="https://github.com/code-42/portfolio_page" target="_blank">My github.com</a>
									</li>
									<li class="divider" role="separator"></li><!--<li class="dropdown-header">Nav header</li>-->
									<li>
										<a href="BetaFCCProductLandingPage_README.pdf" target="_blank">Project README</a>
									</li><!--<li><a href="#">One more separated link</a></li>-->
								</ul>
							</li>
						</ul>
						
					</div>
				</div>
			</nav>
		</div><!-- END NAVBAR -->
	</header>
	<!-- MAIN CONTENT -->
	<main>
		<h1>Example page header</h1>
		<p>This is sample text.</p>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-2 col-md-2 col-lg-2 bg-danger">
					2
				</div>
				<div class="col-sm-8 col-md-8 col-lg-8 bg-info">
					8
				</div>
				<div class="col-sm-2 col-md-2 col-lg-2 bg-danger">
					2
				</div>
			</div>
		</div>
	</main><!-- END MAIN CONTENT -->
	<!-- FOOTER -->
	<footer>
		<p class="pull-right"><a href="#">Back to top</a></p>
		<p>&copy; 2017 Edward Dupre &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
	</footer><!-- Bootstrap core JavaScript -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
	</script>
</body>
</html>