<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!-- Topbar -->
<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

	<!-- Sidebar Toggle (Topbar) -->
	<button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
		<i class="fa fa-bars"></i>
	</button>
	
	<!-- Topbar Language Switch -->
	
	<div class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" id="languagesCFN" data-cfn-locale="${pageContext.response.locale}">
		<div class="input-group">
			<c:choose>
				<c:when test="${pageContext.response.locale == 'en'}">
					<a onclick="event.preventDefault(); languageUri('?language=el');" href="store/dashboard?language=el" class="d-sm-inline-block btn btn-sm underline">Ελληνικά</a>
					<a class="d-sm-inline-block btn btn-sm bold disabled">English</a>
				</c:when>    
				<c:otherwise>
					<a class="d-sm-inline-block btn btn-sm bold disabled">Ελληνικά</a>
					<a onclick="event.preventDefault(); languageUri('?language=en');" href="store/dashboard?language=en" class="d-sm-inline-block btn btn-sm underline">English</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<!-- Topbar Navbar -->
	<ul class="navbar-nav ml-auto">

		<div class="topbar-divider d-none d-sm-block"></div>

		<!-- Nav Item - User Information -->
		<li class="nav-item dropdown no-arrow">
			<a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<span class="mr-2 d-none d-lg-inline text-gray-600 small">${currentUser.storename}</span>
				<img class="img-profile rounded-circle" src="${currentUser.logo}">
			</a>
			<!-- Dropdown - User Information -->
			<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
				<a class="dropdown-item" id="userMenuLogoutCFN" href="store/dashboard/logout" data-toggle="modal" data-target="#logoutModal">
					<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
					<spring:message code="logout"/>
				</a>
				<a class="dropdown-item" href="store/dashboard/profile">
					<i class="fas fa-store fa-sm fa-fw mr-2 text-gray-400"></i>
					<spring:message code="profile"/>
				</a>
			</div>
		</li>

	</ul>

</nav>
<!-- End of Topbar -->

