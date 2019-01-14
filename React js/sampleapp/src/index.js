import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
// import Home from './Meals/Home';
// import SimpleTabl from './Meals/Table';
// import MiniDraw from './Meals/MiniDraw';

ReactDOM.render(<App />, document.getElementById('root'));
// ReactDOM.render(<SimpleTabl />, document.getElementById('menu_table'));


// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
