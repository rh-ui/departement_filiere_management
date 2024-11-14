<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Ajouter une filiere</title>
        </head>

        <body>
            <jsp:include page="header.jsp" />

            <div class="container mt-4 p-4">
                <section class="py-md-5 bg-light bg-gradient mt-4 mb-4">
                    <h2 class="text-center mb-4">Modifier une filiere</h2>
                    <form action="Addfil" method="post" class="w-50 mx-auto">

                        <input type="hidden" name="idEdit" value="${filiere.code}" />
                        <input type="hidden" name="action" value="edit" />

                        <div class="form-group">
                            <label for="name">Nom de filiere</label>
                            <input type="text" class="form-control p-2" id="name" name="name" required
                                placeholder="${filiere.nom}">
                        </div>
                        <div class="form-group">
                            <label for="idDep">Departement</label>
                            <select class="form-control" id="idDep" name="idDep" required>
                                <c:forEach var="department" items="${departmentsList}">
                                    <option value="${department.idDep}">${department.nom}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary mt-3">Modifier</button>
                    </form>
                </section>
            </div>

        </body>

        </html>