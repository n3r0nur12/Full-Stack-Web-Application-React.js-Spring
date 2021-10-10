import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';
import TopBar from '../components/TopBar';
import '../MyStyle.css'


class UserBlackList extends Component {

    constructor(props){
        super(props);
        this.state = {sellers: []};
        this.userid = props.userid;
        this.remove = this.remove.bind(this);
    }

    componentDidMount(){
        fetch(`http://localhost:8080/user/${this.userid}/blacklist`,{
            method:'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
        .then(response=>response.json())
        .then(data=>this.setState({sellers:data}));
    }

    async remove(id) {
        await fetch(`http://localhost:8080/user/${this.userid}/blacklist/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedSellers = [...this.state.sellers].filter(i => i.id !== id);
            this.setState({sellers: updatedSellers});
        });
    }
    
    render() {
        const sellerList = this.state.sellers.map(seller => {
            return <tr key={seller.id}>
                <td style={{whiteSpace: 'nowrap'}}>{seller.name}</td>
                <td>{seller.address}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="danger" onClick={() => this.remove(seller.id)}>Remove From Black List</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });
    
        return (
            <div>
                <TopBar/>
                <Container fluid>
                    <h3>Sellers</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                            <th width="30%">Address</th>
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {sellerList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default UserBlackList;