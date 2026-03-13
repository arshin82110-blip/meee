const apiUrl = "http://localhost:8080/api/parts";

function loadParts() {
    fetch(apiUrl)
        .then(res => res.json())
        .then(data => {
            const list = document.getElementById("partsList");
            list.innerHTML = "";
            data.forEach(part => {
                const li = document.createElement("li");
                li.textContent = part.partName + " - ₹" + part.price;
                list.appendChild(li);
            });
        });
}

function addPart() {
    const part = {
        partName: document.getElementById("name").value,
        partNumber: document.getElementById("number").value,
        price: document.getElementById("price").value,
        quantity: document.getElementById("quantity").value
    };

    fetch(apiUrl, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(part)
    }).then(() => loadParts());
}

loadParts();