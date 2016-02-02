<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<div>
	<!-- Sidebar -->
	<div id="sidebar-wrapper">
		<ul class="sidebar-nav nav-pills nav-stacked" id="menu">
			<security:authorize access="hasRole('SCHOOL')">
				<li class="active"><a
					href="${pageContext.request.contextPath}/school"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-dashboard fa-stack-1x "></i></span> Dashboard</a></li>
			</security:authorize>
			<security:authorize access="hasRole('ADMIN')">
				<li class="active"><a
					href="${pageContext.request.contextPath}/admin"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-dashboard fa-stack-1x "></i></span> Dashboard</a></li>
			</security:authorize>
			<li class="active"><a
				href="${pageContext.request.contextPath}/profile"><span
					class="fa-stack fa-lg pull-left"><i
						class="fa fa-user fa-stack-1x "></i></span>Profile</a></li>
			<security:authorize access="hasRole('ADMIN')">
				<li class="active"><a
					href="${pageContext.request.contextPath}/admin/role"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa glyphicon glyphicon-lock fa-stack-1x "></i></span> Role</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/admin/user"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-cloud-download fa-stack-1x "></i></span>User</a></li>
			</security:authorize>

			<security:authorize access="hasRole('STUDENT')">
			</security:authorize>

			<security:authorize access="hasRole('SCHOOL')">

				<li class="active"><a
					href="${pageContext.request.contextPath}/school/faculty"> <span
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
						class="fa fa-cog fa-stack-1x "></i></span>Setting</a></li>

			<li class="active"><a href="#"><span
					class="fa-stack fa-lg pull-left"><i
						class="fa fa-cog fa-stack-1x "></i></span>Help</a></li>
		</ul>
	</div>
</div>