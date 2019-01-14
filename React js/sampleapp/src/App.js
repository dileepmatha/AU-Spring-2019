import React, { Component } from 'react';
import './App.css';
import MiniDraw from './Meals/MiniDraw';
import SimpleTabl from './Meals/Table';
// import AddButton from './Meals/AddButton';

class App extends Component {
  render() {
    return (
      <div>
        <MiniDraw></MiniDraw>
        <SimpleTabl></SimpleTabl>
      </div>
    );
  }
}

export default App;
