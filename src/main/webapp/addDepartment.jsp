<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Ajouter un department</title>
    </head>

    <body>
        <jsp:include page="header.jsp" />
        <div class="container mt-4 p-4">
            <section class="py-md-5 bg-light bg-gradient mt-4 mb-4">
                <h2 class="text-center mb-4">Ajouter un nouveau departement</h2>
                <form action="AddDep" method="post" class="w-50 mx-auto">
                    <input type="hidden" name="action" value="addDep" />
                    <div class="form-group">
                        <label for="name">Nom du département</label>
                        <input type="text" class="form-control" id="name" name="name" required
                            placeholder="Entrez le nom">
                    </div>
                    <button type="submit" class="btn btn-primary mt-3">Ajouter</button>
                </form>
            </section>
        </div>

    </body>

    </html>