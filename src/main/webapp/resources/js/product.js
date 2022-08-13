/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


function deleteProduct(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let load = document.getElementById(`load${id}`);
    load.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Something wrong!!!");
        load.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        load.style.display = "none";
    });
}

function getProducts(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("myProduct");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                <tr id="row${data[i].id}">
                    <td><img src="${data[i].image}" width="120" /></td>
                    <td>${data[i].name}</td>
                    <td>${data[i].price}</td>
                    <td>
                        <div class="spinner-border text-info" style="display:none" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteProduct('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">Xoa</button>
                    </td>
                </tr>
            `
            d.innerHTML = h;
        }

        let d2 = document.getElementById("mySpinner");
        d2.style.display = "none";
    }).catch(function (err) {
        console.error(err);
    });
}
function addToCart(id, name, image, price) {
    event.preventDefault();

    fetch("/webdemo/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "id": id,
            "name": name,
            "image": image,
            "price": price,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        console.info(res);
        return res.json();
    }).then(function (data) {
        console.info(data);
        let d = document.getElementById("cartCounter");
        d.innerText = data;
    })
}
function updateCart(id, obj) {
    event.preventDefault();

    fetch("/webdemo/api/cart", {
        method: 'put',
        body: JSON.stringify({
            "id": id,
            "quantity": parseInt(obj.value)
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("cartCounter");
        d.innerText = data;
    });
}

function deleteCart(productId) {
    event.preventDefault();

    if (confirm("Ban chac chan xoa khong?") == true) {
        fetch(`/webdemo/api/cart/${productId}`, {
            method: 'delete',
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function (res) {
            return res.json();
            
        }).then(function (data) {
            let d = document.getElementById("cartCounter");
            d.innerText = data;
            location.reload();
        });
    }
}