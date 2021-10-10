import { BrowserRouter, Route, Switch } from "react-router-dom"
import AdminPageOptions from "../components/AdminPageOptions"
import AdminProductEdit from "./AdminProductEdit"
import AdminSellerEdit from "./AdminSellerEdit"
import AdminUserEdit from "./AdminUserEdit"
import EditUser from "./EditUser"
import EditSeller from "./EditSeller"
import EditProduct from "./EditProduct"
import '../MyStyle.css'

const Admin = () => {
    return (
        <>
            <BrowserRouter basename="/admin">
                <div>
                    <AdminPageOptions />
                    <Switch>
                        <Route path='/products' component={AdminProductEdit} exact/>
                        <Route path='/products/:id' component={EditProduct} exact/>
                        <Route path='/sellers' component={AdminSellerEdit} exact/>
                        <Route path='/sellers/:id' component={EditSeller} exact/>
                        <Route path='/users' component={AdminUserEdit} exact/>
                        <Route path='/users/:id' component={EditUser} exact/>
                    </Switch>
                </div>
            </BrowserRouter>
        </>
    )
}

export default Admin;

