<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="panel panel-default">
	<div class="formcontainer">
		<!-- Row start -->
		<div class="row">
			<div class="col-md-12 col-sm-6 col-xs-12">

				<div class="panel-body">
					<table class="table table-striped eaTable">
						<thead>
							<tr>
								<th>School Name</th>
								<th>Email</th>
								<th>User</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="su" items="${schoolUsers}">
								<tr>
									<td>${su.schoolname}</td>
									<td>${su.email}</td>
									<td>${su.firstname}${su.lastname}</td>
									<td><input type="submit"
										onclick="javascript:doActiveSchoolUser(${su.id},${!su.active});return false;"
										value="${!su.active?'Activate':'Deactivate'}"
										class="btn ${!su.active?'btn-success':'btn-danger'}"></td>
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

<script type="text/javascript">
function doActiveSchoolUser(id,active) {
		$.ajax({
			type : 'POST',
			url : 'school/activate',
			data : 'id=' + id+'&active='+active,
			success : function(message) {
				window.location.href = "school";
				//$('#roleDeleteMsg').html("Deleted!");
			},
			error : function(e) {
				//$('#roleDeleteMsg').html("Failed!");
			}
		});
	}
</script>