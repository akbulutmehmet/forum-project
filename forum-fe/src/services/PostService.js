import Swal from "sweetalert2";
import Getaxios from "../utils/Getaxios";
import PostaxiosWithAuth from "../utils/PostAxiosWithAuth";

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
    createPost = (url,data,callback) => {
        PostaxiosWithAuth(url,data).then((response) => {
            if(callback) {
                callback(response);
            }
            Swal.fire({
                title: "Post create ok",
                    text:"Post create ok",
                    icon:"success"
            })
        }).catch((error) => {
            Swal.fire(
                {
                    title:error.message,
                    text:error.message,
                    icon:"error"
                }
            );
        })
    }
}
const postService = new PostService();
export default postService;