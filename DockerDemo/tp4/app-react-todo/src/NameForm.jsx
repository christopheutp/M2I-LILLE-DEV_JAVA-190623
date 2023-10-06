import React from "react";

export default class NameForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = { value: "" };

    //this.handleChange = this.handleChange.bind(this);
    //this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ value: event.target.value });
  }

  handleSubmit(event) {
    alert("A name was submitted: " + this.state.value);
    event.preventDefault();
  }

  render() {
    return (
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="{% url 'home' %}">
          Todo App
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon" />
        </button>

        <ul class="navbar-nav mr-auto" />
        <form onSubmit={this.handleSubmit.bind(this)}>
          <label>
            Name:
            <input
              type="text"
              value={this.state.value}
              onChange={this.handleChange.bind(this)}
            />
          </label>
          <button type="submit" value="Submit">
            Add Item
          </button>
        </form>
      </nav>
    );
  }
}
