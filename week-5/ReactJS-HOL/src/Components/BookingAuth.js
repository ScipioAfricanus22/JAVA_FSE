import React from 'react';

// Sub-component for the Login trigger
export function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}

// Sub-component for the Logout trigger
export function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}

// Sub-component for Authenticated view text
function UserGreeting() {
  return <h1>Welcome back</h1>;
}

// Sub-component for Guest view text
function GuestGreeting() {
  return <h1>Please sign up.</h1>;
}

// Master toggle router component using element logic blocks
export function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}
