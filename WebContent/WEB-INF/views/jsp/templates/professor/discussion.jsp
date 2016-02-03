<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<li class="active"><a href="#question" role="tab"
			data-toggle="tab"> <icon class="glyphicon glyphicon-question-sign"></icon>
				Question
		</a></li>
		<li><a href="#answer" role="tab" data-toggle="tab"> <icon
					class="glyphicon glyphicon-folder-open"></icon> Answer
		</a></li>

	</ul>

	<div class="tab-content">
		<div class="tab-pane fade active in" id="question">
			<div class="panel panel-default">
				<div class="formcontainer">
					<!-- Row start -->
					<div class="row">
						<div class="col-md-12 col-sm-6 col-xs-12">

							<div class="panel-body"></div>

						</div>
					</div>
					<!-- Row end -->

				</div>
			</div>

		</div>
		<div class="tab-pane fade" id="answer">
			<div class="panel panel-default">
				<div class="formcontainer">
					<!-- Row start -->
					<div class="row">
						<div class="col-md-12 col-sm-6 col-xs-12">

							<div class="panel-body"></div>
						</div>
						<!-- Row end -->

					</div>
				</div>
			</div>
		</div>

	</div>
</div>