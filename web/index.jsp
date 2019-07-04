<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript">
        function checkForm() {
            var pass = myForm.password.value;
            var confirmPass = myForm.rpassword.value;
            if (pass !== confirmPass) {
                alert("uncorrect confirm")
            }
        }
    </script>
</head>
<body>
<div align="center">
    <form action="/register" method="post" name="myForm" onsubmit="checkForm()">
        email<br><input type="text" name="email"><br>
        password<br> <input type="password" name="password"> <br>
        repeat password <br> <input name="rpassword" type="password"><br>
        <input type="submit" name="btn">
    </form>
</div>
</body>
</html>
