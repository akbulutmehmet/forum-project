import { useState } from "react";
import "./login.css"
import loginService from "../../services/LoginService";
import { Link } from "react-router-dom";
const Login = () => {
    
    const [user,setUser] = useState({});
    const onChangeUsername = (event) => {
        setUser({
            ...user,
            "username":event.target.value
        })
    }
    const onChangePassword = (event) => {
        setUser({
            ...user,
            "password":event.target.value
        })
    }
    const btnOnClick = () => {
        loginService.login("http://localhost:8081/api/v1/user/login",JSON.stringify(user),(response) => {
            sessionStorage.setItem("token",response.data.token); 
            setTimeout(() => {
                window.location.href = "/"
            },2000);
        });
    }
    return (
        <div className="container justify-content-center" align="center">
            <div className="row  form-signin">
                <div className="col-md-12" >
                    <h2 className="display-2 text-center" >Login Page</h2>
                    <div className="form-gruop">
                        <label htmlFor="username">Username</label>
                        <input type="text" className="form-control" id="username"
                        onChange={onChangeUsername}
                        />
                    </div>
                    <div className="form-gruop">
                        <label htmlFor="password">Password</label>
                        <input type="password" className="form-control" id="password"
                        onChange={onChangePassword}
                        />
                    </div>
                    <div className="form-gruop mt-2">
                        <button type="button" 
                        className="btn btn-outline-primary form-control"
                        onClick={btnOnClick}
                        >Signin</button>
                    </div>
                    <div className="form-gruop mt-2">
                        <Link to={"/register"} type="button" className="btn btn-outline-success form-control">Register</Link>
                    </div>
                </div>
            </div>
        </div>

    );
}
export default Login;