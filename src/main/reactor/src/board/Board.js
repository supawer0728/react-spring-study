import React from 'react';
import {Route, Switch} from "react-router-dom";
import BoardList from "./list/BoardList";
import BoardDetail from "./detail/BoardDetail";

const Board = function (props) {
  return (
    <Switch>
      <Route exact path="/html/boards">
        <BoardList />
      </Route>
      <Route path="/html/boards/:id" component={BoardDetail} />
    </Switch>
  )
};

export {Board};