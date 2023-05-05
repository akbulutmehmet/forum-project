import Header from "../../components/header";
import Footer from "../../components/footer";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import postService from "../../services/PostService";
const Newpost = () =>  {
    const [post,setPost] = useState({});
    const navigate = useNavigate();
    const onChangeTitle = (event) => {
        setPost({
            ...post,
            "title":event.target.value
        });
    }
    const onChangeContent = (event) => {
        setPost({
            ...post,
            "content":event.target.value
        })
    }
    const onClickBtn = () => {
        postService.createPost("/api3/api/v1/post/createPost",JSON.stringify(post),(response) => {
            if(response.status === 200) {
                navigate("/post/"+response.data.id);
            }
        });
    }
    const {categoryId} = useParams();
    useEffect(() => {
        setPost({
            "categoryId":categoryId
        });
    },[categoryId]);
    return (<> 
        <Header />
        <div className="container mt-5 mb-5 pt-1 pb-1 ">
            <div className="row justify-content-center">
                <div className="col-md-8">
                    <div className="form-gruop mt-3">
                        <label htmlFor="title">Title</label>
                        <input className="form-control" id="title" type="text" onChange={onChangeTitle}/>
                    </div>
                    <div className="form-gruop mt-3">
                        <label htmlFor="description">Content</label>
                        <input className="form-control" id="content" type="text" onChange={onChangeContent}/>
                    </div>
                    <div className="form-gruop mt-3">
                        <button onClick={onClickBtn} className="btn btn-lg btn-success">CREATE</button>
                    </div>
                </div>
            </div>
        </div>
    <Footer />
    
    </>);
}
export default Newpost;