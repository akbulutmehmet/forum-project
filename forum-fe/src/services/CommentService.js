import Getaxios from "../utils/Getaxios";
import PostaxiosWithAuth from "../utils/PostAxiosWithAuth";

class CommentService {
    getCommentsByPostId = (url,postId,callback) => {
        Getaxios(url+postId).then((response) => {
            if(callback) {
                callback(response);
            }
        }).catch((error) => {
            console.log(error);
        });
    };
    createComment = (url,data,callback) => {
        PostaxiosWithAuth(url,data).then((response) => {
            if(callback) { 
                callback(response);
            }
        }).catch((error) => {
            console.log(error);
        })
    };
}
const commentService = new CommentService();
export default commentService;