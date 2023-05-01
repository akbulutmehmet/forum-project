import axios from "axios";
const Getaxios = (url) => {
    return new Promise((resolve,reject) => {
        axios.get(url,{headers:{
            'Content-Type':'application/json',
            'Authorization':'Bearer ' + sessionStorage.getItem("token")
        }}).then(   
            (response) => resolve(response)
        ).catch((error) => reject(error));
    });
}

export default Getaxios;