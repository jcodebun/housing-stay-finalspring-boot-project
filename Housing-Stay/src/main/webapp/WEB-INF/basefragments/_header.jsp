<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<nav class="navbar navbar-expand-lg bgcolor"
	style="height: 59px;">
	<div class="container-fluid">
		<img height="40px" width="60px" src="${pageContext.request.contextPath}/resources/images/eco-friendly-home-features-neutrino-burst.jpg"/> &nbsp;  &nbsp; <a class="navbar-brand " href="#"
			style="font-size: 26px; font-family: serif; color: white;"> 
			<span>  Housing-Stay</span>
		</a>

		<form class="container-fluid">
			
		</form>

		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			<c:if test="${sessionScope.user != null}">
				<span class="navbar-text"
					style="color: white; font-size: 14px; font-variant-caps: petite-caps;">
					Hello,${sessionScope.user.firstName}</span>
			</c:if>
			<c:if test="${sessionScope.user == null}">
				<span class="navbar-text"
					style="color: white; font-size: 14px; font-variant-caps: petite-caps;">
					Hello,SignIn </span>
			</c:if>
			</ul>
			
		</div>
	</div>
</nav>
<div class="shadow bg-body rounded">
	<nav class="navbar navbar-expand-lg "
		style="height: 39px; background-color: #0d3c07;">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item linkSize"><a
						class="nav-link active link-light" aria-current="page"
						href="<c:url value="/welcome"/>">Home</a></li>
					<c:if test="${sessionScope.user != null}">
						<c:if test="${sessionScope.user.roleId == 1}">
						
								
								<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/help/search"/>">Help Report</a></li>
								
								<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/feedBack"/>">Add FeedBack</a></li>
								
								<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/feedBack/search"/>">FeedBack Questions</a></li>
								
									<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/userFeedBack/search"/>">User FeedBack</a></li>
				
							
						</c:if>

						<c:if test="${sessionScope.user.roleId == 2}">

							<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/homeStay/search"/>">HomeStays</a></li>
								
							<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/tourPackage/search"/>">Tour Packages</a></li>
								
								<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/bookStay/search"/>">HomeStay Booking</a></li>
								
									<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/bookTour/search"/>">Tour Booking</a></li>
								<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/help"/>">Help</a></li>
								
								<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/help/search"/>">Help Report</a></li>
									
										<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/feedBack/search"/>">FeedBack Questions</a></li>
							
						</c:if>
						
						<c:if test="${sessionScope.user.roleId == 3}">

							<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/homeStay"/>">Add Home Stay</a></li>
								
							<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/homeStay/search"/>">HomeStay List</a></li>
								
								<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/tourPackage"/>">Add TourPackage</a></li>
								
							<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/tourPackage/search"/>">Tour Package List</a></li>
								
								<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/room"/>">Add Room</a></li>
								
							
								
								<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/bookStay/search"/>">HomeStay Booking</a></li>
								
								<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/bookTour/search"/>">Tour Booking</a></li>
								
								<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/help"/>">Help</a></li>
								
								<li class="nav-item linkSize"><a class="nav-link link-light"
								href="<c:url value="/ctl/help/search"/>">Help Report</a></li>
								
							
								
						</c:if>
					</c:if>
					<c:if test="${sessionScope.user == null }">
						<li class="nav-item linkSize"><a class="nav-link link-light"
							href="<c:url value="/aboutUs"/>">AboutUs</a></li>
						<li class="nav-item linkSize"><a class="nav-link link-light"
							href="<c:url value="/contactUs"/>">ContactUs</a></li>
					</c:if>
				</ul>
			</div>
			<ul class="nav justify-content-end">
				<c:if test="${sessionScope.user != null }">

					<li class="nav-item linkSize"><a class="nav-link link-light"
						style="padding: 6px;" href="<c:url value="/profile"/>">My
							Profile</a></li>
					<li class="nav-item linkSize"><a class="nav-link link-light"
						style="padding: 6px;" href="<c:url value="/changepassword"/>">Change
							Password</a></li>

					<li class="nav-item linkSize"><a class="nav-link link-light"
						style="padding: 6px;" href="<c:url value="/login"/>">Logout</a></li>
				</c:if>
				<c:if test="${sessionScope.user == null}">
					<li class="nav-item linkSize"><a class="nav-link link-light"
						style="padding: 6px;" href="<c:url value="/login"/>">SignIn</a></li>
					<li class="nav-item linkSize"><a class="nav-link link-light"
						style="padding: 6px;" href="<c:url value="/signUp"/>">	SignUp</a></li>
				</c:if>

			</ul>
		</div>
	</nav>
</div>
