import React, { Component } from 'react'
import { BrowserRouter, Link, Route, Switch } from "react-router-dom"
import UserBlackList from '../pages/UserBlackList'
import UserFavoriteList from '../pages/UserFavoriteList'
import UserProducts from '../pages/UserProducts'
import UserSellers from '../pages/UserSellers'
import '../MyStyle.css'
import { Navbar, NavbarBrand } from 'reactstrap'

export default class UserId extends Component {
    render() {
        return (
            <div>
                <BrowserRouter basename={"/user/"+this.props.match.params.userid}>
                    <div>
                        <div>
                            <Navbar color="black" dark expand="md">
                                <NavbarBrand tag={Link} to="/favorites">FAVORITES</NavbarBrand>
                                <NavbarBrand tag={Link} to="/blacklist">BLACKLIST</NavbarBrand>
                                <NavbarBrand tag={Link} to="/products">PRODUCTS</NavbarBrand>
                                <NavbarBrand tag={Link} to="/sellers">SELLERS</NavbarBrand>
                            </Navbar>
                        </div>
                        <Switch>
                            <Route exact path='/favorites'> <UserFavoriteList userid={this.props.match.params.userid}/> </Route>
                            <Route exact path='/blacklist'> <UserBlackList userid={this.props.match.params.userid}/> </Route>
                            <Route exact path='/products'> <UserProducts userid={this.props.match.params.userid}/> </Route>
                            <Route exact path='/sellers'> <UserSellers userid={this.props.match.params.userid}/> </Route>
                        </Switch>
                    </div>
                </BrowserRouter>
            </div>
        )
    }
}