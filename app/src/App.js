import React from 'react';
import './App.css';
import Home from './views/Home';
import Header from './components/Header';
import Footer from './components/Footer';
import Navbar from './components/NavBar';

function App() {
  return (
    <div className="page-container">
      <div className="content-wrap">
        <Navbar />
        <Home />

        <Footer />
      </div>

    </div>
  );
}

export default App;
