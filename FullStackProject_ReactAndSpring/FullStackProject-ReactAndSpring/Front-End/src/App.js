import './App.css';
import {Component} from 'react'
import React from 'react';   
import ReactDOM from 'react-dom'; 
import Admin from './pages/Admin';
import User from './pages/User';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Login from './pages/Login';
import './MyStyle.css'

const App = () => {
  return (
    <BrowserRouter>
      <div>
      <Login/>
        <Switch>
          <Route exact path="/admin" component={Admin}/>
          <Route exact path="/user" component={User}/>
        </Switch>
      </div>
    </BrowserRouter>
  )
}

export default App