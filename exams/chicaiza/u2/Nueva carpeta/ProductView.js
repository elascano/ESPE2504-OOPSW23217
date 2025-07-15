class ProductView {
  constructor(controller) {
    this.controller = controller;
    this.table = document.getElementById("productTable");
  }

  renderList() {
    const products = this.controller.readAll();
    this.table.innerHTML = `
      <tr>
        <th>ID</th><th>Name</th><th>Attr1</th><th>Attr2</th><th>Value</th><th>Actions</th>
      </tr>
    `;
    products.forEach(p => {
      const row = document.createElement("tr");
      row.innerHTML = `
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.attr1}</td>
        <td>${p.attr2}</td>
        <td>${p.computeValue()}</td>
        <td>
          <button onclick="editProduct(${p.id})">Edit</button>
          <button onclick="deleteProduct(${p.id})">Delete</button>
        </td>
      `;
      this.table.appendChild(row);
    });
  }
}
