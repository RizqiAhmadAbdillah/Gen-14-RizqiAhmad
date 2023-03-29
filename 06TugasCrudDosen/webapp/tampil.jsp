<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%-- <%@ taglib uri="jakarta.tags.sql" prefix="sql"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%> --%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tabel Dosen</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> Tabel Dosen </a>
		</div>
	</nav>
	<div class="container">

		<div class="row mt-3">
			<div class="col-6">
				<a href="formTambahData" class="btn btn-primary mt-3 mb-3">Tambah
					Data Dosen</a>
			</div>
			<div class="col-6">
				<form action="" method="post">
					<div class="input-group input-group-sm" style="width: 300px;">
						<input type="text" name="keyword" class="form-control float-right"
							placeholder="Cari">

						<div class="input-group-append">
							<button class="btn btn-primary" type="submit">Cari</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row mt-3">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Kode Dosen</th>
						<th scope="col">Nama Dosen</th>
						<th colspan="2">Action</th>
						<th></th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					<c:set var="num" value="0" scope="page" />
					<c:forEach var="dosen" items="${dosen}">
						<c:set var="num" value="${num+1}" scope="page" />
						<tr>
							<td><c:out value="${num}" /></td>
							<td><c:out value="${dosen.kode_dosen}" /></td>
							<td><c:out value="${dosen.nama_dosen}" /></td>
							<td><a href="formUbahData?kode_dosen=${dosen.kode_dosen}"><span
									class="badge text-bg-warning">Edit</span></a></td>
							<td><a href="hapusData?kode_dosen=${dosen.kode_dosen}"><span
									class="badge text-bg-danger" onclick="return deleteConfirmation()">Delete</span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function deleteConfirmation() {
			return confirm("Apakah anda yakin?")
			/* var confirmation = confirm("Apakah anda yakin?");
			if (result)
				return true;
			else
				return false; */
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
</body>
</html>
