<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<!-- <div class="generic-container" ng-controller="UserController as ctrl"> -->
	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tabmyprofile">
		<li class="active"><a href="#myprofile" role="tab"
			data-toggle="tab"> <icon class="fa fa-user"></icon> My Profile
		</a></li>
		<li><a href="#editprofile" role="tab" data-toggle="tab"> <icon
					class="glyphicon glyphicon-pencil"></icon> Edit Profile
		</a></li>
		<li><a href="#changepassword" role="tab" data-toggle="tab"> <icon
					class="glyphicon glyphicon-edit"></icon> Change Password
		</a></li>
	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
		<div class="tab-pane fade active in" id="myprofileTable">
			<div class="panel panel-default">
				<table class="row" id="myprofile">
					<tr class="form-group">
						<td class="col-md-2 control-label">Photo</td>
						<td><img src="../resources/no_image.jpg"
							class="img-thumbnail" alt="Cinque Terre" width="120"></td>
					</tr>
					<tr>
						<td class="col-md-2 control-label">Name</td>
						<td><span class="label label-default">${user.prefix}
								${user.firstname} ${user.lastname}</span></td>
					</tr>
					<tr>
						<td class="col-md-2 control-label">Email</td>
						<td><span class="label label-default">${user.email}</span></td>
					</tr>
				</table>
			</div>
		</div>

		<div class="tab-pane fade" id="changepassword">
			<jsp:directive.include file="changepassword.jsp" />
		</div>
		<div class="tab-pane fade" id="editprofile">
			<div class="panel panel-default">
				<div class="formcontainer">
					<!-- Row start -->
					<div class="row">
						<div class="col-md-12 col-sm-6 col-xs-12">

							<div class="panel-body">
								<form:form class="form-horizontal row-border" action="profile"
									method="post" commandName="user">

									<form:hidden path="id" value="${user.id}" />

									<div class="form-group">
										<label class="col-md-2 control-label">First Name</label>
										<div class="col-md-10">
											<form:select path="prefix" class="form-control"
												style="width: 80px; float: left; margin-right: 10px;">
												<form:option value="Mr" selected="selected">Mr.</form:option>
												<form:option value="Mrs">Mrs.</form:option>

											</form:select>
											<form:input path="firstname" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">Last Name</label>
										<div class="col-md-10">
											<form:input path="lastname" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">Email</label>
										<div class="col-md-10">
											<form:input path="email" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">Contact Number</label>
										<div class="col-md-10">
											<form:input path="contactNumber" class="form-control" />
										</div>
									</div>
									<div class="form-group" style="text-align: left;">
										<label class="col-md-2 control-label">Country</label>
										<div class="col-md-10">
											<form:select path="country"
												class="input-medium bfh-countries"
												data-country="${user.country}" style="height:35px;" />
											<!-- <select class="input-medium bfh-countries" data-country="US"></select> -->
											<%-- <div class="bfh-selectbox bfh-countries" data-country="${user.country}"
												data-flags="true">
												<form:hidden path="country"/>
												<input type="hidden" value="${user.country}" name="country"> <a
													class="bfh-selectbox-toggle" role="button"
													data-toggle="bfh-selectbox" href="#"> <span
													class="bfh-selectbox-option input-medium" data-option=""></span>
													<b class="caret"></b>
												</a>
												<div class="bfh-selectbox-options">
												<form:input path="country" class="bfh-selectbox-filter"/>
													<!-- <input type="text" class="bfh-selectbox-filter" -->
														<!-- name="country"> -->
													<div role="listbox">
														<ul role="option">
														</ul>
													</div>
												</div>
											</div> --%>


										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">City</label>
										<div class="col-md-10">
											<form:input path="city" class="form-control" />

										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">State</label>
										<div class="col-md-10">
											<form:input path="state" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-2 control-label">Zip</label>
										<div class="col-md-10">
											<form:input path="zip" class="form-control" />
										</div>
									</div>
									<div class="form-group">
										<form:button class="btn btn-primary btn-sm">Update</form:button>
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