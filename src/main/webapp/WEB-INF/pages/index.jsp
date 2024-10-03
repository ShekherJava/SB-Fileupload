
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<html>
	<body>
		<font color='red'> ${message} </font>
		<hr>
		<form action="/upload"  method="post" enctype="multipart/form-data">
			Upload file : <input type="file"  name="file"> <br>
			<button type="submit">Upload</button>
		</form>
		
		<h2> Download Files </h2>
		<table border="1">
			<tr>
				<th>FileName</th> <th>Download link </th>
			</tr>
			<c:forEach var="f" items="${files}">	
				<tr>
					<td> ${f.fileName} </td>	
					<td> <a href="/download?id=${f.id}">Download</td>
				</tr>
			</c:forEach>
		</table>			
	</body>
</html>			