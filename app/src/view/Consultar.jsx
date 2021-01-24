import React, { useState } from "react";
import './Consultar.css';

function Consultar() {
	const [houses, setHouses] = useState(false);

	const casas = [
		{
			id: 1,
			item: 'Grifinoria'
		},
		{
			id: 2,
			item: 'Ravenclaw'
		},
		{
			id: 3,
			item: 'Slytherin'
		},
		{
			id: 4,
			item: 'Lufa-Lufa'
		},

	];

	const escolas = [
		{
			id: 1,
			item: 'Hogwarts'
		},
		{
			id: 2,
			item: 'Ilvermorny'
		},
		{
			id: 3,
			item: 'Durmstrang'
		},
		{
			id: 4,
			item: 'Beauxbatons'
		},

	]

	return (
		<div className="consultar">
			<div className="card-consultar">

					
					<form action="" method="get" className="search-characters">
					<legend> Buscar personagens</legend>
						<div className="input-block">
							<label htmlFor="name">Nome personagem:</label>
							<input type="text" id="name" />
						</div>
						<div className="select-block">
							<label htmlFor="school">Escola:</label>
							<select name="school" id="school">
								<option value="">Selecione uma opção</option>
								{escolas.map((item, index)=>(
									<option value={item.id}>{item.item}</option>
								))}
							</select>
						</div>
						<div className="select-block">
							<label htmlFor="house">Casa:</label>
							<select name="house" id="house">
								<option value="">Selecione uma opção</option>
								{casas.map((item, index)=>(
									<option value={item.id}>{item.item}</option>
								))}
							</select>
						</div>
					
							<button type="submit" className="search-button">Buscar</button>
				
					</form>

			</div>
		</div>
	)
}
export default Consultar;