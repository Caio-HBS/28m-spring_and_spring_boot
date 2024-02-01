<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<html lang="en">
  <body>
    <div class="container">
      <h1>Todo details</h1>
      <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
          <form:label path="description">Description</form:label>
          <form:input id="description" type="text" path="description"
                      required="required"/>
          <form:errors cssClass="text-warning" path="description"/>
        </fieldset>
        <fieldset class="mb-3">
          <form:label path="targetDate">Target Date</form:label>
          <form:input type="text" path="targetDate" required="required"/>
          <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>
        <form:input id="description" type="hidden" path="done"/>
        <form:input id="description" type="hidden" path="id"/>
        <button class="btn btn-success">Submit</button>
      </form:form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script
        src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript">
        $("#targetDate").datepicker({
            format: "yyyy-mm-dd"
        });
    </script>
  </body>
</html>