<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Prenotazioni</title>
<meta name="author" content="Surjith S M">

<!-- SEO -->
<meta name="description"
	content="Tomato is a Responsive HTML5 Template for Restaurants and food related services.">
<meta name="keywords"
	content="tomato, responsive, html5, restaurant, template, food, reservation">

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

<body data-scroll-animation="true">
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
								<li><a href="./index_parallax.jsp">Home</a></li>
								<li><a href="./menu.jsp">Men&ugrave;</a></li>
								<li><a href="./prenotazione.jsp"><span
										style="color: #F9C56A;">Riserva un tavolo</span></a></li>
								<li><a href="./contact.html">Contact</a></li>
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
							</ul>
						</div>

						<!--/.navbar-collapse -->
					</div>
				</nav>

				<section class='page_header vertical-padding'></section>

				<!-- Reservations page-->
				<section class="reservation">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="page-header">
									<h1>
										Prenotazione<small>Prenota un tavolo dalle 19:00 alle
											21:59. Ti sar� inviata una email di conferma.</small>
									</h1>
								</div>
							</div>
						</div>
						<div class="reservation-form">
							<h:form id="prenotazioni">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label for="datepicker">Data</label>
											<h:inputText value="#{prenotazioneControllerBean.datepicker}"
												styleClass="form-control" required="true" id="datepicker"
												requiredMessage="Data prenotazione obbligatoria"
												converterMessage="Formato data errato dd/mm/yyyy">
												<f:convertDateTime pattern="dd/MM/yyyy" />
											</h:inputText>
											<i class="fa fa-calendar-o" aria-hidden="true"></i>
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="datepicker" /></span>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="timepicker">Orario di arrivo</label>
											<h:inputText value="#{prenotazioneControllerBean.timepicker}"
												styleClass="form-control" required="true" id="timepicker"
												requiredMessage="Orario di arrivo obbligatorio"
												converterMessage="Formato ora errato hh:mm">
												<f:convertDateTime pattern="HH:mm" />
											</h:inputText>
											<i class="fa fa-clock-o" aria-hidden="true"></i>
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="timepicker" /></span>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="coperti">Coperti</label>
											<h:inputText value="#{prenotazioneControllerBean.coperti}"
												styleClass="form-control" required="true"
												requiredMessage="Numero di coperti obbligatorio"
												validatorMessage="Tavoli non disponibili per questo numero di coperti"
												id="coperti">
												<f:validateLongRange minimum="1" maximum="12" />
											</h:inputText>
											<i class="fa fa-sort-numeric-asc" aria-hidden="true"></i>
											<div class="animated fadeInDown">
												<span class="label label-danger"><h:message
														for="coperti" /></span>
											</div>
										</div>
									</div>
									<div class="col-md-12 col-sm-12">
										<div class="reservation-btn">
											<input type="button" name="tableForm:tableBtn"
												value="Effettua prenotazione" id="conferma"
												data-toggle="modal" data-target="#confirm-submit"
												class="btn btn-default" />
										</div>
										<div class="animated fadeInDown">
											<h:messages globalOnly="true" styleClass="list-group"
												infoClass="list-group-item list-group-item-danger"></h:messages>
										</div>
									</div>
								</div>
								<div class="modal fade" id="confirm-submit" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-body">
												<h4>Confermare prenotazione?</h4>
												<table class="table">
													<tr>
														<th><span class="fa fa-calendar-o" aria-hidden="true"></span>
															Data:</th>
														<td id="date"></td>
													</tr>
													<tr>
														<th><span class="fa fa-clock-o" aria-hidden="true"></span>
															Ora:</th>
														<td id="time"></td>
													</tr>
													<tr>
														<th><span class="fa fa-users" aria-hidden="true"></span>
															Ospiti:</th>
														<td id="osp"></td>
													</tr>
												</table>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Annulla</button>
												<h:commandLink styleClass="btn btn-success"
													value="Effettua prenotazioni"
													action="#{prenotazioneControllerBean.createByUtente}">
												</h:commandLink>

											</div>
										</div>
									</div>
								</div>
							</h:form>
							<h:panelGroup rendered="#{not empty prenotazioneCorrente}">
								<div class="animated fadeInDown">
									<div class="alert alert-success alert-dismissable">
										<button type="button" class="close" data-dismiss="alert">
											<span class="fa fa-close"></span>
										</button>
										<span> SUCCESS: </span>
										<h:outputText value="#{prenotazioneCorrente}" />
										<h:panelGroup rendered="#{not empty prenotazioneError}">
											<div class="animated fadeInDown">
												<div class="alert alert-danger alert-dismissable">
													<button type="button" class="close" data-dismiss="alert">
														<span class="fa fa-close"></span>
													</button>
													<span> ERRORE: </span>
													<h:outputText value="#{prenotazioneError}" />
												</div>
											</div>
										</h:panelGroup>
									</div>
								</div>
							</h:panelGroup>
						</div>
						<div class="reservation-footer">
							<p>
								Puoi contattarci anche al: <strong>+1 224 6787 004</strong> per
								effettuare una prenotazione.
							</p>
							<span></span>
						</div>
					</div>
				</section>
				<!-- Footer-->
				<section class="footer">
					<div class="container">
						<div class="row">
							<div class="col-md-4 col-sm-12">
								<h1>Dicono di noi</h1>
								<p></p>
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
										<i class="fa fa-copyright"></i> 2016. Copyright. Designed with
										<i class="fa fa-heart primary-color"></i>
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
		<script src="js/vendor/validate.js"></script>
		<script src="js/reservation.js"></script>
		<script src="js/vendor/mc/main.js"></script>
		<script src="js/scripts/confermaInserimentoPrenotazione.js"></script>
	</f:view>
</body>

</html>
