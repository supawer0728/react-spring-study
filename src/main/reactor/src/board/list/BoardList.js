import React, {Component} from 'react';
import axios from 'axios';
import {Link} from "react-router-dom";
import Table from "react-bootstrap/Table";

export default class BoardList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      boards: []
    };
  }

  componentDidMount() {
    axios('/api/boards').then(response => {
      this.setState({boards: response.data.content});
    });
  }

  render() {
    const boards = this.state.boards.map((board) => <Board key={board.id} board={board} />);
    return (
      <div id="board">
        <Table striped bordered hover>
          <colgroup>
            <col width="10%" />
            <col />
            <col />
          </colgroup>
          <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Content</th>
          </tr>
          </thead>
          <tbody>
          {boards}
          </tbody>
        </Table>
      </div>
    )
  }
}

function Board(props) {
  const detail = `/html/boards/${props.board.id}`;
  return (
    <tr>
      <td><Link to={detail}>{props.board.id}</Link></td>
      <td>{props.board.title}</td>
      <td>{props.board.content}</td>
    </tr>
  )
}
