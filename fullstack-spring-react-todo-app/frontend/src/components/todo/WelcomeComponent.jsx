import React from "react";
import { Link, useParams } from "react-router-dom";

export default function WelcomeComponent() {
  const { username } = useParams();

  return (
    <div className="ErrorComponent">
      <h1>Welcome {username}</h1>
      <div>
        <Link to="/todos">See my todos</Link>
      </div>
    </div>
  );
}
