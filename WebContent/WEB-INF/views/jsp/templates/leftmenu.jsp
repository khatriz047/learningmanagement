<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<div>
	<!-- Sidebar -->
	<div id="sidebar-wrapper">
		<ul class="sidebar-nav nav-pills nav-stacked" id="menu">
			<li class="active"><a href="#"><span
					class="fa-stack fa-lg pull-left"><i
						class="fa fa-dashboard fa-stack-1x "></i></span> Dashboard</a> <!-- <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="#">link1</a></li>
                        <li><a href="#">link2</a></li>
                    </ul> --></li>

			<li class="active"><a href="${pageContext.request.contextPath}/admin/profile"><span
					class="fa-stack fa-lg pull-left"><i
						class="fa fa-user fa-stack-1x "></i></span>Profile</a></li>
			<security:authorize access="hasRole('ADMIN')">
				<li class="active"><a
					href="${pageContext.request.contextPath}/admin/role"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-flag fa-stack-1x "></i></span> Role</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/admin/school"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-cloud-download fa-stack-1x "></i></span>School</a></li>
			</security:authorize>

			<security:authorize access="hasRole('STUDENT')">
			</security:authorize>

			<security:authorize access="hasRole('SCHOOL')">

				<li class="active"><a href="#"> <span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-cart-plus fa-stack-1x "></i></span>Faculty
				</a></li>

				<li class="active"><a href="#"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-wrench fa-stack-1x "></i></span>Courses</a></li>
			</security:authorize>

			<security:authorize access="hasRole('PROFESSOR')">
				<li class="active"><a
					href="${pageContext.request.contextPath}/admin/user"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-youtube-play fa-stack-1x "></i></span>Users</a></li>
			</security:authorize>

			<li class="active"><a href="#"><span
					class="fa-stack fa-lg pull-left"><i
						class="fa fa-server fa-stack-1x "></i></span>Help</a></li>
		</ul>
	</div>
</div>