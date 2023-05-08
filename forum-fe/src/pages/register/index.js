import { useState } from "react";
import { Link } from "react-router-dom";
import loginService from "../../services/LoginService";
const Register = () => {
    const [user,Setuser] = useState({});
    const onChangeName = (res) => {
        Setuser({
            ...user,
            "name" : res.target.value
        })
    }
    const onChangeSurname = (res) => {
        Setuser({
            ...user,
            "surName" : res.target.value
        })
    }
    const onChangeUsername= (res) => {
        Setuser({
            ...user,
            "username" : res.target.value
        })
    }
    const onChangePassword= (res) => {
        Setuser({
            ...user,
            "password" : res.target.value
        })
    }
    const btnOnClick = () => {
        loginService.register("/api1/api/v1/user/register",JSON.stringify(user),(res) => {
            sessionStorage.setItem("token",res.data.token);
            sessionStorage.setItem("userId",res.data.userId);
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
                    <label htmlFor="username">Name</label>
                    <input type="text" className="form-control" id="name"
                    onChange={onChangeName}
                    required
                    />
                </div>
                <div className="form-gruop">
                    <label htmlFor="surname">Surname</label>
                    <input type="text" className="form-control" id="surname"
                    onChange={onChangeSurname}
                    required
                    />
                </div>
                <div className="form-gruop">
                    <label htmlFor="username">Username</label>
                    <input type="text" className="form-control" id="username"
                    onChange={onChangeUsername}
                    required
                    />
                </div>
                <div className="form-gruop">
                    <label htmlFor="password">Password</label>
                    <input type="password" className="form-control" id="password"
                    onChange={onChangePassword}
                    required
                    />
                </div>
                <div className="form-gruop mt-2">
                    <button
                    onClick={btnOnClick}
                    type="button" className="btn btn-outline-success form-control">Register</button>
                </div>
                <div className="form-gruop mt-2">
                    <Link to={"/login"} type="button" 
                    className="btn btn-outline-primary form-control"
                    
                    >Signin</Link>
                </div>
            </div>
        </div>
    </div>
    );
}

export default Register;