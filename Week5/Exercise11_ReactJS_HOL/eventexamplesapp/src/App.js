import React, { Component } from 'react';
import CurrencyConvertor from './Components/CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      counter: 0
    };
  }

  increment = () => {
    this.setState({
      counter: this.state.counter + 1
    });

    this.sayHello();
  };

  decrement = () => {
    this.setState({
      counter: this.state.counter - 1
    });
  };

  sayHello = () => {
    alert('Hello! Member');
  };

  sayWelcome = (message) => {
    alert(message);
  };

  handleClick = (event) => {
    alert('I was clicked');
  };

  render() {
    return (
      <div>
        <h1>{this.state.counter}</h1>

        <button onClick={this.increment}>Increment</button>
        <br />

        <button onClick={this.decrement}>Decrement</button>
        <br />

        <button onClick={() => this.sayWelcome('Welcome')}>
          Say Welcome
        </button>
        <br />

        <button onClick={this.handleClick}>Click on me</button>

        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;