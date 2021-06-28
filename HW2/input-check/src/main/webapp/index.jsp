
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="style.css" />
    <title>Input Validation</title>
</head>
<body>
<h1>Input Validation using <a href="https://www.sitepoint.com/basic-jquery-form-validation-tutorial/">JQuery</a></h1>
<div class="container">
    <h2>Registration</h2>
    <form action="avatar-servlet" method="post">
        <label for="firstname">First Name</label>
        <input type="text" name="firstname" id="firstname" />

        <label for="lastname">Last Name</label>
        <input type="text" name="lastname" id="lastname" />

        <label for="age">Age</label>
        <input type="number" name="age" id="age" />

        <label for="email">Email</label>
        <input type="email" name="email" id="email" />

        <label for="password">Password</label>
        <input type="password" name="password" id="password" />


        <button name="register">Register</button>


    </form>
</div>
</body>
<script src="form-validation.js"></script>
</html>