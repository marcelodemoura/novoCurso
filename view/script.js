const url = "http://localhost:8080/task/user/1";

function hideLoader(){
    document.getElementById("loading").style.display = "none"

    hideLoader()
}

function show(task){
    let tab =`<thead>
            <th scope = "col>id</th>
            <th scope = "col>Description</th>
            <th scope = "col>Username</th>
            <th scope = "col>UserId</th>
            </thead>`;
            for (let task of tasks){
                tab += `
                <tr>
                <tb scope"row">${task.id}</td>
                <tb>${task.description}</td>
                <tb "row">${task.username}</td>
                <tb scope"row">${task.user.id}</td>
                </tr>`;
            }
            document.getElementById("tasks").innerHTML = tab;
        }
async function getAPI(url){
    const response = await  fetch(url, {method: "Get"});

    var data = await response.json();
    console.log(data);
    if(response)
        hideLoader();
}
getAPI:(url);