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
<form action="/signin" method="post">
    <input type="text" name="email">
    <input type="text" name="password">
    <input type="submit">
</form>

</body>
</html>
