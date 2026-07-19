import React, { Component } from 'react';
import GuestPage from './Components/GuestPage';
import UserPage from './Components/UserPage';
import LoginButton from './Components/LoginButton';
import LogoutButton from './Components/LogoutButton';

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      isLoggedIn: false
    };
  }

  handleLoginClick = () => {
    this.setState({
      isLoggedIn: true
    });
  };

  handleLogoutClick = () => {
    this.setState({
      isLoggedIn: false
    });
  };

  render() {
    const isLoggedIn = this.state.isLoggedIn;

    let page;
    let button;

    if (isLoggedIn) {
      page = <UserPage />;
      button = <LogoutButton onClick={this.handleLogoutClick} />;
    } else {
      page = <GuestPage />;
      button = <LoginButton onClick={this.handleLoginClick} />;
    }

    return (
      <div>
        {page}
        {button}
      </div>
    );
  }
}

export default App;