import { useEffect, useState } from "react";
import { useParams } from "react-router";
import postService from "../services/PostService";
import Header from "./header";
import Footer from "./footer";
import commentService from "../services/CommentService";
import Comment from "./comment";
import CreateComment from "./createComment";
import Author from "./author";
const PostDetail = ({GlobalState}) => {
    const {postId} = useParams();
    const [post,setPost] = useState({});
    const [comments,setComments] = useState([]);
    const {userId} = GlobalState;
    useEffect(() => {
        postService.getPostById("/api3/api/v1/post/",postId,(response) => {
            setPost(response.data);
        });
        commentService.getCommentsByPostId("/api3/api/v1/comment/",postId,(response) => {
            setComments(response.data);
        });
    },[postId]);

    
    return (<>
    <Header />
        <div className="container">
            <div className="col-md-12 text-center border border-black p-2 mt-5 mb-5">
                <h1 className="display-1 text-uppercase">{post.title}</h1>
                <p className="text-lead">{post.content}</p>
            </div>
            <Author userId={post.userId} />
            {(sessionStorage.getItem("userId") === post.userId ) ? 
            <button className="btn btn-lg btn-primary">UPDATE</button>
            : ""  }
            <div className="col-md-12 text-left border border-black p-2 mt-5 mb-5" >
                <h1 className="display-1 text-uppercase">COMMENTS</h1>
            </div>
            
           
            {comments.map((comment,key) => {
            return <Comment key={key} id={comment.id} content={comment.content} userId={comment.userId}/>;
        })}
            <CreateComment userId={userId} postId={postId} callback={(response) => {
                setComments([...comments,response.data]);
            }}/>
        </div>
    <Footer />
    </>)
}
export default PostDetail;