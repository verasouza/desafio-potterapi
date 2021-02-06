import React, { useState } from 'react';
import './Personagem.css';

function Personagem(props){

  const characters = props


  return(
    <div className='personagem-card'>
      <div className="card-header">
        <h3>{characters.name}</h3>
        <p className="school">{characters.school}</p>
    </div>
    <div className="card-content">
        {characters.house ? (
          <div>
            <strong>Casa:</strong>
            <span>{characters.house}</span>
          </div>
        ) : (
            <div>
              <strong>Casa:</strong>
              <span>Não informado</span>
            </div>
          )}
        <div>
          <strong>Role:</strong>
          <span>{characters.role}</span>
        </div>

        {characters.patronus ? (
          <div>
            <strong>Patronus:</strong>
            <span>{characters.patronus}</span>
          </div>
        ) : (
            <div>
              <strong>Patronus:</strong>
              <span>Não informado</span>
            </div>

          )}
      </div>






    </div>
  )
}
export default Personagem;