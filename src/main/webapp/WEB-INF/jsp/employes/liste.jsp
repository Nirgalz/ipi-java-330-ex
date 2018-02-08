<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../tags/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>Liste des employés</h1>
            <div class="btn-group">
                <a href="#" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Nouvel employé
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="/employes/new/technicien">Technicien</a></li>
                    <li><a href="/employes/new/commercial">Commercial</a></li>
                    <li><a href="/employes/new/manager">Manager</a></li>
                </ul>
            </div>
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th scope="col">
                        Matricule <a href="?page=${actualPage}&size=${size}&sortProperty=matricule&sortDirection=${sortDirection}">

                            <span class="glyphicon glyphicon-chevron-down"></span>



                    </a>
                    </th>
                    <th scope="col">
                        Nom <a href="?page=${actualPage - 1}&size=${size}&sortProperty=nom&sortDirection=${sortDirection}"><span class="glyphicon glyphicon-chevron-down"></span></a>
                    </th>
                    <th scope="col">
                        <a href="?page=${actualPage - 1}&size=${size}&sortProperty=prenom&sortDirection=${sortDirection}">Prénom</a>
                    </th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${page.content}" var="item">

                    <tr>
                        <th scope="row">${item.matricule}</th>
                        <td>${item.nom}</td>
                        <td>${item.prenom}</td>
                        <td><a href="employes/${item.id}">Détail</a></td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <div class="row">
                <div class="col-lg-6">
                    <p>
                        Affichage des employés ${actualPage * 10 +1} à ${actualPage * 10 + 10} sur un total de ${nbEmployes}</p>
                </div>
                <div class="col-lg-6">
                    <ul class="pagination">
                        <c:if test="${actualPage != 0}">
                            <li><a href="?page=${actualPage - 1}&size=${size}&sortProperty=${sortProperty}&sortDirection=${sortDirection}">&laquo;</a></li>
                        </c:if>
                        <li><a href="#">${actualPage +1}/${totalPages}</a></li>
                        <c:if test="${actualPage < totalPages -1}">
                        <li><a href="?page=${actualPage + 1}&size=${size}&sortProperty=${sortProperty}&sortDirection=${sortDirection}">&raquo;</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../tags/footer.jsp" %>