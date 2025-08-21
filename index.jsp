<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student App</title>
</head>
<body>
  <h2>Student App</h2>

<button type="button" id="btnJs">View</button><br><br>
<button type="button" id="btnJsadd">Add</button><br><br>

<button type="button" id="delete">delete</button>
<button type="button" id="update">update</button>

  <script>
    document.getElementById('btnJs').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/students';
    });

    document.getElementById('btnJsadd').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/addStudent.jsp';
    });
    document.getElementById('delete').addEventListener('click',function(){
      window.location.href='<%=request.getContextPath() %>/deletestudent.jsp';
    });
     document.getElementById('update').addEventListener('click',function(){
      window.location.href='<%=request.getContextPath() %>/update.jsp';
    });
  </script>
</body>
</html>
