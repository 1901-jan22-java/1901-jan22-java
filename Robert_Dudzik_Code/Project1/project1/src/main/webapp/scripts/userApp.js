window.onload = function()
{
    loadLogIn();
}

function logOut()
{
    console.log('Log Out');
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4)
        {
            loadLogIn();
        }
    }
    xhr.open('GET', 'logOut');
    xhr.send();
}


function logIn()
{
   console.log('Entering log in function')
    let user = {
        username: $('#username').val(),
        password: $('#password').val()
    };
    let json = JSON.stringify(user);
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() 
    {
        if(xhr.readyState == 4)
        {
            if(xhr.status == 230)
            {
                console.log(xhr.responseText);
                loadEmployee();
            }
            else if (xhr.status == 231)
            {
                console.log(xhr.responseText);
                loadManager();
            }
            else if(xhr.status == 418)
            {
                console.log(xhr.responseText);
                alert('Log in failed!');
            }
        }
    }
    xhr.open('POST', 'login');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(json);
}

function addReimbursement()
{
    console.log("Entered Add Reimbursement method");
    let reimbursement = {
        amount: $('#amount').val(),
        description: $('#description').val(),
        typeId: $('input[name ="type"]:checked').val()
    }
    let xhr = new XMLHttpRequest();
    let json = JSON.stringify(reimbursement);
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4)
        {
            if(xhr.status == 230)
            {
                alert("Successfully added Reimbursement request!");
                loadEmployee();
            }
            else if (xhr.status == 418)
            {
                alert("Failed to add Reimbursement!");
                loadEmployee();
            }
        }
    }
    xhr.open('POST', 'addReim');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(json);
}

function viewEmployeeReimbursements()
{
    console.log("Adding Reimbursements to the table")
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4)
        {
            console.log(xhr.responseText);
            let arr = JSON.parse(xhr.responseText);
            for(i in arr)
            {
                console.log(arr[i]);
                //Get a row color based on the status of the reimbursement
                let statusColor = "info";
                if(arr[i].statusId == 2)
                    statusColor = "success";
                else if(arr[i].statusId == 3)
                    statusColor = "danger";
                //Check to see if it has been resolved
                let resolver = true;
                if(arr[i].resolverId == undefined)
                    resolver = false;
                let tableString = "";
                if(resolver)
                {
                    tableString = "<tr class = " + statusColor + "> <td>" + arr[i].amount + "</td>" +
                    "<td>" + arr[i].timeSubmitted + "</td> <td>" + arr[i].timeResolved + "</td> <td>" +
                    arr[i].description + "</td> <td>" + arr[i].status + "</td> <td>" + arr[i].type + "</td></tr>";
                }
                else 
                {
                    tableString = "<tr class = " + statusColor + "> <td>" + arr[i].amount + "</td>" +
                    "<td>" + arr[i].timeSubmitted + "</td> <td>" + " " + "</td> <td>" +
                    arr[i].description + "</td> <td>" + arr[i].status + "</td> <td>" + arr[i].type + "</td></tr>";
                }
                console.log(tableString);
                console.log(resolver);
                $('#reimbTable').append(tableString);
            }
        }
    }
    xhr.open('GET', 'getReim');
    xhr.send();
}

function loadViewReimbursements()
{
    console.log("Entering View Reimbursements page");
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4)
        {
            viewEmployeeReimbursements();
            $('#view').html(xhr.responseText);
            $('#backOut').on('click', loadEmployee);
        }
    }
    xhr.open('GET', 'employeereimbursements.view');
    xhr.send();
}

function loadAddReimbursement()
{
    console.log("Loading add employee reimbursement page");
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4)
        {
            console.log(xhr.responseText);
            $('#view').html(xhr.responseText);
            $('#submitReim').on('click', addReimbursement);
        }
    }
    xhr.open('GET', 'employeeaddreimbursement.view');
    xhr.send();
}

