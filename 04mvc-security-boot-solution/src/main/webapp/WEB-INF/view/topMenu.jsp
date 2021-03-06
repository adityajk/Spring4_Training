<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<script type="text/javascript">
	function signIn(){
		x=window.location.href;
		window.location.href='s'+x.substring(x.lastIndexOf("/"),x.length);
	}
</script>
<div class="header-container">
	<div id="headerSticky">
		<div class="stickyCenter">
			<div class="app-center">
				<h1>
					<a href="home.htm">Way2Learn</a>
				</h1>
				<div class="top-right">
					<div class="support">
						<c:url var="browseCourses" value="user/browseCourses.htm"/> 
						<a class="btn btn-green btn-login" href="${browseCourses}">Browse Courses</a>
						
					</div>
					<div class="support"></div>
					<div class="support"></div>
					<c:if test="${sessionScope.userDetails==null}">
						<div class="support"></div>
					<div class="support"></div>
					</c:if>
					<div class="support">
						<a href="${initParam.resourcePath}/../contactSupport.htm" style="color: black;">
							<i></i>
							<span class="small">Contact Support</span> 
							<span>${aboutUs.contactSupport}</span>
						</a>
					</div>
					
					
					<security:authorize access="authenticated" var="isAuthenticated" />
					
					<c:if test="${!isAuthenticated}">
					<c:url var="loginurl" value="/login/form" />
						<a id="signInLink" class="btn btn-green btn-login" href="${loginurl}">Sign In</a>
					</c:if>
					
				
					<c:if test="${isAuthenticated}">
						<c:url var="logouturl" value="/logout" />
						Welcome  <security:authentication property="name"/>
						<form action="${logouturl}" method="post">
						  <input type="submit" value="Log out"  class="btn btn-green btn-login" />
						  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</form>						
					</c:if>
					 
					
				</div>
			</div>
			<div id="main-nav" role="navigation">
				<div class="app-center">
					<ul id="menu-main" class="menu">
						<li class="menu-item">
							<a href="${initParam.resourcePath}/../home.htm" <c:if test='${activeLink=="home.htm"}'>class="active"</c:if>>
								<i class="home"></i>
								Home
							</a>
						</li>
						<li class="menu-item">
							<a href="${initParam.resourcePath}/../browseCourses.htm" <c:if test='${activeLink=="browseCourses.htm"}'>class="active"</c:if>>
								<i class="courses"></i>
								Courses
							</a>
							<div class="dropdown">
								<ol>
									<c:if test="${courses.size()!=0}">
										<c:forEach items="${courses}" var="course">
											<li><a href="${initParam.resourcePath}/../viewIndividualCourse.htm?courseId=${course.courseId}">${course.name}</a></li>
										</c:forEach>
									</c:if>
									<c:if test="${courses.size()==0}">
										Sorry No Courses to display
									</c:if>
								</ol>
							</div>
						</li>
						<li class="menu-item">
							<a href="${initParam.resourcePath}/../viewAllTrainings.htm">
								<i class="calendar"></i>
								Training Calendar
							</a>
						</li>
						<li class="menu-item">
							<a href="#" id="gallery">
								<i class="gallery"></i>
								Gallery
							</a>
						</li>
						<li class="menu-item">
							<a href="${initParam.resourcePath}/../contactSupport.htm" <c:if test='${activeLink=="contactSupport.htm" or activeLink=="aboutUs1.htm"}'>class="active"</c:if>>
								<i class="about"></i>
								Contact Us
							</a>
							<div class="dropdown">
								<ol>
									<li><a href="${initParam.resourcePath}/../contactSupport.htm">Contact Us</a></li>
									<li><a href="${initParam.resourcePath}/../aboutUs1.htm">About Us</a></li>
								</ol>
							</div>
						</li>
						<li class="menu-item">
							<a href="${initParam.resourcePath}/../allFaqs.htm" <c:if test='${activeLink=="allFaqs.htm"}'>class="active"</c:if>>
								<i class="faq"></i>
								FAQs
							</a>
							<div class="dropdown">
								<ol>
									<li><a href="${initParam.resourcePath}/../allFaqs.htm">FAQs</a></li>
									<li><a href="${initParam.resourcePath}/../privacyPolicy.htm">Privacy Policy</a></li>
									<li><a href="${initParam.resourcePath}/../cancellationPolicy.htm">Cancellation Policy</a></li>
									<li><a href="${initParam.resourcePath}/../termsOfUse.htm">Terms Of Use</a></li>
									<li><a href="${initParam.resourcePath}/../knowHowToGetCourseForFree.htm">Courses For Free</a></li>
									<li><a href="${initParam.resourcePath}/../productsAndServices.htm">Products and Services</a></li>
									<li><a href="${initParam.resourcePath}/../flowOfPurchase.htm">Flow Of Purchase</a></li>
								</ol>
							</div>
						</li>
						<li class="menu-item">
							<a href="${initParam.resourcePath}/../requestInfo.htm" <c:if test='${activeLink=="requestInfo.htm"}'>class="active"</c:if>>
								<i class="request"></i>
								Request Info
							</a>
						</li>
						<c:if test="${sessionScope.SPRING_SECURITY_CONTEXT!=null}">
							<li class="menu-item">
								<a href="#">
									<i class="profile"><img alt="Img" src="${userDetails.imageLocation}" height="28" width="25"/></i>
									My Profile
								</a>
								<div class="dropdown">
									<ol>
										<li>
											<a href="#">Welcome ${userDetails.fullName}</a>
										</li>
										<li>
											<a id="viewAllMachineSecretes">Machine Secret</a>
										</li>
										<li>
											<a href="${initParam.resourcePath}/../s/myProfile.htm">My Profile</a>
										</li>
										<c:if test='${userDetails.role.contains("ROLE_ADMIN")}'>
											<li><a href="adm/allFunctionalities.htm">Administrator</a></li>
										</c:if>
										<li>
											<a href="${initParam.resourcePath}/../s/myCourses.htm">My Courses</a>
										</li>
										<li>
											<a href="${initParam.resourcePath}/../s/referFriends.htm">Refer Friends</a>
										</li>
										<li>
											<a href="#">${userDetails.email}</a>
										</li>
										<li>
											<a href="${initParam.resourcePath}/../logout.htm">Sing Out</a>
										</li>
									</ol>
								</div>
							</li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>