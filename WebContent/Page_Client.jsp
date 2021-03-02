<%@include file="./includes/Navbar_Client.jsp"%>
<!-- Header -->
<header class="w3-display-container w3-content w3-wide"
	style="max-width: 1500px;" id="home">
	<img class="w3-image" src="images/Veterino_Page.jpg" alt="Architecture"
		style="width: 1500px; height: 600px; margin-top: 50px">

</header>

<h3 id="RDV" class="w3-border-bottom w3-border-light-grey w3-padding-16"
	style="text-align: center;">RENDEZ-VOUS</h3>

<div class="container">
	<div class="panel  w3-panel">
		<div class="panel-heading w3-flat-turquoise">Effectuer un Rendez-vous</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label">Motif de RDV :</label> <input
							type="text" class="form-control" name="email" id="email">
					</div>
				</div>
				<div class='col-md-6'>
					<div class="form-group">
						<label class="control-label">Date RDV : </label>
						<div class='input-group date' id='datetimepicker1'>
							<input type='text' class="form-control" /> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
					</div>
				</div>
			</div>
			<input type="submit" class="btn w3-flat-turquoise" value="Effectuer RDV">
		</div>
	</div>
</div>

<div class="w3-container"
	style="display: flex; width: 100%; flex-direction: row; justify-content: space-around; flex-wrap: wrap;">

	<div class="w3-card-4" style="width: 30%; margin-top: 30px">
		<header class="w3-container w3-flat-turquoise">
			<h3>KAMAL CHOKRANE</h3>
		</header>
		<div class="w3-container">
			<p>14 FEVRIER 2021</p>
			<hr>
			<img src="images/img_avatar3.png" alt="Avatar"
				class="w3-left w3-circle w3-margin-right" style="width: 60px">
			<p>Demande Analyse globale pour mon chien .</p>
			<br>
		</div>
		<button class="w3-button w3-block w3-flat-turquoise">ACCEPTER</button>
	</div>
	<div class="w3-card-4" style="width: 30%; margin-top: 30px">
		<header class="w3-container w3-flat-turquoise">
			<h3>ABDERRAZAK GHIYATI</h3>
			<div class="w3-container w3-flat-turquoise">
				<p>14 FEVRIER 2021</p>
				<hr>
				<img src="images/img_avatar3.png" alt="Avatar"
					class="w3-left w3-circle w3-margin-right" style="width: 60px">
				<p>Mon cheval a des maux en genaux.</p>
				<br>
			</div>
			<button class="w3-button w3-block w3-light-grey">ACCEPTER</button>
	</div>
	<div class="w3-card-4" style="width: 30%; margin-top: 30px">
		<header class="w3-container w3-flat-turquoise">
			<h3>LMJED NDOR</h3>
		</header>
		<div class="w3-container">
			<p>30 Fevrier 2021 hhhh</p>
			<hr>
			<img src="images/img_avatar3.png" alt="Avatar"
				class="w3-left w3-circle w3-margin-right" style="width: 60px">
			<p>Cas urgente</p>
			<br>
		</div>
		<button class="w3-button w3-block w3-flat-turquoise">ACCEPTER</button>
	</div>
	<div class="w3-card-4" style="width: 30%; margin-top: 30px">
		<header class="w3-container w3-flat-turquoise">
			<h3>Jamal AMIMI</h3>
		</header>
		<div class="w3-container w3-flat-turquoise">
			<p>24 MARS 2021</p>
			<hr>
			<img src="images/img_avatar3.png" alt="Avatar"
				class="w3-left w3-circle w3-margin-right" style="width: 60px">
			<p>Demande consultation.</p>
			<br>
		</div>
		<button class="w3-button w3-block w3-light-grey">ACCEPTER</button>
	</div>
</div>
<div class="vide"
	style="width: 100%; background-color: white; height: 50px"></div>
<h3 id="QR" class="w3-border-bottom w3-border-light-grey w3-padding-16"
	style="text-align: center;">QUESTIONS/REPONCES</h3>

<div class="w3-row-padding">
	<c:forEach items="${ListQuestionUserConnecte}" var="question"
		varStatus="status">
		<div class="w3-third w3-container w3-margin-bottom">
			<div class="w3-card-4" style="width: 100%; margin-top: 30px;">
				<h2>
					QUESTION
					<c:out value="${status.count}" />
					:
				</h2>
				<p>
					De :
					<c:out value="${question.getUser().getLastName().toString()}" />
					<c:out value="${question.getUser().getFirstName().toString()}" />
				</p>

				<div class="w3-panel w3-card">
					<p>
						<c:out value="${question.getDescriptionQuestions().toString()}" />
					</p>
				</div>
				<c:forEach items="${question.getReponces()}" var="reponce"
					varStatus="status">
					<div class="w3-panel w3-card w3-flat-turquoise"
						style="margin-left: 25px; color: black">
						<p style="font-size: 10px">
							<c:out value="${reponce.getDescriptionReponse()}" />
						</p>
					</div>
				</c:forEach>
				<form class="w3-container" method="post" action="repondreQuestion">

					<input placeholder="Repondez sur cette Question" class="w3-input"
						style="border: 2px solid #000; margin-top: 10px" type="text"
						name="Reponce">
					<div style="width: 100%; height: 20px; background-color: white;"></div>
					<div class="w3-panel w3-card-2"
						style="display: none; height: 100px">
						<p>w3-card-2</p>
					</div>

					<input type="hidden" value="${question.getIdQuestion().toString()}"
						name="idQuestion" /> <input type="submit" value="REPONDRE"
						name="BtnRep" class="w3-button w3-block w3-flat-turquoise" />
				</form>
			</div>
		</div>
	</c:forEach>

	<div class="w3-third w3-margin-bottom">
		<ul
			class="w3-ul w3-border w3-white w3-center w3-opacity w3-hover-opacity-off"
			style="margin-top: 60px;">
			<li class="w3-flat-turquoise w3-xlarge w3-padding-32">-----------</li>
			<li class="w3-padding-16">POSER UNE QUESTION</li>
			<form method="post" action="ajouterQuestion">
				<li class="w3-padding-16"><input
					placeholder="Posez votre Question" class="w3-input"
					style="border: 2px solid #000; margin-top: 10px" type="text"
					name="textQuestion">
					<div style="width: 100%; height: 20px; background-color: white;"></li>
				<li class="w3-light-grey w3-padding-24"><input type="submit"
					value="Envoyer" name="BtnAjQuestion"
					class="w3-button w3-flat-turquoise w3-padding-large w3-hover-black" />
				</li>
			</form>

		</ul>
	</div>

</div>

<script>
	$(function() {
		$('#datetimepicker1').datetimepicker();
	});
</script>










