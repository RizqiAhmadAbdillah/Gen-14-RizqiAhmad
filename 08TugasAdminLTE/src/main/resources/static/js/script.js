function showData() {
	$("#customerTable").empty();
	$.getJSON('http://localhost:8080/customer', function(json) {
		var tr = [];
		tr.push('<thead>');
		tr.push('<tr>');
		tr.push('<th>ID</th>');
		tr.push('<th>Name</th>');
		tr.push('<th>Email</th>');
		tr.push('<th>Address</th>');
		tr.push('<th colspan="2" class="text-center">Actions</th>');
		tr.push('</thead>');
		tr.push('<tbody id="customers">');
		for (var i = 0; i < json.length; i++) {
			tr.push('<tr>');
			tr.push('<td>' + json[i].id + '</td>');
			tr.push('<td>' + json[i].name + '</td>');
			tr.push('<td>' + json[i].email + '</td>');
			tr.push('<td>' + json[i].address + '</td>');
			tr.push('<td class="text-center"><a class=\'edit\'><button type="button" class="btn btn-outline-primary btn-sm"><i class="fas fa-edit fa-fw me-3"></i> Edit</button></a></td>');
			tr.push('<td class="text-center"><a class=\'delete\' id=' + json[i].id + '><button type="button" class="btn btn-outline-danger btn-sm me-3"><i class="fas fa-trash fa-fw"></i> Delete</button></a></td>');
			tr.push('</tr>');
		}
		tr.push('</tbody>');
		$("#customerTable").append($(tr.join('')));
	});
}
$(document).ready(function() {
	showData();
	$(document).delegate('#addNew', 'click', function(event) {
		event.preventDefault();
		var name = $('#name').val();
		var email = $('#email').val();
		var address = $('#address').val();

		if (name == "" && email == "" && address == "") {
			$('#invalid-name').html("<div class='form-text text-danger'>Name cannot be null</div>");
			$('#invalid-email').html("<div class='form-text text-danger'>Email cannot be null</div>");
			$('#invalid-address').html("<div class='form-text text-danger'>Address cannot be null</div>");
			window.setTimeout(function() {
				$("#invalid-name").html("");
				$("#invalid-email").html("");
				$("#invalid-address").html("");
			}, 3000);
		} else if (name == "") {
			$('#invalid-name').html("<div class='form-text text-danger'>Name cannot be null</div>");
			window.setTimeout(function() {
				$("#invalid-name").html("");
			}, 3000);
		} else if (email == "") {
			$('#invalid-email').html("<div class='form-text text-danger'>Email cannot be null</div>");
			window.setTimeout(function() {
				$("#invalid-email").html("");
			}, 3000);
		} else if (address == "") {
			$('#invalid-address').html("<div class='form-text text-danger'>Address cannot be null</div>");
			window.setTimeout(function() {
				$("#invalid-address").html("");
			}, 3000);
		}
		if (name != "" && email != "" && address != "") {
			$.ajax({
				type: "POST",
				contentType: "application/json; charset=utf-8",
				url: "http://localhost:8080/customer/save",
				data: JSON.stringify(
					{ 'name': name, 'email': email, 'address': address }),
				/*data: JSON.stringify(customer),*/
				cache: false,
				success: function(result) {
					$("#msg").html("<div class='alert alert-success text-center' role='alert'>Data Added Successfully</div>");
					$("#form").hide();
					window.setTimeout(function() {
						showData();
						$("#msg").html("");
						$('#name').val("");
						$('#email').val("");
						$('#address').val("");
						$('#invalid').val("");
						$("#addModal").modal('hide');
					}, 1000)
					window.setTimeout(function() {
						$("#form").show();
					}, 1500)
				},
				error: function(err) {
					$("#msg").html("<span style='color: red'>Data cannot be null</span>");
				}
			});
		}
	});

	$(document).delegate('.delete', 'click', function() {
		if (confirm('Do you really want to delete record?')) {
			var id = $(this).attr('id');
			var parent = $(this).parent()
				.parent();
			$.ajax({
				type: "DELETE",
				url: "http://localhost:8080/customer/delete/" + id,
				cache: false,
				success: function() {
					parent.fadeOut(
						'slow', function() {
							$(this).remove();
						});
					/*location.reload(true)*/
					showData;
				},
				error: function() {
					$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error deleting record')
						.fadeIn()
						.fadeOut(4000, function() {
							$(this).remove();
						});
				}
			});
		}
	});
	$(document).delegate('.edit', 'click', function() {
		var parent = $(this).parent().parent();
		var id = parent.children("td:nth-child(1)");
		var name = parent.children("td:nth-child(2)");
		var email = parent.children("td:nth-child(3)");
		var address = parent.children("td:nth-child(4)");
		var buttonEdit = parent.children("td:nth-child(5)");
		var buttonDelete = parent.children("td:nth-child(6)");

		name.html("<input type='text' id='name' value='" + name.html() + "'/>");
		email.html("<input type='text' id='email' value='" + email.html() + "'/>");
		address.html("<input type='text' id='address' value='" + address.html() + "'/>");
		/*buttons.html("<button id='save'>Save</button>&nbsp;&nbsp;<button class='delete' id='" + id.html() + "'>Delete</button>");
		*/
		buttonEdit.html("<a id='save'><button type='button' class='btn btn-outline-primary btn-sm toastsDefaultDanger'><i class='fas fa-save fa-fw me-3'></i> Save</button></a>");
		buttonDelete.html("<a class='delete' id='" + id.html() + "'><button type='button' class='btn btn-outline-danger btn-sm'><i class='fas fa-trash fa-fw me-3'></i> Delete</button></a>");
	});

	$(document).delegate('#save', 'click', function() {
		var parent = $(this).parent().parent();
		var id = parent.children("td:nth-child(1)");
		var name = parent.children("td:nth-child(2)");
		var email = parent.children("td:nth-child(3)");
		var address = parent.children("td:nth-child(4)");
		var buttonEdit = parent.children("td:nth-child(5)");
		var buttonDelete = parent.children("td:nth-child(6)");
		if (name == "" || email == "" || address == "") {
			$('.toastsDefaultDanger').click(function() {
				$(document).Toasts('create', {
					class: 'bg-danger',
					title: 'Invalid Update',
					subtitle: 'Error',
					body: 'Data cannot be null'
				})
			});
		}
		if (name != "" && email != "" && address != "") {
			$.ajax({
				type: "POST",
				contentType: "application/json; charset=utf-8",
				url: "http://localhost:8080/customer/save",
				data: JSON.stringify({
					'id': id.html(),
					'name': name.children("input[type=text]").val(),
					'email': email.children("input[type=text]").val(),
					'address': address.children("input[type=text]").val()
				}),
				cache: false,
				success: function() {
					name.html(name.children("input[type=text]").val());
					email.html(email.children("input[type=text]").val());
					address.html(address.children("input[type=text]").val());
					buttonEdit.html("<a class='edit' id='" + id.html() + "'><button type='button' class='btn btn-outline-primary btn-sm'><i class='fas fa-edit fa-fw me-3'></i> Edit</button></a>");
					buttonDelete.html("<a class='delete' id='" + id.html() + "'><button type='button' class='btn btn-outline-danger btn-sm'><i class='fas fa-trash fa-fw me-3'></i> Delete</button></a>");
				},
				error: function() {
					$('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error updating record')
						.fadeIn()
						.fadeOut(4000, function() {
							$(this).remove();
						});
				}
			});
		}
	});
	/*$('.table tr').each(function() {
		$(this).attr('searchData', $(this).text().toLowerCase());
	});
	$("#search").on('keyup', function() {
		var dataList = $(this).val().toLowerCase();
		$('.table tr').each(function() {
			if ($(this).filter('[searchData *= ' + dataList + ']').length > 0 || dataList.length < 1) {
				$(this).show();
			} else {
				$(this).hide();
			}
		});
	});*/

	/*$("#search").on("keyup", function() {
		var value = $(this).attr('searchData', $(this).text().toLowerCase());

		$("#customers tr").each(function(index) {
			if (index != 0) {

				$row = $(this);

				var id = $row.find("td:first").text();

				if (id.indexOf(value) != 0) {
					$(this).hide();
				}
				else {
					$(this).show();
				}
			}
		});
	});*/

	$(document).ready(function() {
		$("#search").on("keyup", function() {
			var value = $(this).val().toLowerCase();
			$("#customers tr").filter(function() {
				$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			});
		});
	});

	/*$('#customerTable').on('keyup', '#search', function() {
		$('.loader').show();
		//variable untuk menampung nilai input dari keyword
		const keyword = $('#customerTable').val();

		$.ajax({
			url: 'http://localhost:8080/customer/search/' + keyword,
			type: 'post',
			data: 'keyword=' + keyword,
			success: function(response) {
				if (response) {
					$('.loader').hide('slow').fadeOut(1000);
					$('#customers').html(response);
				} else {
					Swal.fire("Data no found");
				}
			}
		});
	});*/

	$("#addButton").click(function() {
		$("#addModal").modal('show');
	});
	$("#closeModal").click(function() {
		$("#addModal").modal('hide');
	});
});