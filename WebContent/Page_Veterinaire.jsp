<%@include file="./includes/Navbar_Veternaire.jsp"%>
<!-- Header -->
<header class="w3-display-container w3-content w3-wide"
	style="max-width: 1500px;" id="home">
	<img class="w3-image" src="images/Veterino_Page.jpg" alt="Architecture"
		style="width: 1500px; height: 600px; margin-top: 50px">

</header>

<h3 id="RDV" class="w3-border-bottom w3-border-light-grey w3-padding-16"
	style="text-align: center;">RENDEZ-VOUS</h3>

<div class="w3-container"
	style="display: flex; width: 100%; flex-direction: row; justify-content: space-around; flex-wrap: wrap;">
	<c:forEach items="${ListRdvs}" var="rdv" varStatus="status">
		<c:if test="${ status.count%2==0}">
			<div class="w3-card-4" style="width: 30%; margin-top: 30px">
				<header class="w3-container w3-flat-turquoise">
					<h3>${rdv.getUser().getLastName().toString()}
						${rdv.getUser().getFirstName().toString()}</h3>
				</header>
				<div class="w3-container">
					<p>${rdv.getDateRdv().toString()}</p>
					<hr>
					<img src="images/img_avatar3.png" alt="Avatar"
						class="w3-left w3-circle w3-margin-right" style="width: 60px">
					<p>${rdv.getMotifRdv().toString()}</p>
					<br>
				</div>
				<form action="confirmeRdv" method="post">
					<c:if test="${rdv.isAccepted()}">
						<input type="submit" value="Deja Confirmé" name="BtnConfirmation"
							class="w3-button w3-block w3-light-grey" disabled />
						<input type="hidden" value="${rdv.getIdRdv()}" name="Rdv" />
					</c:if>
					<c:if test="${!rdv.isAccepted()}">
						<input type="submit" value="Accepter" name="BtnConfirmation"
							class="w3-button w3-block w3-light-grey" />
						<input type="hidden" value="${rdv.getIdRdv()}" name="Rdv" />
					</c:if>
				</form>
			</div>
		</c:if>
		<c:if test="${ status.count%2==1}">
			<div class="w3-card-4" style="width: 30%; margin-top: 30px">
				<header class="w3-container w3-flat-turquoise">
					<h3>${rdv.getUser().getLastName().toString()}
						${rdv.getUser().getFirstName().toString()}</h3>
				</header>
				<div class="w3-container w3-flat-turquoise">
					<p>${rdv.getDateRdv().toString()}</p>
					<hr>
					<img src="images/img_avatar3.png" alt="Avatar"
						class="w3-left w3-circle w3-margin-right" style="width: 60px">
					<p>${rdv.getMotifRdv().toString()}</p>
					<br>
				</div>
				<form action="confirmeRdv" method="post">
					<c:if test="${rdv.isAccepted()}">
						<input type="submit" value="Deja Confirmé" name="BtnConfirmation"
							class="w3-button w3-block w3-light-grey" disabled />
						<input type="hidden" value="${rdv.getIdRdv()}" name="Rdv" />
					</c:if>
					<c:if test="${!rdv.isAccepted()}">
						<input type="submit" value="Accepter" name="BtnConfirmation"
							class="w3-button w3-block w3-light-grey" />
						<input type="hidden" value="${rdv.getIdRdv()}" name="Rdv" />
					</c:if>
				</form>
			</div>
		</c:if>



	</c:forEach>



</div>
<div class="vide"
	style="width: 100%; background-color: white; height: 50px"></div>
<h3 id="QR" class="w3-border-bottom w3-border-light-grey w3-padding-16"
	style="text-align: center;">QUESTIONS/REPONCES</h3>





<c:forEach items="${listesQuestions}" var="question" varStatus="status">

	<div class="w3-card-4"
		style="width: 40%; margin-top: 30px; margin-left: 30%">
		<h2>
			QUESTION
			<c:out value="${status.count}" />
			:
		</h2>
		<p>
			De
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
			<label>Entrez votre reponce ? </label> <input class="w3-input"
				style="border: 2px solid #000; margin-top: 10px" type="text"
				name="Reponce">
			<div style="width: 100%; height: 20px; background-color: white;">
			</div>

			<div class="w3-panel w3-card-2" style="display: none; height: 100px">
				<p>w3-card-2</p>
			</div>

			<input type="hidden" value="${question.getIdQuestion().toString()}"
				name="idQuestion" /> <input type="submit" value="REPONDRE"
				name="BtnRep" class="w3-button w3-block w3-flat-turquoise" />
		</form>
	</div>


</c:forEach>










