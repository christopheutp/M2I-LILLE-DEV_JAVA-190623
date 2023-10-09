import React, { Component } from "react";

export default class TodoItem extends Component {
  constructor() {
    super();
    this.state = { itemStatus: "Uncrossed" };
    this.Style = { textDecoration: "none" };
  }
  handleDelete(e) {
    this.props.onDelete(e, this.props.name, true);
  }

  handleClick = e => {
    if (this.state.itemStatus === "Uncrossed") {
      this.setState({ itemStatus: "Crossed" });
      this.Style = { textDecorationLine: "line-through" };
    } else {
      this.setState({ itemStatus: "Uncrossed" });
      this.Style = { textDecoration: "none" };
    }
    this.props.OnStatusUpdate(e, this.props.name, this.state.itemStatus);
    e.preventDefault();
  };
  render() {
    return (
      <tr>
        <td style={this.Style}>{this.props.name.text}</td>
        <td>
          <center>
            <button
              type="button"
              className="btn btn-link"
              onClick={this.handleClick}
            >
              {this.state.itemStatus}
            </button>
          </center>
        </td>
        <td>
          <form
            className="form-inline my-2 my-lg-0"
            onSubmit={this.handleDelete.bind(this)}
          >
            <button className="btn btn-outline-dark my-2 my-sm-0" type="submit">
              Delete
            </button>
          </form>
        </td>
      </tr>
    );
  }
}
