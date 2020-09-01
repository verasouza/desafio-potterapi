import React from 'react';
import axios from 'axios';
import {Grid, Paper, Typography} from '@material-ui/core';
import { makeStyles } from '@material-ui/core/styles';
import Card from "@material-ui/core/Card";
import CardActionArea from "@material-ui/core/CardActionArea";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import CardMedia from "@material-ui/core/CardMedia";
import Button from "@material-ui/core/Button";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    marginTop: 50,
    paddingTop: 30
  },
  container: {
    display: 'grid',
    gridTemplateColumns: 'repeat(12, 1fr)',
    gridGap: theme.spacing(3),
  },
  paper: {
    padding: theme.spacing(2),
    textAlign: 'center',
    color: theme.palette.text.secondary,
  },
}));

function Home() {
  const classes = useStyles();

    return (
      <div className={classes.root}>
      <Grid container spacing={30} justify="center" direction="row" alignItems="center">
        <Grid item xs={6}>
          <Card>
              <CardContent>
                <Typography gutterBottom variant="h5" component="h2">Desafio</Typography>
                <Typography component="p">API que disponibiliza informações sobre personagens da saga Harry Potter. 
                    Nesse app a ideia é disponibilizar essas informações em um banco que pode ser consultado pelo nome/sobrenome do personagem, casa ou escola.
                    Também é possível cadastrar um novo personagem, e sua casa será sorteada automaticamente.</Typography>
              </CardContent>
              <CardActions>
                <Button size="small" color="primary">Cadastrar</Button>
                <Button size="small" color="primary">Consultar</Button>
              </CardActions>
          </Card>

        </Grid>
        

      </Grid>
    </div>

    )
}

export default Home;