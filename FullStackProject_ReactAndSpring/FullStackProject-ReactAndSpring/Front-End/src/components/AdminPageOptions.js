import { Link } from "react-router-dom"
import { Container, Nav, Navbar, NavbarBrand } from "reactstrap";
import '../MyStyle.css'

const AdminPageOptions = () => {
    return (
        <div>
                            <Navbar color="black" dark expand="md">
                                <NavbarBrand tag={Link} to="/products">PRODUCTS</NavbarBrand>
                                <NavbarBrand tag={Link} to="/sellers">SELLERS</NavbarBrand>
                                <NavbarBrand tag={Link} to="/users">USERS</NavbarBrand>
                            </Navbar>
        </div>
    )
}

export default AdminPageOptions;
