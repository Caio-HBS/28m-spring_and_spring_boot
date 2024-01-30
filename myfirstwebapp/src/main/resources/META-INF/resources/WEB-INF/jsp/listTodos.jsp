<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List TODOs Page</title>
  </head>
  <body>
    <div>Welcome ${name}</div>
    <hr>
    <h1>Your TODOs</h1>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Description</th>
          <th>Target Date</th>
          <th>Is Completed</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${todos}" var="todo">
          <tr>
            <td>${todo.id}</td>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>