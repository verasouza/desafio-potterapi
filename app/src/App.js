import './App.css';
import { BrowserRouter as Router, Switch, Route} from 'react-router-dom';

import Home from './view/Home';
import Navbar from "./components/Navbar";
import Cadastrar from './view/Cadastrar';
import Consultar from './view/Consultar';


function App() {
  return (
    <>
     
     <Router>
        <Navbar />
    <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/cadastrar" component={Cadastrar} />
        <Route path="/consultar" component={Consultar} />
    </Switch>
    
    </Router>
     
     
  
    </>
 
  );
}

export default App;
