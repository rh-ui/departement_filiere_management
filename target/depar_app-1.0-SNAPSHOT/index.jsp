<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Page d'accueil</title>


        </head>

        <body>

            <jsp:include page="header.jsp" />

            <div class="container mt-4 p-4">
                <section class="py-md-5 bg-light bg-gradient mt-4 mb-4">
                    <div class="">
                        <div class="row justify-content-center">
                            <div class="col-12 col-lg-10 col-xxl-7">
                                <div class="row gy-4">

                                    <!-- ******************** DEPARTEMENTS **************************** -->
                                    <div class="col-12 col-sm-6" id="departement">
                                        <div class="card widget-card border-light shadow-sm">
                                            <div class="card-body p-4">
                                                <div class="row">
                                                    <div class="col-8">
                                                        <a class="link-dark link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover"
                                                            href="<%= request.getContextPath() %>/depController">
                                                            <h5 class="card-title mb-3">Departements</h5>
                                                        </a>
                                                    </div>
                                                    <div class="col-4">
                                                        <div class="d-flex justify-content-end">
                                                            <div
                                                                class="lh-1 text-white bg-primary rounded-circle p-3 d-flex align-items-center justify-content-center">
                                                                <i class="fas fa-building"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- ********************** FILIERE ************************** -->
                                    <div class="col-12 col-sm-6" id="AnalyseSommeil">
                                        <div class="card widget-card border-light shadow-sm">
                                            <div class="card-body p-4">
                                                <div class="row">
                                                    <div class="col-8">
                                                        <a class="link-dark link-offset-2 link-offset-3-hover link-underline link-underline-opacity-0 link-underline-opacity-75-hover"
                                                            href="<%= request.getContextPath() %>/filController">
                                                            <h5 class="card-title widget-card-title mb-3">
                                                                Filiere
                                                            </h5>
                                                        </a>
                                                    </div>
                                                    <div class="col-4">
                                                        <div class="d-flex justify-content-end">
                                                            <div
                                                                class="lh-1 text-white bg-primary rounded-circle p-3 d-flex align-items-center justify-content-center">
                                                                <i class="fas fa-graduation-cap"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <!-- ******************************************************************** -->
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>



        </body>

        </html>