import officeImage from './office.png';

function App() {
  const element = "Office Space";

  const officeSpaces = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai"
    },
    {
      Name: "WeWork",
      Rent: 75000,
      Address: "Bangalore"
    },
    {
      Name: "Regus",
      Rent: 55000,
      Address: "Hyderabad"
    }
  ];

  return (
    <div>
      <h1>{element}, at Affordable Range</h1>

      <img
        src={officeImage}
        width="300"
        height="200"
        alt="Office Space"
      />

      {officeSpaces.map((office, index) => (
        <div key={index}>
          <h1>Name: {office.Name}</h1>

          <h3
            style={{
              color: office.Rent < 60000 ? "red" : "green"
            }}
          >
            Rent: Rs. {office.Rent}
          </h3>

          <h3>Address: {office.Address}</h3>
        </div>
      ))}
    </div>
  );
}

export default App;