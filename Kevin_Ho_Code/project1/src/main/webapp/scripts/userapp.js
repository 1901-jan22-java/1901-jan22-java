window.onload = function(){
   loadLoginView();
}

function loadLoginView(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
            $('#goToSubmit').on('click', loadRegisterView);
            $('#logIn').on('click', logIn);
        }   
    }
    xhr.open("GET", "partials/logIn.html");
    xhr.send();
}

function loadRegisterView(){
    //function to load view to add new user
    console.log("load register view function");

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
        	$('#addUser').on('click', addUser);
            $('#goToLogin').on('click', loadLoginView);
        }   
    }
    xhr.open("GET", "partials/register.html");
    xhr.send();
}

function logIn(){
    var user = {
        username: $('#username').val(),
        password: $('#password').val()};
    var json = JSON.stringify(user);
	
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                //logged in successfully
            	loadHomeView(xhr.responseText);
            }
            else if(xhr.status == 201){
            	loadManagerView(xhr.responseText);
            }
            else if(xhr.status == 409){
                //encountered known problem (wrong password/user not in system)
                console.log(xhr.responseText);
                $('#error').html("Wrong login!!");
                $('#error').css('color', 'red');
            }
            else{
                //some other error, likely send to error page
                $('#error').html("What in gods name did you do");            	
            }
        }
    }
    xhr.open("POST", "logIn");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

function loadHomeView(user){
	console.log("home view");
	var info = JSON.parse(user);
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
            $('#name').html(`${info.firstName} ${info.lastName}`);
            $('#reqReimb').on('click', loadAddReimbView);
            $('#reqReimb').on('click', removeReimbView);
            showReimb();
        }
    }
    xhr.open("GET", "partials/home.html");
    xhr.send();
}

function loadManagerView(user){
	console.log("manager view");
	var info = JSON.parse(user);
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
            $('#name').html(`${info.firstName} ${info.lastName}`);
            $('#reqReimb').on('click', loadAddReimbView);
            $('#reqReimb').on('click', removeReimbView);
            $('#resolveReimb').on('click', resolve);
            showReimb();
        }
    }
    xhr.open("GET", "partials/homeManager.html");
    xhr.send();
}

function showReimb(){
	$('#tableData').html("");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			var reimb = JSON.parse(xhr.responseText);
			for(let i = 0; i < reimb.length; i++){
				switch(reimb[i].typeId)
				{
				case 1: reimb[i].typeId='Lodging';break;
				case 2: reimb[i].typeId='Food';break;
				case 3: reimb[i].typeId='Travel';break;
				}
				switch(reimb[i].statusId)
				{
				case 1: reimb[i].statusId='Pending';break;
				case 2: reimb[i].statusId='Approved';break;
				case 3: reimb[i].statusId='Denied';break;
				}
				if(reimb[i].resolved != null)
				{
					$('#tableData').append(`
							<tr>
								<td>${reimb[i].author}</td>
								<td>${reimb[i].amount}</td>
								<td>${reimb[i].typeId}</td>
								<td>${reimb[i].description}</td>
								<td>${new Date(reimb[i].submitted)}</td>
								<td>${new Date(reimb[i].resolved)}</td>
								<td>${reimb[i].resolver}</td>
								<td>${reimb[i].statusId}</td>
							</tr>`);
				}
				else
				{	
					$('#tableData').append(`
							<tr>
								<td>${reimb[i].author}</td>
								<td>${reimb[i].amount}</td>
								<td>${reimb[i].typeId}</td>
								<td>${reimb[i].description}</td>
								<td>${new Date(reimb[i].submitted)}</td>
								<td>N/A</td>
								<td>${reimb[i].resolver}</td>
								<td>${reimb[i].statusId}</td>
							</tr>`);
				}
			
			}
		}
	}
	xhr.open("GET", "showReimb");
	xhr.send();
}

function removeReimbView(){
	$('#reimbView').html("");
}

function loadAddReimbView(){
    console.log("load reimb view function");

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#reimbView').html(xhr.responseText);
        	$('#addReimb').on('click', addReimb);
            $('#goToHome').on('click', removeReimbView);
        }   
    }
    xhr.open("GET", "partials/reimbRegister.html");
    xhr.send();
}


function addReimb(){
	var reimb = {
			amount: $('#amount').val(),
			description: $('#description').val(),
			typeId: $('#type').val()
		};

    var json = JSON.stringify(reimb);
    console.log(json);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200 || xhr.status==201){
                //added money in
            	$('#reimbView').html("Success!!");
            	showReimb();
            }
            else if(xhr.status == 409){
                //failed to add money in
            	$('#reimbView').html("Invalid Input");
            }
            else{
                //some other error, likely send to error page
            	$('#reimbView').html("Something went wrong!");
            	console.log(xhr.status);
            }
        }
    }
    xhr.open("POST", "addReimb");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

function addUser(){
	if($('#roleId').attr('checked'))
	{
		var user = {
	        username: $('#username').val(), 
	        password: $('#password').val(),
	        firstName: $('firstName').val(),
	        lastName: $('lastName').val(),
	        email: $('#email').val(),
	        roleId: 1
		};
	}
	else
	{
		var user = {
		        username: $('#username').val(), 
		        password: $('#password').val(),
		        firstName: $('#firstName').val(),
		        lastName: $('#lastName').val(),
		        email: $('#email').val(),
		        roleId: 0
			};
	}
	    var json = JSON.stringify(user);

	    var xhr = new XMLHttpRequest();
	    xhr.onreadystatechange = function(){
	        if(xhr.readyState == 4){
	            if(xhr.status == 201){
	                //logged in successfully
	            	$('#view').html(xhr.responseText);
	            }
	            else if(xhr.status == 409){
	                //failed to log in
	            	$('#view').html(xhr.responseText);
	            }
	            else{
	            	alert("lamseaoiwme");
	            }
	        }
	    }
	    xhr.open("POST", "registerUser");
	    xhr.setRequestHeader("Content-type", "application/json");
	    xhr.send(json);
}