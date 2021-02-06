import React from 'react';
import { Link } from "react-router-dom";
import './Home.css';

function Home() {

    return (
        <div className="home">
            <div className="card-description">
                <h3>Desafio</h3>
                <p>API que disponibiliza informações sobre personagens da saga Harry Potter <br />
                    Nesse app a ideia é disponibilizar essas informações em um banco que pode ser consultado pelo nome/sobrenome do personagem, casa ou escola.
                    Também é possível cadastrar um novo personagem, e sua casa será sorteada automaticamente.
                </p>
                <div className="card-buttons">
                    <Link to="/cadastrar" id="cadastrar">Cadastrar</Link>
                    <Link to="/consultar" id="consultar">Consultar</Link>
                </div>
            </div>

        </div>

    );

}
export default Home;