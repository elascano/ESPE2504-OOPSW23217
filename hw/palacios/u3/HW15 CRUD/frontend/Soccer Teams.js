document.getElementById("equipoForm").addEventListener("submit", async function (e) {
  e.preventDefault();

  const id = document.getElementById("id").value;
  const name = document.getElementById("name").value;
  const win = parseInt(document.getElementById("win").value);
  const totalmatches = parseInt(document.getElementById("totalmatches").value);
  const porcentaje = totalmatches > 0 ? (win / totalmatches) * 100 : 0;

  const equip = { id, name, win, totalmatches, porcentaje };

  const respuesta = await fetch("http://localhost:3000/team", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(equip),
  });

  const data = await respuesta.json();
  document.getElementById("result").innerText =
    `Registered team. Winning percentage: ${data.porcentaje.toFixed(2)}%`;
});
