<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="it.uniroma3.project.controller.facade.Facade"%>
<%@page import="it.uniroma3.project.persistence.entity.CategoriaPiatto"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Inserimento nuovo piatto</title>


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

	<!-- Preloder-->
	<div class="preloder animated">
		<div class="scoket">
			<img src="img/preloader.svg" alt="" />
		</div>
	</div>

	<div class="body">
		<div class="main-wrapper">
			<%
				if (session.getAttribute("amministratoreCorrente") == null) {
					String redirectURL = "./404.html";
					response.sendRedirect(redirectURL);

				} else {
			%>
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
							<img src="img/nav-logo.png" alt="nav-logo">
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


			<section class='page_header vertical-padding'></section>

			<!-- Inserimento Piatti page-->
			<section class="reservation">
				<div class="container">
					<div class="row">
						<div class="col-md-12">
							<div class="page-header">
								<h1>Inserisci un nuovo piatto</h1>
							</div>
						</div>
					</div>

					<div class="reservation-form">
						<form action="processaPiatto" method="post"
							enctype="multipart/form-data" id="formfield">
							<input type="hidden" name="action" value="add_form" />
							<!-- Tabs -->
							<div class="element-tab">
								<!-- Nav tabs -->
								<ul class="nav nav-tabs" role="tablist">
									<li class="active"><a href="#categoria" role="tab"
										data-toggle="tab"> Categoria piatto </a></li>
									<li><a href="#descrizione" role="tab" data-toggle="tab">
											Descrizione </a></li>
								</ul>
								<!-- Tab panes -->
								<div class="tab-content">
									<div class="tab-pane fade active in" id="categoria">
										<div class="col-md-12">
											<div id="OT_searchWrapper">
												<div id="OT_defList" class="">
													<div id="OT_partySize" class="">
														<div class="form-group">
															<select id="categoria" name="categoria" id="categoria"
																class="feedFormField">
																<option selected value="empty">Inserisci la
																	categoria</option>
																<c:forEach var="categoria" items="${categorie}">
																	<option value="${categoria.id}">${categoria.nome}</option>
																</c:forEach>
															</select>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>


									<div class="tab-pane fade" id="descrizione">
										<div class="row">
											<div class="col-md-6 col-sm-6">
												<div class="form-group">
													<label for="name">Nome</label> <input type="text"
														class="form-control" id="nome" name="nome"
														placeholder="Inserisci il nome del piatto"
														title="Inserisci il nome del piatto"
														value='${param["nome"]}'> <i class="fa fa-cutlery"
														aria-hidden="true"></i>
												</div>
											</div>
											<div class="col-md-6 col-sm-6">
												<div class="form-group">
													<label for="immagine">Immagine</label> <input type=file
														name="fileName" style="length: 100%;"> <i
														class="fa fa-picture-o" aria-hidden="true"></i>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6 col-sm-6">
												<div class="form-group">
													<label for="descrizione">Descrizione</label>
													<textarea class="form-control" id="descrizione"
														placeholder="Inserisci la descrizione" rows="4" cols="5"
														name="descrizione">${param["descrizione"]}</textarea>
													<i class="fa fa-comment-o" aria-hidden="true"></i>
												</div>
											</div>
											<div class="col-md-6 col-sm-6">
												<div class="form-group">
													<label for="prezzo">Prezzo</label> <input type="text"
														class="form-control" id="prezzo" name="prezzo"
														placeholder="Inserisci il prezzo"
														title="Inserisci il prezzo del piatto"
														value='${param["prezzo"]}'> <i class="fa fa-eur"
														aria-hidden="true"></i>
												</div>
											</div>
											<div id="OT_partySize" class="col-md-6 col-sm-6">
												<div class="form-group">
													<label for="surgelati">Contiene prodotti surgelati?</label>
													<input type="checkbox" name="surgelati" value="True"
														id="surgelato">
												</div>
											</div>
											<div id="OT_partySize" class="col-md-6 col-sm-6">
												<div class="form-group">
													<label for="allergeni">Contiene allergeni?</label> <input
														type="checkbox" name="allergeni" value="True"
														id="allergeni">
												</div>
											</div>

										</div>
									</div>
								</div>
							</div>

							<div id="OT_searchWrapper">
								<div id="OT_defList" class="row">
									<div class="col-md-12 col-sm-12">
										<div class="reservation-btn">

											<input type="button" name="btn" value="Inserisci piatto"
												id="submitBtn" data-toggle="modal"
												data-target="#confirm-submit" class="btn btn-default" />
											<%
												if (request.getAttribute("ERRORE") != null) {
											%>
											<div class="animated fadeInDown">
												<div class="form-group">
													<div class="alert alert-error alert-dismissable">
														<button type="button" class="close" data-dismiss="alert">
															<span class="fa fa-close"></span>
														</button>
														<span> ERRORE: </span>${nomeCategoria} ${nomeError}
														${descrizioneError} ${prezzoError} ${urlError}
													</div>
												</div>

											</div>
											<%
												}
											%>
										</div>
									</div>
								</div>
							</div>
						</form>

						<div class="modal fade" id="confirm-submit" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-body">
										<h4>Confermare inserimento?</h4>
										<table class="table">
											<tr>
												<th><span class="fa fa-cutlery" aria-hidden="true"></span>
													Nome:</th>
												<td id="nom"></td>
											</tr>
											<tr>
												<th><span class="fa fa-eur" aria-hidden="true"></span>
													Prezzo:</th>
												<td id="pre"></td>
											</tr>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Annulla</button>
										<a href="#" id="submit" class="btn btn-success success">Inserisci
											piatto</a>
									</div>
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
							<h1>Seguici sui social!</h1>
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
		<%
			}
		%>

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

	<script src="js/scripts/confermaInserimentoPiatto.js"> </script>
	<script src="js/scripts/confermaInserimentoPiatti.js"> </script>



</body>

</html>
