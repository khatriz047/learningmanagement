<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="generic-container" ng-controller="UserController as ctrl">
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li class="active"><a href="#list" role="tab" data-toggle="tab">
					<icon class="glyphicon glyphicon-list-alt"></icon>Role List
			</a></li>
			<li><a href="#add" role="tab" data-toggle="tab"> <icon
						class="glyphicon glyphicon-plus"></icon>Add Role
			</a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content">
			<div class="tab-pane fade active in" id="list">
				<div class="panel panel-default">
					<div class="tablecontainer">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>ID.</th>
									<th>Name</th>
									<th width="20%"></th>
								</tr>
							</thead>
							<tbody>
								<tr ng-repeat="u in ctrl.users">
									<td><span ng-bind="u.id"></span></td>
									<td><span ng-bind="u.username"></span></td>
									<td>
										<button type="button" ng-click="ctrl.edit(u.id)"
											class="btn btn-success custom-width">Edit</button>
										<button type="button" ng-click="ctrl.remove(u.id)"
											class="btn btn-danger custom-width">Remove</button>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="tab-pane fade" id="add">
				<div class="panel panel-default">
					<div class="formcontainer">
						<form ng-submit="ctrl.submit()" name="userForm"
							class="form-horizontal">
							<input type="hidden" ng-model="ctrl.user.id" />
							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-2 control-lable" for="uname">Name</label>
									<div class="col-md-7">
										<input type="text" ng-model="ctrl.user.username" id="uname"
											class="username form-control input-sm"
											placeholder="Enter your name" required ng-minlength="3" />
										<div class="has-error" ng-show="userForm.$dirty">
											<span ng-show="userForm.uname.$error.required">This is
												a required field</span> <span
												ng-show="userForm.uname.$error.minlength">Minimum
												length required is 3</span> <span ng-show="userForm.uname.$invalid">This
												field is invalid </span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-2 control-lable" for="address">Address</label>
									<div class="col-md-7">
										<input type="text" ng-model="ctrl.user.address" id="address"
											class="form-control input-sm"
											placeholder="Enter your Address" />
									</div>
								</div>
							</div>


							<div class="row">
								<div class="form-actions floatRight">
									<input type="submit"
										value="{{!ctrl.user.id ? 'Add' : 'Update'}}"
										class="btn btn-primary btn-sm" ng-disabled="userForm.$invalid">
									<button type="button" ng-click="ctrl.reset()"
										class="btn btn-warning btn-sm"
										ng-disabled="userForm.$pristine">Reset Form</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>



	</div>
</div>

