<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="panel panel-default">
	<div class="formcontainer">
		<!-- Row start -->
		<div class="row">
			<div class="col-md-12 col-sm-6 col-xs-12">

				<div class="panel-body">
					<form:form class="form-horizontal row-border" action="school"
						method="post" modelAttribute="schoolUser">


						<div class="form-group">
							<label class="col-md-2 control-label">School Name</label>
							<div class="col-md-10">
								<form:input path="schoolname" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">Username</label>
							<div class="col-md-10">
								<form:input path="username" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">password</label>
							<div class="col-md-10">
								<form:input path="password" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label">Email</label>
							<div class="col-md-10">
								<form:input path="email" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<form:button class="btn btn-primary btn-sm">Add</form:button>
						</div>
					</form:form>
				</div>

			</div>
		</div>
		<!-- Row end -->

	</div>
</div>