<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tambah Data Dosen</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> Tambah Data Dosen </a>
		</div>
	</nav>
	<div class="container">
		<div class="row mt-3">
			<div class="col-6">
				<form action="tambahData" method="post">
					<div class="mb-3">
						<label for="kode_dosen" class="form-label">Kode Dosen</label> <input
							type="text" class="form-control" id="kode_dosen"
							name="kode_dosen" required="required">
					</div>
					<div class="mb-3">
						<label for="nama_dosen" class="form-label">Nama Dosen</label> <input
							type="text" class="form-control" id="nama_dosen"
							name="nama_dosen" required="required">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>