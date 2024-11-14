<html>

<body>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <!DOCTYPE html>
        <html lang="fr">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Login Page</title>
            <!-- Lien vers le CSS de Bootstrap -->
            <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        </head>

        <body class="bg-light">

            

            <div class="container">
                <div class="row justify-content-center mt-5">
                    <div class="col-md-4">
                        <div class="card shadow-sm">
                            <div class="card-body">
                                <h3 class="card-title text-center mb-4">Se connecter</h3>

                                <form action="<%= request.getContextPath() %>/auth" method="post">
                                    <div class="form-group">
                                        <label for="username">Nom d'utilisateur</label>
                                        <input type="text" id="username" name="username" class="form-control" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="password">Mot de passe</label>
                                        <input type="password" id="password" name="password" class="form-control"
                                            required>
                                    </div>
                                    <!-- Bouton de connexion -->
                                    <button type="submit" class="btn btn-primary btn-block mt-4">Se connecter</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Scripts JS de Bootstrap -->
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        </body>

        </html>

</body>

</html>