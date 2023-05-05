import { useEffect, useState } from "react";
import commentService from "../services/CommentService";

const CreateComment = ({postId,callback}) => {
    const [comment,setComment] = useState({});
    useEffect(() => {
        setComment({
            "postId":postId
        })
    },[postId]);
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
         <div className="row">
            <div className="col-md-12 text-center border border-black p-2 m-5">
                <textarea className="form-control" rows={"10"} onChange={onChangeContent} >
                    
                </textarea>
                <button onClick={onClickbtn} className="btn btn-lg btn-success mt-3" >CREATE COMMENT</button>
            </div>
        </div>
    </>);
}
export default CreateComment;