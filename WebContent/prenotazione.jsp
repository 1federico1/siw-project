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

<!--[if lt IE 9]>
            <script src="js/vendor/html5-3.6-respond-1.4.2.min.js"></script>
        <![endif]-->
</head>

<body data-scroll-animation="true">
	<!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->
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
						<a class="navbar-brand" href="./home_Utente.jsp"> <img
							src="img/nav-logo.png" alt="nav-logo">
						</a>
					</div>

					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="./home_Utente.jsp">Home</a></li>
							<li><a
								href="${pageContext.request.contextPath}/ProcessaMenu">Men&ugrave;</a></li>
							<li><a href="./galleria.jsp">Galleria</a></li>
							<li><a href="./prenotazione.jsp">Riserva un tavolo</a></li>
							<li><a href="./contact.html">Contact</a></li>
							<li class="dropdown"><a href="./home_Utente"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">Benvenuto
									${utenteCorrente.nome}<span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a
										href="${pageContext.request.contextPath}/processaProfilo">Profilo</a></li>
									<li><a href="./index_parallax.jsp">Logout</a></li>
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
									Prenotazione<small>Prenota un tavolo online. Ti sar�
										inviata una email di conferma.</small>
								</h1>
							</div>
						</div>
					</div>
					<div class="reservation-form">
						<form action="processaPrenotazione" method="post" id="formfield">
							<input type="hidden" name="action" value="add_form" />
							<div id="OT_searchWrapper">
								<div id="OT_defList" class="row">
									<div class="row">
										<div class="col-md-4 col-sm-6">
											<div class="form-group">
												<label for="datepicker">Data</label> <input type="text"
													name="data" class="form-control" id="datepicker"
													placeholder="Seleziona una data" title="seleziona una data"
													value='${param["data"]}'> <i
													class="fa fa-calendar-o"></i>
											</div>
										</div>
										<div class="col-md-4 col-sm-6">
											<div class="form-group">
												<label for="timepicker">Orario di arrivo</label> <input
													type="text" class="form-control" id="timepicker" name="ora"
													placeholder="Seleziona l'orario di arrivo"
													title="Seleziona un'ora di arrivo" value='${param["ora"]}'>
												<i class="fa fa-clock-o"></i>
											</div>
										</div>
										<div id="OT_partySize" class="col-md-4 col-sm-12">
											<div class="form-group">
												<label for="ospiti">Numero di ospiti</label> <select
													name="ospiti" id="ospiti" class="feedFormField">
													<option selected value="0">Inserisci il numero di
														Ospiti</option>
													<option value="1">1 Persona</option>
													<option value="2">2 Persone</option>
													<option value="3">3 Persone</option>
													<option value="4">4 Persone</option>
													<option value="5">5 Persone</option>
													<option value="6">6 Persone</option>
													<option value="7">7 Persone</option>
													<option value="8">8 Persone</option>
													<option value="9">9 Persone</option>
													<option value="10">10 Persone</option>
													<option value="11">11 Persone</option>
													<option value="12">12 Persone</option>
													<option value="13">13 Persone</option>
													<option value="14">14 Persone</option>
													<option value="15">15 Persone</option>
												</select> <i class="fa fa-sort-numeric-asc" aria-hidden="true"></i>
											</div>
										</div>
									</div>
								</div>
								<div id="OT_searchWrapper">
									<div id="OT_defList" class="row">
										<div class="col-md-12 col-sm-12">
											<div class="reservation-btn">
												<input type="button" name="btn"
													value="Effettua prenotazione" id="submitBtn"
													data-toggle="modal" data-target="#confirm-submit"
													class="btn btn-default" />
											</div>
										</div>
									</div>
								</div>
								<%
									if (request.getAttribute("ERROR") != null) {
								%>
								<div class="animated fadeInDown">
									<div class="alert alert-error alert-dismissable">
										<button type="button" class="close" data-dismiss="alert">
											<span class="fa fa-close"></span>
										</button>
										<span> ERRORE: </span>${dataError} ${oraError} ${ospitiError}
										${tavoliError } ${prenotazioniError}
									</div>

								</div>
								<%
									}
								%>
								<%
									if (request.getAttribute("OK") != null) {
								%>
								<div class="animated fadeInDown">
									<div class="alert alert-success alert-dismissable">
										<button type="button" class="close" data-dismiss="alert">
											<span class="fa fa-close"></span>
										</button>
										<span> SUCCESS: </span>${OK}
									</div>

								</div>
								<%
									}
								%>
							</div>
						</form>
					</div>
					<div class="reservation-footer">
						<p>
							Puoi contattarci anche al: <strong>+1 224 6787 004</strong> per
							effettuare una prenotazione.
						</p>
						<span></span>
					</div>


					<div class="modal fade" id="confirm-submit" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-body">
									<h4>Confermare prenotazione?</h4>
									<table class="table">
										<tr>
											<th>Data:</th>
											<td id="date"></td>
										</tr>
										<tr>
											<th>Ora:</th>
											<td id="time"></td>
										</tr>
										<tr>
											<th>Ospiti:</th>
											<td id="osp"></td>
										</tr>
									</table>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Annulla</button>
									<a href="#" id="submit" class="btn btn-success success">Effettua
										prenotazione</a>
								</div>
							</div>
						</div>
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
									<p class="footer-blog-text">Hand picked ingredients for our
										best customers</p>
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

</body>

</html>
