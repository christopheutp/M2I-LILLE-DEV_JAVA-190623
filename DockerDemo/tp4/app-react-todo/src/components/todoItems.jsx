import React, { Component } from "react";
import TodoItem from "./todoItem";

export default class TodoItems extends Component {
  render() {
    let todo;

    if (this.props.name.length > 0)
      todo = this.props.name.map(item => (
        <TodoItem
          key={item.key}
          name={item}
          onDelete={this.props.onDeleteItem}
          OnStatusUpdate={this.props.onItemStatusUpdate}
        />
      ));
    return (
      <table className="table table-bordered">
        <tbody>{todo}</tbody>
      </table>
    );
  }
}
