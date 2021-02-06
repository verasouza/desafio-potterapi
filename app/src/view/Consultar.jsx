import React, { useState, useEffect } from "react";
import './Consultar.css';
import api from '../services/api';
import Personagem from '../components/Personagem';

function Consultar() {
	const [houses, setHouses] = useState('');
	const [name, setName] = useState('');
	const[school, setSchool] = useState('');
	let url = 'characters/filter';

	const[loading, setLoading] = useState(false);
	const[error, setError]= useState(false);
	const[characters, setCharacters] = useState(false);
	const [filter, setFilter] = useState({
		action: false
	})
	

	useEffect(()=>{
		async function fetchData(){
			if(!loading && !characters){
				getCharactersInfo();
			}
		}
		
		 fetchData()
	}, [characters])


	const casas = [
		{
			label: 'Grifinoria',
			value: 'Grifinoria'
		},
		{
			label: 'Ravenclaw',
			value: 'Ravenclaw'
		},
		{
			label: 'Slytherin',
			value: 'Slytherin'
		},
		{
			label: 'Lufa-Lufa',
			value: 'Lufa-Lufa'
		},

	];

	const escolas = [
		{
			label: 'Hogwarts',
			value: 'Hogwarts'
		},
		{
			label: 'Ilvermorny',
			value: 'Ilvermorny'
		},
		{
			label: 'Durmstrang',
			value: 'Durmstrang'
		},
		{
			label: 'Beauxbatons',
			value: 'Beauxbatons'
		},

	];

	async function getCharactersInfo(){
		setLoading(true);

		const response = await api.get('characters/')
			.then(response => {
				setCharacters(response.data)
			}).catch(() => {
				setError(true);
			});

			setLoading(false);

	}

	function handleFilter(){

	}

	async function handleSubmit(e) {
		e.preventDefault();
		
		const body = {
			name: name,
			house: houses,
			school: school
		}

		const response = await api.post(url, body)
			.then(response => {
				setCharacters(response.data)
			}).catch(() => {
				setError(true);
			});


	}


	return (
		<div className="consultar">
			<div className="card-consultar">

					
					<form action="" method="post" className="search-characters">
					<legend> Buscar personagens</legend>
						<div className="input-block">
							<label htmlFor="name">Nome personagem:</label>
							<input type="text" id="name" value={name} onChange={e => setName(e.target.value)} />
						</div>
						<div className="select-block">
							<label htmlFor="school">Escola:</label>
							<select name="school" id="school" onChange={e => setSchool(e.target.value)}>
								<option value="">Selecione uma opção</option>
								{escolas.map((item, index)=>(
									<option key={index} value={item.value}>{item.label}</option>
								))}
							</select>
						</div>
						<div className="select-block">
							<label htmlFor="house">Casa:</label>
							<select name="house" id="house" onChange={e => setHouses(e.target.value)}>
								<option value="">Selecione uma opção</option>
								{casas.map((item, index)=>(
									<option key={index} value={item.value}>{item.label}</option>
								))}
							</select>
						</div>
					
							<button type="submit" className="search-button" onClick={handleSubmit}>Buscar</button>
				
					</form>
				<div className="container-characters">
					<div className="container-cards">
						{characters ? (
							characters.map((item, index) => (
								<Personagem
									name={item.name}
									house={item.house}
									school={item.school}
									role={item.role}
									patronus={item.patronus} />
							))

						) : (
								<h2>Carregando...</h2>
							)}
					</div>
				</div>

			</div>
		</div>
	)
}
export default Consultar;