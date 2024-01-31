<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New TODO</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
  </head>
  <body>
    <div class="container">
      <h1>Todo details</h1>
      <form:form method="post" modelAttribute="todo">
        <label for="description">Description</label>
        <form:input id="description" type="text" path="description" required="required" />
        <form:input id="description" type="hidden" path="done"/>
        <form:input id="description" type="hidden" path="id" />
        <button class="btn btn-success">Submit</button>
      </form:form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>