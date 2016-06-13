<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Chi siamo</title>
<meta name="author" content="Alessandro e Federico">

<!-- Favicons -->
<link rel="shortcut icon" href="img/favicon.ico">

<!-- Responsive Tag -->
<meta name="viewport" content="width=device-width">

<!-- CSS Files -->

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="css/plugin.css">
<link rel="stylesheet" href="css/main.css">


</head>

<body>
	<f:view>
		<!-- Preloder-->
		<div class="preloder animated">
			<div class="scoket">
				<img src="img/preloader.svg" alt="" />
			</div>
		</div>

		<div class="body">

			<div class="main-wrapper">
				<!-- Navigation-->
				<nav class="navbar navbar-fixed-top">
					<div class="container">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed"
								data-toggle="collapse" data-target="#navbar"
								aria-expanded="false" aria-controls="navbar">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="./index_parallax.jsp"> <img
								src="img/nav-logo.png" alt="nav-logo">
							</a>
						</div>
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./index_parallax.jsp"><span>Home</span></a></li>
								<li><a href="./menu.jsp">Men&ugrave;</a></li>
								<h:panelGroup rendered="#{utenteCorrente.username != null}">
									<li><a href="./prenotazione.jsp">Riserva un tavolo</a></li>
								</h:panelGroup>
								<li><a href="./about.jsp"><span style="color: #F9C56A;">Chi
											siamo</span></a></li>
								<li><a href="./contact.jsp">Contatti</a></li>
								<h:panelGroup rendered="#{utenteCorrente.username == null}">
									<li><a href="./loginSignup.jsp">Login / Signup</a></li>
								</h:panelGroup>
								<h:panelGroup rendered="#{utenteCorrente.username != null}">
									<li class="dropdown"><a href="./index_parallax.jsp"
										class="dropdown-toggle" data-toggle="dropdown" role="button"
										aria-haspopup="true" aria-expanded="false">Benvenuto <h:outputText
												value="#{utenteCorrente.username}"></h:outputText> <span
											class="caret"></span></a>
										<ul class="dropdown-menu">
											<li class="text-center"><a href="./profilo.jsp">Profilo</a></li>
											<li><h:form>
													<h:commandButton action="#{utenteController.logout}"
														styleClass="btn btn-default btn-xs btn-block"
														value="Logout" />
												</h:form></li>
										</ul></li>
								</h:panelGroup>
							</ul>
						</div>
						<!--/.navbar-collapse -->
					</div>
				</nav>
				<!-- Page Header -->
				<section class="page_header">
					<div class="container">
						<div class="row">
							<div class="col-md-12 text-center">
								<h2 class="text-uppercase wow fadeInDown">Un po' di noi</h2>
								<p class="wow fadeInUp">Leggi la nostra storia, Come abbiamo
									iniziato ed il nostro team</p>
							</div>
						</div>
					</div>
				</section>


				<!-- About -->
				<section class="about2">
					<div class="container">
						<div class="row wow fadeInUp">
							<div class="col-md-5">
								<img src="img/about.png" class="img-responsive" alt="" />
							</div>
							<div class="col-md-7 text-left">
								<h2 class="text-left">Our Story</h2>
								<p>Lorem Ipsum is simply dummy text of the printing and
									typesetting industry. Lorem Ipsum has been the industry's
									standard dummy text ever since the 1500s, when an unknown
									printer took a galley of type and scrambled it to make a type
									specimen book. It has survived not only five centuries, but
									also the leap into electronic typesetting, remaining
									essentially unchanged. It was popularised in the 1960s with the
									release of Letraset sheets containing Lorem Ipsum passage</p>
								<a class="btn btn-default" role="button" href="#menu">See
									Our Menu</a>
							</div>
						</div>
					</div>
				</section>

				<!-- Services -->
				<section class="services">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="page-header wow fadeInDown">
									<h1 class="white">
										Servizi Speciali<small>Festegia un evento importante
											da noi!</small>
									</h1>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="services-slider wow fadeIn">
									<div class="service-content text-center">
										<img src="img/ico1.png" class="center-block" alt="" />
										<h4 class="text-uppercase">Birthday Party</h4>
										<p>Lorem Ipsum is simply dummy text of the printing and
											typesetting industry. Lorem Ipsum has been the industry's
											standard dummy text ever since the 1500s.</p>
									</div>
									<div class="service-content text-center">
										<img src="img/ico2.png" class="center-block" alt="" />
										<h4 class="text-uppercase">Wedding Party</h4>
										<p>Lorem Ipsum is simply dummy text of the printing. Lorem
											Ipsum has been the industry's standard dummy text ever since
											the 1500s, when an unknown printer.</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>

				<!-- Team -->
				<section class="team">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="page-header wow fadeInDown">
									<h1>
										Il nostro team<small>Il duro lavoro dietro al nostro
											ristorante</small>
									</h1>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 col-sm-6 text-center">
								<div class="team-staff wow fadeInUp" data-wow-delay="0.2s">
									<img src="img/team/1.png" class="img-responsive center-block"
										alt="" />
									<h4>Alessandro Giannetti</h4>
									<p>Designation here</p>
									<ul class="team-social">
										<li><a href="http://www.facebook.com"><i
												class="fa fa-facebook"></i></a></li>
										<li><a href="http://www.twitter.com"><i
												class="fa fa-twitter"></i></a></li>
										<li><a href="http://plus.google.com"><i
												class="fa fa-google-plus"></i></a></li>
									</ul>
								</div>
							</div>
							<div class="col-md-6 col-sm-6 text-center">
								<div class="team-staff wow fadeInUp" data-wow-delay="0.4s">
									<img src="img/team/2.png" class="img-responsive center-block"
										alt="" />
									<h4>Federico Arcangeli</h4>
									<p>Designation here</p>
									<ul class="team-social">
										<li><a href="http://www.facebook.com"><i
												class="fa fa-facebook"></i></a></li>
										<li><a href="http://www.twitter.com"><i
												class="fa fa-twitter"></i></a></li>
										<li><a href="http://plus.google.com"><i
												class="fa fa-google-plus"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</section>

				<!-- subscribe -->
				<section class="subscribe">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<h1>Subscribe</h1>
								<p>Get updates about new dishes and upcoming events</p>
								<form class="form-inline" action="php/subscribe.php" id="invite"
									method="POST">
									<div class="form-group">
										<input class="e-mail form-control" name="email" id="address"
											type="email" placeholder="Your Email Address" required>
									</div>
									<button type="submit" class="btn btn-default">
										<i class="fa fa-angle-right"></i>
									</button>
								</form>

							</div>
						</div>
					</div>
				</section>

				<!-- Footer-->
				<section class="footer">
					<div class="container">
						<div class="row">
							<div class="col-md-4 col-sm-12">
								<h1>About us</h1>
								<p>Duis leo justo, condimentum at purus eu,Aenean sed dolor
									sem. Etiam massa libero, auctor vitae egestas et, accumsan quis
									nunc.Duis leo justo, condimentum at purus eu, posuere pretium
									tellus.</p>
								<a href="./about.html">Read more &rarr;</a>
							</div>
							<div class="col-md-4  col-sm-6">
								<h1>Recent post</h1>
								<div class="footer-blog clearfix">
									<a href="./blog_right_sidebar.html"> <img
										src="img/thumb8.png" class="img-responsive footer-photo"
										alt="blog photos">
										<p class="footer-blog-text">Hand picked ingredients for
											our best customers</p>
										<p class="footer-blog-date">29 may 2015</p>
									</a>
								</div>
								<div class="footer-blog clearfix last">
									<a href="./blog_right_sidebar.html"> <img
										src="img/thumb9.png" class="img-responsive footer-photo"
										alt="blog photos">
										<p class="footer-blog-text">Daily special foods that you
											will going to love</p>
										<p class="footer-blog-date">29 may 2015</p>
									</a>
								</div>
							</div>
							<div class="col-md-4  col-sm-6">
								<h1>Reach us</h1>
								<div class="footer-social-icons">
									<a href="http://www.facebook.com"> <i
										class="fa fa-facebook-square"></i>
									</a> <a href="http://www.twitter.com"> <i class="fa fa-twitter"></i>
									</a> <a href="http://plus.google.com"> <i class="fa fa-google"></i>
									</a> <a href="http://www.youtube.com"> <i
										class="fa fa-youtube-play"></i>
									</a> <a href="http://www.vimeo.com"> <i class="fa fa-vimeo"></i>
									</a> <a href="http://www.pinterest.com"> <i
										class="fa fa-pinterest-p"></i>
									</a> <a href="http://www.linkedin.com"> <i
										class="fa fa-linkedin"></i>
									</a>
								</div>
								<div class="footer-address">
									<p>
										<i class="fa fa-map-marker"></i>28 Seventh Avenue, Neew York,
										10014
									</p>
									<p>
										<i class="fa fa-phone"></i>Phone: (415) 124-5678
									</p>
									<p>
										<i class="fa fa-envelope-o"></i>support@restaurant.com
									</p>
								</div>
							</div>
						</div>
					</div>

					<!-- Footer - Copyright -->
					<div class="footer-copyrights">
						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<p>
										<i class="fa fa-copyright"></i> 2015.Tomato.All rights
										reserved. Designed with <i class="fa fa-heart primary-color"></i>
										by Federico & Alessandro
									</p>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>

		</div>

		<!-- Javascript -->
		<script src="js/vendor/jquery-1.11.2.min.js"></script>
		<script src="js/vendor/bootstrap.min.js"></script>
		<script src="js/vendor/jquery.flexslider-min.js"></script>
		<script src="js/vendor/spectragram.js"></script>
		<script src="js/vendor/owl.carousel.min.js"></script>
		<script src="js/vendor/velocity.min.js"></script>
		<script src="js/vendor/velocity.ui.min.js"></script>
		<script src="js/vendor/bootstrap-datepicker.min.js"></script>
		<script src="js/vendor/bootstrap-clockpicker.min.js"></script>
		<script src="js/vendor/jquery.magnific-popup.min.js"></script>
		<script src="js/vendor/isotope.pkgd.min.js"></script>
		<script src="js/vendor/slick.min.js"></script>
		<script src="js/vendor/wow.min.js"></script>
		<script src="js/animation.js"></script>
		<script src="js/vendor/vegas/vegas.min.js"></script>
		<script src="js/vendor/jquery.mb.YTPlayer.js"></script>
		<script src="js/vendor/jquery.stellar.js"></script>
		<script src="js/main.js"></script>
		<script src="js/vendor/mc/jquery.ketchup.all.min.js"></script>
		<script src="js/vendor/mc/main.js"></script>
	</f:view>
</body>

</html>
