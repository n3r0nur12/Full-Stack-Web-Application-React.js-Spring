import { BrowserRouter, Route, Switch } from "react-router-dom"
import UserId from "../components/UserId";
import UserPageOptions from "../components/UserPageOptions";
import UserBlackList from "./UserBlackList";
import UserFavoriteList from "./UserFavoriteList";
import UserProducts from "./UserProducts";
import '../MyStyle.css'

const User = () => {
    return (
        <div>
            <BrowserRouter basename="/user">
                <div>
                    <UserPageOptions />
                    <Switch>
                        <Route path='/:userid' component={UserId} exact/>
                        <Route path='/:userid/favorites' component={UserFavoriteList} exact/>
                        <Route path='/:userid/blacklist' component={UserBlackList} exact/>
                        <Route path='/:userid/products' component={UserProducts} exact/>
                        <Route path='/:userid/sellers' component={UserProducts} exact/>
                    </Switch>
                </div>
            </BrowserRouter>
        </div>
    )
}

export default User;