import axios from "axios"

const Postaxios = (url,data) => {
    return new Promise((resolve,reject) => {
        axios.post(url,data,{headers:{
            'Content-Type':'application/json'
        }}).then( 
            (response) => resolve(response)
        ).catch((error) => reject(error));
    });
}

export default Postaxios;