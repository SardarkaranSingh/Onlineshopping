<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>





<html lang="en">
<head>
  <title>Registration</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  

</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp"></jsp:include>

<div class="container">
  <h2>Registration form</h2>
  
  <div class="col-lg-12">
  <div class="row">
  <form:form modelAttribute="user" action="saveRegister" method="post">
  
  
  <div class="form-group">
  <label>Email:</label><br>
  <form:input path="email"class="form-control" placeholder="Enter email"/>
  </div>
  
   <div class="form-group">
  <label>Name:</label><br>
  <form:input path="name"class="form-control" placeholder="Enter Name"/>
  </div>
  
 
  <div class="form-group">
  <label>Password:</label><br>
  <form:input path="passwrod"type="password" class="form-control" placeholder="Enter password"/>
  </div>
  
  <div class="form-group">
  <label>Address:</label><br>
  <form:input path="addresss"class="form-control" placeholder="Enter address"/>
    </div>
  
   <div class="form-group">
  <label>Phone:</label><br>
  <form:input path="phone"class="form-control" placeholder="Enter phone"/>
    </div>
  
  
  
  
  <br><br>
  <button type="submit" class="btn btn-lg btn-info">SUBMIT</button>
  
  <button type="reset" class="btn btn-lg btn-info">RESET</button>
  
  
  
   
   
  
  
  
  </form:form>
</div>
  </div>
  </div>
    
    

</body>
</html>
