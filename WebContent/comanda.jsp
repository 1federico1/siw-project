<!DOCTYPE html>
<html lang="it">

<head>
<meta charset="utf-8">
<title>Ristorante da Peppe</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<link rel="stylesheet" href="js/vendor/vegas/vegas.min.css">
<link rel="stylesheet" href="css/main.css">

</head>

<body id="intro4">

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
						<a class="navbar-brand" href="./home_Administrator.jsp"> <img
							src="img/nav-logo.png" alt="nav-logo">
						</a>
					</div>

					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="./prenotazioneAdmin.jsp">Riserva un tavolo</a></li>
							<li><a href="./inserisciComanda.jsp">Nuova comanda</a></li>
							<li><a href="/siw-project/ProcessaCategoria">Inserisci
									nuovi piatti</a></li>
							<li class="dropdown"><a href="./index.html"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-haspopup="true" aria-expanded="false">Benvenuto
									${amministratoreCorrente.username}<span class="caret"></span>
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

			<!-- Shop Content -->
			<div class="shop-content">

				<div class="food-menu wow fadeInUp">
					<div class="container">
						<div class="row">


							<aside class="col-md-3">
								<h4>Categoria</h4>
								<div class="menu-tags3">
									<div class="side-widget">
										<ul class="shop-cat">
											<li><span data-filter=".starter"><i
													class="fa fa-angle-right"></i>starters</span></li>

											<li><span data-filter=".breakfast"><i
													class="fa fa-angle-right"></i>breakfast</span></li>

											<li><span data-filter=".lunch"><i
													class="fa fa-angle-right"></i>lunch</span></li>

											<li><span data-filter=".dinner"><i
													class="fa fa-angle-right"></i>dinner</span></li>

											<li><span data-filter=".desserts"><i
													class="fa fa-angle-right"></i>desserts</span></li>
										</ul>
									</div>
								</div>
							</aside>
							<div class="col-md-6">
								<h4>Piatti</h4>
								<div class="shop-grid">
									<div class="shop-products">
										<div class="row">
											<div class="row menu-items3">
												<div class="menu-item3 col-sm-4 starter dinner desserts">
													<div class="product-info">
														<h4>
															<a href="./recipe_detail-image.html">Food Name</a>
														</h4>
														<div class="shop-meta">
															<button type="button" class="btn btn-success">
																<i class="fa fa-shopping-cart"></i> Aggiungi
															</button>
														</div>
													</div>
												</div>

												<div class="menu-item3 col-sm-4 starter dinner desserts">
													<div class="product-info">

														<h4>
															<a href="./recipe_detail-image.html">Food Name</a>
														</h4>
														<div class="shop-meta">
															<button type="button" class="btn btn-success">
																<i class="fa fa-shopping-cart"></i> Aggiungi
															</button>
														</div>

													</div>
												</div>
												<div class="menu-item3 col-sm-4 starter dinner desserts">
													<div class="product-info">

														<h4>
															<a href="./recipe_detail-image.html">Food Name</a>
														</h4>
														<div class="shop-meta">
															<button type="button" class="btn btn-success">
																<i class="fa fa-shopping-cart"></i> Aggiungi
															</button>
														</div>

													</div>
												</div>

											</div>
										</div>
									</div>
								</div>
							</div>
							<aside class="col-md-3">
								<div class="side-widget">

									<form>

										<div class="row">
											<div class="form-group">
												<div class="col-md-9">
													<div class="shop-grid">
														<div class="shop-products">
															<div class="row">
																<div class="col-md-12">
																	<h4>Prenotazione effettuate</h4>
																	<br>
																	<table
																		class="cart-table account-table table table-bordered">
																		<thead>
																			<tr>
																				<th>Piatto</th>
																				<th>Quantit�</th>
																				<th>Aggiungi</th>

																			</tr>
																		</thead>
																		<tbody>

																			<tr>
																				<td>Lasagna de cristo</td>
																				<td><input type="number" placeholder="qta"
																					style="width: 65px;"></td>
																				<td><input class="btn btn-default"
																					type="button" value="Input"></td>

																			</tr>

																		</tbody>
																	</table>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</aside>
						</div>
					</div>
				</div>
			</div>
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
</body>

</html>