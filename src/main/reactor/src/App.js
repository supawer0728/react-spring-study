import React, {Component} from 'react';
import Container from "react-bootstrap/Container";
import Gnb from "./gnb/Gnb";
import {Route, Switch, useRouteMatch} from "react-router-dom";
import {Board} from "./board/Board";

export default class App extends Component {

  render() {
    return (
      <Container>
        <Gnb />
        <Switch>
          <Route exact path="/">
            <Home />
          </Route>
          <Route exact path="/html">
            <Home />
          </Route>
          <Route path="/html/boards">
            <Board />
          </Route>
        </Switch>
      </Container>
    )
  }
}

function Home() {
  let match = useRouteMatch();
  console.log(match);
  return (
    <div>Hello World!</div>
  )
}