import React from "react";
const ItemStatus = props => {
  return (
    <center>
      <form onSubmit={props.onClickStatus}>
        <a href="#" onClick={props.onClickStatus}>
          {props.Status}
        </a>
        <button type="submit" class="btn btn-link">
          {props.Status}
        </button>
      </form>
    </center>
  );
};

export default ItemStatus;
