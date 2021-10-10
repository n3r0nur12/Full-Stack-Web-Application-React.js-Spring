import { useHistory } from "react-router-dom";
import Admin from "./Admin";
import User from "./User";
import '../MyStyle.css'

const Login = () => {
    let history = useHistory();
    return (
        <div>
            <button onClick={()=>{history.push("/admin")}}>LOGIN AS ADMIN</button>
            <button onClick={()=>{history.push("/user")}}>LOGIN AS USER</button>
        </div>
    );
}

export default Login;