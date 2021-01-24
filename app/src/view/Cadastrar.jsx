import React from "react";
import './Cadastrar.css';

function Cadastrar(){

    return(
        <div className="cadastrar">
            <div className="card-cadastrar">
                <main>
                    <form action="" method="post" className="create-character-form">
                        <fieldset>
                            <legend>Registre um personagem</legend>
                            <div className="input-block">
                                <label htmlFor="name">Nome personagem:</label>
                                <input type="text" id="name"/>
                            </div>
                            <div className="input-block">
                                <label htmlFor="school">Escola: </label>
                                <input type="text" id="school"/>
                            </div>
                            <div className="input-block">
                                <label htmlFor="house">Casa:</label>
                                <input type="text" id="house"/>
                            </div>
                            <div className="input-block">
                                <label htmlFor="role">O que ele faz?(estudante, professor, staff etc...)</label>
                                <input type="text" id="role"/>
                            </div>
                            <div className="input-block">
                                <label htmlFor="patronus">Seu patrono:</label>
                                <input type="text" id="patronus"/>
                            </div>
                        </fieldset>
                        <button className="save-button">Salvar</button>
                    </form>
                </main>

            </div>
        </div>
    )
}
export default Cadastrar;