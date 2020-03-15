import React, {Component} from 'react';
import axios from 'axios';
import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";

export default class BoardDetail extends Component {
  constructor(props) {
    super(props);
    this.state = {
      board: {}
    };
    this.backClick = (e) => {
      console.log('back clicked');
    };
  }

  componentDidMount() {
    console.log(this.props);
    axios(`/api/boards/${this.props.match.params.id}`)
      .then(response => {
        this.setState({board: response.data});
      });
  }

  render() {
    return (
      <div>
        <Table striped bordered hover>
          <thead>
          <tr>
            <th>Field</th>
            <th>Value</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>id</td>
            <td>{this.state.board.id}</td>
          </tr>
          <tr>
            <td>title</td>
            <td>{this.state.board.title}</td>
          </tr>
          <tr>
            <td>content</td>
            <td>{this.state.board.content}</td>
          </tr>
          <tr>
            <td>writer</td>
            <td>{this.state.board.writer}</td>
          </tr>
          <tr>
            <td>editor</td>
            <td>{this.state.board.editor}</td>
          </tr>
          </tbody>
        </Table>
        <Button variant="danger" onClick={this.props.history.goBack}>Back</Button>
      </div>
    )
  }
}