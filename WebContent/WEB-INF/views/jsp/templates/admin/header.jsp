<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="headerLeft" style="text-align: right;color: green;">
	Dear <strong>${username}</strong>, Welcome to Admin Page.
	<a href="<c:url value="/logout" />">Logout</a>
</div>