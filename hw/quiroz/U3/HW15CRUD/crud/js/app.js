const cuerpoTabla = document.querySelector("#cuerpo-tabla");
const myModal = new bootstrap.Modal(document.getElementById("modalGift"));

let idGiftUpdate = null;
let datos = []; // aquí guardamos la data cargada del servidor

window.mostrarModal = (id) => {
  idGiftUpdate = id;
  let index = datos.findIndex((item) => item.id == idGiftUpdate);

  document.querySelector("#giftModal").value = datos[index].gift;
  document.querySelector("#tipoModal").value = datos[index].tipo;
  document.querySelector("#tiempoModal").value = datos[index].tiempo;
  document.querySelector("#precioModal").value = datos[index].precio;
  document.querySelector("#imagenModal").value = datos[index].imagen;

  myModal.show();
};

const cargarTabla = async () => {
  try {
    const res = await fetch('http://localhost:3000/gifts');
    datos = await res.json();

    cuerpoTabla.innerHTML = "";
    datos.map((item) => {
      const fila = document.createElement("tr");

      const celdas = `<th>${item.gift}</th>
          <td>${item.tipo}</td>
          <td>${item.tiempo}</td>
          <td>$${item.precio}</td>
          <td>
          <div class="d-flex gap-2">
          <button class="btn btn-outline-warning" onclick="mostrarModal(${item.id})"><i class="fa fa-pencil" aria-hidden="true"></i></button>
          <button class="btn btn-outline-danger" onclick="borrarGift(${item.id})"><i class="fa fa-times" aria-hidden="true"></i></button>
          </div>
          </td>`;

      fila.innerHTML = celdas;
      cuerpoTabla.append(fila);
    });
  } catch (error) {
    console.error('Error al cargar gifts:', error);
  }
};

const agregarGift = async (event) => {
  event.preventDefault();

  let id = datos.length > 0 ? datos[datos.length - 1].id + 1 : 1;
  let gift = document.querySelector("#gift").value;
  let tipo = document.querySelector("#tipo").value;
  let tiempo = document.querySelector("#tiempo").value;
  let precio = document.querySelector("#precio").value;
  let imagen = document.querySelector("#imagen").value;

  const newGift = { id, gift, tipo, tiempo, precio, imagen };

  try {
    const res = await fetch('http://localhost:3000/gifts', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(newGift),
    });

    if (!res.ok) throw new Error('Error al agregar gift');

    document.querySelector("#formGift").reset();
    cargarTabla();
  } catch (error) {
    console.error(error);
  }
};

const giftUpdate = async (e) => {
  e.preventDefault();

  let gift = document.querySelector("#giftModal").value;
  let tipo = document.querySelector("#tipoModal").value;
  let tiempo = document.querySelector("#tiempoModal").value;
  let precio = document.querySelector("#precioModal").value;
  let imagen = document.querySelector("#imagenModal").value;

  const updatedGift = { id: idGiftUpdate, gift, tipo, tiempo, precio, imagen };

  try {
    const res = await fetch(`http://localhost:3000/gifts/${idGiftUpdate}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(updatedGift),
    });

    if (!res.ok) throw new Error('Error al actualizar gift');

    myModal.hide();
    cargarTabla();
  } catch (error) {
    console.error(error);
  }
};

window.borrarGift = async (id) => {
  const confirmar = confirm('¿Está seguro de eliminar esta gift?');

  if (!confirmar) return;

  try {
    const res = await fetch(`http://localhost:3000/gifts/${id}`, {
      method: 'DELETE',
    });

    if (!res.ok) throw new Error('Error al eliminar gift');

    cargarTabla();
  } catch (error) {
    console.error(error);
  }
};

document.querySelector("#formGift").addEventListener("submit", agregarGift);
document.querySelector("#formModal").addEventListener("submit", giftUpdate);

cargarTabla();
