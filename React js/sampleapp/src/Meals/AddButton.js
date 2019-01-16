import React, { Component } from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import Fab from '@material-ui/core/Fab';
import AddIcon from '@material-ui/icons/Add';

const divStyle = {
  marginLeft: '80%',
  marginTop: '8%',
};

export default class AddButton extends Component {
  state = {
    open: false,
    rows: [{itemname:"Chapathi",itemcost:15,isAvailable:'yes'},
    {itemname:"Dal",itemcost:20,isAvailable:'yes'},
    {itemname:"Fry",itemcost:20,isAvailable:'yes'},
    {itemname:"Curd",itemcost:10,isAvailable:'yes'}],
    temp: [],
  };

  handleClickOpen = (event) => {
    this.setState({ open: true });
    this.setState({ rows: [...this.state.rows, {itemname: this.state.temp[0], itemcost:this.state.temp[1], isAvailable:this.state.temp[2]}] });
    this.setState({temp: []});
    
  };
  handleChange1 = (event) =>{
    this.setState({ temp: [...this.state.temp, event.target.value] });
    // alert(this.state.temp);
  };

  handleChange2 = (event) =>{
    this.setState({ temp: [...this.state.temp, event.target.value] });
  };

  handleChange3 = (event) =>{
    this.setState({ temp: [...this.state.temp, event.target.value] });
  };

  handleClose = () => {
    this.setState({ open: false });
  };

  render() {
    // const { classes } = this.props
    return (
      <div style={divStyle}>
         <Fab color="primary" aria-label="Add" onClick={this.handleClickOpen}>
            <AddIcon />
         </Fab>
        <Dialog
          open={this.state.open}
          onClose={this.handleClose}
          aria-labelledby="form-dialog-title"
        >
          <DialogTitle id="form-dialog-title">Subscribe</DialogTitle>
          <DialogContent>
            <DialogContentText>
              Add Item to the list
            </DialogContentText>
            <TextField
              autoFocus
              margin="dense"
              name="itemname"
              label="Curry Name"
              type="text"
              value={this.itemname}
              onChange={this.handleChange1}
              fullWidth
            />
            <TextField
              autoFocus
              margin="dense"
              name="itemcost"
              label="Curry price"
              type="text"
              value={this.itemcost}
              onChange={this.handleChange2}
              fullWidth
            />
            <TextField
              autoFocus
              margin="dense"
              name="isAvailable"
              label="Curry price"
              type="text"
              value={this.isAvailable}
              onChange={this.handleChange3}
              fullWidth
            />
          </DialogContent>
          <DialogActions>
            <Button onClick={this.handleClickOpen} color="primary">
              Cancel
            </Button>
            <Button onClick={this.handleClose} color="primary">
              Submit
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    );
  }
}