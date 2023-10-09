import React from "react";
const Message = props => {
  return (
    <div
      className="alert alert-secondary alert-dismissible fade show"
      role="alert"
    >
      {props.msg}
      <button
        type="button"
        className="close"
        data-dismiss="alert"
        aria-label="Close"
      >
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
  );
};

export default Message;
