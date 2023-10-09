import React, { Component } from "react";
import NavBar from "./navBar";
import TodoItems from "./todoItems";
import Message from "./message";

export default class Home extends Component {
  constructor(props) {
    super(props);

    this.state = {
      items: []
    };
    this.addedItem = "";
    this.deletedItem = "";
    //this.updatedItem = props.location.edititem;

    this.itemName = "";
    this.isItemAdded = false;
    this.isItemDeleted = false;
    this.isItemDone = false;
    console.log("constructor");
  }

  componentDidMount() {
    console.log("componentDidMount");
    // localStorage.getItem("items") &&
    //   this.setState({ items: JSON.parse(localStorage.getItem("items")) });
    let item = this.props.location.item;

    if (localStorage.getItem("items") && item !== undefined) {
      let currentState = JSON.parse(localStorage.getItem("items"));
      console.log("currentState", currentState);

      let items = [...currentState];
      console.log("items", items);
      console.log("item", item);

      const index = currentState.indexOf(item);
      console.log("index", index);

      items[index] = { ...item };
      items[index].text = this.props.location.itemtext;
      console.log("localStorage", items);
      this.setState({ items: items });
    } else {
      localStorage.getItem("items") &&
        this.setState({ items: JSON.parse(localStorage.getItem("items")) });
    }
  }
  //WARNING! To be deprecated in React v17. Use componentDidUpdate instead.
  componentWillUpdate(nextProps, nextState) {
    console.log("componentWillUpdate", nextState);
  }
  componentDidUpdate(prevProps, prevState) {
    console.log("componentDidUpdate", prevState);
  }

  componentWillUnmount() {
    console.log("componentWillUnmount");
    localStorage.setItem("items", JSON.stringify(this.state.items));
  }

  handleItemAdd(e, value, status) {
    this.setState(prevState => {
      return { items: prevState.items.concat(value) };
    });
    this.itemName = value.text;
    this.isItemAdded = status;
    e.preventDefault();
  }

  handleItemDelete(e, value, status) {
    this.itemName = value.text;
    this.isItemDeleted = status;
    this.setState(prevState => {
      return {
        items: prevState.items.filter(item => {
          return item.key !== value.key;
        })
      };
    });
    e.preventDefault();
  }

  handleItemStatusUpdate = (e, value, status) => {
    this.isItemDone = status === "Uncrossed" ? true : false;
    this.itemName = value.text;

    const items = [...this.state.items];
    const index = items.indexOf(value);
    items[index] = { ...value };
    items[index].status = this.isItemDone;

    this.setState({ items: items });
    e.preventDefault();
  };

  render() {
    console.log(
      "back from update-id" +
        this.props.location.item +
        " text" +
        this.props.location.itemtext
    );
    console.log(this.props.location.item);

    let itemMsg;

    if (this.itemName !== "") {
      if (this.isItemAdded) {
        itemMsg = <Message msg={this.itemName + " successfully added...!!!"} />;
        this.isItemAdded = false;
      } else if (this.isItemDeleted) {
        itemMsg = (
          <Message msg={this.itemName + " successfully deleted...!!!"} />
        );
        this.isItemDeleted = false;
      } else if (this.isItemDone) {
        itemMsg = <Message msg={this.itemName + " is completed...!!!"} />;
        this.isItemDone = false;
      } else {
        itemMsg = <Message msg={this.itemName + " is not completed...!!!"} />;
        this.isItemDone = true;
      }
      this.itemName = "";
    }

    return (
      <div>
        <NavBar onAddItem={this.handleItemAdd.bind(this)} />
        <br />
        <div className="container">
          {itemMsg}
          <TodoItems
            name={this.state.items}
            onDeleteItem={this.handleItemDelete.bind(this)}
            onItemStatusUpdate={this.handleItemStatusUpdate}
          />
        </div>
      </div>
    );
  }
}
