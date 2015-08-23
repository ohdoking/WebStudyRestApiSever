<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="save" />

<form:form id="peopleForm" commandName="people" method="post"
       action="${actionUrl }" class="pure-form pure-form-aligned">

     <fieldset>
          <legend></legend>

          <div class="pure-control-group">
              <label for="name">Name</label>
              <form:input path="name" placeholder="Book Name" />
          </div>
          <div class="pure-control-group">
               <label for="code">Age</label>
               <form:input path="age" placeholder="Age" maxlength="15" />
          </div>
          <div class="pure-control-group">
              <label for="price">Sex</label>
              <form:input path="sex" placeholder="Sex" maxlength="10" />
          </div>
          <div class="pure-control-group">
              <label for="isbn">ETC</label>
              <form:input path="etc" placeholder="ETC" />
          </div>
          <div class="pure-control-group">
              <label for="publishedOn">Published On</label>
              <form:input path="publishedOn" placeholder="YYYY-MM-DD" class="datepicker" />
          </div>

          <form:input path="id" type="hidden" />
      </fieldset>
</form:form>