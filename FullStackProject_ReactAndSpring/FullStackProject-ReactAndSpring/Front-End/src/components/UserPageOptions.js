import { Link } from "react-router-dom"
import React, { Component } from 'react'
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import '../MyStyle.css'

export default class UserPageOptions extends Component {
    emptyItem = {
        userid: ''
    };

    constructor(){
        super();
        this.state = {item:  this.emptyItem};
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    render() {
        const {item} = this.state;
        return (
            <div>
                    <Form>
                        <FormGroup>
                            <Label for="id">Your user ID is:</Label>
                            <Input type="id" name="userid" id="userid" value={item.userid || ''}
                                onChange={this.handleChange} autoComplete="userid"/>
                        </FormGroup>
                        <FormGroup>
                            <Button color="secondary" tag={Link} to={"/"+this.state.item.userid}>SET THIS AS MY USER ID</Button>
                        </FormGroup>
                    </Form>
            </div>
        );
    }
}
