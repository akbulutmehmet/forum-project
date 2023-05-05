import Header from "../../components/header";
import Footer from "../../components/footer";
import { useEffect, useState } from "react";
import { useParams } from "react-router";
const Newpost = () =>  {
    const [post,setPost] = useState({});
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
                        <input className="form-control" id="title" type="text" />
                    </div>
                    <div className="form-gruop mt-3">
                        <label htmlFor="description">Description</label>
                        <input className="form-control" id="description" type="text" />
                    </div>
                    <div className="form-gruop mt-3">
                        <button onClick={"onClickBtn"} className="btn btn-lg btn-success">CREATE</button>
                    </div>
                </div>
            </div>
        </div>
    <Footer />
    
    </>);
}
export default Newpost;