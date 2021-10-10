import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';
import TopBar from '../components/TopBar';
import '../MyStyle.css'


class UserFavoriteList extends Component {

    constructor(props){
        super(props);
        this.state = {products: []};
        this.userid = props.userid;
        this.remove = this.remove.bind(this);
    }

    componentDidMount(){
        fetch(`http://localhost:8080/user/${this.userid}/favorites`,{
            method:'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
        .then(response=>response.json())
        .then(data=>this.setState({products:data}));
    }

    async remove(id) {
        await fetch(`http://localhost:8080/user/${this.userid}/favorites/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedProducts = [...this.state.products].filter(i => i.id !== id);
            this.setState({products: updatedProducts});
        });
    }
    
    render() {
        const productList = this.state.products.map(product => {
            return <tr key={product.id}>
                <td style={{whiteSpace: 'nowrap'}}>{product.name}</td>
                <td>${product.price}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="danger" onClick={() => this.remove(product.id)}>Remove From Favorites</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });
    
        return (
            <div>
                <TopBar/>
                <Container fluid>
                    <h3>Products</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                            <th width="30%">Price</th>
                            <th width="40%">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {productList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}
export default UserFavoriteList;