function updateReimbursement(reimbursement)
{
    console.log("Updating reimbursment");
    let xhr = new XMLHttpRequest();
    let json = JSON.stringify(reimbursement);
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4)
        {
            if(xhr.status == 200)
            {
                console.log('Reimbursement Updated');
                loadManager();
            }
        }
    }
    xhr.open('POST', 'updateReim');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(json);
}

function viewAllReimbursements()
{
    console.log("Adding Reimbursements to the table")
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4)
        {
            console.log(xhr.responseText);
            let arr = JSON.parse(xhr.responseText);
            for(i in arr)
            {
                console.log(arr[i]);
                //Get a row color based on the status of the reimbursement
                let statusColor = "info";
                if(arr[i].statusId == 2)
                    statusColor = "success";
                else if(arr[i].statusId == 3)
                    statusColor = "danger";
                //Check to see if it has been resolved
                let resolver = true;
                if(arr[i].resolverId == null)
                    resolver = false;
                let tableString = "";
                if(resolver)
                {
                    tableString = "<tr class = " + statusColor + "> <td>" +arr[i].id + "</td> <td>"+ 
                    arr[i].amount + "</td>" +
                    "<td>" + arr[i].timeSubmitted + "</td> <td>" + arr[i].timeResolved + "</td> <td>" +
                    arr[i].description + "</td> <td>" + arr[i].status + "</td> <td>" + arr[i].type + "</td>";
                }
                else 
                {
                    tableString = "<tr class = " + statusColor + "> <td>" + arr[i].amount + "</td>" +
                    "<td>" + arr[i].timeSubmitted + "</td> <td>" + " " + "</td> <td>" +
                    arr[i].description + "</td> <td>" + arr[i].status + "</td> <td>" + arr[i].type + "</td>";
                }
                if(arr[i].statusId == 1)
                {
                    //Need to add buttons to approve or deny these requests
                    ApproveId = "Approve"+arr[i].id;
                    DenyId = "Deny"+arr[i].id;
                    tableString += ("<td><button id="+ApproveId+" class=btn btn-success>Approve</button>"
                    + "<button id="+DenyId+" class=btn btn-warning>Deny</button></tr>");
                    let reimbursmentA = {
                        id: arr[i].id,
                        amount: arr[i].amount,
                        authorId: arr[i].authorId,
                        statusId: 2,
                        status: "Approved"
                    };
                    let reimbursmentD = {
                        id: arr[i].id,
                        amount: arr[i].amount,
                        authorId: arr[i].authorId,
                        statusId: 3,
                        status: "Denied"
                    };
                    $(document).on('click',"#"+ApproveId, function(){updateReimbursement(reimbursmentA);});
                    $(document).on('click',"#"+DenyId, function(){updateReimbursement(reimbursmentD);});
                }
                else
                {
                    tableString += "</tr>";
                }
                console.log(tableString);
                console.log(resolver);
                $('#managerTable').append(tableString);
            }
        }
    }
    xhr.open('GET', 'getReim');
    xhr.send();
}

function loadManager()
{
    console.log("Loading manager page");
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4)
        {
            console.log(xhr.responseText);
            viewAllReimbursements();
            $('#view').html(xhr.responseText);
            $('#managerLogOut').on('click', logOut);
        }
    }
    xhr.open('GET', 'manager.view');
    xhr.send();
}

function loadEmployee()
{
    console.log("Loading employee page");
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4)
        {
            console.log(xhr.responseText);
            $('#view').html(xhr.responseText);
            $('#addReim').on('click', loadAddReimbursement);
            $('#viewReim').on('click', loadViewReimbursements);
            $('#logOut').on('click', logOut);
        }
    }
    xhr.open('GET', 'employee.view');
    xhr.send();
}

function loadLogIn()
{
    console.log("Loading log in");
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if(xhr.readyState == 4)
        {
            console.log(xhr.responseText);
            $('#view').html(xhr.responseText);
            console.log('Right before click');
            $('#logIn').on('click', logIn);
            console.log('Right after click');
        }
    }   
    xhr.open('GET', 'login.view');
    xhr.send();
}