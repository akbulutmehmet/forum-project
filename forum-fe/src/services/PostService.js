import Getaxios from "../utils/Getaxios";

class PostService { 
    getPostById = (url,id,callback) => {
        Getaxios(url+id).then((response) => {
            if(callback) {
                callback(response);
            }
        }).catch((error) => {
            console.log(error);
        })
    };
}
const postService = new PostService();
export default postService;