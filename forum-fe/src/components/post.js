import { Link } from "react-router-dom";

const Post = (props) => {
    return (<>
    <div className="col-md-12 text-left border border-black m-2 p-2">
        <Link to={'/post/' + props.id} >
        <h1 className="display-4 text-uppercase">{props.title}</h1>
        </Link>
    </div>
    </>);
}
export default Post;