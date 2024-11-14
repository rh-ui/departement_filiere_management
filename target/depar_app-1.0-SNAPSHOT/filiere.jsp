<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
    <html>

    <head>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Filieres</title>

        </head>

    </head>

    <body>


        <jsp:include page="header.jsp" />

        <div class="container mt-4 p-4">
            <section class="py-md-5 bg-light bg-gradient mt-4 mb-4">
                <h2 class="text-center mb-4">Filieres</h2>
                <a href="Addfil" class="btn btn-primary mb-3">Ajouter une nouvelle filiere</a>
                <div class="table-responsive p-4">
                    <table class="table table-bordered table-striped table-hover">
                        <thead class="thead-dark">
                            <tr>
                                <th>ID</th>
                                <th>Nom</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="filiere" items="${filieres}">
                                <tr>
                                    <td>${filiere.code}</td>
                                    <td>${filiere.nom}</td>
                                    <td>
                                        <a href="Addfil?idEdit=${filiere.code}" class="btn btn-sm btn-warning">Edit</a>
                                        <button type="button" class="btn btn-sm btn-danger" data-bs-toggle="modal"
                                            data-bs-target="#deleteModal-${filiere.code}">Delete</button>
                                            <!-- Modal -->
                                            <div class="modal fade" id="deleteModal-${filiere.code}" tabindex="-1"
                                                aria-labelledby="deleteModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="btn-close"
                                                                data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-body">
                                                            Voulez vous vraiment supprimer cette filiere !!
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary"
                                                                data-bs-dismiss="modal">Fermer</button>
                                                            <a href="Addfil?idDelete=${filiere.code}" class="btn btn-danger">Supprimer</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
            </section>
        </div>

        <script>
            const myModal = document.getElementById('myModal')
            const myInput = document.getElementById('myInput')

            myModal.addEventListener('shown.bs.modal', () => {
                myInput.focus()
            })
        </script>

    </body>

    </html>