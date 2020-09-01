import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import List from '@material-ui/core/List';
import HomeIcon from '@material-ui/icons/Home';
import PersonAddIcon from '@material-ui/icons/PersonAdd';
import GroupIcon from '@material-ui/icons/Group';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import ChevronRightIcon from '@material-ui/icons/ChevronRight';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';

function NavigationMenu() {

  

  return (
    <List>
      <ListItem>
        <ListItemIcon><HomeIcon /></ListItemIcon>
        <ListItemText primary="Home" />
      </ListItem>
      <ListItem>
        <ListItemIcon><PersonAddIcon /></ListItemIcon>
        <ListItemText primary="Adicionar" />
      </ListItem>
      <ListItem>
        <ListItemIcon><GroupIcon /></ListItemIcon>
        <ListItemText primary="Consultar" />
      </ListItem>
    </List>
  )

}
export default NavigationMenu;