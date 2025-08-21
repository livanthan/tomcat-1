<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add Student</title>
</head>
<body>
  <h2>Add Student</h2>

  <%
    String msg = (String) session.getAttribute("msg");
    if (msg != null) {
  %>
      <p style="color:red;"><%= msg %></p>
  <%
      session.removeAttribute("msg");
    }
  %>

<form method="post" action="<%= request.getContextPath() %>/students/delete">
    <label>Id: <input type="number" name="id" min="1" required></label>
    <button type="submit">Save</button>
  </form>

<a href="<%= request.getContextPath() %>/">Home</a><br><br>
<a href="<%= request.getContextPath() %>/addStudent.jsp">Add</a><br><br>
<a href="<%= request.getContextPath() %>/update.jsp">update</a>
</body>
</html>
