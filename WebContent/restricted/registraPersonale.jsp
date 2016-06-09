<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Inserimento personale</title>
<meta name="author" content="Surjith S M">

<!-- SEO -->
<meta name="description"
	content="Tomato is a Responsive HTML5 Template for Restaurants and food related services.">
<meta name="keywords"
	content="tomato, responsive, html5, restaurant, template, food, reservation">

<!-- Favicons -->
<link rel="shortcut icon" href="../img/favicon.ico">

<!-- Responsive Tag -->
<meta name="viewport" content="width=device-width">

<!-- CSS Files -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="../css/plugin.css">
<link rel="stylesheet" href="../css/main.css">

</head>

<body>
	<f:view>

		<!-- Preloder-->
		<div class="preloder animated">
			<div class="scoket">
				<img src="../img/preloader.svg" alt="" />
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
							<a class="navbar-brand"
								href="${pageContext.request.contextPath}/processaPannelloControllo">
								<img src="../img/nav-logo.png" alt="nav-logo">
							</a>
						</div>

						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li><a href="./prenotazioneAdmin.jsp">Riserva un tavolo</a></li>
								<li><a
									href="${pageContext.request.contextPath}/processaSala">Sala</a></li>
								<li class="dropdown"><a href="./index.html"
									class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false">Benvenuto
										${amministratoreCorrente.username} -
										${amministratoreCorrente.role}<span class="caret"></span>
								</a>
									<ul class="dropdown-menu">
										<li><a href="./index_parallax.jsp">Logout</a></li>
									</ul></li>
							</ul>
						</div>

						<!--/.navbar-collapse -->
					</div>
				</nav>

				<!-- Page Header -->
				<section class='page_header vertical-padding'></section>

				<!-- Account Content -->

				<section class="reservation">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<div class="row shop-login">
									<div class="box-content">
										<h3 class="text-center">Registra nuovo personale</h3>
										<br>
										<div class="reservation-form">
											<h:form id="inserimentoPersonale">
												<div id="OT_searchWrapper">
													<div id="OT_defList" class="row">
														<div class="clearfix space20"></div>
														<div class="row">
															<div class="col-md-6 col-sm-6">
																<div class="form-group">
																	<label for="username">Username</label>
																	<h:inputText
																		value="#{utenteController.username}"
																		styleClass="form-control" required="true"
																		requiredMessage="Username obbligatorio" id="username" />
																	<i class="fa fa-user" aria-hidden="true"></i>
																	<div class="animated fadeInDown">
																		<span class="label label-danger"><h:message
																				for="username" /></span>
																	</div>
																</div>
															</div>
															<div class="col-md-6 col-sm-6">
																<div class="form-group">
																	<label for="password">Password</label>
																	<h:inputSecret
																		value="#{utenteController.password}"
																		styleClass="form-control" required="true"
																		requiredMessage="Password obbligatoria" id="password" />
																	<i class="fa fa-lock" aria-hidden="true"></i>
																	<div class="animated fadeInDown">
																		<span class="label label-danger"><h:message
																				for="password" /></span>
																	</div>
																</div>
															</div>
														</div>
														<div class="row">
															<div class="col-md-12">
																<div class="space20"></div>
																<div class="reservation-btn">
																	<input type="button" name="btn"
																		value="Registra operatore" id="conferma"
																		data-toggle="modal" data-target="#confirm-submit"
																		class="btn btn-default" />
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="modal fade" id="confirm-submit" tabindex="-1"
													role="dialog" aria-labelledby="myModalLabel"
													aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-body">
																<h4>Confermare inserimento?</h4>
																<table class="table">
																	<tr>
																		<th><span class="fa fa-user" aria-hidden="true"></span>
																			Username :</th>
																		<td id="use"></td>
																	</tr>
																</table>
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-default"
																	data-dismiss="modal">Annulla</button>
																<h:commandLink styleClass="btn btn-success"
																	value="Registra Operatore"
																	action="#{utenteController.createOperatore}">
																</h:commandLink>
															</div>
														</div>
													</div>
												</div>
												<h:messages globalOnly="true" styleClass="list-group"
														infoClass="list-group-item list-group-item-danger"/>
											</h:form>
										</div>
									</div>
									<br>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>

		</div>

		<!-- Javascript -->
		<script src="../js/vendor/jquery-1.11.2.min.js"></script>
		<script src="../js/vendor/bootstrap.min.js"></script>
		<script src="../js/vendor/jquery.flexslider-min.js"></script>
		<script src="../js/vendor/spectragram.js"></script>
		<script src="../js/vendor/owl.carousel.min.js"></script>
		<script src="../js/vendor/velocity.min.js"></script>
		<script src="../js/vendor/velocity.ui.min.js"></script>
		<script src="../js/vendor/bootstrap-datepicker.min.js"></script>
		<script src="../js/vendor/bootstrap-clockpicker.min.js"></script>
		<script src="../js/vendor/jquery.magnific-popup.min.js"></script>
		<script src="../js/vendor/isotope.pkgd.min.js"></script>
		<script src="../js/vendor/slick.min.js"></script>
		<script src="../js/vendor/wow.min.js"></script>
		<script src="../js/animation.js"></script>
		<script src="../js/vendor/vegas/vegas.min.js"></script>
		<script src="../js/vendor/jquery.mb.YTPlayer.js"></script>
		<script src="../js/vendor/jquery.stellar.js"></script>
		<script src="../js/main.js"></script>
		<script src="../js/vendor/mc/jquery.ketchup.all.min.js"></script>
		<script src="../js/vendor/mc/main.js"></script>
		<script src="../js/scripts/confermaInserimentoOperatore.js"></script>
	</f:view>
</body>

</html>
