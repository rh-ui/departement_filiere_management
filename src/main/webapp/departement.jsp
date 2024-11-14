<b%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <html>

    <head>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Departments</title>

        </head>

    </head>

    <body>


        <jsp:include page="header.jsp" />

        <div class="container mt-4 p-4">
            <section class="py-md-5 bg-light bg-gradient mt-4 mb-4">
                <h2 class="text-center mb-4">Departments</h2>
                <a href="AddDep" class="btn btn-primary mb-3">Ajouter un nouveau department</a>
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
                            <c:forEach var="department" items="${departments}">
                                <tr>
                                    <td>${department.idDep}</td>
                                    <td>${department.nom}</td>
                                    <td>
                                        <a href="AddDep?idEditDep=${department.idDep}"
                                            class="btn btn-sm btn-warning">Edit</a>
                                        <button type="button" class="btn btn-sm btn-danger" data-bs-toggle="modal"
                                            data-bs-target="#deleteModal-${department.idDep}">Delete</button>
                                        <!-- Modal -->
                                        <div class="modal fade" id="deleteModal-${department.idDep}" tabindex="-1"
                                            aria-labelledby="deleteModalLabel" aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                            aria-label="Close"></button>
                                                    </div>
                                                    <div class="modal-body text-center">
                                                        Voulez vous vraiment supprimer le departement : ${department.nom} !
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary"
                                                            data-bs-dismiss="modal">Fermer</button>
                                                        <a href="AddDep?idDeleteDep=${department.idDep}"
                                                            class="btn btn-danger">Supprimer</a>
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