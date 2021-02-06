import React, {useState, useEffect} from "react";
import './Cadastrar.css';
import api from '../services/api';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.min.css'; 

toast.configure()

function Cadastrar(){

const [house, setHouse] = useState('');
const [name, setName] = useState('');
const [school, setSchool] = useState('');
const [role, setRole] = useState('');
const [patronus, setPatronus] = useState('');


const notifySucess = () =>{
    toast.success('Personagem salva!', {
        position: toast.POSITION.TOP_CENTER
    });
}

const notifyFailed = () =>{
    toast.error('Xii...deu ruim', {
        position: toast.POSITION.TOP_CENTER
    });
}


async function savePersonagem(e){
    e.preventDefault();

    const body = {
        name: name,
        house: house,
        school: school,
        role: role,
        patronus: patronus
    }

    const response = await api.post('characters/save', body)
    .then(response =>{
        notifySucess();
        
    }).catch((error) =>{
        console.log(error)
        notifyFailed();
    });

    clearForm();

}

function clearForm(){
    setHouse('');
    setName('');
    setSchool('');
    setRole('');
    setPatronus('');
}

    return(
        <div className="cadastrar">
            <div className="card-cadastrar">
                <main>
                    <form action="" method="post" className="create-character-form" id="createCharacter">
                        <fieldset>
                            <legend>Registre um personagem</legend>
                            <div className="input-block">
                                <label htmlFor="name">Nome personagem:</label>
                                <input type="text" id="name" value={name} onChange={e => setName(e.target.value)}/>
                            </div>
                            <div className="input-block">
                                <label htmlFor="school">Escola: </label>
                                <input type="text" id="school" value={school} onChange={e => setSchool(e.target.value)}/>
                            </div>
                            <div className="input-block">
                                <label htmlFor="house">Casa:</label>
                                <input type="text" id="house" value={house} onChange={e => setHouse(e.target.value)}/>
                            </div>
                            <div className="input-block">
                                <label htmlFor="role">O que ele faz?(estudante, professor, staff etc...)</label>
                                <input type="text" id="role" value={role} onChange={e => setRole(e.target.value)}/>
                            </div>
                            <div className="input-block">
                                <label htmlFor="patronus">Seu patrono:</label>
                                <input type="text" id="patronus" value={patronus} onChange={e => setPatronus(e.target.value)}/>
                            </div>
                        </fieldset>
                        <button className="save-button" onClick={savePersonagem}>Salvar</button>
                    </form>
                </main>

            </div>
        </div>
    )
}
export default Cadastrar;