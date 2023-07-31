// import './App.css';
import Menu from "./Menu/Menu";
import { route } from './Router/Route';
import { Container } from "reactstrap";
function App() {
  return (
    <>
      <Menu />
      <br></br>
      {route}
    </>
  );
}

export default App;
