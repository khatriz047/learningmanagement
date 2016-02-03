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
			<security:authorize access="hasRole('PROFESSOR')">
				<li class="active"><a
					href="${pageContext.request.contextPath}/professor"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-dashboard fa-stack-1x "></i></span> Dashboard</a></li>
			</security:authorize>
			<security:authorize access="hasRole('STUDENT')">
				<li class="active"><a
					href="${pageContext.request.contextPath}/student"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-dashboard fa-stack-1x "></i></span> Dashboard</a></li>
			</security:authorize>
			<li class="active"><a
				href="${pageContext.request.contextPath}/profile"><span
					class="fa-stack fa-lg pull-left"><i
						class="glyphicon glyphicon-user fa-stack-1x "></i></span>Profile</a></li>
			<security:authorize access="hasRole('ADMIN')">
				<li class="active"><a
					href="${pageContext.request.contextPath}/admin/role"><span
						class="fa-stack fa-lg pull-left"><i
							class="glyphicon glyphicon-lock fa-stack-1x "></i></span> Role</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/admin/user"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-cloud-download fa-stack-1x "></i></span>User</a></li>

				<li class="active"><a
					href="${pageContext.request.contextPath}/admin/schedular"><span
						class="fa-stack fa-lg pull-left"><i
							class="glyphicon glyphicon-repeat fa-stack-1x "></i></span>Schedular</a></li>
			</security:authorize>

			<security:authorize access="hasRole('STUDENT')">
				<li class="active"><a
					href="${pageContext.request.contextPath}/student/resource"><span
						class="fa-stack fa-lg pull-left"><i
							class="glyphicon glyphicon-folder-open fa-stack-1x "></i></span>Resource</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/student/discussion"><span
						class="fa-stack fa-lg pull-left"><i
							class="glyphicon glyphicon-transfer fa-stack-1x "></i></span>Discussion</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/student/message"><span
						class="fa-stack fa-lg pull-left"><i
							class="glyphicon glyphicon-envelope fa-stack-1x "></i></span>Message</a></li>
			</security:authorize>

			<security:authorize access="hasRole('SCHOOL')">

				<li class="active"><a
					href="${pageContext.request.contextPath}/school/faculty"> <span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-cart-plus fa-stack-1x "></i></span>Faculty
				</a></li>

				<li class="active"><a
					href="${pageContext.request.contextPath}/school/course"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-wrench fa-stack-1x "></i></span>Courses</a></li>

				<li class="active"><a
					href="${pageContext.request.contextPath}/school/professor"><span
						class="fa-stack fa-lg pull-left"><i
							class="fa fa-wrench fa-stack-1x "></i></span>Professors</a></li>
			</security:authorize>

			<security:authorize access="hasRole('PROFESSOR')">
				<li class="active"><a
					href="${pageContext.request.contextPath}/professor/student"><span
						class="fa-stack fa-lg pull-left"><i
							class="glyphicon glyphicon-education fa-stack-1x"></i></span>Students</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/professor/resource"><span
						class="fa-stack fa-lg pull-left"><i
							class="glyphicon glyphicon-folder-open fa-stack-1x "></i></span>Resource</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/professor/discussion"><span
						class="fa-stack fa-lg pull-left"><i
							class="glyphicon glyphicon-transfer fa-stack-1x "></i></span>Discussion</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/professor/message"><span
						class="fa-stack fa-lg pull-left"><i
							class="glyphicon glyphicon-envelope fa-stack-1x "></i></span>Message</a></li>
			</security:authorize>

			<li class="active"><a
				href="${pageContext.request.contextPath}/setting"><span
					class="fa-stack fa-lg pull-left"><i
						class="fa fa-cog fa-stack-1x "></i></span>Setting</a></li>

			<li class="active"><a
				href="${pageContext.request.contextPath}/help"><span
					class="fa-stack fa-lg pull-left"><i
						class="glyphicon glyphicon-header fa-stack-1x "></i></span>Help</a></li>
		</ul>
	</div>
</div>