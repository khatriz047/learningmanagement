<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<li class="active"><a href="#question" role="tab"
			data-toggle="tab"> <icon class="fa fa-home"></icon> Question
		</a></li>
	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
		<div class="tab-pane fade active in" id="question">

			<div class="panel panel-default">
				<div class="formcontainer">
					<!-- Row start -->
					<div class="row">
						<div class="col-md-12 col-sm-6 col-xs-12">

							<div class="panel-body">
								<form:form class="form-horizontal row-border" action="portal"
									method="post" modelAttribute="question">

									<form:hidden path="id" value="${question.id}" />


									<div class="form-group">
										<label class="col-md-2 control-label">Question</label>
										<div class="col-md-10">
											<form:input path="title" class="form-control" />

										</div>
									</div>
									<div class="form-group">
										<form:button class="btn btn-primary btn-sm">Post Question</form:button>
									</div>

								</form:form>
							</div>

						</div>
					</div>
					<!-- Row end -->

				</div>

			</div>
		</div>

	</div>