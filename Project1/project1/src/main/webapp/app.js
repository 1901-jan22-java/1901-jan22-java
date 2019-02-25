//window.onload = function(){
//	console.log("Loaded app");
//	loginView();
//}
$(document).ready(function(){
	console.log("Loaded App")
	loginView();
});

function loginView(){
	console.log("In loginView method");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            $('#view').html(xhr.responseText);
            $('#login').on('click', console.log('login clicked'));
            $('#login').on('click', logIn);
        }   
    }
    xhr.open("GET", "login.view");
    xhr.send();
}

function userView(){
	console.log("In userView method");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('rSubmit').on('click', console.log("rSubmit clicked"));
//			$('#rSubmit').on('click', addReimbursement);
		}
	}
	xhr.open("GET", "userHome.view");
	xhr.send();
}

function managerView(){
	console.log("In managerView method");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "managerHome.view");
	xhr.send();
}

function logIn(){
	console.log("In logIn method");
    var user = {
        username: $('#username').val(), 
        password: $('#pass').val()};
    var json = JSON.stringify(user);

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4){
            if(xhr.status == 200){
                console.log("success");
                var user = JSON.parse(xhr.responseText);
                console.log(user);
                if(user.roleId == 1){
                	userView();  
                }
                else if(user.roleId==2){
                	managerView();
                }
                else{
                	console.log('err');
                }   
            }
            else if(xhr.status == 401){
                console.log(xhr.responseText);
                alert("Wrong login!");
            }
        }
    }
    xhr.open("POST", "login");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
}

function addReimbursement(){
	console.log("In addReimb method");
	var reimbursement = {
			amount: $('#reimbamount').val(),
			description: $('#reimbdesc').val(),
			type: $('#reimbtype').val()
	};
	console.log('adding reimbursement:');
	console.log(reimbursement);
	var json = JSON.stringify(user);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				alert("Reimbursment Submitted");
				console.log(xhr.responseText);
			} else if(xhr.status == 401){
				console.log("Error Not Submitted");
				$('#view').html(userView); 
			}
		}
	}
	xhr.open("POST", "/addReimb");
	xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(json);
};