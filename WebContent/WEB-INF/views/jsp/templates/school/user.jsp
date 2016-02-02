

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">

	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<li class="active"><a href="#professorlist" role="tab"
			data-toggle="tab"> <icon class="glyphicon glyphicon-th-list"></icon>
				Professor List
		</a></li>
		<li><a href="#addProfessor" role="tab" data-toggle="tab"> <icon
					class="glyphicon glyphicon-plus"></icon> Add Professor
		</a></li>

	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
		<div class="tab-pane fade active in" id="professorlist">
			<div class="panel panel-default">
				<div class="formcontainer">
					<!-- Row start -->
					<div class="row">
						<div class="col-md-12 col-sm-6 col-xs-12">

							<div class="panel-body">
								<table class="table table-striped eaTable">
									<thead>
										<tr>
											<th>Name</th>
											<th>Email</th>
											<th>Status</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="pu" items="${professorUsers}">
											<tr>
												<td>${pu.firstname}${pu.lastname}</td>
												<td>${pu.email}</td>
												<td><input type="submit"
													onclick="javascript:doActiveAdminUser(${pu.id},${!pu.active});return false;"
													value="${!pu.active?'Activate':'Deactivate'}"
													class="btn ${!pu.active?'btn-success':'btn-danger'}"></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>

						</div>
					</div>
					<!-- Row end -->

				</div>
			</div>

		</div>
		<div class="tab-pane fade" id="addProfessor">
			<div class="panel panel-default">
				<div class="formcontainer">
					<!-- Row start -->
					<div class="row">
						<div class="col-md-12 col-sm-6 col-xs-12">

							<div class="panel-body">
								<form:form class="form-horizontal row-border"
									action="user/professor" method="post"
									modelAttribute="professor">

									<div class="form-group">
										<label class="col-md-2 control-label">First Name</label>
										<div class="col-md-10">
											<form:input path="firstname" class="form-control"
												id="firstname" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">Last Name</label>
										<div class="col-md-10">
											<form:input path="lastname" class="form-control"
												id="lastname" />
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
											<form:password path="password" class="form-control" />
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
		</div>
	</div>

</div>



<script type="text/javascript">
function doActiveAdminUser(id,active) {
		$.ajax({
			type : 'POST',
			url : 'professor/activate',
			data : 'id=' + id+'&active='+active,
			success : function(message) {
				window.location.href = "user";
				//$('#roleDeleteMsg').html("Deleted!");
			},
			error : function(e) {
				//$('#roleDeleteMsg').html("Failed!");
			}
		});
	}
</script>

