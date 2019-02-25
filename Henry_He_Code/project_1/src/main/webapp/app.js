window.onload = function(){
	console.log("Loaded app.js");
	loadLoginView();
	$(document).on('click','#login',login);
}

function selectRow(){
	let tableRow = $(this).closest("tr");
	if(tableRow.hasClass("selected")){
		tableRow.removeClass("selected");
	} else {
		tableRow.addClass("selected");
	}
}

function getTableData(){
    let tableData = $(this).children("td").map(function() {
        return $(this).text();
    }).get();
    console.log(tableData);
}

function reloadTable(){
	setTimeout(function(){
		$('table').remove();
		loadUserView();
	}, 1000);
};

function loadLoginView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "login.view");
	xhr.send();
}

function loadUserView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			$('#view').html(xhr.responseText);
			$("tr.tblRow").click(selectRow);
			$("#new_reimb").click(make_new_reimbursement);
			$("#approve").click(approve);
			$("#deny").click(deny);
			$('select[name="filter"').change(filter);
		}
	}
	xhr.open("POST", "user");
	xhr.send();
}

function approve(){
	let tableData = $('table tr.tblRow.selected td');
	let length = tableData.length;
	let rid_arr = [];
	for(let i=0; i<length; i+=5){
		rid_arr.push(tableData[i].innerText);
	}
	console.log(rid_arr);
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){};
	xhr.open("PUT","reimb");
	xhr.setRequestHeader("Content-type","text/plain");
	let data = "1," +document.querySelector('input[name="uid"]').value+ ",";
	for(let rid of rid_arr)
		data += rid + ",";
	data = data.substring(0,data.length-1);
	console.log(data);
	xhr.send(data);
	reloadTable();
}

function deny(){
	let tableData = $('table tr.tblRow.selected td');
	let length = tableData.length;
	let rid_arr = [];
	for(let i=0; i<length; i+=5){
		rid_arr.push(tableData[i].innerText);
	}
	console.log(rid_arr);
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){};
	xhr.open("PUT","reimb");
	xhr.setRequestHeader("Content-type","text/plain");
	let data = "0," +document.querySelector('input[name="uid"]').value+ ",";
	for(let rid of rid_arr)
		data += rid + ",";
	data = data.substring(0,data.length-1);
	console.log(data);
	xhr.send(data);
	reloadTable();
}

function filter(){
	let tdata = $('table tr.tblRow td');
	let filter_status = $('select option:selected')[0].innerText;
	for(let i=4; i<tdata.length; i+=5){
		let parent = tdata[i].parentElement
		if(tdata[i].innerText == filter_status || filter_status == "ALL")
			parent.removeAttribute("hidden");
		else 
			parent.setAttribute("hidden",true);
	}
}

function login(){
	let un = document.querySelector('input').value;
	let pw = document.querySelector('input[type="password"]').value;
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("success!");
			loadUserView();
		} else if (xhr.status == 401){
			let err_div = document.querySelector("#error_message");
			console.log("invalid credentials");
			if (err_div.innerText == 0){
				err_div.appendChild(
					document.createTextNode("Invalid Credentials, Please Try Again.")
				);
			}
		} else {
//			console.log("Something bork'd");
		}
	}
	xhr.open("POST","login");
	xhr.setRequestHeader("Content-type","text/plain");
	xhr.send(un+","+pw);
}

function make_new_reimbursement(){
	let amountInputField = document.querySelector('input[name="amount"]').value;
	let descInputField = document.querySelector('input[name="desc"]').value;
	let data = [
		document.querySelector('input[name="uid"]').value,
		amountInputField,
		document.querySelector('select').value,
		descInputField,
		new Date().toLocaleDateString()
	];
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('tbody').append(xhr.response)
			amountInputField = " ";
			descInputField = " ";
			alert("Reimbursement Submitted");
		} else if (xhr.status == 401){
			alert("Something went wrong. Please try again!");
		} else {
//			console.log("Something bork'd");
		}
	};
	xhr.open("POST","reimb");
	xhr.setRequestHeader("Content-type","text/plain");
	xhr.send(data[0] +","+ data[1] +","+ data[2] +","+ data[3] +","+ data[4]);
}