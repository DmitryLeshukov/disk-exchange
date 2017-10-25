<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="/resource/css/registration.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="resource/js/registration.js"></script>
</head>
<body>

<div class="wrapper">

    <form id="reg-form" class="form-reg">
        <h2 class="form-reg-heading">Create your account</h2>
        <ul class="error"></ul>
        <div class="input-fields">
            <input name="login" type="text" class="form-control" placeholder="Login" autofocus/>
            <input name="lastName" type="text" class="form-control" placeholder="Last name"/>
            <input name="firstName" type="text" class="form-control" placeholder="First name"/>
            <input name="middleName" type="text" class="form-control" placeholder="Middle name"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <input name="passwordConfirm" type="password" class="form-control" placeholder="Confirm your password"/>
        </div>
        <button class="btn btn-lg btn-primary btn-block">Submit</button>
    </form>

</div>
</body>
</html>
