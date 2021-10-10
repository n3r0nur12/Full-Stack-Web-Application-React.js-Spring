import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link, withRouter } from 'react-router-dom';
import TopBar from '../components/TopBar';
import '../MyStyle.css'


class UserProducts extends Component {

    constructor(props){
        super(props);
        this.state = {products: []};
        this.add = this.add.bind(this);
        this.userid = this.props.userid;
    }
    

    componentDidMount(){
        fetch(`http://localhost:8080/user/${this.userid}/products`,{
            method:'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
        .then(response=>response.json())
        .then(data=>this.setState({products:data}));
    }

    async add(id) {
        await fetch(`http://localhost:8080/user/${this.userid}/favorites`, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(id),
        }).then(() => {
            let updatedProducts = [...this.state.products].filter(i => i.id !== id);
            this.setState({products: updatedProducts});
        });
        this.props.history.push('/products');
    }
    
    render() {
        const productList = this.state.products.map(product => {
            return <tr key={product.id}>
                <td style={{whiteSpace: 'nowrap'}}>{product.name}</td>
                <td>${product.price}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="success" onClick={() => this.add(product.id)}>Add Favorites</Button>
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
export default withRouter(UserProducts);