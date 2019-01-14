import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import AddButton from './AddButton';

// import Fab from '@material-ui/core/Fab';
// import AddIcon from '@material-ui/icons/Add';

// import Swithces from './navigation';

const CustomTableCell = withStyles(theme => ({
  head: {
    backgroundColor: theme.palette.common.black,
    color: theme.palette.common.white,
  },
  body: {
    fontSize: 14,
  },
}))(TableCell);

const styles = theme => ({
  root: {
    width: '80%',
    // marginTop: theme.spacing.unit * 3,
    overflowX: 'auto',
    marginTop: '3%',
    marginLeft: '10%'
  },
  icon:{
    marginTop: '5%',
    marginLeft: '3%',
  },
  table: {
    minWidth: 700,
  },
  row: {
    '&:nth-of-type(odd)': {
      backgroundColor: theme.palette.background.default,
    },
  },
});

const rows=[{itemname:"Chapathi",itemcost:15,isAvailable:'yes'},
    {itemname:"Dal",itemcost:20,isAvailable:'yes'},
    {itemname:"Fry",itemcost:20,isAvailable:'yes'},
    {itemname:"Curd",itemcost:10,isAvailable:'yes'}
    ]

export class  CustomizedTable extends Component {
  state= {
    rows: []
  }
  handlerows=(items)=>{
    this.setState({rows : [...this.state.rows, items]});
  }
  const {classes} = props
  render(){
  return (
    <div>
    <AddButton onUpdateRows={this.handlerows}/>
    <Paper className={classes.root}>
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
      </Table>
    </Paper>
    </div>
  );
  }
}

CustomizedTable.propTypes = {
  classes: PropTypes.object.isRequired,
};

const SimpleTabl = withStyles(styles)(CustomizedTable);
export default SimpleTabl;