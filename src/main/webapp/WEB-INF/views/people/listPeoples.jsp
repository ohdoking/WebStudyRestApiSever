<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>List Of Peoples</title>

<link rel="stylesheet" href='<c:url value="/web-resources/css/pure-0.4.2.css"/>'>

<link rel="stylesheet"
       href='<c:url value="/web-resources/css/font-awesome-4.0.3/css/font-awesome.css"/>'>
<link rel="stylesheet" 
       href='<c:url value="/web-resources/css/jquery-ui-1.10.4.custom.css"/>'>
<style type="text/css">
  th {
       text-align: left
  }

</style>
</head>

<body>
   <div style="width: 95%; margin: 0 auto;">
       
        <div id="peopleDialog" style="display: none;">
            <%@ include file="peopleForm.jsp"%>
        </div>

        <h1>List Of Peoples</h1>

        <button class="pure-button pure-button-primary" onclick="addPeople()">
            <i class="fa fa-plus"></i> Add People
         </button>
         <br>
         <table class="pure-table pure-table-bordered pure-table-striped">
            <thead>
               <tr>
                  <th width="4%">S.N</th>
                  <th width="20%">Name</th>
                  <th width="20%">Age</th>
                  <th width="20%">Sex</th>
                  <th width="20%">ETC</th>
                  <th width="20%">Published On</th>
                  <th width="20%"></th>
               </tr>
            </thead>
            <tbody>
               <c:forEach items="${peopleList}" var="people" varStatus="loopCounter">
               <tr>
                   <td><c:out value="${loopCounter.count}" /></td>
                   <td><c:out value="${people.name}" /></td>
                   <td><c:out value="${people.age}" /></td>
                   <td><c:out value="${people.sex}" /></td>
                   <td><c:out value="${people.etc}" /></td>
                   <td><c:out value="${people.publishedOn}" /></td>

                   <td>
                     <nobr>
                        <button onclick="editPeople(${people.id});"
                                class="pure-button pure-button-primary">
                             <i class="fa fa-pencil"></i> Edit
                        </button>

                        <a href="delete/${people.id}" class="pure-button pure-button-primary"
                   onclick="return confirm('Are you sure you want to delete this people?');">
                             <i class="fa fa-times"></i>Delete
                        </a>
                      </nobr>
                   </td>
                </tr>
                </c:forEach>
            </tbody>
         </table>
     </div>

     <!--  It is advised to put the <script> tags at the end of the document body so that they don't block rendering of the page -->
     
    <script type="text/javascript"
       src='<c:url value="/web-resources/js/lib/jquery-1.10.2.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="/web-resources/js/lib/jquery-ui-1.10.4.custom.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="/web-resources/js/lib/jquery.ui.datepicker.js"/>'></script>
    <script type="text/javascript"
       src='<c:url value="/web-resources/js/js-for-listPeoples.js"/>'></script>
</body>
</html> 