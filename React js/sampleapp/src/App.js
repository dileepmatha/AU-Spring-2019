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

{/* <Paper style={classes.root}>
      <Table className={classes.table}>
        <TableHead>
          <TableRow>
            <CustomTableCell align="right">ItemName</CustomTableCell>
            <CustomTableCell align="right">ItemCost</CustomTableCell>
            <CustomTableCell align="right">isAvailable</CustomTableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map(row => {
            return (
              <TableRow className={classes.row} key={row.id}>
                <CustomTableCell align="right">{row.itemname}</CustomTableCell>
                <CustomTableCell align="right">{row.itemcost}</CustomTableCell>
                <CustomTableCell align="right">
                </CustomTableCell>
              </TableRow>
            );
          })}
        </TableBody>
      </Table> */}
    // </Paper>