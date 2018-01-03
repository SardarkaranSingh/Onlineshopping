<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
  <title>khanjar's of all kind</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<h2>Registration Form</h2>
<div class="col-sm-8">
<div class="row">

<form:form modelAttribute="user" action="saveRegister" method="post">
<div class= "form-group">
<label>Email:</label>
<form:input path="email" class="form-conrol placeholder="Enter Email"/>
</div>

<div class= "form-group">
<label>Name:</label>
<form:input path="name" class="form-conrol placeholder="Enter Name"/>
</div>

<div class= "form-group">
<label>Password:</label>
<form:input path="password" class="form-conrol placeholder="Enter Password"/>
</div>

<div class= "form-group">
<label>Address:</label>
<form:input path="address" class="form-conrol placeholder="Enter Addresss"/>
</div>

<div class= "form-group">
<label>Phone:</label>
<form:input path="phone" class="form-conrol placeholder="Enter Phone"/>
</div>

<br><br>
<button type="submit" class="btn btn-lg btn-Primary">SUBMIT</button>
<button type="reset" class="btn btn-lg btn-Primary">CANCEL</button>
</form:form>

</div>
</div>
</div>
</body>
</html>