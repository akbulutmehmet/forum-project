import { useEffect, useState } from "react";
import { useParams } from "react-router";
import postService from "../services/PostService";
import Header from "./header";
import Footer from "./footer";
import commentService from "../services/CommentService";
import Comment from "./comment";
import CreateComment from "./createComment";
const PostDetail = () => {
    const {postId} = useParams();
    const [post,setPost] = useState({});
    const [comments,setComments] = useState([]);
    useEffect(() => {
        postService.getPostById("/api3/api/v1/post/",postId,(response) => {
            setPost(response.data);
        });
    },[postId]);
    useEffect(() => {
        commentService.getCommentsByPostId("/api3/api/v1/comment/",postId,(response) => {
            setComments(response.data);
        });
    },[postId])

    
    return (<>
    <Header />
        <div className="container">
            <div className="col-md-12 text-center border border-black p-2 m-5">
                <h1 className="display-1 text-uppercase">{post.title}</h1>
                <p className="text-lead">{post.content}</p>
            </div>
            <div className="col-md-12 text-left border border-black p-2 m-5" >
                <h1 className="display-1 text-uppercase">COMMENTS</h1>
            </div>
            {comments.map((comment,key) => {
            return <Comment key={key} id={comment.id} content={comment.content} />;
        })}
            <CreateComment postId={postId} callback={(response) => {
                setComments([...comments,response.data]);
            }}/>
        </div>
    <Footer />
    </>)
}
export default PostDetail;