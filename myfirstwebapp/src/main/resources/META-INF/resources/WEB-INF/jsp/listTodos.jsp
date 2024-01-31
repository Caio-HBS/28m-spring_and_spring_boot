<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List TODOs Page</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
  </head>
  <body>
    <div class="container">
      <h1>Your TODOs</h1>
      <table class="table">
        <thead>
          <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Completed</th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${todos}" var="todo">
            <tr>
              <td>${todo.description}</td>
              <td>${todo.targetDate}</td>
              <td>${todo.done}</td>
              <td>
                <a href="update-todo?id=${todo.id}">
                  <button class="btn btn-info">Update</button>
                </a>
              </td><td>
                <a href="delete-todo?id=${todo.id}">
                  <button class="btn btn-danger">Delete</button>
                </a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <a href="new-todo"><button type="button" class="btn btn-success">Add todo</button></a>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </body>
</html>