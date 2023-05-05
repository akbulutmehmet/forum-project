import Getaxios from "../utils/Getaxios";

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
}
const commentService = new CommentService();
export default commentService;