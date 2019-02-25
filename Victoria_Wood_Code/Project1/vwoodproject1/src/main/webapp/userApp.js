window.onload = function(){
	console.log("Loaded App");
	$('#logout').on('click', loadLoginView);
	loadLoginView();
}

function loadLoginView(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
            $('#logIn').on('click', logIn);
        }   
    }
    xhr.open("GET", "login.view");
    xhr.send();
}

function logIn(){
    var user = {
        username: $('#username').val(), 
        password: $('#pw').val()
        };
    var json = JSON.stringify(user);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				managerMenu();
				// can create hidden message that shows when username/pwd is incorrect
			} else if(xhr.status == 201){
				menu();
			}else if(xhr.status == 418){
				alert("Wrong Username or Password");
			} else{
				// another error page
			}
		}
	}
	
	xhr.open("POST", "login");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(json);
}

function menu() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			$('#view').html(xhr.responseText);
			$('#viewReimb').on('click', viewReimb);
			$('#addReimb').on('click', addReimbView);
			console.log("in menu");
		}
		
	}
	xhr.open("GET", "menu.view");
	xhr.send();
}
function managerMenu() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		$('#view').html(xhr.responseText);
		$('#viewAll').on('click', viewAll);	
		console.log("in manager menu");
	}
	xhr.open("GET", "managermenu.view");
	xhr.send();
}

function viewReimb() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		$("#view").html(xhr.responseText);
		$("#home").on('click', menu);
		$(document).ready( function () {
		    $('#myTable').DataTable();
		} );
		console.log("viewing user reimbursements");
	}
	xhr.open("GET", "menu");
	xhr.send();
}

function addReimbView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			$("#view").html(xhr.responseText);
			$("#add").on('click', addReimb);
			$("#home").on('click', menu);
			console.log("ready to add reimbursement");
		}
	}
	xhr.open("GET", "reimbursements.view");
	xhr.send()
}

function addReimb(){
	var reimb = {
		amount: $('#amount').val(),
		description: $('#description').val(),
		type_id: $('#type').val()
	};
	console.log(reimb);
	var json = JSON.stringify(reimb);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				$('#view').html(xhr.responseText);
				$('#menu').on('click', menu);
			}else if (xhr.status == 418){
				$('#view').html(xhr.responseText);
				$('#menu').on('click', menu);
			} 
			else{
				alert("Something went wrong during your request. Please try again.")
			}
		} else {
			//error page
		}
	}
	xhr.open("POST","reimbursements");
	xhr.setRequestHeader("Content-type","application/json");
	xhr.send(json);
}

function viewAll(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		$("#view").html(xhr.responseText);
		$("#home").on('click', managerMenu);
		$('#byStatus').on('click', filterByStatus);
		$('#changeStatus').on('click', changeStatusView);
		$(document).ready( function () {
		    $('#myTable').DataTable();
		} );
		console.log("viewing all reimbursements");
	}
	xhr.open("GET", "managermenu");
	xhr.send();
}

function filterByStatus(){
	var status = $('#status').val();
	console.log(status);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		$('#view').html(xhr.responseText);
		$("#viewAll").on('click', viewAll);
		$('#home').on('click', managerMenu);
		$('#byStatus').on('click', filterByStatus);
		$("#changeStatus").on('click', changeStatusView);
		$(document).ready( function () {
		    $('#myTable').DataTable();
		} );
		console.log("viewing reimbursement by status");
		}
	xhr.open("GET", "managermenu/"+status);
	xhr.send();
	
	
}

function changeStatusView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4) {
			$('#view').html(xhr.responseText);
			$('#viewAll').on('click', viewAll);
			$('#approve').on('click', approve);
			$('#deny').on('click', deny);
			console.log("selecting reimbursement to update");
		}
	}
	xhr.open("GET","status");
	xhr.send();
	
}

function approve(){
	var reimb = {
			id: $('input[name=choice]:checked').val(),
			status_id : 3
	};
	console.log(reimb.id);
	var json = JSON.stringify(reimb);
	var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			$('#view').html(xhr.responseText);
			$('#home').on('click', managerMenu)
			console.log("updating reimbursement status");
		}
	xhr.open("POST","status");
	xhr.setRequestHeader("Content-type","application/json");
	xhr.send(json);
}

function deny(){
	var reimb = {
			id: $('input[name=choice]:checked').val(),
			status_id : 2
	};
	var json = JSON.stringify(reimb);
	var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			$('#view').html(xhr.responseText);
			$('#home').on('click', managerMenu)
			console.log("updating reimbursement status");
		}
	xhr.open("POST","status");
	xhr.setRequestHeader("Content-type","application/json");
	xhr.send(json);
}


