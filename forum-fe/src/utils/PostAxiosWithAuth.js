const PostaxiosWithAuth = (url,data) => {
    return new Promise((resolve,reject) => {
        axios.post(url,data,{headers:{
            'Content-Type':'application/json',
            'Authorization':'Bearer ' + sessionStorage.getItem("token")
        }}).then( 
            (response) => resolve(response)
        ).catch((error) => reject(error));
    });
}
export default PostaxiosWithAuth;