import Swal from "sweetalert2";
import Postaxios from "../utils/Postaxios"
class LoginService {
    login = function (url,data,callback) {
        Postaxios(url,data).then((response) => {
            if(callback) {
                Swal.fire({
                    title: "Login ok",
                    text:"login text",
                    icon:"success"
                });
                callback(response);
            }
        }).catch((error) => {
            Swal.fire(
                {
                    title:error.message,
                    text:error.message,
                    icon:"error"
                }
            )
        });
    };
    register = function (url,data,callback) {
        Postaxios(url,data).then((response) => {
            if(callback) {
                Swal.fire({
                    title: "Register ok",
                    text:"Register text",
                    icon:"success"
                });
                callback(response);
            }   
        }).catch((error) => {
            Swal.fire(
                {
                    title:error.message,
                    text:error.message,
                    icon:"error"
                }
            )
        });;
    }
}
const loginService = new LoginService();
export default loginService;
