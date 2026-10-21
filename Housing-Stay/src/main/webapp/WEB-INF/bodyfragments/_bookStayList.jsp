<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/ctl/bookStay" />

<c:url var="addSearch" value="/ctl/bookStay/search" />

<c:url var="editUrl" value="/ctl/bookStay?id=" />

<c:url var="statusUrl" value="/ctl/bookStay/status" />

<br>
<div class="container"> 
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item linkSize"><i class="fas fa-tachometer-alt"></i> <a class="link-dark" href="<c:url value="/home"/>">Home</a></li>
    <li class="breadcrumb-item linkSize active" aria-current="page"> <i class="fa fa-arrow-right" aria-hidden="true"></i>Book Stay List</li>
  </ol>
</nav>
</div>
<hr>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/ctl/bookStay/search"
		modelAttribute="form">
		<div class="card">
			<h5 class="card-header bgcolor"
				style="color: white;">BookStay List</h5>
			<div class="card-body">
				<div class="row g-3">
					
					<s:bind path="bookingNo">
						<div class="col">
							<sf:input path="${status.expression}" class="form-control form-control-sm"
								placeholder="Search By Booking No" />
						</div>
					</s:bind>
					
					<s:bind path="date">
						<div class="col">
							<sf:input path="${status.expression}" id="datepicker1" class="form-control form-control-sm"
								placeholder="Search By To Date" />
						</div>
					</s:bind>
					
					<s:bind path="fromDate">
						<div class="col">
							<sf:input path="${status.expression}" id="datepicker" class="form-control form-control-sm"
								placeholder="Search By From Date" />
						</div>
					</s:bind>
					
					
					
					
					
					<div class="col">
						<input type="submit" class="btn btn-sm btn-outline-primary"
							name="operation" value="Search"></input> or <input type="submit"
							class="btn btn-sm btn-outline-secondary" name="operation"
							value="Reset">
					</div>
				</div>
				<b><%@ include file="businessMessage.jsp"%></b>
				<br>
				<sf:input type="hidden" path="pageNo" />
				<sf:input type="hidden" path="pageSize" />

				<sf:input type="hidden" path="listsize" />
				<sf:input type="hidden" path="total" />
				<sf:input type="hidden" path="pagenosize" />
<div id="examples">
				<table class="table table-bordered border-primary">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Booking No</th>
							<th scope="col">Name</th>
							<th scope="col">Home Stay</th>
							<th scope="col">Room No</th>
							<th scope="col">Booking Date</th>
							<th scope="col">CheckIn</th>
							<th scope="col">CheckOut</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="bk" varStatus="bookStay">
							<tr>
								<td scope="row">${bookStay.index+1}</td>
								<td scope="row">${bk.bookingNo}</td>
								<td scope="row">${bk.user.firstName} ${bk.user.lastName}</td>
								<td scope="row">${bk.homeStay.name}</td>
								<td scope="row">${bk.roomNo}</td>
								<td scope="row">${bk.bookingDate}</td>
								<td scope="row">${bk.checkIn}</td>
								<td scope="row">${bk.checkOut}</td>
						</c:forEach>
					</tbody>
				</table>
				</div>
				<div class="clearfix">
			<c:if test="${sessionScope.user.roleId == 3}">
				<a href="#" class="btn btn-warning float-start" id="print" onclick="printContent('examples')">Print</a>
				</c:if>
			<nav aria-label="Page navigation example float-end">
				<ul class="pagination justify-content-end" style="font-size: 13px">
					<li class="page-item"><input type="submit" name="operation"
								class="page-link" 	<c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
								value="Previous"></li>
								 <c:forEach var = "i" begin = "1" end = "${(listsize/10)+1}">
								 <c:if test="${i== pageNo}">
								<li class="page-item active"><a class="page-link activate" href="${addSearch}?pageNo=${i}">${i}</a></li>
								</c:if>
								<c:if test="${i != pageNo}">
								<li class="page-item"><a class="page-link" href="${addSearch}?pageNo=${i}">${i}</a></li>
								</c:if>
								</c:forEach>
					<li class="page-item"><input type="submit" name="operation"
								class="page-link" <c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>
								value="Next"></li>
				</ul>
			</nav>
			</div>
			</div>
		</div>
	</sf:form>
