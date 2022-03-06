<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="css/login.css">
    <title>Login</title>
</head>
<body>
    <div id="logreg-forms">
        <form action="login" class="form-signin" method="post">
            <h1 class="h3 mb-3" style="text-align: center"> Sign in</h1>
            <h5 class="mt-4 mb-2">Username</h5>
            <input type="text" name="user" class="form-control" placeholder="Account" required="" autofocus="">
            <h5 class="mt-4 mb-2">Password</h5>
            <input type="password" name="password" class="form-control" placeholder="Password" required="">

            <button class="btn btn-success btn-block mt-4" type="submit">
                <i class="fas fa-sign-in-alt"></i> Sign in
            </button>
        </form>
        <br>
    </div>

</body>
</html>