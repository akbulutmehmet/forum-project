import Commentauthor from "./commentauthor";

const Comment = ({id,content,userId}) => {
    return (
        <div className="row border border-black mt-2 mb-2">
            <div className="col-md-2">
                <Commentauthor userId={userId} />
            </div>
            <div className="col-md-8">
                {content}
            </div>
            <div className="col-md-2">
                <button className="btn btn-xs btn-primary  ">Update</button>
                <button className="btn btn-xs btn-danger ">Delete</button>
            </div>
        </div>
    );
}
export default Comment;