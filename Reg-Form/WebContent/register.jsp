<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<style>  
body{  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: pink;  
}  
.container {  
    padding: 50px;  
  background-color: lightblue;  
}  
  
input[type=text], input[type=password], textarea {  
  width: 100%;  
  padding: 15px;  
  margin: 5px 0 22px 0;  
  display: inline-block;  
  border: none;  
  background: #f1f1f1;  
}  
input[type=text]:focus, input[type=password]:focus {  
  background-color: orange;  
  outline: none;  
}  
 div {  
            padding: 10px 0;  
         }  
hr {  
  border: 1px solid #f1f1f1;  
  margin-bottom: 25px;  
}  
.registerbtn {  
  background-color: #4CAF50;  
  color: white;  
  padding: 16px 20px;  
  margin: 8px 0;  
  border: none;  
  cursor: pointer;  
  width: 100%;  
  opacity: 0.9;  
}

.view-user-btn{  
    padding: 10px 20px;
    font-size: 16px;
    font-weight: bold;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    cursor: pointer;
    border: 2px solid #3498db;
    color: red;
    border-radius: 5px;
    transition: background-color 0.3s, color 0.3s;
    float: right; /* Align to the right */
}    
.registerbtn:hover {  
  opacity: 1;  
}  
</style>  
</head>  
<body>
   <button class="view-user-btn" onclick="redirectToAnotherJSP()">View User</button>
   <form action="RegisterServlet" method="post" onsubmit="showAlert()">  
  <div class="container">  
  <center>  <h1>  Registeration Form</h1> </center>  
 
   
  <hr>  
  <label> Firstname </label>   
<input type="text" name="fname" id="fname" placeholder= "Firstname" size="15" required />   
 
<label> Lastname: </label>    
<input type="text" name="lname"  id="lname" placeholder="Lastname" size="15"required />   
<div>  
<label>   
Caste :  
</label>   
  
<select id="caste" name="caste" required>  
<option value="SC">SC</option>  
<option value="ST">ST</option>  
<option value="OBC">OBC</option>  
<option value="OPEN">OPEN</option>  
 
</select>  
</div>  
<div>  
<label>   
Gender :  
</label><br>  
<input type="radio" value="Male" id="male" name="gender" checked > Male   
<input type="radio" value="Female"  id="female" name="gender"> Female   
<input type="radio" value="Other" id="other" name="gender"> Other  
  
</div>  


 <label for="email"><b>Email</b></label>  
 <input type="text" id = "email" placeholder="Enter Email" name="email" required>  
  
    
  
    
    <button type="submit" class="registerbtn" value="Register">Register</button>    
</form>  

<script>
    function redirectToAnotherJSP() {
        // Replace 'path/to/your/another.jsp' with the actual path to your JSP file
        window.location.href = 'displayData.jsp';
    }
</script>



</body>
</html>