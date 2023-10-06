import React, { Component } from "react";

export default class AddItem extends Component {
  handleSubmit(e) {
    if (this._item.value !== "") {
      var item = {
        key: Date.now(),
        text: this._item.value,
        status: true
      };
      this.props.onAddItem(e, item, true);
      this._item.value = "";
    }
    e.preventDefault();
  }

  render() {
    return (
      <form
        className="form-inline my-2 my-lg-0"
        onSubmit={this.handleSubmit.bind(this)}
      >
        <input
          className="form-control mr-sm-2"
          type="search"
          placeholder="Add Todo Item"
          name="item"
          ref={input => (this._item = input)}
          aria-label="Search"
        />
        <button className="btn btn-outline-dark my-2 my-sm-0" type="submit">
          Add Item
        </button>
      </form>
    );
  }
}
