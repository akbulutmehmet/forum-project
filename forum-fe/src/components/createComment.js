import { useEffect, useState } from "react";
import commentService from "../services/CommentService";

const CreateComment = ({postId,callback,userId}) => {
    const [comment,setComment] = useState({});
    useEffect(() => {
        setComment({
            "postId":postId,
            "userId":userId
        })
    },[postId,userId]);
    const onChangeContent = (event) => {
        setComment({
            ...comment,
            "content":event.target.value
        });
    }
    const onClickbtn = () => {
        commentService.createComment("/api3/api/v1/comment/createComment",JSON.stringify(comment),(response) => {
            if(callback) {
                callback(response)
            }
        })
    }
    return (<>
         <div className="row mt-5">
            <div className="form-outline col-md-12 text-left border border-black">
                <h4 className="display-4">Create Comment</h4>
                <textarea className="form-control mt-2" rows={"10"} onChange={onChangeContent} >
                    
                </textarea>
                <button onClick={onClickbtn} className="btn btn-lg btn-success mt-2 mb-2" >CREATE COMMENT</button>
            </div>
        </div>
    </>);
}
export default CreateComment;