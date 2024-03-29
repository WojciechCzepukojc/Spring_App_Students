<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/css.jspf"%>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

      <%@include file="../dynamic/navigationMain.jspf"%>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>



          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>




            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Imię nazwisko</span>
               
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Profile
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">
<form method="post" action='<c:url value="/addTask/${task.id}"/>'>
                    <!-- Content Row -->
                    <div class="row">
                        <div class="col-xl-12 col-md-12 mb-12">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                   
                                   
                                   
<div class="form-group row">
    <label  class="col-2 col-form-label">Wybierz kursanta</label>
    <div class="col-10">
  <select class="form-control" name="userAssigned" id="sel1">
    <option hidden>${task.userAssigned}</option>
    <c:forEach items="${person}" var="title">
        <option>${title.firstName} ${title.lastName}</option>
    </c:forEach>
  </select>
    </div>
</div>                     
                                   
                                   
                                   
                                    <div class="form-group row">
                                        <label  class="col-2 col-form-label">Deadline</label>
                                        <div class="col-10">
                                            <input class="form-control" type="date" name="deadline" value="${task.deadline}" placeholder="">
                                        </div>
                            </div>
                          

                            <div class="form-group row">
                                <label for="start" class="col-2 col-form-label">Tresć zadania:</label>
                                <div class="col-10">
                                <textarea class="form-control" rows="5" name="description" id="start" placeholder="${task.description}"></textarea>
                                </div>
                            </div>


                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
       
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <div class="form-group row">

                                    <div class="col-md-9 col-sm-9 col-xs-9">
                                    <div class="row">
                                    <div class="col-sm-2">
                                    <label class="radio-inline"><input type="radio" name="color" value="success" checked>
                                    <i class="btn btn-success btn-circle btn-sm"></i> poziom junior</label>
                                    </div>
                                    <div class="col-sm-2">
                                    <label class="radio-inline"><input type="radio" name="color" value="info" checked>
                                    <i class="btn btn-info btn-circle btn-sm"></i> poziom junior+</label>
                                    </div>
                                    <div class="col-sm-2">
                                    <label class="radio-inline"><input type="radio" name="color" value="secondary" checked>
                                    <i class="btn btn-secondary btn-circle btn-sm"></i> poziom mid</label>
                                    </div>
                                    <div class="col-sm-2">
                                    <label class="radio-inline"><input type="radio" name="color" value="primary" checked>
                                    <i class="btn btn-primary btn-circle btn-sm"></i> poziom mid+</label>
                                    </div>
                                    <div class="col-sm-2">
                                        <label class="radio-inline"><input type="radio" name="color" value="danger" checked>
                                            <i class="btn btn-danger btn-circle btn-sm"></i> poziom senior</label>
                                    </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>             
                    
                    
                    
                    
 <input class="btn btn-success pull-left" type="submit" value="Zapisz" id="searchButton"></input>
    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">
    Usuń
    </button>
</form>

            <!-- The Modal -->
            <div class="modal" id="myModal">
                <div class="modal-dialog">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Czy na pewno chcesz usunąć osobę ?</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            Jeżeli usuniesz to już nie będzie odwrotu
                        </div>

                        <!-- Modal footer -->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary" data-dismiss="modal">Anuluj</button>
                            <form method="post" action='<c:url value="/editTask/${task.id}"/>'>
                                <input type="submit" class="btn btn-danger pull-left" value="Tak"/>
                            </form>
                        </div>

                    </div>

                </div>
            </div>

    

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

        <%@include file="../dynamic/board.jspf"%>

        <%@include file="../dynamic/javaScript.jspf"%>
</body>

</html>
