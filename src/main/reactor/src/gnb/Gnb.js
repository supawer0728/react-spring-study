import React, {Component} from 'react';
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";

export default class Gnb extends Component {
  render() {
    return (
      <Navbar>
        <Navbar.Brand href="/">Home</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto">
            <Nav.Link href="/html/boards">Board</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    )
  }
}