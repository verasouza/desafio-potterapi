import React from 'react'
import * as FaIcon from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import * as IoIcons from "react-icons/io5";

export const SideBar = [
  {
    title: 'Home',
    path: '/',
    icon: <AiIcons.AiFillHome />,
    cName: 'nav-text'
  },
  {
    title: 'Cadastrar',
    path: '/cadastrar',
    icon: <IoIcons.IoPersonAddSharp />,
    cName: 'nav-text'
  },
  {
    title: 'Consultar',
    path: '/consultar',
    icon: <IoIcons.IoPeopleCircleSharp />,
    cName: 'nav-text'
  },
]