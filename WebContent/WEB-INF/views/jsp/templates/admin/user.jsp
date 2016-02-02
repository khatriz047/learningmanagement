<div class="container">

	<!-- Nav tabs -->
	<ul class="nav nav-tabs" role="tablist">
		<li class="active"><a href="#adminlist" role="tab"
			data-toggle="tab"> <icon class="glyphicon glyphicon-th-list"></icon>
				Admin List
		</a></li>
		<li><a href="#adduseradmin" role="tab" data-toggle="tab"> <icon
					class="glyphicon glyphicon-plus"></icon> Add Admin
		</a></li>
		<li><a href="#schoollist" role="tab" data-toggle="tab"> <icon
					class="glyphicon glyphicon-th-list"></icon> School List
		</a></li>

		<li><a href="#adduserschool" role="tab" data-toggle="tab"> <icon
					class="glyphicon glyphicon-plus"></icon> Add School
		</a></li>
	</ul>

	<!-- Tab panes -->
	<div class="tab-content">
		<div class="tab-pane fade active in" id="adminlist">
			<jsp:directive.include file="listAdmin.jsp" />
		</div>
		<div class="tab-pane fade" id="schoollist">
			<jsp:directive.include file="listSchool.jsp" />
		</div>
		<div class="tab-pane fade" id="adduseradmin">
			<jsp:directive.include file="addAdminUser.jsp" />
		</div>
		<div class="tab-pane fade" id="adduserschool">
			<jsp:directive.include file="addSchoolUser.jsp" />
		</div>
	</div>

</div>